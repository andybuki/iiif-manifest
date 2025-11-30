package org.crossasia.manifest.metadata.builder;

import java.util.List;

/**
 * Common metadata field definitions for IIIF manifests.
 *
 * Each field has:
 * - label: The display name (e.g., "dcterms:date")
 * - labelLang: The language of the label (default "en")
 * - defaultValueLang: The default language for values ("none" for language-neutral)
 *
 * Usage:
 *   MetadataField.DC_DATE.with(attrs.getDate())           // String value
 *   MetadataField.DCTERMS_PLACE.with(attrs.getPlaces())   // List value
 */
public enum MetadataField {

    // ========== Dublin Core Terms (dcterms:) ==========
    DCTERMS_DATE("dcterms:date", "en", "none"),
    DCTERMS_SUBJECT("dcterms:subject", "en", "en"),
    DCTERMS_IDENTIFIER("dcterms:identifier", "en", "none"),
    DCTERMS_DESCRIPTION("dcterms:description", "en", "en"),
    DCTERMS_LANGUAGE("dcterms:language", "en", "none"),
    DCTERMS_EXTENT("dcterms:extent", "en", "none"),
    DCTERMS_PLACE("dcterms:place", "en", "en"),

    // ========== Dublin Core (dc:) ==========
    DC_TITLE("dc:title", "en", "en"),
    DC_DATE("dc:date", "en", "none"),
    DC_DATE_DESCRIPTION_ID("dc:date_description_id", "en", "none"),
    DC_DESCRIPTION("dc:description", "en", "en"),
    DC_IDENTIFIER("dc:identifier", "en", "none"),

    // ========== Schema.org (schema:) ==========
    SCHEMA_INDEX("schema:index", "en", "none"),
    SCHEMA_KEYWORD("schema:keyword", "en", "en"),
    SCHEMA_CATEGORY("schema:category", "en", "en"),
    SCHEMA_COMMENT("schema:comment", "en", "en"),
    SCHEMA_NAME("schema:name", "en", "none"),
    SCHEMA_TEXT("schema:text", "en", "en"),
    SCHEMA_CITATION("schema:citation", "en", "en"),
    SCHEMA_GRANT("schema:grant", "en", "en"),
    SCHEMA_ABSTRACT("schema:abstract", "en", "en"),
    SCHEMA_PLACE("schema:place", "en", "en"),
    SCHEMA_RECIPIENT("schema:recipient", "en", "en"),

    // ========== DTAB specific (dtab:) ==========
    DTAB_ARCHIVE_ID("dtab:archive_id", "en", "none"),
    DTAB_ARCHIVE_SIGNATORY("dtab:archive_signatory", "en", "none"),
    DTAB_COMMENT_PLACE("dtab:comment_place", "en", "de"),
    DTAB_COMMENT_ABOUT_TYPES("dtab:comment_about_types_of_document", "en", "en"),
    DTAB_DATE_ID("dtab:date_id", "en", "none"),
    DTAB_DESCRIPTION_DATE("dtab:description_date", "en", "de"),
    DTAB_DOCUMENT_ID("dtab:document_id", "en", "none"),
    DTAB_GPOS("dtab:gpos", "en", "none"),
    DTAB_GROUPNO("dtab:groupno", "en", "none"),
    DTAB_HTML_FILES("dtab:html_files", "en", "none"),
    DTAB_ID("id", "en", "none"),
    DTAB_ID_IN_ARCHIVE("dtab:id_in_archive", "en", "none"),
    DTAB_INVISIBLE("dtab:invisible", "en", "none"),
    DTAB_NAME_OF_ARCHIVE("dtab:name_of_archive", "en", "en"),
    DTAB_OTHER_FILES("dtab:other_files", "en", "none"),
    DTAB_PLACE_COMMENT("dtab:place_comment", "en", "en"),
    DTAB_PLACE_ID("dtab:place_id", "en", "none"),
    DTAB_PLACE_OF_ISSUE_ID("dtab:place_of_issue_id", "en", "none"),
    DTAB_PREVIEW_IMAGE_FILES("dtab:preview_image_files", "en", "none"),
    DTAB_PROVERBS("dtab:proverbs", "en", "en"),
    DTAB_RECEIVER("dtab:receiver", "en", "de"),
    DTAB_RECEIVER_COMMENT("dtab:receiver_comment", "en", "en"),
    DTAB_RECEIVER_ID("dtab:receiver_id", "en", "none"),
    DTAB_SCRIPT("dtab:script", "en", "en"),
    DTAB_SCRIPT_ID_ROLE("dtab:script_id_role", "en", "none"),
    DTAB_SENDER("dtab:sender", "en", "de"),
    DTAB_SENDER_COMMENT("dtab:sender_comment", "en", "en"),
    DTAB_SENDER_ID("dtab:sender_id", "en", "none"),
    DTAB_SENDER_ROLE_COMMENT("dtab:sender_role_comment", "en", "en"),
    DTAB_TERMINOLOGY("dtab:terminology", "en", "en"),
    DTAB_TRANSCRIPTION_FILES("dtab:transcription_files", "en", "none"),
    DTAB_USED_SCRIPTS("dtab:used_scripts", "en", "en"),

