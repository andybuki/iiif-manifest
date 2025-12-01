package org.crossasia.manifest.statics.collection;

/**
 * Unified configuration for all collections.
 * Consolidates Data, Label, Summary, Url enums and field classes into one place.
 *
 * Replaces:
 * - org.crossasia.manifest.statics.collection.Data
 * - org.crossasia.manifest.statics.collection.Label
 * - org.crossasia.manifest.statics.collection.Summary
 * - org.crossasia.manifest.statics.collection.Url
 * - org.crossasia.manifest.metadata.fields.Coll
 * - org.crossasia.manifest.metadata.fields.SummaryData
 * - org.crossasia.manifest.metadata.fields.RequiredStatement
 * - org.crossasia.manifest.metadata.fields.PartOf
 */
public enum CollectionConfig {

    TURFAN(
            // Identifiers
            "turfan",                    // collectionName (from Coll enum)
            "turfan+",                   // manifestCollection

            // URLs
            "https://itr02.crossasia.org/fcrepo/rest/turfan/akten",           // dataUrl
            "https://itr02.crossasia.org/fcrepo/rest/turfan/collection",      // collectionUrl
            "https://iiif.crossasia.org/s/turfan/",                           // partOf

            // Display
            "Turfan Sammlung - Akten",   // label
            "Die hier präsentierten Turfan Akten versammeln die im Museum für Asiatische Kunst (AKu) verwahrten 21 Aktenbände. Die Aktenbände I bis XV sowie der Aktenband XVII enthalten im Museum für Völkerkunde (erst Königliches Museum für Völkerkunde, später dann Staatliches Museum für Völkerkunde) archivierten Unterlagen zu den Hintergründen für die Aussendung, Vorbereitung, Planung, Ausführung und Abrechnung der Expeditionen sowie die Korrespondenz mit Wissenschaftlern bzw. Berichte und Anträge im Hinblick auf die Erforschung, Konservierung und Präsentation der aus Chinesisch Zentralasien mitgebrachten Objekte im damaligen Museum für Völkerkunde. Die Aktenbände XVI sowie XVIII bis XXI enthalten den Schriftwechsel, der ursprünglich beim sogenannten Turfan-Komitee (Lokalkomitee zur Erforschung Zentral-Asiens) verwahrt wurde, und dann, nach Auflösung des Komitees, in die Obhut des Museums für Völkerkunde überging.", // summary
            "Images provided by Museum für Asiatische Kunst, Staatliche Museen zu Berlin. Licensed under CC BY-NC-SA 4.0.", // requiredStatement

            // IIIF
            "https://iiif-content.crossasia.org/xasia/",   // iiifBaseUrl

            // File paths
            "C:\\Collections\\Turfan\\result\\",
            "C:\\Collections\\Turfan\\manifests\\",

            // Settings
            IdType.INTEGER,
            "de"                         // language
    ),

    SUGAWARA(
            "xinjiang-legaldocuments",
            "sugawara+",
            "https://itr02.crossasia.org/fcrepo/rest/xinjiang-legaldocuments",
            "https://itr02.crossasia.org/fcrepo/rest/xinjiang-legaldocuments/collection",
            "https://iiif.crossasia.org/s/xinjiang-legaldocuments/",
            "Kashgar Contractual Documents Collection",
            "The collection contains roughly eight hundred contractual documents from the Kashgar Region from the beginning of the 19th to the mid 20th century.",
            "Images and metadata provided by the Sugawara Collection. Licensed under CC BY-NC-SA 4.0.",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\Sugawara\\result\\",
            "C:\\Collections\\Sugawara\\manifests\\",
            IdType.STRING,
            "en"
    ),

    KAHLEN(
            "kahlen",
            "kahlen+",
            null,
            "https://itr02.crossasia.org/fcrepo/rest/kahlen",
            "https://iiif.crossasia.org/s/kahlen/",
            "Tangtong Gyalpo - Archive Wolf Kahlen",
            "The collection 'Tangtong Gyalpo - Archive Wolf Kahlen' comprises the photographs of Wolf Kahlen, which he took in Tibet, China, India, the Himalayan region and Mongolia in the period from 1985 to 1994.",
            "The collection 'Tangtong Gyalpo - Archive Wolf Kahlen' comprises the photographs of Wolf Kahlen, which he took in Tibet, China, India, the Himalayan region and Mongolia in the period from 1985 to 1994. The licence is CC BY-NC-SA. Commercial use is only possible after consultation with VG Bildkunst and Wolf Kahlen.",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\Kahlen\\result\\",
            "C:\\Collections\\Kahlen\\manifests\\",
            IdType.STRING,
            "en"
    ),

    DTAB(
            "dtab",
            "dtab+",
            "https://itr02.crossasia.org/fcrepo/rest/dtab",
            "https://itr02.crossasia.org/fcrepo/rest/dtab/collection",
            "https://iiif.crossasia.org/s/dtab/",
            "DTAB Collection",
            "The database Digital Tibetan Archives Bonn (DTAB) is a collection of more than 4400 handwritten Tibetan legal texts, which were digitized and described within two research projects led by Prof. Dr. Peter Schwieger 1999-2005.",
            "Images and metadata provided by Digital Tibetan Archives Bonn. Licensed under CC BY-NC-SA 4.0.",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\DTAB\\result\\",
            "C:\\Collections\\DTAB\\manifests\\",
            IdType.INTEGER,
            "de"
    ),

