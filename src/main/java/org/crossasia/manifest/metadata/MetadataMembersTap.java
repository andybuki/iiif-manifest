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

        // ========== From BaseCollectionAttributes (if available) ==========
        // addIfPresent(metadataList, MetadataField.DC_IDENTIFIER.with(attrs.getIdentifier()));
        // addIfPresent(metadataList, MetadataField.DC_TITLE.with(attrs.getTitle()));

        // ========== TAP-specific String fields ==========
        addIfPresent(metadataList,
                MetadataBuilder.create("schema:alternative", attrs.getAlternative(), "en")
                        .withLabelLang("en"));
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
}