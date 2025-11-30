package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import org.crossasia.manifest.attributes.KahlenAttributes;
import org.crossasia.manifest.metadata.builder.MetadataBuilder;
import org.crossasia.manifest.metadata.builder.MetadataField;

import java.util.ArrayList;
import java.util.List;

/**
 * Metadata members for Kahlen collection.
 *
 * Usage:
 *   MetadataMembersKahlen.metadataMembersKahlen(attributes, manifest);
 *
 * The MetadataField.with() method is overloaded to handle both:
 *   - String values:       MetadataField.DATE.with(attrs.getDate())
 *   - List<String> values: MetadataField.PLACE.with(attrs.getPlaces())
 *
 * Java will automatically select the correct method based on the parameter type.
 */
public class MetadataMembersKahlen {

    /**
     * Add all Kahlen metadata to manifest
     */
    public static void metadataMembersKahlen(KahlenAttributes attrs, Manifest manifest) {
        List<info.freelibrary.iiif.presentation.v3.properties.Metadata> metadataList = new ArrayList<>();

        // String fields
        addIfPresent(metadataList, MetadataField.DCTERMS_DATE.with(attrs.getDate()));
        addIfPresent(metadataList, MetadataField.SCHEMA_INDEX.with(attrs.getIndexes()));

        // dc:identifier (was kahlenAttributes.getIdentifier())
        addIfPresent(metadataList, MetadataField.DC_IDENTIFIER.with(attrs.getIdentifier()));

        // List fields
        addIfPresent(metadataList, MetadataField.DCTERMS_PLACE.with(attrs.getPlaces()));
        addIfPresent(metadataList, MetadataField.SCHEMA_KEYWORD.with(attrs.getKeyword()));

        // Multi-language subject field (English at index 0, Chinese at index 1)
        if (attrs.getSubjects() != null && attrs.getSubjects().size() >= 2) {
            addIfPresent(metadataList,
                    MetadataField.DCTERMS_SUBJECT.builder()
                            .addValueFromList("en", attrs.getSubjects(), 0)
                            .addValueFromList("zh", attrs.getSubjects(), 1)
            );
        } else if (attrs.getSubjects() != null && !attrs.getSubjects().isEmpty()) {
            // Single value - just use the list
            addIfPresent(metadataList, MetadataField.DCTERMS_SUBJECT.with(attrs.getSubjects()));
        }

        // Set all metadata at once
        if (!metadataList.isEmpty()) {
            manifest.setMetadata(metadataList);
        }
    }

    /**
     * Helper to add metadata if builder has values
     */
    private static void addIfPresent(
            List<info.freelibrary.iiif.presentation.v3.properties.Metadata> list,
            MetadataBuilder builder) {
        if (builder != null && builder.hasValues()) {
            info.freelibrary.iiif.presentation.v3.properties.Metadata metadata = builder.build();
            if (metadata != null) {
                list.add(metadata);
            }
        }
    }
}