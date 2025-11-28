package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.attributes.KahlenAttributes;
import org.crossasia.manifest.canvas.CanvasCreator;
import org.crossasia.manifest.json.StaticJsonCallerTurfan;
import org.crossasia.manifest.metadata.StaticFields;
import org.crossasia.manifest.metadata.kahlen.LabelMetadata;
import org.crossasia.manifest.statics.collection.CollectionConfig;
import org.crossasia.manifest.transformation.IdTransformation;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.crossasia.manifest.metadata.MetadataMembersKahlen.metadataMembersKahlen;

public class FileCreator {

    /**
     * Legacy method - processes Kahlen files (default behavior)
     * Kept for backward compatibility with IIIFManifest.buildManifest()
     */
    public static void fileCreator(File[] filesDir, Manifestor manifestor) throws IOException {
        processKahlenFiles(filesDir, manifestor);
    }

    /**
     * Process Kahlen collection files
     */
    public static void processKahlenFiles(File[] filesDir, Manifestor manifestor) throws IOException {
        CollectionConfig config = CollectionConfig.KAHLEN;
        CanvasCreator canvasCreator = CanvasCreator.forKahlen();

        File outputDir = new File(config.getManifestsFolder());
        ensureDirectoryExists(outputDir);

        for (File file : filesDir) {
            try {
                processKahlenFile(file, outputDir, canvasCreator, manifestor);
                System.out.println("Processed: " + file.getName());
            } catch (Exception e) {
                System.err.println("Error processing file: " + file.getName() + " - " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Process a single Kahlen file
     */
    private static void processKahlenFile(File file, File outputDir,
                                          CanvasCreator canvasCreator,
                                          Manifestor manifestor) throws IOException {
        // Parse JSON
        JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

        // Parse attributes (still needed for metadata)
        KahlenAttributes kahlenAttributes = new KahlenAttributes();
        StaticJsonCallerTurfan.staticJsonCallerKahlen(kahlenAttributes, jsonObj);

        // Extract ID
        String id = IdTransformation.idTransformator(file).replace("kahlen_", "");

        // Get title
        I18n i18n_title_kahlen = LabelMetadata.getLabelTitle(kahlenAttributes);

        // Create manifest with title or fallback to ID
        Manifest manifest = createManifest(file, id, i18n_title_kahlen);

        // Add static fields
        StaticFields.staticFields(id, manifest, i18n_title_kahlen.getStrings().get(0));

        // Add metadata
        metadataMembersKahlen(kahlenAttributes, manifest);

        // Create canvases using new CanvasCreator
        canvasCreator.createCanvas(file, jsonObj, manifest);

        // Write output
        File newFile = new File(outputDir, file.getName());
        manifestor.write(manifest, newFile);
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