    TAP(
            "tap",
            "tap+",
            "https://itr02.crossasia.org/fcrepo/rest/tap",
            "https://itr02.crossasia.org/fcrepo/rest/tap/collection",
            "https://iiif.crossasia.org/s/tap/",
            "TAP Collection",
            "TAP Collection documents.",
            "Images and metadata provided by TAP Collection. Licensed under CC BY-NC-SA 4.0.",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\TAP\\result\\",
            "C:\\Collections\\TAP\\manifests\\",
            IdType.STRING,
            "en"
    ),

    DLLM(
            "dllm",
            "dllm+",
            null,
            null,
            "https://iiif.crossasia.org/s/dllm/",
            "Digital Library of Lao Manuscripts",
            "The Digital Library of Lao Manuscripts makes images of over 12,000 texts from throughout Laos easily accessible for study. Collaborating institutions are the National Library of Laos, the University of Passau, and the Staatsbibliothek zu Berlin Preußischer Kulturbesitz.",
            "Images and metadata are made available by the National Library of Laos (CC BY-NC 4.0) via the Staatsbibliothek zu Berlin | CrossAsia.",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\DLLM\\result\\",
            "C:\\Collections\\DLLM\\manifests\\",
            IdType.STRING,
            "lo"
    ),

    LANNA(
            "lanna",
            "lanna+",
            null,
            null,
            "https://iiif.crossasia.org/s/lanna/",
            "Lanna Collection",
            "Lanna manuscript collection.",
            "Images and metadata provided by Lanna Collection. Licensed under CC BY-NC-SA 4.0.",
            "https://iiif-content.crossasia.org/xasia/",
            "C:\\Collections\\Lanna\\result\\",
            "C:\\Collections\\Lanna\\manifests\\",
            IdType.STRING,
            "th"
    );

    // ========== Fields ==========

    // Identifiers
    private final String collectionName;      // From Coll enum
    private final String manifestCollection;

    // URLs
    private final String dataUrl;             // From Data enum
    private final String collectionUrl;       // From Url enum
    private final String partOf;              // From PartOf class

    // Display
    private final String label;               // From Label enum
    private final String summary;             // From Summary enum / SummaryData
    private final String requiredStatement;   // From RequiredStatement class

    // IIIF
    private final String iiifBaseUrl;

    // File paths
    private final String resultFolder;
    private final String manifestsFolder;

    // Settings
    private final IdType idType;
    private final String language;            // From Languages enum

    CollectionConfig(String collectionName, String manifestCollection,
                     String dataUrl, String collectionUrl, String partOf,
                     String label, String summary, String requiredStatement,
                     String iiifBaseUrl,
                     String resultFolder, String manifestsFolder,
                     IdType idType, String language) {
        this.collectionName = collectionName;
        this.manifestCollection = manifestCollection;
        this.dataUrl = dataUrl;
        this.collectionUrl = collectionUrl;
        this.partOf = partOf;
        this.label = label;
        this.summary = summary;
        this.requiredStatement = requiredStatement;
        this.iiifBaseUrl = iiifBaseUrl;
        this.resultFolder = resultFolder;
        this.manifestsFolder = manifestsFolder;
        this.idType = idType;
        this.language = language;
    }

    // ========== Getters ==========

    /** Collection name (replaces Coll.getVal()) */
    public String getCollectionName() { return collectionName; }

    /** Manifest collection prefix (e.g., "kahlen+") */
    public String getManifestCollection() { return manifestCollection; }

    /** Data URL (replaces Data.getVal()) */
    public String getDataUrl() { return dataUrl; }

    /** Collection URL (replaces Url.getVal()) */
    public String getCollectionUrl() { return collectionUrl; }

    /** Part of URL (replaces PartOf.PARTOF) */
    public String getPartOf() { return partOf; }

    /** Label (replaces Label.getVal()) */
    public String getLabel() { return label; }

    /** Summary (replaces Summary.getVal() and SummaryData.SUMMARY) */
    public String getSummary() { return summary; }

    /** Required statement (replaces RequiredStatement.REQUIRED) */
    public String getRequiredStatement() { return requiredStatement; }

    /** IIIF base URL */
    public String getIiifBaseUrl() { return iiifBaseUrl; }

    /** Result folder path */
    public String getResultFolder() { return resultFolder; }

    /** Manifests folder path */
    public String getManifestsFolder() { return manifestsFolder; }

    /** ID type (INTEGER or STRING) */
    public IdType getIdType() { return idType; }

    /** Primary language code */
    public String getLanguage() { return language; }

    // ========== Shared Constants (from field classes) ==========

    /** IIIF Context URL (from Contexts.CONTEXT) */
    public static final String CONTEXT = "http://iiif.io/api/presentation/3/context.json";

    /** Fedora base URL (from Id.FEDORA) */
    public static final String FEDORA = "https://itr02.crossasia.org/fcrepo/rest/";

    /** Homepage URL (from Homepage.HOMEPAGE) */
    public static final String HOMEPAGE = "https://iiif.crossasia.org";

    /** Homepage description (from Homepage.HOMEPAGE_DESCRIPTION) */
    public static final String HOMEPAGE_DESCRIPTION = "Crossasia IIIF collections";

    /** Provider website (from Provider.WEBSITE) */
    public static final String PROVIDER_WEBSITE = "crossasia.org";

    /** Provider name (from Provider.PROVIDER) */
    public static final String PROVIDER_NAME = "Staatsbibliothek zu Berlin | CrossAsia";

    /** Rights URL (from Rights.RIGHTS) */
    public static final String RIGHTS = "https://creativecommons.org/licenses/by-nc-sa/4.0/";

    /** Info label for required statement (from RequiredStatement.INFO) */
    public static final String REQUIRED_STATEMENT_LABEL = "Info & Rights Statement";

    /**
     * How to extract the ID from JSON
     */
    public enum IdType {
        INTEGER,
        STRING
    }
}