package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.PersonRole;
import org.crossasia.manifest.attributes.domain.ScriptInfo;
import org.crossasia.manifest.attributes.domain.SealInfo;
import org.crossasia.manifest.metadata.builder.MetadataBuilder;
import org.crossasia.manifest.metadata.builder.MetadataField;

import java.util.ArrayList;
import java.util.List;

/**
 * Metadata members for Sugawara collection.
 *
 * Based on SugawaraAttributes which extends CollectionAttributes.
 * Uses nested objects: PersonRole, SealInfo, ScriptInfo
 */
public class MetadataMembersSugawara {

    public static void metadataMembersSugawara(SugawaraAttributes attrs, Manifest manifest) {
        List<Metadata> metadataList = new ArrayList<>();

        // ========== Identification (from CollectionAttributes parent) ==========
        // These getters should be in CollectionAttributes - adjust if different
        // addIfPresent(metadataList, MetadataField.DCTERMS_IDENTIFIER.with(attrs.getIdentifier()));
        // addIfPresent(metadataList, MetadataField.DATE.with(attrs.getDate()));
        // addIfPresent(metadataList, MetadataField.PLACE.with(attrs.getPlace()));
        // addIfPresent(metadataList, MetadataField.DC_DESCRIPTION.with(attrs.getDescription()));

        // ========== Sugawara-specific fields ==========
        addIfPresent(metadataList, MetadataField.SUGAWARA_FOLDER.with(attrs.getFolder()));
        addIfPresent(metadataList, MetadataField.SUGAWARA_DOCUMENT.with(attrs.getDocument()));
        addIfPresent(metadataList, MetadataField.SCHEMA_CATEGORY.with(attrs.getCategory()));

        // Location
        addIfPresent(metadataList,
                MetadataBuilder.create("mods:physicalLocation", attrs.getPhysicalLocation(), "en")
                        .withLabelLang("en"));

        // Subjects (List<String>)
        addIfPresent(metadataList, MetadataField.DCTERMS_SUBJECT.with(attrs.getSubjects()));

        // ========== Physical description ==========
        addIfPresent(metadataList,
                MetadataBuilder.create("sugawara:physicalData", attrs.getPhysicalData(), "en")
                        .withLabelLang("en"));
        addIfPresent(metadataList,
                MetadataBuilder.create("sugawara:physicalType", attrs.getPhysicalType(), "en")
                        .withLabelLang("en"));
        addIfPresent(metadataList, MetadataField.DCTERMS_EXTENT.with(attrs.getExtent()));

        // ========== Tax stamps (List<String>) ==========
        addIfPresent(metadataList,
                MetadataBuilder.create("sugawara:taxStamp", attrs.getTaxStamps(), "en")
                        .withLabelLang("en"));

        // ========== Person Role A (nested PersonRole) ==========
        if (attrs.getRoleA() != null) {
            PersonRole roleA = attrs.getRoleA();
            String labelA = isNotEmpty(roleA.getRole()) ? roleA.getRole() : "Person A";
            addIfPresent(metadataList,
                    MetadataBuilder.create(labelA, roleA.getPersonName(), "en")
                            .withLabelLang("en"));
            // If multiple names
            if (roleA.getPersonNames() != null && !roleA.getPersonNames().isEmpty()) {
                addIfPresent(metadataList,
                        MetadataBuilder.create(labelA + " (names)", roleA.getPersonNames(), "en")
                                .withLabelLang("en"));
            }
            if (isNotEmpty(roleA.getRoleComment())) {
                addIfPresent(metadataList,
                        MetadataBuilder.create(labelA + " Comment", roleA.getRoleComment(), "en")
                                .withLabelLang("en"));
            }
        }

        // ========== Person Role B (nested PersonRole) ==========
        if (attrs.getRoleB() != null) {
            PersonRole roleB = attrs.getRoleB();
            String labelB = isNotEmpty(roleB.getRole()) ? roleB.getRole() : "Person B";
            addIfPresent(metadataList,
                    MetadataBuilder.create(labelB, roleB.getPersonName(), "en")
                            .withLabelLang("en"));
            // If multiple names
            if (roleB.getPersonNames() != null && !roleB.getPersonNames().isEmpty()) {
                addIfPresent(metadataList,
                        MetadataBuilder.create(labelB + " (names)", roleB.getPersonNames(), "en")
                                .withLabelLang("en"));
            }
            if (isNotEmpty(roleB.getRoleComment())) {
                addIfPresent(metadataList,
                        MetadataBuilder.create(labelB + " Comment", roleB.getRoleComment(), "en")
                                .withLabelLang("en"));
            }
        }

        // ========== Seal Info (nested SealInfo) ==========
        if (attrs.getSealInfo() != null) {
            SealInfo seal = attrs.getSealInfo();
            addIfPresent(metadataList, MetadataField.SUGAWARA_SEAL.with(seal.getSeal()));
            // Add other seal fields as needed based on SealInfo structure
            // addIfPresent(metadataList, MetadataField.DTAB_SEAL_ID.with(seal.getSealId()));
        }

        // ========== Script Info (nested ScriptInfo) ==========
        if (attrs.getScriptInfo() != null) {
            ScriptInfo script = attrs.getScriptInfo();
            // Add script fields based on ScriptInfo structure
            // Example: addIfPresent(metadataList, MetadataField.LANGUAGE.with(script.getLanguage()));
        }

        // ========== Citations and grants ==========
        addIfPresent(metadataList, MetadataField.SCHEMA_CITATION.with(attrs.getCitation()));
        addIfPresent(metadataList, MetadataField.SCHEMA_GRANT.with(attrs.getGrant()));
        addIfPresent(metadataList, MetadataField.SCHEMA_ABSTRACT.with(attrs.getAbstractText()));

        // Set all metadata
        if (!metadataList.isEmpty()) {
            manifest.setMetadata(metadataList);
        }
    }

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