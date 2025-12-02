package org.crossasia.manifest.statics.collection;

/**
 * Legacy collection data constants.
 *
 * @deprecated Use {@link CollectionConfig} instead for collection-specific configuration.
 */
@Deprecated
public class CollectionData {
    public static final String MANIFESTS_FOLGER = "C:\\Colllections\\KahlenFotosammlung\\manifests2\\";
    public static final String COLLECTION = "C:\\Colllections\\KahlenFotosammlung\\collection.json";

    public static final String COLLECTION_LABEL = CollectionConfig.DTAB.getLabel();
    public static final String COLLECTION_SUMMARY = CollectionConfig.DTAB.getSummary();
    public static final String COLLECTION_URL_LINK_ID = CollectionConfig.DTAB.getPartOf();
    public static final String STORAGE_DATA = CollectionConfig.DTAB.getDataUrl();
    public static final String LANGUAGE = CollectionConfig.DTAB.getLanguage();
}
