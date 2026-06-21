package com.otterly76.ott.client.model.ctm;

/**
 * Lookup table for the CTM "full detailed" layout (12×4 tile grid, 192×64 px) — the compact
 * OptiFine-style layout that replaced the legacy 8×8 / 128×128 Fusion atlas.
 * <p>The 8-bit connection mask uses:
 * bit 0 (1) = top, bit 1 (2) = top-right (only when top AND right connect),
 * bit 2 (4) = right, bit 3 (8) = bottom-right (only when right AND bottom connect),
 * bit 4 (16) = bottom, bit 5 (32) = bottom-left (only when bottom AND left connect),
 * bit 6 (64) = left, bit 7 (128) = top-left (only when left AND top connect).
 * <p>TILE_X[mask] and TILE_Y[mask] give the column (0–11) and row (0–3)
 * of the correct tile in the 192×64 CTM atlas PNG.
 * <p>Regenerated from the legacy Fusion table by remapping each tile to its OptiFine slot
 * (see to_be_added/reformat/OLD.png ↔ NEW.png; tile N → column N%12, row N//12).
 */
public final class FullLayoutLookup {

    private FullLayoutLookup() {}

    // 256-entry arrays: index = 8-bit connection mask
    public static final byte[] TILE_X = {
        0, 0, 0, 0, 1, 4, 1, 1, 0, 0, 0, 0, 1, 4, 1, 1,
        0, 0, 0, 0, 4, 6, 4, 6, 0, 0, 0, 0, 1, 4, 1, 1,
        0, 0, 0, 0, 1, 4, 1, 1, 0, 0, 0, 0, 1, 4, 1, 1,
        0, 0, 0, 0, 4, 6, 4, 6, 0, 0, 0, 0, 1, 4, 1, 1,
        3, 5, 3, 5, 2, 6, 2, 4, 3, 5, 3, 5, 2, 6, 2, 4,
        5, 7, 5, 7, 7, 10, 7, 8, 5, 7, 5, 7, 7, 9, 7, 11,
        3, 5, 3, 5, 2, 6, 2, 4, 3, 5, 3, 5, 2, 6, 2, 4,
        3, 7, 3, 7, 5, 9, 5, 10, 3, 7, 3, 7, 2, 10, 2, 9,
        0, 0, 0, 0, 1, 4, 1, 1, 0, 0, 0, 0, 1, 4, 1, 1,
        0, 0, 0, 0, 4, 6, 4, 6, 0, 0, 0, 0, 1, 4, 1, 1,
        0, 0, 0, 0, 1, 4, 1, 1, 0, 0, 0, 0, 1, 4, 1, 1,
        0, 0, 0, 0, 4, 6, 4, 6, 0, 0, 0, 0, 1, 4, 1, 1,
        3, 3, 3, 3, 2, 6, 2, 2, 3, 3, 3, 3, 2, 6, 2, 2,
        5, 5, 5, 5, 7, 8, 7, 11, 5, 5, 5, 5, 7, 11, 7, 9,
        3, 3, 3, 3, 2, 6, 2, 2, 3, 3, 3, 3, 2, 6, 2, 2,
        3, 3, 3, 3, 5, 10, 5, 8, 3, 3, 3, 3, 2, 8, 2, 2
    };

    public static final byte[] TILE_Y = {
        0, 3, 0, 3, 0, 1, 0, 3, 0, 3, 0, 3, 0, 1, 0, 3,
        1, 2, 1, 2, 0, 0, 0, 2, 1, 2, 1, 2, 1, 2, 1, 2,
        0, 3, 0, 3, 0, 1, 0, 3, 0, 3, 0, 3, 0, 1, 0, 3,
        1, 2, 1, 2, 0, 0, 0, 2, 1, 2, 1, 2, 1, 2, 1, 2,
        0, 1, 0, 1, 0, 1, 0, 3, 0, 1, 0, 1, 0, 1, 0, 3,
        0, 1, 0, 1, 0, 3, 0, 0, 0, 1, 0, 1, 2, 0, 2, 1,
        0, 1, 0, 1, 0, 1, 0, 3, 0, 1, 0, 1, 0, 1, 0, 3,
        1, 3, 1, 3, 2, 1, 2, 2, 1, 3, 1, 3, 1, 1, 1, 3,
        0, 3, 0, 3, 0, 1, 0, 3, 0, 3, 0, 3, 0, 1, 0, 3,
        1, 2, 1, 2, 0, 0, 0, 2, 1, 2, 1, 2, 1, 2, 1, 2,
        0, 3, 0, 3, 0, 1, 0, 3, 0, 3, 0, 3, 0, 1, 0, 3,
        1, 2, 1, 2, 0, 0, 0, 2, 1, 2, 1, 2, 1, 2, 1, 2,
        0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3,
        0, 3, 0, 3, 0, 1, 0, 0, 0, 3, 0, 3, 2, 2, 2, 2,
        0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3,
        1, 2, 1, 2, 2, 0, 2, 2, 1, 2, 1, 2, 1, 3, 1, 2
    };

    /** Number of tile columns in the atlas (12 tiles × 16px = 192px wide). */
    public static final int TILES_WIDE = 12;
    /** Number of tile rows in the atlas (4 tiles × 16px = 64px tall). */
    public static final int TILES_TALL = 4;
}
