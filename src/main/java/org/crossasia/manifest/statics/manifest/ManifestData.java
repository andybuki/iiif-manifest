package org.crossasia.manifest.statics.manifest;
/**
 * Legacy manifest data class - delegates to new configuration classes.
 *
 * @deprecated Use {@link ManifestConfig} for shared settings and
 *             {@link org.crossasia.manifest.statics.collection.CollectionConfig}
 *             for collection-specific settings.
 */
import info.freelibrary.iiif.presentation.v3.properties.RequiredStatement;


@Deprecated
public class ManifestData {

    // These now delegate to ManifestConfig
    public static final String SERVER = ManifestConfig.SERVER;
    public static final String THUMBNAIL_PATH = ManifestConfig.THUMBNAIL_PATH;
    public static final String LOGO_LINK = ManifestConfig.LOGO_LINK;
    public static final String LANGUAGE = ManifestConfig.DEFAULT_LANGUAGE;
    public static final String MANIFEST_RIGHTS = ManifestConfig.MANIFEST_RIGHTS;
    public static final String MANIFEST_HOMEPAGE = ManifestConfig.MANIFEST_HOMEPAGE;
    public static final String MANIFEST_HOMEPAGE_LABEL = ManifestConfig.MANIFEST_HOMEPAGE_LABEL;
    public static final String MANIFEST_REQUIRED_STATEMENT = ManifestConfig.MANIFEST_REQUIRED_STATEMENT;

    // ========== Collection-specific paths (use CollectionConfig instead) ==========

    // TAP collection - default for backward compatibility
    public static final String RESULT_FOLGER = "C:\\Collections\\TAP\\result\\";
    public static final String MANIFESTS_FOLGER = "C:\\Collections\\TAP\\manifests\\";
    public static final String MANIFEST_COLLECTION = "tap+";

    public static final String MANIFEST_SUMMARY = "Die hier präsentierten Turfan Akten versammeln die im Museum für Asiatische Kunst (AKu) verwahrten 21 Aktenbände. Die Aktenbände I bis XV sowie der Aktenband XVII enthalten im Museum für Völkerkunde (erst Königliches Museum für Völkerkunde, später dann Staatliches Museum für Völkerkunde) archivierten Unterlagen zu den Hintergründen für die Aussendung, Vorbereitung, Planung, Ausführung und Abrechnung der Expeditionen sowie die Korrespondenz mit Wissenschaftlern bzw. Berichte und Anträge im Hinblick auf die Erforschung, Konservierung und Präsentation der aus Chinesisch Zentralasien mitgebrachten Objekte im damaligen Museum für Völkerkunde. Die Aktenbände XVI sowie XVIII bis XXI enthalten den Schriftwechsel, der ursprünglich beim sogenannten Turfan-Komitee (Lokalkomitee zur Erforschung Zentral-Asiens) verwahrt wurde, und dann, nach Auflösung des Komitees, in die Obhut des Museums für Völkerkunde überging.";

}
