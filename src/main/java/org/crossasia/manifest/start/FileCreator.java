package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.canvas.CanvasCreator;
import org.crossasia.manifest.metadata.StaticFields;
import org.crossasia.manifest.statics.collection.CollectionConfig;
import org.crossasia.manifest.transformation.IdTransformation;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Generic file processor that works with any collection.
 *
 * To add a new collection:
 * 1. Add entry to CollectionConfig enum
 * 2. Add entry to AttributeProcessor enum (if collection-specific metadata needed)
 * 3. Done! No new methods needed here.
 */
public class FileCreator {

    /**
     * Legacy method - processes Kahlen files (default behavior)
     * Kept for backward compatibility with IIIFManifest.buildManifest()
     */
    public static void fileCreator(File[] filesDir, Manifestor manifestor) throws IOException {
        processFiles(filesDir, manifestor, CollectionConfig.KAHLEN);
    }

    /**
     * Generic method to process files for ANY collection.
     * This is the main entry point for all collections.
     */
    public static void processFiles(File[] filesDir, Manifestor manifestor,
                                    CollectionConfig config) throws IOException {

        CanvasCreator canvasCreator = createCanvasCreator(config);
        AttributeProcessor attributeProcessor = AttributeProcessor.forCollection(config);

        File outputDir = new File(config.getManifestsFolder());
        ensureDirectoryExists(outputDir);

        for (File file : filesDir) {
            try {
                processFile(file, outputDir, canvasCreator, attributeProcessor, manifestor, config);
                System.out.println("Processed: " + file.getName());
            } catch (Exception e) {
                System.err.println("Error processing file: " + file.getName() + " - " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Process a single file - works for any collection
     */
    private static void processFile(File file, File outputDir,
                                    CanvasCreator canvasCreator,
                                    AttributeProcessor attributeProcessor,
                                    Manifestor manifestor,
                                    CollectionConfig config) throws IOException {

        // Parse JSON
        JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

        // Extract ID based on collection's ID prefix
        String id = extractId(file, config);

        // Get title using the attribute processor
        I18n title = attributeProcessor.extractTitle(jsonObj);

        // Create manifest
        Manifest manifest = createManifest(file, id, title);

        // Add static fields
        String titleString = (title != null && title.getStrings() != null &&
                !title.getStrings().isEmpty()) ? title.getStrings().get(0) : id;
        StaticFields.staticFields(id, manifest, titleString);

        // Add collection-specific metadata
        attributeProcessor.addMetadata(jsonObj, manifest);

        // Create canvases
        canvasCreator.createCanvas(file, jsonObj, manifest);

        // Write output
        File newFile = new File(outputDir, file.getName());
        manifestor.write(manifest, newFile);
    }

    /**
     * Create the appropriate CanvasCreator for the collection
     */
    private static CanvasCreator createCanvasCreator(CollectionConfig config) {
        switch (config) {
            case KAHLEN:
                return CanvasCreator.forKahlen();
            default:
                return new CanvasCreator(config);
        }
    }

    /**
     * Extract ID from file, removing collection-specific prefix
     */
    private static String extractId(File file, CollectionConfig config) {
        String rawId = IdTransformation.idTransformator(file);
        // Remove collection prefix (e.g., "kahlen_", "dtab_", "tap_")
        String prefix = config.getCollectionName() + "_";
        return rawId.replace(prefix, "");
    }

    /**
     * Create manifest with proper label
     */
    private static Manifest createManifest(File file, String id, I18n title) {
        if (title != null && title.getStrings() != null &&
                !title.getStrings().isEmpty() && title.getStrings().get(0) != null) {
            return new Manifest(file.getName(), new Label(new I18n[]{title}));
        } else {
            return new Manifest(file.getName(), new Label(id));
        }
    }

    /**
     * Ensure output directory exists
     */
    private static void ensureDirectoryExists(File directory) {
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}