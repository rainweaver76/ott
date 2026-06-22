package com.otterly76.ott.client.model.ctm;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.neoforged.neoforge.client.model.BakedModelWrapper;
import net.neoforged.neoforge.client.model.IQuadTransformer;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.data.ModelProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * Baked model for CTM "connecting" blocks. Wraps the base block model and remaps
 * quad UVs on the fly based on which neighbors connect.
 *
 * <p>Connection data is computed in {@link #getModelData} (called once per chunk section
 * rebuild) and stored in {@link ModelData} for retrieval in {@link #getQuads}.
 */
public class ConnectingBakedModel extends BakedModelWrapper<net.minecraft.client.resources.model.BakedModel> {

    /**
     * Stores per-rule connection masks: {@code masks[ruleIndex][face.ordinal()]} = 8-bit mask.
     */
    public static final ModelProperty<int[][]> CTM_MASKS = new ModelProperty<>();

    // ---- face-to-neighbor-offset tables ----------------------------------------

    /**
     * For each face direction, 8 neighbor offsets in texture-space order:
     * T, TR, R, BR, B, BL, L, TL.
     */
    private static final BlockPos[][] NEIGHBOR_OFFSETS = buildNeighborOffsets();

    private static BlockPos[][] buildNeighborOffsets() {
        BlockPos[][] offsets = new BlockPos[6][8];
        // Horizontal faces
        buildOffsets(offsets, Direction.UP,    Direction.NORTH, Direction.EAST);
        buildOffsets(offsets, Direction.DOWN,  Direction.SOUTH, Direction.EAST);
        // Vertical faces — "top" = UP; "right" defined by which side is rightward when
        // viewed from outside the block
        buildOffsets(offsets, Direction.NORTH, Direction.UP, Direction.EAST);
        buildOffsets(offsets, Direction.SOUTH, Direction.UP, Direction.WEST);
        buildOffsets(offsets, Direction.WEST,  Direction.UP, Direction.SOUTH);
        buildOffsets(offsets, Direction.EAST,  Direction.UP, Direction.NORTH);
        return offsets;
    }

    private static void buildOffsets(BlockPos[][] offsets, Direction face, Direction topDir, Direction rightDir) {
        Direction botDir  = topDir.getOpposite();
        Direction leftDir = rightDir.getOpposite();

        BlockPos top   = BlockPos.ZERO.relative(topDir);
        BlockPos right = BlockPos.ZERO.relative(rightDir);
        BlockPos bot   = BlockPos.ZERO.relative(botDir);
        BlockPos left  = BlockPos.ZERO.relative(leftDir);

        int fi = face.ordinal();
        offsets[fi][0] = top;
        offsets[fi][1] = top.offset(right);
        offsets[fi][2] = right;
        offsets[fi][3] = bot.offset(right);
        offsets[fi][4] = bot;
        offsets[fi][5] = bot.offset(left);
        offsets[fi][6] = left;
        offsets[fi][7] = top.offset(left);
    }

    // ---- fields ----------------------------------------------------------------

    /**
     * Unique rules in order, parallel to the first axis of the masks array.
     */
    private final List<ConnectionRule> ruleList;
    /**
     * Maps each sprite to its rule index within {@link #ruleList}.
     */
    private final Map<TextureAtlasSprite, Integer> spriteToRuleIndex;
    /** Catch-all rule index (used when sprite not found in spriteToRuleIndex), or -1. */
    private final int catchAllRuleIndex;
    /** Default atlas layout for this model — controls tile lookup and tile dimensions. */
    private final CtmLayout layout;
    /**
     * Per-sprite layout overrides. Sprites not present here use {@link #layout}.
     * Built from per-texture {"layout":…,"rules":[…]} syntax in the model JSON.
     */
    private final Map<TextureAtlasSprite, CtmLayout> spriteLayouts;
    /**
     * Maps CTM atlas sprite → isolated tile sprite.
     * When Domum Ornamentum calls {@link #getQuads}, we return quads using the isolated
     * sprite so DO's {@code ModelSpriteQuadTransformer} maps to just the isolated tile
     * instead of the full 128×128 atlas.
     */
    private final Map<TextureAtlasSprite, TextureAtlasSprite> ctmToIsolated;

    public ConnectingBakedModel(net.minecraft.client.resources.model.BakedModel wrapped,
                                Map<TextureAtlasSprite, ConnectionRule> spriteRules) {
        this(wrapped, spriteRules, Map.of(), CtmLayout.FULL, Map.of());
    }

    public ConnectingBakedModel(net.minecraft.client.resources.model.BakedModel wrapped,
                                Map<TextureAtlasSprite, ConnectionRule> spriteRules,
                                Map<TextureAtlasSprite, TextureAtlasSprite> ctmToIsolated) {
        this(wrapped, spriteRules, ctmToIsolated, CtmLayout.FULL, Map.of());
    }

    public ConnectingBakedModel(net.minecraft.client.resources.model.BakedModel wrapped,
                                Map<TextureAtlasSprite, ConnectionRule> spriteRules,
                                Map<TextureAtlasSprite, TextureAtlasSprite> ctmToIsolated,
                                CtmLayout layout) {
        this(wrapped, spriteRules, ctmToIsolated, layout, Map.of());
    }

    public ConnectingBakedModel(net.minecraft.client.resources.model.BakedModel wrapped,
                                Map<TextureAtlasSprite, ConnectionRule> spriteRules,
                                Map<TextureAtlasSprite, TextureAtlasSprite> ctmToIsolated,
                                CtmLayout layout,
                                Map<TextureAtlasSprite, CtmLayout> spriteLayouts) {
        super(wrapped);
        this.layout = layout;
        this.spriteLayouts = new IdentityHashMap<>(spriteLayouts);

        // Build a deduplicated rule list using identity (rules are stateless value objects)
        Map<ConnectionRule, Integer> ruleIndex = new IdentityHashMap<>();
        List<ConnectionRule> list = new ArrayList<>();
        int catchAll = -1;

        for (Map.Entry<TextureAtlasSprite, ConnectionRule> e : spriteRules.entrySet()) {
            ConnectionRule rule = e.getValue();
            if (!ruleIndex.containsKey(rule)) {
                ruleIndex.put(rule, list.size());
                list.add(rule);
            }
            if (e.getKey() == null) {
                catchAll = ruleIndex.get(rule);
            }
        }

        this.ruleList = list;
        this.catchAllRuleIndex = catchAll;

        Map<TextureAtlasSprite, Integer> s2r = new IdentityHashMap<>();
        for (Map.Entry<TextureAtlasSprite, ConnectionRule> e : spriteRules.entrySet()) {
            if (e.getKey() != null) {
                s2r.put(e.getKey(), ruleIndex.get(e.getValue()));
            }
        }
        this.spriteToRuleIndex = s2r;
        this.ctmToIsolated = new IdentityHashMap<>(ctmToIsolated);
    }

    // ---- ModelData (called per chunk rebuild, before getQuads) -----------------

    /**
     * Fallback for multipart models: NeoForge's MultipartModelData per-sub-model
     * resolution may not correctly pass CTM_MASKS back through getQuads.
     * Storing masks in a ThreadLocal ensures getQuads always finds them, since
     * getModelData and getQuads for the same block run sequentially on one thread.
     */
    private static final ThreadLocal<int[][]> MASKS_FALLBACK = new ThreadLocal<>();

    @Override
    public @NotNull ModelData getModelData(@NotNull BlockAndTintGetter level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull ModelData existing) {
        int numRules = ruleList.size();
        if (numRules == 0) return existing;

        boolean giant = this.layout == CtmLayout.GIANT;
        int[][] masks = new int[numRules][6];
        for (int ri = 0; ri < numRules; ri++) {
            for (Direction face : Direction.values()) {
                masks[ri][face.ordinal()] = giant
                        ? giantTileIndex(pos, face)
                        : computeMask(level, pos, state, face, ruleList.get(ri));
            }
        }

        MASKS_FALLBACK.set(masks);
        return existing.derive().with(CTM_MASKS, masks).build();
    }

    private int computeMask(BlockAndTintGetter level, BlockPos pos, BlockState state,
                            Direction face, ConnectionRule rule) {
        BlockPos[] offsets = NEIGHBOR_OFFSETS[face.ordinal()];

        boolean t  = rule.connects(level, pos, state, pos.offset(offsets[0]));
        boolean r  = rule.connects(level, pos, state, pos.offset(offsets[2]));
        boolean b  = rule.connects(level, pos, state, pos.offset(offsets[4]));
        boolean l  = rule.connects(level, pos, state, pos.offset(offsets[6]));
        // Diagonals only "active" if both adjacent cardinals connect
        boolean tr = t && r && rule.connects(level, pos, state, pos.offset(offsets[1]));
        boolean br = b && r && rule.connects(level, pos, state, pos.offset(offsets[3]));
        boolean bl = b && l && rule.connects(level, pos, state, pos.offset(offsets[5]));
        boolean tl = t && l && rule.connects(level, pos, state, pos.offset(offsets[7]));

        return (t ? 1 : 0) | (tr ? 2 : 0) | (r ? 4 : 0) | (br ? 8 : 0)
             | (b ? 16 : 0) | (bl ? 32 : 0) | (l ? 64 : 0) | (tl ? 128 : 0);
    }

    /**
     * Position-based tile index (0–3) for the GIANT 2×2 layout: a 2×2×2 image
     * spread across blocks. Ports Athena's GiantBlockModel formula for width=height=2.
     * Returns a linear tile index that {@code CtmLayout.GIANT.tile} decodes to [x,y].
     */
    private static int giantTileIndex(BlockPos pos, Direction face) {
        int x = Math.abs(pos.getX());
        int y = Math.abs(pos.getY());
        int z = Math.abs(pos.getZ());
        return switch (face.getAxis()) {
            case X -> {
                if (face.getAxisDirection() == Direction.AxisDirection.POSITIVE) z = Math.abs(z - 3);
                yield (z % 2) + (y % 2) * 2;
            }
            case Z -> {
                if (face.getAxisDirection() == Direction.AxisDirection.NEGATIVE) x = Math.abs(x - 3);
                yield (x % 2) + (y % 2) * 2;
            }
            default -> { // Y (up/down)
                if (face.getAxisDirection() == Direction.AxisDirection.NEGATIVE) z = Math.abs(z - 3);
                yield (x % 2) + (z % 2) * 2;
            }
        };
    }

    // ---- getQuads (UV remapping) -----------------------------------------------

    /**
     * Vanilla 3-arg path (used by {@code ItemRenderer} for item display). {@link BakedModelWrapper}
     * would otherwise delegate straight to the wrapped model, bypassing CTM — so route it through
     * the 5-arg override with empty model data. For PIECES this yields the solo tile (mask 0);
     * for legacy layouts the empty data falls back to the base quads exactly as before.
     */
    @Override
    public @NotNull List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side,
                                             @NotNull RandomSource rand) {
        return getQuads(state, side, rand, ModelData.EMPTY, null);
    }

    @Override
    public @NotNull List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side,
                                             @NotNull RandomSource rand, @NotNull ModelData data, @Nullable RenderType renderType) {
        // When DO calls us to sample our texture, return quads using the isolated sprite.
        // DO's ModelSpriteQuadTransformer normalises vertex UVs relative to sprite.getU0/U1,
        // so it must receive a sprite that covers exactly the isolated tile — not the full
        // 128×128 CTM atlas.
        if (isCalledByDomumOrnamentum()) {
            List<BakedQuad> base = originalModel.getQuads(state, side, rand, data, renderType);
            if (ctmToIsolated.isEmpty()) return base;
            List<BakedQuad> isolated = new ArrayList<>(base.size());
            for (BakedQuad quad : base) {
                TextureAtlasSprite iso = ctmToIsolated.get(quad.getSprite());
                isolated.add(iso != null ? createIsolatedQuad(quad, iso) : quad);
            }
            return isolated;
        }

        List<BakedQuad> base = originalModel.getQuads(state, side, rand, data, renderType);
        if (base.isEmpty()) return base;

        // Pane-type blocks (IronBarsBlock subclasses) have directional connection properties.
        // Their thin arm faces get AO-darkened at block boundaries where adjacent panes meet,
        // creating a dark stripe. Disable AO for these blocks by stripping the per-quad flag.
        boolean stripAO = state != null
                && state.hasProperty(BlockStateProperties.NORTH)
                && state.hasProperty(BlockStateProperties.EAST);

        // For pane-type blocks, suppress the post's own side faces in connected directions.
        // This must run BEFORE the masks null-check so it fires even when CTM data is absent
        // (multipart models may not propagate ModelData to sub-model getQuads calls).
        // The post model is uniquely identified by having unculled faces in all 4 horizontal
        // directions (N+S+E+W). Arm models only expose 2 horizontal directions (their two
        // glass faces), so this check safely targets the post without touching arm faces.
        if (stripAO && side == null) {
            boolean hasN = false, hasS = false, hasE = false, hasW = false;
            for (BakedQuad q : base) {
                switch (q.getDirection()) {
                    case NORTH -> hasN = true;
                    case SOUTH -> hasS = true;
                    case EAST  -> hasE = true;
                    case WEST  -> hasW = true;
                    default -> {}
                }
            }
            if (hasN && hasS && hasE && hasW) {
                List<BakedQuad> filtered = new ArrayList<>(base.size());
                for (BakedQuad q : base) {
                    Direction dir = q.getDirection();
                    BooleanProperty prop = switch (dir) {
                        case NORTH -> BlockStateProperties.NORTH;
                        case SOUTH -> BlockStateProperties.SOUTH;
                        case EAST  -> BlockStateProperties.EAST;
                        case WEST  -> BlockStateProperties.WEST;
                        default    -> null;
                    };
                    if (prop != null && state.hasProperty(prop) && state.getValue(prop)) continue;
                    filtered.add(q);
                }
                base = filtered;
                if (base.isEmpty()) return base;
            }
        }

        int[][] masks = data.get(CTM_MASKS);
        if (masks == null) masks = MASKS_FALLBACK.get(); // fallback for multipart models
        // PIECES blocks must still render when there's no connection data — item rendering
        // (state == null) and any missing-mask case fall back to the solo tile (mask 0) via the
        // compositor, rather than the raw full-strip base model.
        boolean piecesActive = isPiecesItem(layout)
                || spriteLayouts.values().stream().anyMatch(ConnectingBakedModel::isPiecesItem);
        if (masks == null && !piecesActive) return base;

        List<BakedQuad> result = new ArrayList<>(base.size());
        for (BakedQuad quad : base) {
            // Culled quads: side gives the face direction.
            // Unculled quads (e.g. glass pane faces that lack cullface): fall back to
            // the quad's own facing direction so CTM still fires for thin blocks.
            Direction quadFace = (side != null) ? side : quad.getDirection();
            int faceOrdinal = quadFace.ordinal();
            CtmLayout l = spriteLayouts.getOrDefault(quad.getSprite(), layout);
            if (isPieces(l)) {
                // state == null is item rendering: no neighbours, so show the solo tile.
                int mask;
                if (state == null || masks == null) {
                    mask = 0;
                } else {
                    int ruleIdx = spriteToRuleIndex.getOrDefault(quad.getSprite(), catchAllRuleIndex);
                    mask = (ruleIdx < 0 || ruleIdx >= masks.length) ? 0 : masks[ruleIdx][faceOrdinal];
                }
                addPieceQuads(result, quad, mask, faceOrdinal, stripAO);
            } else if (l == CtmLayout.PIECES_PANE) {
                // state == null is item rendering: no neighbours, so show the solo tile.
                int mask;
                if (state == null || masks == null) {
                    mask = 0;
                } else {
                    int ruleIdx = spriteToRuleIndex.getOrDefault(quad.getSprite(), catchAllRuleIndex);
                    mask = (ruleIdx < 0 || ruleIdx >= masks.length) ? 0 : masks[ruleIdx][faceOrdinal];
                }
                addPiecePaneQuads(result, quad, mask, faceOrdinal, stripAO);
            } else if (masks != null) {
                result.add(remapQuad(quad, masks, faceOrdinal, stripAO));
            } else {
                result.add(withAo(quad, !stripAO && quad.hasAmbientOcclusion()));
            }
        }
        return result;
    }

    /**
     * Faces whose Minecraft UV U-axis runs opposite to our neighbor-offset "right" convention.
     * For these faces, swap the L/R bits (and their diagonal pairs) before the tile lookup.
     */
    private static final boolean[] FLIP_H = new boolean[6];
    static {
        FLIP_H[Direction.NORTH.ordinal()] = true;
        FLIP_H[Direction.SOUTH.ordinal()] = true;
    }

    /**
     * Mirrors a CTM mask horizontally: swaps L↔R, TR↔TL, BR↔BL; T and B stay.
     * Bit layout: T=0, TR=1, R=2, BR=3, B=4, BL=5, L=6, TL=7
     */
    private static int flipMaskH(int m) {
        int t  = m & 1;
        int tr = (m >> 1) & 1;
        int r  = (m >> 2) & 1;
        int br = (m >> 3) & 1;
        int b  = (m >> 4) & 1;
        int bl = (m >> 5) & 1;
        int l  = (m >> 6) & 1;
        int tl = (m >> 7) & 1;
        return t | (tl << 1) | (l << 2) | (bl << 3) | (b << 4) | (br << 5) | (r << 6) | (tr << 7);
    }

    private BakedQuad remapQuad(BakedQuad quad, int[][] masks, int faceOrdinal, boolean stripAO) {
        TextureAtlasSprite sprite = quad.getSprite();

        // Find rule index for this sprite
        int ruleIdx = spriteToRuleIndex.getOrDefault(sprite, catchAllRuleIndex);
        if (ruleIdx < 0 || ruleIdx >= masks.length) {
            return (stripAO && quad.hasAmbientOcclusion())
                    ? new BakedQuad(quad.getVertices(), quad.getTintIndex(), quad.getDirection(), sprite, quad.isShade(), false)
                    : quad;
        }

        CtmLayout l = spriteLayouts.getOrDefault(sprite, layout);
        int mask = masks[ruleIdx][faceOrdinal];
        // GIANT stores a position-derived tile index, not a neighbour mask — never flip it.
        if (l != CtmLayout.GIANT && FLIP_H[faceOrdinal]) mask = flipMaskH(mask);
        // Vertical CTM connects only along the column's 4 side faces. The up/down caps are
        // perpendicular to the connection axis, so they must never connect — pin them to the
        // base tile [0,0] (the atlas's top section = the pillar cap design).
        if (l == CtmLayout.PIECES_VERTICAL
                && (faceOrdinal == Direction.UP.ordinal() || faceOrdinal == Direction.DOWN.ordinal())) {
            mask = 0;
        }
        int[] tile = l.tile(mask);
        int tileX = tile[0];
        int tileY = tile[1];

        boolean aoFlag = !stripAO && quad.hasAmbientOcclusion();

        // Tile [0,0] means "no connections" — input UV is already at tile [0,0], nothing to shift.
        if (tileX == 0 && tileY == 0) {
            if (aoFlag == quad.hasAmbientOcclusion()) return quad;
            return new BakedQuad(quad.getVertices(), quad.getTintIndex(), quad.getDirection(),
                    sprite, quad.isShade(), aoFlag);
        }

        int[] newVerts = Arrays.copyOf(quad.getVertices(), quad.getVertices().length);
        remapUV(newVerts, sprite, tileX, tileY, l);

        return new BakedQuad(newVerts, quad.getTintIndex(), quad.getDirection(),
                sprite, quad.isShade(), aoFlag);
    }

    // ---- PIECES layout: Athena-style 4-quadrant composition ---------------------

    /**
     * Athena piece-type for one corner, from its two cardinal neighbours and the diagonal.
     * <pre>
     *   both cardinals connect  → diagonal ? 1 (full interior) : 2 (inner corner)
     *   vertical cardinal only  → 3 (vertical edge)
     *   horizontal cardinal only→ 4 (horizontal edge)
     *   neither                 → 0 (solo / outer corner)
     * </pre>
     */
    private static int pieceType(boolean vert, boolean horiz, boolean diag) {
        if (vert && horiz) return diag ? 1 : 2;
        return vert ? 3 : horiz ? 4 : 0;
    }

    /** Athena type code → strip column index in the 80×16 (5×1 tile) texture. */
    private static final int[] TYPE_TO_COL = { 0, 1, 4, 2, 3 };

    /**
     * True only for the quarter-composition layout. PIECES_VERTICAL/PIECES_HORIZONTAL are
     * whole-tile (UV-shift) layouts and go through {@link #remapQuad}, not the compositor.
     */
    private static boolean isPieces(CtmLayout l) {
        return l == CtmLayout.PIECES;
    }

    /** Layouts whose item (state==null) rendering must still composite the solo tile. */
    private static boolean isPiecesItem(CtmLayout l) {
        return l == CtmLayout.PIECES || l == CtmLayout.PIECES_PANE;
    }

    /**
     * Returns a copy of {@code quad} with only its ambient-occlusion flag adjusted.
     */
    private static BakedQuad withAo(BakedQuad q, boolean aoFlag) {
        if (aoFlag == q.hasAmbientOcclusion()) return q;
        return new BakedQuad(q.getVertices(), q.getTintIndex(), q.getDirection(), q.getSprite(), q.isShade(), aoFlag);
    }

    /**
     * Splits a full-face quad into four 8×8 corner quadrants (PIECES layout). Each quadrant
     * independently selects a type-tile from the 80×16 strip via {@link #pieceType} and samples
     * that tile's matching corner-quarter. Geometry is bilinearly interpolated from the source
     * quad's four corners, so winding/normals/shade are preserved. If the source quad isn't a
     * clean 4-corner face (e.g. partial pane faces), it is emitted unchanged.
     */
    private void addPieceQuads(List<BakedQuad> out, BakedQuad quad, int mask, int faceOrdinal, boolean stripAO) {
        TextureAtlasSprite sprite = quad.getSprite();
        boolean aoFlag = !stripAO && quad.hasAmbientOcclusion();

        int[] sv = quad.getVertices();
        int stride = IQuadTransformer.STRIDE;
        if (sv.length < 4 * stride) { out.add(withAo(quad, aoFlag)); return; }

        float u0 = sprite.getU0(), u1 = sprite.getU1(), v0 = sprite.getV0(), v1 = sprite.getV1();

        // Map each source vertex to its texture corner (fu,fv ∈ {0,1}); fu=0 is the strip's left.
        int[] fuArr = new int[4], fvArr = new int[4];
        int[] cornerVert = { -1, -1, -1, -1 }; // index = fu + fv*2
        for (int i = 0; i < 4; i++) {
            int bp = i * stride;
            float u = Float.intBitsToFloat(sv[bp + IQuadTransformer.UV0]);
            float v = Float.intBitsToFloat(sv[bp + IQuadTransformer.UV0 + 1]);
            int fu = Math.abs(u - u0) <= Math.abs(u - u1) ? 0 : 1;
            int fv = Math.abs(v - v0) <= Math.abs(v - v1) ? 0 : 1;
            fuArr[i] = fu; fvArr[i] = fv;
            cornerVert[fu + fv * 2] = i;
        }
        for (int c = 0; c < 4; c++) {
            if (cornerVert[c] < 0) { out.add(withAo(quad, aoFlag)); return; } // not a clean quad
        }

        // Source corner positions for bilinear interpolation: [fu + fv*2][xyz]
        float[][] pos = new float[4][3];
        for (int c = 0; c < 4; c++) {
            int bp = cornerVert[c] * stride + IQuadTransformer.POSITION;
            pos[c][0] = Float.intBitsToFloat(sv[bp]);
            pos[c][1] = Float.intBitsToFloat(sv[bp + 1]);
            pos[c][2] = Float.intBitsToFloat(sv[bp + 2]);
        }

        // Connectivity → per-corner column. N/S faces flip L↔R to match texture U orientation.
        if (FLIP_H[faceOrdinal]) mask = flipMaskH(mask);
        boolean t  = (mask &   1) != 0, tr = (mask &   2) != 0, r  = (mask & 4) != 0, br = (mask & 8) != 0;
        boolean b  = (mask &  16) != 0, bl = (mask &  32) != 0, lf = (mask & 64) != 0, tl = (mask & 128) != 0;

        // regionX: 0=left,1=right ; regionY: 0=top,1=bottom
        out.add(buildCornerQuad(quad, sv, stride, sprite, aoFlag, fuArr, fvArr, pos, 0, 0, TYPE_TO_COL[pieceType(t, lf, tl)]));
        out.add(buildCornerQuad(quad, sv, stride, sprite, aoFlag, fuArr, fvArr, pos, 1, 0, TYPE_TO_COL[pieceType(t, r,  tr)]));
        out.add(buildCornerQuad(quad, sv, stride, sprite, aoFlag, fuArr, fvArr, pos, 0, 1, TYPE_TO_COL[pieceType(b, lf, bl)]));
        out.add(buildCornerQuad(quad, sv, stride, sprite, aoFlag, fuArr, fvArr, pos, 1, 1, TYPE_TO_COL[pieceType(b, r,  br)]));
    }

    /**
     * Builds one corner sub-quad. {@code regionX/regionY} select which face quadrant (and which
     * quarter of the {@code col} type-tile) this quad covers; vertex order matches the source so
     * winding is preserved.
     */
    private BakedQuad buildCornerQuad(BakedQuad src, int[] sv, int stride, TextureAtlasSprite sprite,
                                      boolean aoFlag, int[] fuArr, int[] fvArr, float[][] pos,
                                      int regionX, int regionY, int col) {
        float u0 = sprite.getU0(), v0 = sprite.getV0();
        float stripW = sprite.getU1() - u0, stripH = sprite.getV1() - v0;
        float tileW = stripW / 5f;     // one 16×16 type-tile
        float pieceW = tileW / 2f;     // one 8×8 piece (corner-quarter)
        float halfH = stripH / 2f;
        float qU0 = u0 + col * tileW + (regionX == 1 ? pieceW : 0f);
        float qV0 = v0 + (regionY == 1 ? halfH : 0f);

        int[] verts = sv.clone(); // preserves COLOR/UV2/NORMAL of each source vertex
        for (int i = 0; i < 4; i++) {
            int bp = i * stride;
            int fu = fuArr[i], fv = fvArr[i];
            float sfu = regionX * 0.5f + fu * 0.5f;
            float sfv = regionY * 0.5f + fv * 0.5f;
            verts[bp + IQuadTransformer.POSITION]     = Float.floatToRawIntBits(bilerp(pos, 0, sfu, sfv));
            verts[bp + IQuadTransformer.POSITION + 1] = Float.floatToRawIntBits(bilerp(pos, 1, sfu, sfv));
            verts[bp + IQuadTransformer.POSITION + 2] = Float.floatToRawIntBits(bilerp(pos, 2, sfu, sfv));
            verts[bp + IQuadTransformer.UV0]     = Float.floatToRawIntBits(qU0 + fu * pieceW);
            verts[bp + IQuadTransformer.UV0 + 1] = Float.floatToRawIntBits(qV0 + fv * halfH);
        }
        return new BakedQuad(verts, src.getTintIndex(), src.getDirection(), sprite, src.isShade(), aoFlag);
    }

    /** Bilinear interpolation of position component {@code comp} over the 4 face corners. */
    private static float bilerp(float[][] p, int comp, float fu, float fv) {
        return p[0][comp] * (1 - fu) * (1 - fv) + p[1][comp] * fu * (1 - fv)
             + p[2][comp] * (1 - fu) * fv       + p[3][comp] * fu * fv;
    }

    // ---- PIECES_PANE: quarter composition clipped to a pane arm/post sub-strip ---------

    /** Faces whose pane-strip horizontal (texture U) axis runs opposite world+; tune vs. in-game. */
    private static final boolean[] PANE_FLIP_X = new boolean[6];
    static {
        PANE_FLIP_X[Direction.NORTH.ordinal()] = true;
        PANE_FLIP_X[Direction.EAST.ordinal()]  = true;
    }

    /**
     * Composes the pieces appearance for a glass/window PANE broad face. A pane is thin, so each
     * arm/post broad face only covers a vertical sub-strip of the full 16×16 block face. We derive
     * that sub-strip from the quad's baked GEOMETRY (robust to the blockstate's 90° arm rotations),
     * then emit the quarter-pieces that overlap it, clipped — so a row/grid of panes composes the
     * same corner/edge/interior pieces a full block would. Up/down edge faces and non-rectangular
     * quads pass through unchanged.
     */
    private void addPiecePaneQuads(List<BakedQuad> out, BakedQuad quad, int mask, int faceOrdinal, boolean stripAO) {
        boolean aoFlag = !stripAO && quad.hasAmbientOcclusion();
        Direction dir = quad.getDirection();
        if (dir.getAxis() == Direction.Axis.Y) { out.add(withAo(quad, aoFlag)); return; } // edge/cap faces

        TextureAtlasSprite sprite = quad.getSprite();
        int[] sv = quad.getVertices();
        int stride = IQuadTransformer.STRIDE;
        if (sv.length < 4 * stride) { out.add(withAo(quad, aoFlag)); return; }

        // In-plane horizontal axis: N/S faces (normal Z) use X; E/W faces (normal X) use Z.
        int hAxis = (dir.getAxis() == Direction.Axis.Z) ? 0 : 2;
        boolean flipX = PANE_FLIP_X[faceOrdinal];

        // Source positions (block-local 0..1) and per-vertex face coords (0..16, V top-down).
        float[][] p = new float[4][3];
        float[] fx = new float[4], fy = new float[4];
        for (int i = 0; i < 4; i++) {
            int bp = i * stride + IQuadTransformer.POSITION;
            p[i][0] = Float.intBitsToFloat(sv[bp]);
            p[i][1] = Float.intBitsToFloat(sv[bp + 1]);
            p[i][2] = Float.intBitsToFloat(sv[bp + 2]);
            float h = p[i][hAxis] * 16f;
            fx[i] = flipX ? (16f - h) : h;
            fy[i] = 16f - p[i][1] * 16f;
        }
        float fx0 = Math.min(Math.min(fx[0], fx[1]), Math.min(fx[2], fx[3]));
        float fx1 = Math.max(Math.max(fx[0], fx[1]), Math.max(fx[2], fx[3]));
        float fy0 = Math.min(Math.min(fy[0], fy[1]), Math.min(fy[2], fy[3]));
        float fy1 = Math.max(Math.max(fy[0], fy[1]), Math.max(fy[2], fy[3]));
        if (fx1 - fx0 < 1e-4f || fy1 - fy0 < 1e-4f) { out.add(withAo(quad, aoFlag)); return; }

        // Map each source vertex to a rect corner (cx,cy) so winding is preserved.
        int[] role = new int[4];
        for (int i = 0; i < 4; i++) {
            int cx = Math.abs(fx[i] - fx0) <= Math.abs(fx[i] - fx1) ? 0 : 1;
            int cy = Math.abs(fy[i] - fy0) <= Math.abs(fy[i] - fy1) ? 0 : 1;
            role[i] = cx + cy * 2;
        }

        if (FLIP_H[faceOrdinal]) mask = flipMaskH(mask);
        boolean t  = (mask &   1) != 0, tr = (mask &   2) != 0, r  = (mask & 4) != 0, br = (mask & 8) != 0;
        boolean b  = (mask &  16) != 0, bl = (mask &  32) != 0, lf = (mask & 64) != 0, tl = (mask & 128) != 0;

        float u0 = sprite.getU0(), v0 = sprite.getV0();
        float stripW = sprite.getU1() - u0, stripH = sprite.getV1() - v0;
        float tileW = stripW / 5f, pieceW = tileW / 2f, halfH = stripH / 2f;

        // [regionX, regionY, strip-column] for the 4 face quadrants.
        int[][] qd = {
            {0, 0, TYPE_TO_COL[pieceType(t, lf, tl)]},
            {1, 0, TYPE_TO_COL[pieceType(t, r,  tr)]},
            {0, 1, TYPE_TO_COL[pieceType(b, lf, bl)]},
            {1, 1, TYPE_TO_COL[pieceType(b, r,  br)]},
        };
        for (int[] q : qd) {
            int rx = q[0], ry = q[1], col = q[2];
            float qx0 = rx * 8f, qy0 = ry * 8f;
            float cx0 = Math.max(qx0, fx0), cx1 = Math.min(qx0 + 8f, fx1);
            float cy0 = Math.max(qy0, fy0), cy1 = Math.min(qy0 + 8f, fy1);
            if (cx1 - cx0 <= 1e-4f || cy1 - cy0 <= 1e-4f) continue; // quadrant not in this strip

            int[] verts = sv.clone();
            for (int i = 0; i < 4; i++) {
                int cx = role[i] & 1, cy = role[i] >> 1;
                float ax = (cx == 0) ? cx0 : cx1;
                float ay = (cy == 0) ? cy0 : cy1;
                // geometry: position within the source face-rect → bilerp source corners
                float gfu = (ax - fx0) / (fx1 - fx0);
                float gfv = (ay - fy0) / (fy1 - fy0);
                int bp = i * stride;
                verts[bp + IQuadTransformer.POSITION]     = Float.floatToRawIntBits(bilerpRole(p, 0, gfu, gfv, role));
                verts[bp + IQuadTransformer.POSITION + 1] = Float.floatToRawIntBits(bilerpRole(p, 1, gfu, gfv, role));
                verts[bp + IQuadTransformer.POSITION + 2] = Float.floatToRawIntBits(bilerpRole(p, 2, gfu, gfv, role));
                // texture: position within the quadrant → that quarter of the strip tile
                float tfu = (ax - qx0) / 8f, tfv = (ay - qy0) / 8f;
                verts[bp + IQuadTransformer.UV0]     = Float.floatToRawIntBits(u0 + col * tileW + (rx + tfu) * pieceW);
                verts[bp + IQuadTransformer.UV0 + 1] = Float.floatToRawIntBits(v0 + (ry + tfv) * halfH);
            }
            out.add(new BakedQuad(verts, quad.getTintIndex(), dir, sprite, quad.isShade(), aoFlag));
        }
    }

    /** Bilerp of component {@code comp} using the per-vertex corner {@code role} (cx + cy*2). */
    private static float bilerpRole(float[][] p, int comp, float fu, float fv, int[] role) {
        float[] c = new float[4]; // c[cx + cy*2]
        for (int i = 0; i < 4; i++) c[role[i]] = p[i][comp];
        return c[0] * (1 - fu) * (1 - fv) + c[1] * fu * (1 - fv)
             + c[2] * (1 - fu) * fv       + c[3] * fu * fv;
    }

    /**
     * Creates a copy of {@code quad} where the CTM atlas sprite is replaced by the
     * isolated tile sprite and vertex UVs are remapped to span the isolated sprite's
     * full extent.
     *
     * <p>DO's {@code ModelSpriteQuadTransformer} normalises vertex UVs as:
     * {@code u_rel = (u_vertex - source.getU0()) / (source.getU1() - source.getU0())}
     * and then maps to the target via {@code target.getU(u_rel)}.
     * For the retextured block to display only the isolated tile, the quad we hand to DO
     * must have {@code sprite == isolatedSprite} and vertex UVs spanning
     * {@code [iso.u0, iso.u1]} — so DO's normalisation gives {@code u_rel ∈ [0, 1]}
     * and maps to the full isolated sprite.
     */
    private BakedQuad createIsolatedQuad(BakedQuad quad, TextureAtlasSprite isolatedSprite) {
        TextureAtlasSprite ctmSprite = quad.getSprite();
        float ctmU0 = ctmSprite.getU0();
        float ctmV0 = ctmSprite.getV0();
        CtmLayout l = spriteLayouts.getOrDefault(ctmSprite, layout);
        float tileW = (ctmSprite.getU1() - ctmU0) / l.tilesWide;
        float tileH = (ctmSprite.getV1() - ctmV0) / l.tilesHigh;

        float isoU0 = isolatedSprite.getU0();
        float isoU1 = isolatedSprite.getU1();
        float isoV0 = isolatedSprite.getV0();
        float isoV1 = isolatedSprite.getV1();

        int[] verts = Arrays.copyOf(quad.getVertices(), quad.getVertices().length);
        int stride = IQuadTransformer.STRIDE;
        int uvOffset = IQuadTransformer.UV0;

        for (int v = 0; v < 4; v++) {
            int base = v * stride + uvOffset;
            float u = Float.intBitsToFloat(verts[base]);
            float vv = Float.intBitsToFloat(verts[base + 1]);

            // Normalize within the first CTM tile: [ctmU0, ctmU0+tileW] → [0, 1]
            float uRel = (u - ctmU0) / tileW;
            float vRel = (vv - ctmV0) / tileH;

            // Remap to the full isolated sprite extent
            verts[base]     = Float.floatToRawIntBits(isoU0 + uRel * (isoU1 - isoU0));
            verts[base + 1] = Float.floatToRawIntBits(isoV0 + vRel * (isoV1 - isoV0));
        }

        return new BakedQuad(verts, quad.getTintIndex(), quad.getDirection(),
                isolatedSprite, quad.isShade(), quad.hasAmbientOcclusion());
    }

    private static final StackWalker STACK_WALKER = StackWalker.getInstance();

    private static boolean isCalledByDomumOrnamentum() {
        return STACK_WALKER.walk(frames -> frames.limit(25).anyMatch(f -> {
            String name = f.getClassName();
            return name.contains("domumornamentum") || name.contains("ldbc");
        }));
    }

    /**
     * Remaps UV coordinates in-place from tile [0,0] to tile [tileX, tileY].
     */
    private void remapUV(int[] verts, TextureAtlasSprite sprite, int tileX, int tileY, CtmLayout l) {
        float u0 = sprite.getU0();
        float u1 = sprite.getU1();
        float v0 = sprite.getV0();
        float v1 = sprite.getV1();
        float tileW = (u1 - u0) / l.tilesWide;
        float tileH = (v1 - v0) / l.tilesHigh;

        int stride = IQuadTransformer.STRIDE;
        int uvOffset = IQuadTransformer.UV0;

        for (int v = 0; v < 4; v++) {
            int base = v * stride + uvOffset;
            float u = Float.intBitsToFloat(verts[base]);
            float vv = Float.intBitsToFloat(verts[base + 1]);

            // The input UV already sits within tile [0,0] (first 16px of the sprite).
            // Shift it by tileX/tileY tile-widths to reach the target tile.
            verts[base]     = Float.floatToRawIntBits(u  + tileX * tileW);
            verts[base + 1] = Float.floatToRawIntBits(vv + tileY * tileH);
        }
    }
}