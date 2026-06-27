# OTT Block / Recipe / Tab Architecture

A map of how blocks get defined, how their assets (blockstate/model/item/lang) get generated, how
engraving recipes + the creative tabs are built, and **where it's coupled** — written to help decide
what to simplify. Goal end-state (yours): *spreadsheets + material tags, minimal hand-written Java.*

---

## 0. The pipeline in one picture

```
 [1] DEFINE a block            [2] GENERATE its assets         [3] GROUP it            [4] SHOW it
 ----------------------         -----------------------         ------------           -----------
 (a) Java register()            blockstate + block model        material tag           creative tab
 (b) ModBlocks (minecraft:)     item model               --->   ott:material/X  --->   + ENGRAVED tab =
 (c) block_templates.csv  --->  lang (display name)                                     EngravingEntries
 (d) ctm_blocks.tsv             recipes (engrave/stonecut/                              .tabItems()
                                         smelt/craft)
```

Two things to internalize:
- **Defining a block and generating its assets are separate steps, done in different places.** A CTM
  block is *registered in Java* but its model is *described in a TSV*. Miss either half → broken/invisible.
- **`EngravingEntries.enumerate()` is read twice** — once to write recipes, once to build the ENGRAVED
  tab. That's why one edit there changes both recipes and the tab.

---

## 1. The four ways a block gets DEFINED (registered)

| # | Path | Where | Namespace | Spreadsheet? | Used for |
|---|------|-------|-----------|--------------|----------|
| 1 | `OttBlocks.register(name, supplier)` | `ott_blocks/.../OttBlocks.java` | `ott:` | ❌ hand-written Java | Most decorative blocks, CTM blocks, panes, doors/trapdoors, marble, mosaics, glass |
| 2 | `ModBlocks.registerBackportedBlock(...)` | root `ModBlocks.java` | `minecraft:` | ❌ hand-written Java | Backported vanilla (pale oak, resin, copper, …) |
| 3 | `block_templates.csv` → `OttTemplateBlocks` | `ott_blocks/.../block_templates.csv` | `ott:` | ✅ **CSV** | Plain cube/column/glass blocks ("template blocks"), auto-paned |
| 4 | `ctm_blocks.tsv` (assets only) | `ott_blocks/.../ctm_blocks.tsv` | `ott:` | ✅ **TSV** (assets, not registration) | Connecting-texture blocks |

Important nuances:
- **Paths 1 & 2 are loop-or-hand Java.** Color sets, wood sets, marble, mosaics, pattern blocks are all
  Path 1 — some loop over a list (color/wood sets), some are 100+ individual `register(...)` lines (marble).
- **Path 3 (CSV) is the closest to your spreadsheet dream** — one row `name,material,template,render`
  produces the DeferredBlock **and** (for `template=glass`) an auto static pane. Columns:
  - `name` – block id
  - `material` – texture folder *and* the `ott:material/<material>` group it joins (drives engraving!)
  - `template` – `cube_all` (default) / `cube_column` / `glass` / `glass_column` / `crying_obsidian`
  - `render` – ` ` / `solid` / `cutout` / `cutout_mipped` / `translucent`
- **Path 4 (TSV) only generates ASSETS** — the block must *also* be registered via Path 1. So a CTM block
  lives in **two places**: a `register("x_ctm", …)` line in `OttBlocks.java` **and** a row in `ctm_blocks.tsv`.
  This double-bookkeeping is a real friction point.

---

## 2. Who GENERATES each asset

| Asset | Provider | How it iterates |
|-------|----------|-----------------|
| blockstate + block model (ott:) | `OttBlockStateProvider` | Explicit sweeps over collections (`COLOR_SETS`, `OPAL_SETS`, `STONE_SETS`, marble…) **+** a loop over `OttTemplateBlocks.TEMPLATE_BY_NAME` for CSV blocks |
| blockstate + model (minecraft:) | `MinecraftBackportBlockStateProvider` | Sweeps `ModBlocks.MINECRAFT_BLOCKS` |
| CTM blockstate/model/item | `OttCtmModelProvider` | Reads `ctm_blocks.tsv`; for each row whose block is registered, writes 3 JSONs. Has a **coverage check** that errors if a registered `_ctm` block has no row |
| CTM panes | `OttCtmPaneProvider` | Hardcoded `buildSpecs()` list of `PaneSpec(name, paneTex, edgeTex, render, …)` |
| item models | `ModItemModelProvider` / `MinecraftBackportItemModelProvider` | Per-block; doors/trapdoors special-cased |
| lang (display names) | `ModLangMergeProvider` | Merges committed `assets/ott/lang/en_us_base.json` + auto-title-cased entries generated from collections (wood doors, glass, etc.) |
| recipes | `ModRecipeProvider` | Engraving via `EngravingEntries.enumerate`; stonecut/smelt/craft hand-written |

Base model helpers live in `ModBlockStateProvider` (doors/trapdoors, etc.).

---

## 3. The CTM + static-twin pattern (the "framed glass" recipe)

