package org.crossasia.manifest.transformation;

import org.crossasia.manifest.statics.collection.CollectionConfig;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Transforms file names to document IDs.
 *
 * Different collections have different ID formats:
 * - DTAB: "B0001" → "B-0001" (needs dash after letter)
 * - TAP: "A0001" → "A0001" (no transformation needed)
 * - KAHLEN: uses ID as-is
 */
public class IdTransformation {

    /**
     * Transform file name to ID based on collection rules.
     * This is the preferred method.
     *
     * @param file   The input file
     * @param config The collection configuration
     * @return The transformed ID
     */
    @NotNull
    public static String idTransformator(File file, CollectionConfig config) {
        String id = file.getName().replace(".json", "");

        switch (config) {
            case DTAB:
                // DTAB needs dash after letter prefix (B0001 → B-0001)
                return transformDtabId(id);

            case TAP:
            case KAHLEN:
            case TURFAN:
            case SUGAWARA:
            case DLLM:
            case LANNA:
            default:
                // No transformation needed - use ID as-is
                return id;
        }
    }

    /**
     * DTAB-specific transformation: adds dash after letter prefix.
     * B0001 → B-0001
     * ELA0001 → ELA-0001
     */
    private static String transformDtabId(String id) {
        // Handle multi-letter prefixes first
        if (id.contains("ELA") && !id.contains("ELA-")) {
            return id.replace("ELA", "ELA-");
        }
        if (id.contains("LA") && !id.contains("LA-")) {
            return id.replace("LA", "LA-");
        }

        // Handle single letter prefixes (only if followed by digit)
        id = addDashAfterLetter(id, "B");
        id = addDashAfterLetter(id, "C");
        id = addDashAfterLetter(id, "D");

        // Special case for A: only if the non-digit part equals "A"
        if (id.replaceAll("\\d", "").equals("A") && !id.contains("A-")) {
            id = id.replace("A", "A-");
        }

        return id;
    }

    /**
     * Add dash after a letter prefix if not already present.
     */
    private static String addDashAfterLetter(String id, String letter) {
        if (id.startsWith(letter) && !id.startsWith(letter + "-")) {
            return id.replace(letter, letter + "-");
        }
        return id;
    }

    // ========== Legacy method for backward compatibility ==========

    /**
     * @deprecated Use {@link #idTransformator(File, CollectionConfig)} instead.
     * This applies DTAB transformation to all collections, which may not be correct.
     */
    @Deprecated
    @NotNull
    public static String idTransformator(File file) {
        // Legacy behavior - applies DTAB transformation (for backward compatibility)
        String id = file.getName().replace(".json", "");
        return transformDtabId(id);
    }
}