package com.otterly76.ott.client.model.ctm;

/**
 * CTM atlas layout types. Each layout defines how a neighbour-mask maps to
 * a tile coordinate within its texture atlas, and how many tiles wide/tall
 * that atlas is.
 *
 * <p>Our 8-bit mask encoding (matches {@link ConnectingBakedModel}):
 * bit 0=T, bit 1=TR, bit 2=R, bit 3=BR, bit 4=B, bit 5=BL, bit 6=L, bit 7=TL
 */
public enum CtmLayout {

    // ---- layout types ---------------------------------------------------------

    /** 8×8 atlas (128×128 px), all 8 neighbours, 256 combinations. Default. */
    FULL(8, 8) {
        @Override public int[] tile(int mask) {
            int m = mask & 0xFF;
            return new int[]{ FullLayoutLookup.TILE_X[m], FullLayoutLookup.TILE_Y[m] };
        }
    },

    /**
     * 4×4 atlas (64×64 px), 4 cardinal neighbours only, 16 combinations.
     * Handles all corner, edge, T-junction, and centre patterns.
     */
    SIMPLE(4, 4) {
        @Override public int[] tile(int mask) {
            int idx = simpleIdx(mask);
            return new int[]{ SIMPLE_X[idx], SIMPLE_Y[idx] };
        }
    },

    /**
     * 4×1 atlas (64×16 px), left + right neighbours only.
     * Tiles: isolated | right-end | centre | left-end.
     */
    HORIZONTAL(4, 1) {
        @Override public int[] tile(int mask) {
            // left=bit6, right=bit2
            int idx = ((mask >> 6) & 1) | (((mask >> 2) & 1) << 1);
            return new int[]{ HORIZ_X[idx], 0 };
        }
    },

    /**
     * 1×4 atlas (16×64 px), top + bottom neighbours only.
     * Tiles: isolated | bottom-end | centre | top-end.
     */
    VERTICAL(1, 4) {
        @Override public int[] tile(int mask) {
            // top=bit0, bottom=bit4
            int idx = (mask & 1) | (((mask >> 4) & 1) << 1);
            return new int[]{ 0, VERT_Y[idx] };
        }
    },

    /**
     * 5×1 atlas (80×16 px), all 8 neighbours, 5 tile variants.
     * Designed for striped / plank textures that only need: isolated (0),
     * fully-connected (1), vertical-straight (2), horizontal-straight (3),
     * and cross / no-diagonal (4).
     *
     * <p>Tile map:
     * <pre>
     *  0  isolated (0–1 sides, corners, T-junctions without full seams)
     *  1  fully connected (4 cardinals + all 4 diagonals)
     *  2  vertical straight (T+B, with side neighbours forming a clean column)
     *  3  horizontal straight (L+R, with side neighbours forming a clean row)
     *  4  cross (4 cardinals, no diagonals)
     * </pre>
     */
    COMPACT(5, 1) {
        @Override public int[] tile(int mask) {
            boolean t  = (mask &   1) != 0;
            boolean r  = (mask &   4) != 0;
            boolean b  = (mask &  16) != 0;
            boolean l  = (mask &  64) != 0;
            boolean tr = (mask &   2) != 0;
            boolean br = (mask &   8) != 0;
            boolean bl = (mask &  32) != 0;
            boolean tl = (mask & 128) != 0;
            int sides = (t ? 1 : 0) + (r ? 1 : 0) + (b ? 1 : 0) + (l ? 1 : 0);
            int x;
            if (sides <= 1) {
                x = 0;
            } else if (sides == 2) {
                if      (l && r) x = 3;
                else if (t && b) x = 2;
                else             x = 0; // corner
            } else if (sides == 3) {
                if (l && r)
                    x = ((tl && t && tr) || (bl && b && br)) ? 3 : 0;
                else // t && b must be true; only {t,b,l} or {t,b,r} remain
                    x = ((tl && l && bl) || (tr && r && br)) ? 2 : 0;
            } else { // sides == 4
                if      ( tl &&  tr &&  bl &&  br) x = 1;
                else if (!tl && !tr && !bl && !br) x = 4;
                else                               x = 0;
            }
            return new int[]{ x, 0 };
        }
    },

    /**
     * 2×2 atlas (e.g. 32×32 px). Position-based "giant" layout: a 2×2×2 image spread
     * across a region of blocks. The tile is chosen from the block's world position + face
     * axis in {@code ConnectingBakedModel.giantTileIndex}, so here {@code idx} arrives already
     * as the linear tile index (0–3), not a neighbour mask.
     */
    GIANT(2, 2) {
        @Override public int[] tile(int idx) {
            int m = idx & 3;
            return new int[]{ m % 2, m / 2 };
        }
    },

    /**
     * 5×1 strip (80×16 px), Athena-style piece composition. Each block face is split into
     * four 8×8 corner quadrants; each quadrant independently picks one of the 5 type-tiles
     * (solo / full / vertical-edge / horizontal-edge / inner-corner) and samples that tile's
     * matching corner-quarter. Unlike the other layouts, this one does NOT use the UV-shift
     * {@link #tile} path — {@link ConnectingBakedModel} routes it through a dedicated
     * 4-quadrant compositor. {@code tile()} is unused here.
     *
     * <p>Strip columns (each a 16×16 type-tile): 0=solo, 1=full, 2=vertical-edge,
     * 3=horizontal-edge, 4=inner-corner. See {@link ConnectingBakedModel} for the
     * {@code (vertical, horizontal, diagonal) → column} selection rule.
     *
     * <p>Model id: {@code "pieces_full"} (alias {@code "pieces"}).
     */
    PIECES(5, 1) {
        @Override public int[] tile(int mask) {
            return new int[]{ 0, 0 };
        }
    },