Each fancy connecting block is **two blocks**: a connecting (`_ctm`) one and a plain static twin.
Using `stone_framed_glass` as the template — to add a new member you touch **all** of these:

| Half | What | File |
|------|------|------|
| CTM block | `register("X_framed_glass_ctm", () -> new TransparentBlock(...))` | `OttBlocks.java` |
| CTM block assets | one TSV row: `X_framed_glass_ctm  <mat>  ctm_cube_all_pieces  minecraft:translucent  pieces_full  all=ott:block/<mat>/ctm/X_framed_glass  all  solo  minecraft:translucent` | `ctm_blocks.tsv` |
| CTM texture | `ott:block/<mat>/ctm/X_framed_glass.png` (atlas) | `ott_blocks/.../textures/block/<mat>/ctm/` |
| CTM pane block | `register("X_framed_glass_ctm_pane", () -> new CtmPaneBlock(...))` | `OttBlocks.java` |
| CTM pane assets | a `PaneSpec(...)` entry | `OttCtmPaneProvider.buildSpecs()` |
| static twin (block + pane) | one CSV row: `X_framed_glass,<mat>,glass,translucent` (auto-registers block **and** `X_framed_glass_pane`) | `block_templates.csv` |
| engraving | `s.tagged(materialTag("glass"), …, "X_framed_glass_ctm_engraving")` | `EngravingEntries.java` |
| lang | `"block.ott.X_framed_glass_ctm": "Framed … Glass"` (+ pane) | `en_us_base.json` |

That's **~8 touch-points across 5 files for one block** — the core reason this feels out of control.

---

## 4. The engraving system

`EngravingEntries.java` is the single source of truth for *both* engraving recipes *and* the ENGRAVED tab.

**`enumerate(Sink s)`** walks every engraving once and calls one of three Sink methods:

