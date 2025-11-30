package org.crossasia.manifest.metadata.builder;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Builder for creating IIIF Presentation API 3.0 metadata entries.
 *
 * Simplifies metadata creation with support for:
 * - Single string values
 * - Multiple values (arrays)
 * - Multi-language values
 * - Null-safe operations
 *
 * Usage:
 *   MetadataBuilder.create("dcterms:date", attributes.getDate())
 *       .withLabelLang("en")
 *       .build();
 *
 *   MetadataBuilder.create("dcterms:subject")
 *       .withLabelLang("en")
 *       .addValue("en", "English value")
 *       .addValue("zh", "Chinese value")
 *       .build();
 */
public class MetadataBuilder {

    private String labelText;
    private String labelLang = "en";
    private final List<I18n> values = new ArrayList<>();

    private MetadataBuilder(String labelText) {
        this.labelText = labelText;
    }

    // ========== Static Factory Methods ==========

    /**
     * Create metadata with a single string value
     */
    public static MetadataBuilder create(String label, String value) {
        MetadataBuilder builder = new MetadataBuilder(label);
        if (isNotEmpty(value)) {
            builder.addValue("none", value);
        }
        return builder;
    }

    /**
     * Create metadata with a single string value and language
     */
    public static MetadataBuilder create(String label, String value, String valueLang) {
        MetadataBuilder builder = new MetadataBuilder(label);
        if (isNotEmpty(value)) {
            builder.addValue(valueLang, value);
        }
        return builder;
    }

    /**
     * Create metadata with a list of values (same language)
     */
    public static MetadataBuilder create(String label, List<?> values, String valueLang) {
        MetadataBuilder builder = new MetadataBuilder(label);
        if (values != null && !values.isEmpty()) {
            for (Object value : values) {
                if (value != null) {
                    builder.addValue(valueLang, value.toString());
                }
            }
        }
        return builder;
    }

    /**
     * Create empty metadata builder (for multi-language values)
     */
    public static MetadataBuilder create(String label) {
        return new MetadataBuilder(label);
    }

    // ========== Builder Methods ==========

    /**
     * Set the language of the label
     */
    public MetadataBuilder withLabelLang(String lang) {
        this.labelLang = lang;
        return this;
    }

    /**
     * Add a value with language
     */
    public MetadataBuilder addValue(String lang, String value) {
        if (isNotEmpty(value)) {
            this.values.add(new I18n(lang, value));
        }
        return this;
    }

    /**
     * Add multiple values with same language
     */
    public MetadataBuilder addValues(String lang, List<String> values) {
        if (values != null) {
            for (String value : values) {
                addValue(lang, value);
            }
        }
        return this;
    }

    /**
     * Add value from list at specific index
     */
    public MetadataBuilder addValueFromList(String lang, List<?> list, int index) {
        if (list != null && index >= 0 && index < list.size()) {
            Object value = list.get(index);
            if (value != null) {
                addValue(lang, value.toString());
            }
        }
        return this;
    }

    // ========== Build Methods ==========

    /**
     * Build the Metadata object (returns null if no values)
     */
    public Metadata build() {
        if (values.isEmpty()) {
            return null;
        }

        Label label = new Label(labelLang, labelText);
        Value value = new Value(values.toArray(new I18n[0]));

        return new Metadata(label, value);
    }

    /**
     * Build and add to manifest if not null
     */
    public void addToManifest(Manifest manifest) {
        Metadata metadata = build();
        if (metadata != null) {
            List<Metadata> existingMetadata = manifest.getMetadata();
            if (existingMetadata == null) {
                existingMetadata = new ArrayList<>();
            }
            existingMetadata.add(metadata);
            manifest.setMetadata(existingMetadata);
        }
    }

    /**
     * Check if the metadata has values
     */
    public boolean hasValues() {
        return !values.isEmpty();
    }

    // ========== Utility ==========

    private static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    /**
     * Safely get a String value from a nested object.
     * Returns null if the parent object is null.
     *
     * Usage:
     *   String sealId = MetadataBuilder.safeGet(attrs.getSealInfo(), SealInfo::getSealId);
     */
    public static <T> String safeGet(T obj, java.util.function.Function<T, String> getter) {
        if (obj == null) {
            return null;
        }
        return getter.apply(obj);
    }

    /**
     * Safely get a List value from a nested object.
     * Returns null if the parent object is null.
     */
    public static <T, R> java.util.List<R> safeGetList(T obj, java.util.function.Function<T, java.util.List<R>> getter) {
        if (obj == null) {
            return null;
        }
        return getter.apply(obj);
    }
}