    /**
     * 4×1 strip (64×16 px), whole-tile selection for vertical pillars. Tiles left→right:
     * 0=cap/isolated, 1=top (connects down), 2=middle (connects both), 3=bottom (connects up).
     * Selected by the top/bottom neighbours only; the cap tile (0) also covers the up/down end
     * faces (pinned in {@code ConnectingBakedModel.remapQuad}). NOT quarter-composed.
     */
    PIECES_VERTICAL(4, 1) {
        @Override public int[] tile(int mask) {
            boolean up   = (mask &  1) != 0; // T
            boolean down = (mask & 16) != 0; // B
            int x = (up && down) ? 2 : down ? 1 : up ? 3 : 0;
            return new int[]{ x, 0 };
        }
    },

    /**
     * 4×1 strip (64×16 px), whole-tile selection for horizontal connecting bricks. Tiles
     * left→right: 0=cap/isolated, 1=left-end (connects right), 2=middle (connects both),
     * 3=right-end (connects left). Selected by the left/right neighbours only. NOT quarter-composed.
     */
    PIECES_HORIZONTAL(4, 1) {
        @Override public int[] tile(int mask) {
            boolean left  = (mask & 64) != 0; // L
            boolean right = (mask &  4) != 0; // R
            int x = (left && right) ? 2 : right ? 1 : left ? 3 : 0;
            return new int[]{ x, 0 };
        }
    },

    /**
     * 5×1 strip (80×16) for glass/window PANES sharing the block's {@code pieces_full} strip.
     * Panes are thin (partial faces), so they can't use the {@link #PIECES} quarter-compositor;
     * instead this is a whole-tile UV-shift layout (routed through {@code remapQuad}, NOT the
     * compositor) that shows a center vertical slice of one of the 5 pieces-strip tiles.
     *
     * <p>Tile selection is tuned for pane connectivity so glass reads "clear when connecting,
     * framed when isolated":
     * <pre>
     *   connected along a run (L&amp;R or U&amp;D), or mostly surrounded → 1 (FULL / clear interior)
     *   isolated / single-side                                        → 0 (SOLO / bordered frame)
     * </pre>
     * Strip columns match {@link #PIECES}: 0=solo, 1=full, 2=vertical-edge, 3=horizontal-edge,
     * 4=inner-corner. (First-pass selection — tune here against in-client results.)
     */
    PIECES_PANE(5, 1) {
        @Override public int[] tile(int mask) {
            boolean t = (mask &  1) != 0; // up
            boolean r = (mask &  4) != 0; // right
            boolean b = (mask & 16) != 0; // down
            boolean l = (mask & 64) != 0; // left
            // Clear (FULL) when part of a run (or 3+ sides, which always includes a full axis);
            // framed (SOLO) when isolated/cornered.
            int x = ((l && r) || (t && b)) ? 1 : 0;
            return new int[]{ x, 0 };
        }
    };

    // ---- dimensions -----------------------------------------------------------

    /** Number of tiles across the atlas horizontally. */
    public final int tilesWide;
    /** Number of tiles down the atlas vertically. */
    public final int tilesHigh;

    CtmLayout(int tilesWide, int tilesHigh) {
        this.tilesWide = tilesWide;
        this.tilesHigh = tilesHigh;
    }

    /**
     * Returns {tileX, tileY} for the given 8-bit neighbour mask.
     * Tile [0,0] is the top-left (isolated / no-connections) tile.
     */
    public abstract int[] tile(int mask);

    // ---- SIMPLE ---------------------------------------------------------------
    // 4-bit index: bit0=T, bit1=R, bit2=B, bit3=L  (cardinals extracted from 8-bit mask)

    private static int simpleIdx(int mask8) {
        return (mask8 & 1) | ((mask8 >> 2 & 1) << 1) | ((mask8 >> 4 & 1) << 2) | ((mask8 >> 6 & 1) << 3);
    }

    //                         0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
    // idx key: none, T, R, TR, B, TB, RB, TRB, L, TL, LR, TRL, BL, TBL, RBL, all
    private static final int[] SIMPLE_X = { 0, 3, 2, 2, 2, 1, 2, 0, 3, 3, 0, 0, 3, 1, 1, 1 };
    private static final int[] SIMPLE_Y = { 0, 1, 1, 3, 0, 1, 2, 2, 0, 3, 1, 3, 2, 2, 3, 0 };

    // ---- HORIZONTAL -----------------------------------------------------------
    // 2-bit index: bit0=L, bit1=R

    //                          0  1  2  3   (none, L, R, L+R)
    private static final int[] HORIZ_X = { 0, 3, 1, 2 };

    // ---- VERTICAL -------------------------------------------------------------
    // 2-bit index: bit0=T, bit1=B

    //                         0  1  2  3   (none, T, B, T+B)
    private static final int[] VERT_Y = { 0, 3, 1, 2 };

    // ---- factory --------------------------------------------------------------

    /** Parses a layout id string; defaults to {@link #FULL} for unknown/absent values. */
    public static CtmLayout fromId(String id) {
        return switch (id.toLowerCase()) {
            case "simple"     -> SIMPLE;
            case "horizontal" -> HORIZONTAL;
            case "vertical"   -> VERTICAL;
            case "compact"    -> COMPACT;
            case "giant"      -> GIANT;
            case "pieces_full", "pieces" -> PIECES; // "pieces" kept as a hidden alias
            case "pieces_vertical"   -> PIECES_VERTICAL;
            case "pieces_horizontal" -> PIECES_HORIZONTAL;
            case "pieces_pane"       -> PIECES_PANE;
            default           -> FULL;
        };
    }
}
