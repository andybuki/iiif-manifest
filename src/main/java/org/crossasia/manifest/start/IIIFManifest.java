package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.statics.collection.CollectionConfig;

import java.io.File;
import java.io.IOException;

import static org.crossasia.manifest.start.FileCreator.fileCreator;

/**
 * Entry point for building IIIF manifests.
 *
 * Option 1: Keep using legacy static import (no changes needed)
 * Option 2: Use CollectionConfig for flexibility
 */
public class IIIFManifest {

    // ========== Option 1: Original code (works with new FileCreator) ==========

    /**
     * Build manifests using default configuration (Kahlen collection).
     * Uses RESULT_FOLGER from ManifestData for backward compatibility.
     */
    public static void buildManifest() throws IOException {
        // This still works! ManifestData.RESULT_FOLGER is still available
        File in = new File(org.crossasia.manifest.statics.manifest.ManifestData.RESULT_FOLGER);
        File directory = new File(String.valueOf(in));
        File[] filesDir = directory.listFiles();
        Manifestor manifestor = new Manifestor();
        fileCreator(filesDir, manifestor);
    }

    // ========== Option 2: New flexible approach ==========

    /**
     * Build manifests for a specific collection.
     * Uses CollectionConfig for all paths.
     *
     * @param config The collection configuration to use
     */
    public static void buildManifest(CollectionConfig config) throws IOException {
        File inputDir = new File(config.getResultFolder());

        if (!inputDir.exists() || !inputDir.isDirectory()) {
            throw new IOException("Input directory does not exist: " + config.getResultFolder());
        }

        File[] filesDir = inputDir.listFiles();
        if (filesDir == null || filesDir.length == 0) {
            System.out.println("No files found in: " + config.getResultFolder());
            return;
        }

        Manifestor manifestor = new Manifestor();

        // Call appropriate processor based on collection
        switch (config) {
            case KAHLEN:
                FileCreator.processKahlenFiles(filesDir, manifestor);
                break;
            // Add other collections here as needed:
            // case DTAB:
            //     FileCreator.processDtabFiles(filesDir, manifestor);
            //     break;
            default:
                System.err.println("No processor defined for collection: " + config.name());
        }
    }
}