    // ========== DTAB Seal fields ==========
    DTAB_SEAL("dtab:seal", "en", "de"),
    DTAB_SEAL_COLOR("dtab:seal_color", "en", "de"),
    DTAB_SEAL_COLOR_NEW("dtab:seal_color", "en", "en"),
    DTAB_SEAL_COMMENT("dtab:seal_comment", "en", "en"),
    DTAB_SEAL_COMMENT_USED_SCRIPTS("dtab:seal_comment_used_scripts", "en", "none"),
    DTAB_SEAL_COMPARE("dtab:seal_compare", "en", "none"),
    DTAB_SEAL_DOC_ID("dtab:seal_docID", "en", "none"),
    DTAB_SEAL_FORM("dtab:seal_form_orig", "en", "en"),
    DTAB_SEAL_FORM_NEW("dtab:seal_form", "en", "en"),
    DTAB_SEAL_ID("dtab:seal_id", "en", "none"),
    DTAB_SEAL_IMAGE_FILES("dtab:seal_image_files", "en", "none"),
    DTAB_SEAL_INFO("dtab:seal_info", "en", "en"),
    DTAB_SEAL_INSCRIPTION("dtab:seal_inscription", "en", "en"),
    DTAB_SEAL_LINKS("dtab:seal_docID", "en", "none"),
    DTAB_SEAL_NAME_SCRIPT("dtab:seal_script", "en", "none"),
    DTAB_SEAL_REFERENCE("dtab:seal_reference", "en", "en"),
    DTAB_SEAL_SIZE("dtab:seal_size", "en", "none"),

    // ========== Sugawara specific ==========
    SUGAWARA_FOLDER("sugawara:folder", "en", "none"),
    SUGAWARA_DOCUMENT("sugawara:document", "en", "en"),
    SUGAWARA_PLACE("sugawara:place", "en", "en"),
    SUGAWARA_SEAL("sugawara:seal", "en", "en"),

    // ========== Crossasia ==========
    CROSSASIA_DATE_ORIGINAL("crossasia:dateOriginal", "en", "none"),
    CROSSASIA_YEAR_ORIGINAL("crossasia:yearOriginal", "en", "none"),
    CROSSASIA_LANGUAGE("crossasia:language", "en", "none"),

    // ========== General / Common ==========
    IDENTIFIER("Identifier", "en", "none"),
    TITLE("Title", "en", "en"),
    DATE("Date", "en", "none"),
    PLACE("Place", "en", "en"),
    DESCRIPTION("Description", "en", "en"),
    SUBJECT("Subject", "en", "en"),
    KEYWORD("Keyword", "en", "en"),
    CREATOR("Creator", "en", "en"),
    FORMAT("Format", "en", "none"),
    SOURCE("Source", "en", "en"),
    LANGUAGE("Language", "en", "none"),
    TYPE("Type", "en", "en"),
    COLLECTION("Collection", "en", "en"),
    COMMENT("Comment", "en", "en");

    private final String label;
    private final String labelLang;
    private final String defaultValueLang;

    MetadataField(String label, String labelLang, String defaultValueLang) {
        this.label = label;
        this.labelLang = labelLang;
        this.defaultValueLang = defaultValueLang;
    }

    public String getLabel() { return label; }
    public String getLabelLang() { return labelLang; }
    public String getDefaultValueLang() { return defaultValueLang; }

    /**
     * Create a MetadataBuilder for this field with a String value
     */
    public MetadataBuilder with(String value) {
        return MetadataBuilder.create(label, value, defaultValueLang)
                .withLabelLang(labelLang);
    }

    /**
     * Create a MetadataBuilder for this field with a List of values
     */
    public MetadataBuilder with(List<?> values) {
        return MetadataBuilder.create(label, values, defaultValueLang)
                .withLabelLang(labelLang);
    }

    /**
     * Create a MetadataBuilder for this field with a String value and specific language
     */
    public MetadataBuilder with(String value, String lang) {
        return MetadataBuilder.create(label, value, lang)
                .withLabelLang(labelLang);
    }

    /**
     * Create a MetadataBuilder for this field with a List and specific language
     */
    public MetadataBuilder with(List<?> values, String lang) {
        return MetadataBuilder.create(label, values, lang)
                .withLabelLang(labelLang);
    }

    /**
     * Create an empty MetadataBuilder for this field (for multi-language values)
     */
    public MetadataBuilder builder() {
        return MetadataBuilder.create(label)
                .withLabelLang(labelLang);
    }
}