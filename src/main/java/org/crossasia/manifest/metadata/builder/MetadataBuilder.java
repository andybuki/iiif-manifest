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
    // Store values grouped by language: Map<lang, List<String>>
    private final java.util.Map<String, List<String>> valuesByLang = new java.util.LinkedHashMap<>();

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
     * Create metadata with a list of values, auto-detecting language for each value.
     * Chinese, Japanese, Korean, Thai, etc. will be detected and separated.
     *
     * Usage:
     *   MetadataBuilder.createWithAutoLang("schema:keyword", keywords, "en")
     *
     * Input: ["Jiang Jingguo", "蔣經國", "visitors", "來賓"]
     * Result: { "en": ["Jiang Jingguo", "visitors"], "zh": ["蔣經國", "來賓"] }
     *
     * @param label The metadata label
     * @param values List of values (mixed languages)
     * @param defaultLang Default language for values without detected script
     */
    public static MetadataBuilder createWithAutoLang(String label, List<?> values, String defaultLang) {
        MetadataBuilder builder = new MetadataBuilder(label);
        if (values != null && !values.isEmpty()) {
            for (Object value : values) {
                if (value != null) {
                    String text = value.toString();
                    String detectedLang = detectLanguage(text, defaultLang);
                    builder.addValue(detectedLang, text);
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
     * Add a value with language.
     * Multiple values with same language will be grouped together.
     */
    public MetadataBuilder addValue(String lang, String value) {
        if (isNotEmpty(value)) {
            valuesByLang.computeIfAbsent(lang, k -> new ArrayList<>()).add(value);
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
     * Build the Metadata object (returns null if no values).
     * Groups all values by language correctly.
     *
     * Example:
     *   Input values: [("en", "Jiang"), ("zh", "蔣經國"), ("en", "visitors"), ("zh", "來賓")]
     *   Output: { "en": ["Jiang", "visitors"], "zh": ["蔣經國", "來賓"] }
     */
    public Metadata build() {
        if (valuesByLang.isEmpty()) {
            return null;
        }

        Label label = new Label(labelLang, labelText);

        // Create I18n array - one I18n per language, with all strings for that language
        List<I18n> i18nList = new ArrayList<>();
        for (java.util.Map.Entry<String, List<String>> entry : valuesByLang.entrySet()) {
            String lang = entry.getKey();
            List<String> strings = entry.getValue();
            // Create I18n with all strings for this language
            i18nList.add(new I18n(lang, strings));
        }

        Value value = new Value(i18nList.toArray(new I18n[0]));

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
        return !valuesByLang.isEmpty();
    }

    // ========== Utility ==========

    private static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    /**
     * Check if a string contains Chinese characters.
     * Covers CJK Unified Ideographs and common extensions.
     */
    public static boolean containsChinese(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        // CJK Unified Ideographs: \u4E00-\u9FFF
        // CJK Unified Ideographs Extension A: \u3400-\u4DBF
        // CJK Compatibility Ideographs: \uF900-\uFAFF
        return text.matches(".*[\\u4E00-\\u9FFF\\u3400-\\u4DBF\\uF900-\\uFAFF]+.*");
    }

    /**
     * Check if a string contains Japanese Hiragana or Katakana.
     */
    public static boolean containsJapanese(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        // Hiragana: \u3040-\u309F
        // Katakana: \u30A0-\u30FF
        return text.matches(".*[\\u3040-\\u309F\\u30A0-\\u30FF]+.*");
    }

    /**
     * Check if a string contains Korean Hangul.
     */
    public static boolean containsKorean(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        // Hangul Syllables: \uAC00-\uD7AF
        // Hangul Jamo: \u1100-\u11FF
        return text.matches(".*[\\uAC00-\\uD7AF\\u1100-\\u11FF]+.*");
    }

    /**
     * Check if a string contains Thai characters.
     */
    public static boolean containsThai(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        // Thai: \u0E00-\u0E7F
        return text.matches(".*[\\u0E00-\\u0E7F]+.*");
    }

    /**
     * Check if a string contains Tibetan characters.
     */
    public static boolean containsTibetan(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        // Tibetan: \u0F00-\u0FFF
        return text.matches(".*[\\u0F00-\\u0FFF]+.*");
    }

    /**
     * Check if a string contains Lao characters.
     */
    public static boolean containsLao(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        // Lao: \u0E80-\u0EFF
        return text.matches(".*[\\u0E80-\\u0EFF]+.*");
    }

    /**
     * Check if a string contains Arabic characters.
     */
    public static boolean containsArabic(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        // Arabic: \u0600-\u06FF
        // Arabic Supplement: \u0750-\u077F
        return text.matches(".*[\\u0600-\\u06FF\\u0750-\\u077F]+.*");
    }

    /**
     * Detect the language of a string based on script.
     * Returns ISO 639-1 language code.
     *
     * @param text The text to analyze
     * @param defaultLang Default language if no specific script detected
     * @return Language code (e.g., "zh", "ja", "ko", "en")
     */
    public static String detectLanguage(String text, String defaultLang) {
        if (text == null || text.isEmpty()) {
            return defaultLang;
        }
        if (containsJapanese(text)) {
            return "ja";
        }
        if (containsKorean(text)) {
            return "ko";
        }
        if (containsChinese(text)) {
            return "zh";
        }
        if (containsThai(text)) {
            return "th";
        }
        if (containsTibetan(text)) {
            return "bo";
        }
        if (containsLao(text)) {
            return "lo";
        }
        if (containsArabic(text)) {
            return "ar";
        }
        return defaultLang;
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