| Method | Ingredient | Meaning | Count |
|--------|-----------|---------|-------|
| `s.tagged(materialTag("X"), out, id)` | the **tag** `ott:material/X` | **any** block in the group → out. Put any group member in the table, see the whole group as outputs. **This is the model you want everywhere.** | ~1,911 |
| `s.one(input, out, id)` | one **specific** block | base-only → out, *one-directional* (variants can't be re-engraved into each other) | ~488 |
| `s.group(ingredient, out, id)` | a custom `Ingredient` | tagged-but-inline; a workaround from before a tag existed | 3 |

**Why three exist:** accretion, not design. `s.one`/`s.group` predate having a material tag for every
material. **The simplification is to make everything `s.tagged`** — that gives the consistent "any-in →
all-out" behavior. The only prerequisite per converted material: a tag file listing all its members.

The same list feeds the tab via **`tabItems()`** (unique `ott:` outputs, first-seen order). The
ENGRAVED tab (`OttCreativeCategories`) just iterates that list and pairs each cube with its pane/carpet.

---

## 5. Material tags — the grouping mechanism

- Live at `data/ott/tags/item/material/<name>.json` — **296 files**, hand-authored, committed.
- A tag lists every block that counts as that material (the engraving *inputs*).
- `block_templates.csv`'s `material` column is what slots a CSV block into a group; hand-registered
  blocks are added by editing the tag file (or via `ModItemTagProvider` copies for door families).
- **To convert an `s.one` material to `s.tagged`:** ensure `ott:material/<x>.json` contains the base
  + all variants, then flip the entries. (e.g. marble: needs `ott:material/<color>_marble` populated.)

---

## 6. Creative tabs

`OttCreativeCategories.java` — ~20 tabs. Membership is set per tab by either:
- **explicit `output.accept(...)` sweeps** over collections (COLORS, WOOD_SETS, STONE_CUSTOM, BLOCKS…), or
- **ENGRAVED** = `EngravingEntries.tabItems()` (so it mirrors engraving exactly; reordered at render time
  by the section-cluster logic we added), or
- **COVERAGE** = audit net: everything in `OttBlocks`/`ModBlocks` not already placed in another tab.

---

## 7. The content families — spreadsheet-readiness scorecard

| Family | Defined in | Members | Spreadsheet today? | Engraving coupling |
|--------|-----------|---------|--------------------|--------------------|
| CTM blocks | `ctm_blocks.tsv` (assets) + Java register | ~2,000 rows | ✅ assets fully TSV; ❌ registration still Java | tagged loops |
| Template blocks | `block_templates.csv` | thousands | ✅ fully CSV | via `material` column |
| Color sets | `ModColorSets.ALL` (Java list) + `ColorSetBlockRegistrar` | 17 colors × ~20 types | ⚠️ one list, loop-registered (centralized but Java) | base material, light |
| Wood sets | `ModWoodSets.ALL` (Java list) + `WoodSetBlockRegistrar` | 2 woods × ~29 types | ⚠️ one list, loop-registered | base material |
| Pattern blocks | `ModPatterns` (scans texture folder) + loop | ~20 patterns × ~33 colors | ⚠️ filesystem-discovered, Java datagen | white base engraved |
| Marble | **individual `register(...)` fields** in OttBlocks | 16 colors × ~7 = ~112+ | ❌ fully hand-written | **heavy** (~150 `s.one` lines) |
| Mosaics | individual fields + `ctm_blocks.tsv` | 25 + floor/fresco/masonry | ⚠️ mixed | smooth_sandstone section |

**Biggest pain / best ROI to simplify:** marble (hand-written everywhere), and the CTM
"register-in-Java-AND-describe-in-TSV" double bookkeeping.

---

## 8. Coupling map (what ripples into what)

- `EngravingEntries.enumerate()` → **recipes AND the ENGRAVED tab** (the big one).
- `block_templates.csv` `material` column → which `ott:material/X` group → engraving input set → tab pairing.
- A CTM block needs **both** a Java `register` line **and** a `ctm_blocks.tsv` row (+ a pane block needs
  a `register` line **and** a `PaneSpec`).
- `material` tag files are hand-maintained; a block not in its tag is silently un-engravable.
- Marble variants are wired in ~4 places each (register, datagen, stone-set wrapper, engraving).

---

## 9. End-state vision + incremental migration (no rewrite)

**Target:** a spreadsheet per "kind of thing" (you fill in textures + details), datagen turns rows into
blockstates/models/items/lang/recipes/tags. You already have two of these sheets working
(`block_templates.csv`, `ctm_blocks.tsv`). The work is **widening them and deleting bespoke Java**, one
family at a time. Each step below is standalone and safe to do/verify on its own:

1. **Unify engraving on `s.tagged`.** Pick one `s.one` family at a time (start with marble), populate its
   `ott:material/<x>` tag, flip the entries. Removes the "base-only" inconsistency. *(behavioral win you asked for)*
2. **Make `ctm_blocks.tsv` also register the block.** Have the CTM provider/registrar create the
   DeferredBlock from the row (like `block_templates.csv` does), so CTM blocks live in **one** place, not two.
   Kills the biggest double-bookkeeping.
3. **Lang from the sheets.** Add an optional `display_name` column to the CSV/TSV; `ModLangMergeProvider`
   reads it. Removes most hand-authored lang entries.
4. **Move marble to the CSV/TSV** (it's just colored cube/brick/tile/pillar variants) and delete the ~112
   hand fields + ~150 engraving lines; engraving comes free via the `material` column once on `s.tagged`.
5. **A `families.csv`** (later): one row defines a whole family (members + recipe relationships) and a
   generator expands it — the fullest version of your spreadsheet dream. Optional capstone.

Do them in order; each is a small, reviewable PR-sized change, and none requires gutting anything.

---

*Generated 2026-06-26 as a living map — update as systems change.*


Otter Notes:
---
leave marble in custom stone, stonecutter recipes
remove from engraving system

ott:material/dripstone_block needs created/fixed
ott:material/shroomlight needs created/fixed
ott:material/sea_lantern needs created/fixed

amethyst framed glass pane (both) are uncategorized

ALL trapdoors missing material group engraving tags (only tag they have is minecraft:mineable/axe)

all pale oak windows missing material group engraving tags

all window panes need removed from engraving recipes (only default 6 blocks -> 16 panes recipe)

currently have 2 sets of each wood type window tiles (block and pane) connecting, but one is a broken dup
it is showing as cube all without the proper wooden planks texture on top and only has an ott:ctm_blocks tag
these dups all need to be removed

the wood type bookshelves (acacia, bamboo, birch, cherry, crimson, dark oak, jungle, mangrove, oak, spruce, warped) need to be added to their own material group
each one of these needs to have a unique shaped recipe created reusing the vanilla bookshelf recipe but substituting the proper wood type
the vanilla bookshelf recipe should be altered to only accept oak planks
each wood type bookshelf (acacia, bamboo, birch, cherry, crimson, dark oak, jungle, mangrove, oak, spruce, warped) needs to have its own material group created
we currently have a list of oak bookshelves that should be added to the oak material group
the vanilla bookshelf should also be added to this group
the others will only have the one bookshelf for now but I will be adding more, as well as creating a pale oak group

wood type trapdoors should only accept other trapdoors of their wood type as unput
they are currently accepting doors

there appear to be two sets now for framed stone glass, framed sandstone glass, framed red sandstone glass, framed obsidian glass
one set correctly shows as part of the glass material group
one set incorrectly shows as part of the stone/sandstone/red sandstone/obsidian material group
this set needs to be removed

connecting sea lantern needs to be added to the sea_lantern material group as it is currently only accepting the vanilla sea lantern as input
I suspect this is part of the s.one tag issues we saw that we should be fixing anyway

we are also missing a LOT of minecraft tags for blocks, doors, trapdoors, glass, etc
it appears we only have the mineable tags set but missing all others that would be applied

chisels sets (nexus, etc) are missing minecraft AND ott tags
I suspect this is due to their oddball generation
they should be added to their parent stone material group and tagged as appropriate