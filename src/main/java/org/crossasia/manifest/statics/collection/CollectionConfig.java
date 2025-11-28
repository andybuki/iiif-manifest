package org.crossasia.manifest.statics.collection;

/**
 * Unified configuration for all collections.
 * Consolidates Data, Label, Summary, Url enums into one place.
 */
public enum CollectionConfig {

    TURFAN(
            // Data URL
            "https://itr02.crossasia.org/fcrepo/rest/turfan/akten",
            // Collection URL
            "https://itr02.crossasia.org/fcrepo/rest/turfan/collection",
            // Label
            "Turfan Sammlung - Akten",
            // Summary
            "Die hier präsentierten Turfan Akten versammeln die im Museum für Asiatische Kunst (AKu) verwahrten 21 Aktenbände. Die Aktenbände I bis XV sowie der Aktenband XVII enthalten im Museum für Völkerkunde (erst Königliches Museum für Völkerkunde, später dann Staatliches Museum für Völkerkunde) archivierten Unterlagen zu den Hintergründen für die Aussendung, Vorbereitung, Planung, Ausführung und Abrechnung der Expeditionen sowie die Korrespondenz mit Wissenschaftlern bzw. Berichte und Anträge im Hinblick auf die Erforschung, Konservierung und Präsentation der aus Chinesisch Zentralasien mitgebrachten Objekte im damaligen Museum für Völkerkunde. Die Aktenbände XVI sowie XVIII bis XXI enthalten den Schriftwechsel, der ursprünglich beim sogenannten Turfan-Komitee (Lokalkomitee zur Erforschung Zentral-Asiens) verwahrt wurde, und dann, nach Auflösung des Komitees, in die Obhut des Museums für Völkerkunde überging.",
            // IIIF settings
            "turfan",
            "turfan+",
            "https://iiif-content.crossasia.org/xasia/",
            // File paths
            "C:\\Collections\\Turfan\\result\\",
            "C:\\Collections\\Turfan\\manifests\\",
            // ID type
            IdType.INTEGER
    ),

    SUGAWARA(
            "https://itr02.crossasia.org/fcrepo/rest/xinjiang-legaldocuments",
            "https://itr02.crossasia.org/fcrepo/rest/xinjiang-legaldocuments/collection",
            "Kashgar Contractual Documents Collection",
            "The collection contains roughly eight hundred contractual documents from the Kashgar Region from the beginning of the 19th to the mid 20th century.",
            "sugawara",
            "sugawara+",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\Sugawara\\result\\",
            "C:\\Collections\\Sugawara\\manifests\\",
            IdType.STRING
    ),

    KAHLEN(
            null, // No data URL for Kahlen
            "https://itr02.crossasia.org/fcrepo/rest/kahlen",
            "Kahlen Collection",
            "Die Kahlen-Sammlung enthält historische Fotografien und Dokumente.",
            "kahlen",
            "kahlen+",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\Kahlen\\result\\",
            "C:\\Collections\\Kahlen\\manifests\\",
            IdType.STRING
    ),

    DTAB(
            "https://itr02.crossasia.org/fcrepo/rest/dtab",
            "https://itr02.crossasia.org/fcrepo/rest/dtab/collection",
            "DTAB Collection",
            "The database Digital Tibetan Archives Bonn (DTAB) is a collection of more than 4400 handwritten Tibetan legal texts, which were digitized and described within two research projects led by Prof. Dr. Peter Schwieger 1999-2005.",
            "dtab",
            "dtab+",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\DTAB\\result\\",
            "C:\\Collections\\DTAB\\manifests\\",
            IdType.INTEGER
    ),

    TAP(
            "https://itr02.crossasia.org/fcrepo/rest/tap",
            "https://itr02.crossasia.org/fcrepo/rest/tap/collection",
            "TAP Collection",
            "TAP Collection documents.",
            "tap",
            "tap+",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\TAP\\result\\",
            "C:\\Collections\\TAP\\manifests\\",
            IdType.STRING
    );

    // Fields matching old enums
    private final String dataUrl;           // From Data enum
    private final String collectionUrl;     // From Url enum
    private final String label;             // From Label enum
    private final String summary;           // From Summary enum

    // IIIF-specific fields
    private final String collectionName;
    private final String manifestCollection;
    private final String iiifBaseUrl;

    // File paths
    private final String resultFolder;
    private final String manifestsFolder;

    // ID handling
    private final IdType idType;

    CollectionConfig(String dataUrl, String collectionUrl, String label, String summary,
                     String collectionName, String manifestCollection, String iiifBaseUrl,
                     String resultFolder, String manifestsFolder, IdType idType) {
        this.dataUrl = dataUrl;
        this.collectionUrl = collectionUrl;
        this.label = label;
        this.summary = summary;
        this.collectionName = collectionName;
        this.manifestCollection = manifestCollection;
        this.iiifBaseUrl = iiifBaseUrl;
        this.resultFolder = resultFolder;
        this.manifestsFolder = manifestsFolder;
        this.idType = idType;
    }

    // ========== Getters matching old enum method names ==========

    /** @return Data URL (replaces Data.getVal()) */
    public String getDataUrl() { return dataUrl; }

    /** @return Collection URL (replaces Url.getVal()) */
    public String getCollectionUrl() { return collectionUrl; }

    /** @return Label (replaces Label.getVal()) */
    public String getLabel() { return label; }

    /** @return Summary (replaces Summary.getVal()) */
    public String getSummary() { return summary; }

    // ========== IIIF-specific getters ==========

    public String getCollectionName() { return collectionName; }
    public String getManifestCollection() { return manifestCollection; }
    public String getIiifBaseUrl() { return iiifBaseUrl; }

    // ========== File path getters ==========

    public String getResultFolder() { return resultFolder; }
    public String getManifestsFolder() { return manifestsFolder; }

    // ========== ID handling ==========

    public IdType getIdType() { return idType; }

    /**
     * How to extract the ID from JSON
     */
    public enum IdType {
        INTEGER,
        STRING
    }
}