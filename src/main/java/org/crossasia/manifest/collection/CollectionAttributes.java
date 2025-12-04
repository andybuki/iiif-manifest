package org.crossasia.manifest.collection;

import info.freelibrary.iiif.presentation.v3.Collection;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Summary;
import org.crossasia.manifest.statics.collection.CollectionConfig;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.crossasia.manifest.statics.collection.CollectionData.*;

/**
 * Handles collection attribute extraction and IIIF Collection creation.
 */
public class CollectionAttributes {
    private static final Logger logger = LoggerFactory.getLogger(CollectionAttributes.class);

    /**
     * Creates a collection from manifest files using deprecated CollectionData constants.
     *
     * @param in the directory containing manifest files
     * @return the constructed IIIF Collection
     * @throws FileNotFoundException if the directory or files cannot be read
     * @deprecated Use {@link #getCollection(File, CollectionConfig)} for better flexibility
     */
    @Deprecated
    @NotNull
    public static Collection getCollection(File in) throws FileNotFoundException {
        return getCollection(in, CollectionConfig.DTAB);
    }

    /**
     * Creates a collection from manifest files using the specified configuration.
     *
     * @param in     the directory containing manifest files
     * @param config the collection configuration to use
     * @return the constructed IIIF Collection
     * @throws FileNotFoundException if the directory or files cannot be read
     */
    @NotNull
    public static Collection getCollection(File in, CollectionConfig config) throws FileNotFoundException {
        logger.debug("Creating collection from directory: {}", in.getAbsolutePath());

        File dir = new File(String.valueOf(in));
        File[] filesInDir = dir.listFiles();

        if (filesInDir == null) {
            logger.warn("Directory is empty or cannot be read: {}", dir.getAbsolutePath());
            filesInDir = new File[0];
        }

        Collection collection = new Collection("Collection", config.getLabel());
        List<Collection.Item> items = new ArrayList<>();
        Summary summary = new Summary(new I18n(config.getLanguage(), config.getSummary()));
        collection.setSummary(summary);
        collection.setID(config.getCollectionUrl());

        getManifestData(filesInDir, collection, items, config);

        logger.info("Created collection with {} items", items.size());
        return collection;
    }

    /**
     * Extracts manifest data from files and adds them as collection items.
     *
     * @param filesInDir the files to process
     * @param collection the collection to populate
     * @param items      the list to add items to
     * @param config     the collection configuration
     * @throws FileNotFoundException if a file cannot be read
     */
    private static void getManifestData(File[] filesInDir, Collection collection,
                                       List<Collection.Item> items, CollectionConfig config)
            throws FileNotFoundException {
        int processedCount = 0;
        int errorCount = 0;

        for (File file : filesInDir) {
            if (!file.isFile()) {
                logger.debug("Skipping non-file: {}", file.getName());
                continue;
            }

            try (FileInputStream fis = new FileInputStream(file)) {
                JSONObject jsonObj = new JSONObject(new JSONTokener(fis));

                String id = jsonObj.optString("id", null);
                if (id == null || id.isEmpty()) {
                    logger.warn("Manifest file missing 'id' field: {}", file.getName());
                    continue;
                }

                String title = extractTitle(jsonObj, config.getLanguage());

                logger.debug("Processing manifest: {} - {}", id, title);

                Collection.Item manifest = new Collection.Item(Collection.Item.Type.MANIFEST, id);
                manifest.setLabel(title);
                items.add(manifest);
                processedCount++;

            } catch (JSONException e) {
                logger.error("Failed to parse JSON from file: {}", file.getName(), e);
                errorCount++;
            } catch (IOException e) {
                logger.error("Failed to read file: {}", file.getName(), e);
                errorCount++;
            }
        }

        collection.setItems(items);
        logger.info("Processed {} manifests ({} errors)", processedCount, errorCount);
    }

    /**
     * Extracts the title from a manifest JSON object.
     *
     * @param jsonObj  the manifest JSON object
     * @param language the preferred language for the title
     * @return the extracted title or "Untitled" if not found
     */
    private static String extractTitle(JSONObject jsonObj, String language) {
        JSONObject label = jsonObj.optJSONObject("label");

        if (label != null) {
            // Try preferred language first
            if (label.has(language)) {
                try {
                    return label.getJSONArray(language).optString(0, "Untitled");
                } catch (JSONException e) {
                    logger.debug("Failed to extract title in language '{}', trying fallback", language);
                }
            }

            // Fallback to English
            if (label.has("en")) {
                try {
                    return label.getJSONArray("en").optString(0, "Untitled");
                } catch (JSONException e) {
                    logger.debug("Failed to extract English title, using default");
                }
            }

            // Fallback to first available language
            if (label.length() > 0) {
                try {
                    String firstKey = label.keys().next();
                    return label.getJSONArray(firstKey).optString(0, "Untitled");
                } catch (JSONException e) {
                    logger.debug("Failed to extract title from first available language");
                }
            }
        }

        return "Untitled";
    }
}
