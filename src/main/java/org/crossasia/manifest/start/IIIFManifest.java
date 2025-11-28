package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.statics.collection.CollectionConfig;

import java.io.File;
import java.io.IOException;

/**
 * Entry point for building IIIF manifests.
 *
 * Usage:
 *   IIIFManifest.buildManifest();                           // Default: Kahlen
 *   IIIFManifest.buildManifest(CollectionConfig.DTAB);      // Specific collection
 */
public class IIIFManifest {

    /**
     * Build manifests using default configuration (Kahlen collection).
     * Kept for backward compatibility.
     */
    public static void buildManifest() throws IOException {
        buildManifest(CollectionConfig.TAP);
    }

    /**
     * Build manifests for a specific collection.
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

        // One line! No switch needed - FileCreator handles everything
        FileCreator.processFiles(filesDir, manifestor, config);
    }
}