package org.crossasia.manifest;

import org.crossasia.manifest.start.IIIFCollection;
import org.crossasia.manifest.statics.collection.CollectionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Entry point for building IIIF collection manifests.
 * <p>
 * This application reads individual manifest files from a configured directory
 * and creates an aggregated IIIF Collection manifest.
 * </p>
 *
 * <h3>Usage:</h3>
 * <pre>
 * # Build collection for default (DTAB) configuration
 * java -jar iiif-manifest.jar
 *
 * # Build collection for specific configuration
 * java -jar iiif-manifest.jar KAHLEN
 * java -jar iiif-manifest.jar SUGAWARA
 * java -jar iiif-manifest.jar TURFAN
 * </pre>
 */
public class IIIFCollectionStart {
    private static final Logger logger = LoggerFactory.getLogger(IIIFCollectionStart.class);

    /**
     * Main entry point for collection building.
     *
     * @param args optional command line arguments. First argument can specify collection name
     *             (DTAB, KAHLEN, SUGAWARA, TURFAN, TAP, DLLM, LANNA)
     */
    public static void main(String[] args) {
        try {
            CollectionConfig config = determineConfig(args);
            logger.info("Building collection for: {}", config.name());

            IIIFCollection.buildCollection(config);

            logger.info("Collection build completed successfully");
            System.exit(0);

        } catch (IllegalArgumentException e) {
            logger.error("Invalid configuration: {}", e.getMessage());
            printUsage();
            System.exit(1);

        } catch (IOException e) {
            logger.error("Failed to build collection: {}", e.getMessage(), e);
            System.exit(1);

        } catch (Exception e) {
            logger.error("Unexpected error during collection build", e);
            System.exit(1);
        }
    }

    /**
     * Determines which collection configuration to use based on command line arguments.
     *
     * @param args command line arguments
     * @return the collection configuration to use
     * @throws IllegalArgumentException if an invalid collection name is specified
     */
    private static CollectionConfig determineConfig(String[] args) {
        if (args.length == 0) {
            logger.info("No collection specified, using default: TAP");
            return CollectionConfig.TAP;
        }

        String collectionName = args[0].trim().toUpperCase();
        try {
            return CollectionConfig.valueOf(collectionName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Unknown collection: " + collectionName +
                    ". Valid options: DTAB, KAHLEN, SUGAWARA, TURFAN, TAP, DLLM, LANNA"
            );
        }
    }

    /**
     * Prints usage information to the console.
     */
    private static void printUsage() {
        System.err.println("\nUsage: java -jar iiif-manifest.jar [COLLECTION_NAME]");
        System.err.println("\nAvailable collections:");
        for (CollectionConfig config : CollectionConfig.values()) {
            System.err.println("  - " + config.name() + ": " + config.getLabel());
        }
        System.err.println("\nExample: java -jar iiif-manifest.jar KAHLEN");
    }
}
