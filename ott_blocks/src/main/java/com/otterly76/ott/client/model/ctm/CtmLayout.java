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

    /** 12×4 atlas (192×64 px), all 8 neighbours, 256 combinations. Default. (Compact OptiFine layout.) */
    FULL(12, 4) {
        @Override public int[] tile(int mask) {
            int m = mask & 0xFF;
            return new int[]{ FullLayoutLookup.TILE_X[m], FullLayoutLookup.TILE_Y[m] };
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

    // ---- factory --------------------------------------------------------------

    /** Parses a layout id string; defaults to {@link #FULL} for unknown/absent values. */
    public static CtmLayout fromId(String id) {
        return switch (id.toLowerCase()) {
            case "full", "full_detailed" -> FULL; // "full_detailed" = self-documenting alias for the 12×4 atlas
            case "giant"      -> GIANT;
            case "pieces_full", "pieces" -> PIECES; // "pieces" kept as a hidden alias
            case "pieces_vertical"   -> PIECES_VERTICAL;
            case "pieces_horizontal" -> PIECES_HORIZONTAL;
            case "pieces_pane"       -> PIECES_PANE;
            default           -> FULL;
        };
    }
}
