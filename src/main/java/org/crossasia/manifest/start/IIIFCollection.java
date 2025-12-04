package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.Collection;
import org.crossasia.manifest.statics.collection.CollectionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.crossasia.manifest.collection.CollectionAttributes.getCollection;

/**
 * Builds IIIF Collection manifests from individual manifest files.
 * <p>
 * This class reads manifest files from a configured directory and creates
 * a collection manifest that aggregates them into a single IIIF Collection.
 * </p>
 */
public class IIIFCollection {
    private static final Logger logger = LoggerFactory.getLogger(IIIFCollection.class);

    /**
     * Builds a collection manifest using the default DTAB configuration.
     * This method is kept for backward compatibility.
     *
     * @throws IOException if an error occurs reading manifests or writing the collection
     * @deprecated Use {@link #buildCollection(CollectionConfig)} instead for better flexibility
     */
    @Deprecated
    public static void buildCollection() throws IOException {
        buildCollection(CollectionConfig.DTAB);
    }

    /**
     * Builds a collection manifest for the specified collection configuration.
     *
     * @param config the collection configuration to use
     * @throws IOException if an error occurs reading manifests or writing the collection
     */
    public static void buildCollection(CollectionConfig config) throws IOException {
        logger.info("Starting collection build for: {}", config.getLabel());

        File manifestsDir = new File(config.getManifestsFolder());

        if (!manifestsDir.exists()) {
            throw new FileNotFoundException("Manifests directory not found: " + config.getManifestsFolder());
        }

        if (!manifestsDir.isDirectory()) {
            throw new IllegalArgumentException("Manifests path is not a directory: " + config.getManifestsFolder());
        }

        File[] files = manifestsDir.listFiles();
        if (files == null || files.length == 0) {
            logger.warn("No manifest files found in: {}", config.getManifestsFolder());
        }

        // Build the collection from manifest files
        Collection collection = getCollection(manifestsDir, config);

        // Determine output file path (collection.json in parent directory of manifests)
        Path manifestsPath = Paths.get(config.getManifestsFolder());
        Path collectionPath = manifestsPath.getParent().resolve("collection.json");
        File collectionFile = collectionPath.toFile();

        // Ensure parent directory exists
        File parentDir = collectionFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            if (parentDir.mkdirs()) {
                logger.info("Created directory: {}", parentDir.getAbsolutePath());
            }
        }

        // Write collection to file with try-with-resources
        try (PrintStream out = new PrintStream(new FileOutputStream(collectionFile))) {
            out.println(collection);
            logger.info("Successfully wrote collection manifest to: {}", collectionFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            logger.error("Failed to create collection file: {}", collectionFile.getAbsolutePath(), e);
            throw e;
        }

        logger.info("Collection build completed for: {}", config.getLabel());
    }
}

