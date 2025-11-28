package org.crossasia.manifest.statics.collection;

/**
 * Configuration for different IIIF collections.
 * Each collection has its own static configuration data.
 */
public enum CollectionConfig {

    DTAB(
            "dtab",
            "dtab+",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\DTAB\\result\\",
            "C:\\Collections\\DTAB\\manifests\\",
            "Die hier präsentierten Dokumente stammen aus der DTAB-Sammlung.",
            IdType.INTEGER
    ),

    KAHLEN(
            "kahlen",
            "kahlen+",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\Kahlen\\result\\",
            "C:\\Collections\\Kahlen\\manifests\\",
            "Die Kahlen-Sammlung enthält historische Fotografien und Dokumente.",
            IdType.STRING
    ),

    TAP(
            "tap",
            "tap+",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\TAP\\result\\",
            "C:\\Collections\\TAP\\manifests\\",
            "Die hier präsentierten Turfan Akten versammeln die im Museum für Asiatische Kunst (AKu) verwahrten 21 Aktenbände.",
            IdType.STRING
    );

    private final String collectionName;
    private final String manifestCollection;
    private final String baseUrl;
    private final String resultFolder;
    private final String manifestsFolder;
    private final String summary;
    private final IdType idType;

    CollectionConfig(String collectionName, String manifestCollection, String baseUrl,
                     String resultFolder, String manifestsFolder, String summary, IdType idType) {
        this.collectionName = collectionName;
        this.manifestCollection = manifestCollection;
        this.baseUrl = baseUrl;
        this.resultFolder = resultFolder;
        this.manifestsFolder = manifestsFolder;
        this.summary = summary;
        this.idType = idType;
    }

    public String getCollectionName() { return collectionName; }
    public String getManifestCollection() { return manifestCollection; }
    public String getBaseUrl() { return baseUrl; }
    public String getResultFolder() { return resultFolder; }
    public String getManifestsFolder() { return manifestsFolder; }
    public String getSummary() { return summary; }
    public IdType getIdType() { return idType; }

    /**
     * How to extract the ID from JSON
     */
    public enum IdType {
        INTEGER,
        STRING
    }
}