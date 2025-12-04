package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import org.crossasia.manifest.attributes.TapAttributes;
import org.crossasia.manifest.metadata.builder.MetadataBuilder;
import org.crossasia.manifest.metadata.builder.MetadataField;

import java.util.ArrayList;
import java.util.List;

/**
 * Metadata members for TAP collection.
 *
 * Usage:
 *   MetadataMembersTap.metadataMembersTap(attributes, manifest);
 */
public class MetadataMembersTap {

    /**
     * Add all TAP metadata to manifest
     */
    public static void metadataMembersTap(TapAttributes attrs, Manifest manifest) {
        List<Metadata> metadataList = new ArrayList<>();

        // ========== dc:title - combines Chinese title + English alternative ==========
        // dc:title has Chinese value, schema:alternative has English value
        // Result: { "zh": ["中文標題"], "en": ["English Title"] }
        MetadataBuilder titleBuilder = MetadataBuilder.create("dc:title").withLabelLang("en");
        if (isNotEmpty(attrs.getTitle())) {
            // dc:title is Chinese
            titleBuilder.addValue("zh", attrs.getTitle());
        }
        if (isNotEmpty(attrs.getAlternative())) {
            // schema:alternative is English - add to same dc:title field
            titleBuilder.addValue("en", attrs.getAlternative());
        }
        addIfPresent(metadataList, titleBuilder);

        // ========== TAP-specific String fields ==========
        // NOTE: schema:alternative is NOT added separately - it's part of dc:title above
        addIfPresent(metadataList,
                MetadataBuilder.create("schema:caption", attrs.getCaption(), "en")
                        .withLabelLang("en"));
        addIfPresent(metadataList,
                MetadataBuilder.create("Label", attrs.getLabel(), "en")
                        .withLabelLang("en"));

        // ========== TAP-specific List fields with auto-language detection ==========
        // These fields may contain mixed English/Chinese values
        addIfPresent(metadataList,
                MetadataBuilder.createWithAutoLang("schema:organization", attrs.getOrganization(), "en")
                        .withLabelLang("en"));
        addIfPresent(metadataList,
                MetadataBuilder.createWithAutoLang("schema:people", attrs.getPeople(), "en")
                        .withLabelLang("en"));

        // Keywords: ["Jiang Jingguo", "蔣經國", "visitors", "來賓"]
        // → { "en": ["Jiang Jingguo", "visitors"], "zh": ["蔣經國", "來賓"] }
        addIfPresent(metadataList, MetadataField.SCHEMA_KEYWORD.withAutoLang(attrs.getKeywords()));
        addIfPresent(metadataList, MetadataField.DCTERMS_SUBJECT.withAutoLang(attrs.getSubject()));

        // Set all metadata at once
        if (!metadataList.isEmpty()) {
            manifest.setMetadata(metadataList);
        }
    }

    /**
     * Helper to add metadata if builder has values
     */
    private static void addIfPresent(List<Metadata> list, MetadataBuilder builder) {
        if (builder != null && builder.hasValues()) {
            Metadata metadata = builder.build();
            if (metadata != null) {
                list.add(metadata);
            }
        }
    }

    private static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}