package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.*;
import org.crossasia.manifest.metadata.builder.MetadataBuilder;
import org.crossasia.manifest.metadata.builder.MetadataField;

import java.util.ArrayList;
import java.util.List;

/**
 * Metadata members for DTAB collection.
 *
 * Based on DTAB metadata fields from the original implementation.
 * Each field maps to a getter in DtabAttributes.
 */
public class MetadataMembersDtab {

    public static void metadataMembersDtab(DtabAttributes attrs, Manifest manifest) {
        List<Metadata> metadataList = new ArrayList<>();

        // ========== Identification ==========
        addIfPresent(metadataList, MetadataField.DC_TITLE.with(attrs.getTitle()));
        addIfPresent(metadataList, MetadataField.DTAB_ID.with(attrs.getId()));
        addIfPresent(metadataList, MetadataField.DTAB_DOCUMENT_ID.with(attrs.getDocumentId()));

        if (attrs.getArchiveInfo() != null) {
            ArchiveInfo archive = attrs.getArchiveInfo();
            addIfPresent(metadataList, MetadataField.DTAB_ARCHIVE_SIGNATORY.with(archive.getArchiveSignatory()));
            addIfPresent(metadataList, MetadataField.DTAB_ARCHIVE_ID.with(archive.getArchiveId()));
            addIfPresent(metadataList, MetadataField.DTAB_ID_IN_ARCHIVE.with(archive.getIdInArchive()));
            addIfPresent(metadataList, MetadataField.DTAB_NAME_OF_ARCHIVE.with(archive.getArchiveName()));
        }
        addIfPresent(metadataList, MetadataField.DTAB_INVISIBLE.with(attrs.getInvisible()));

        // ========== Dates ==========
        if (attrs.getDateInfo() != null) {
            DateInfo dateInfo = attrs.getDateInfo();
            addIfPresent(metadataList, MetadataField.DC_DATE.with(dateInfo.getDate()));
            addIfPresent(metadataList, MetadataField.DTAB_DATE_ID.with(dateInfo.getDateId()));
            addIfPresent(metadataList, MetadataField.DC_DATE_DESCRIPTION_ID.with(dateInfo.getDateDescriptionId()));
            addIfPresent(metadataList, MetadataField.DTAB_DESCRIPTION_DATE.with(dateInfo.getDescriptionDate()));
        }

        // ========== Places ==========
        if (attrs.getPlaceInfo() != null) {
            PlaceInfo placeInfo = attrs.getPlaceInfo();
            addIfPresent(metadataList, MetadataField.SCHEMA_PLACE.with(placeInfo.getPlace()));
            addIfPresent(metadataList, MetadataField.DTAB_PLACE_ID.with(placeInfo.getPlaceId()));
            addIfPresent(metadataList, MetadataField.DTAB_PLACE_OF_ISSUE_ID.with(placeInfo.getPlaceOfIssueId()));
            addIfPresent(metadataList, MetadataField.DTAB_COMMENT_PLACE.with(placeInfo.getCommentPlace()));
        }

        // ========== Sender / Receiver ==========
        if (attrs.getSender() != null || attrs.getReceiver() != null) {
            PersonRole sender = attrs.getSender();
            PersonRole receiver = attrs.getReceiver();
            addIfPresent(metadataList, MetadataField.DTAB_SENDER.with(sender.getPersonName()));
            addIfPresent(metadataList, MetadataField.DTAB_SENDER_ID.with(sender.getPersonId()));
            addIfPresent(metadataList, MetadataField.DTAB_SENDER_ROLE_COMMENT.with(sender.getRoleComment()));
            // If there are multiple names
            addIfPresent(metadataList, MetadataField.DTAB_SENDER.with(sender.getPersonNames()));
            addIfPresent(metadataList, MetadataField.DTAB_RECEIVER.with(receiver.getPersonName()));
            addIfPresent(metadataList, MetadataField.DTAB_RECEIVER_ID.with(receiver.getPersonId()));
            addIfPresent(metadataList, MetadataField.DTAB_RECEIVER_COMMENT.with(receiver.getRoleComment()));
            // If there are multiple names
            addIfPresent(metadataList, MetadataField.DTAB_RECEIVER.with(receiver.getPersonNames()));
        }

        // ========== Content & Comments ==========
        addIfPresent(metadataList, MetadataField.SCHEMA_TEXT.with(attrs.getText()));
        addIfPresent(metadataList, MetadataField.SCHEMA_COMMENT.with(attrs.getComment()));
        addIfPresent(metadataList, MetadataField.DTAB_COMMENT_ABOUT_TYPES.with(attrs.getCommentAboutTypesOfDocument()));
        addIfPresent(metadataList, MetadataField.DTAB_PROVERBS.with(attrs.getProverbs()));
        addIfPresent(metadataList, MetadataField.DTAB_TERMINOLOGY.with(attrs.getTerminology()));

        // ========== Scripts ==========
        if (attrs.getScriptInfo() != null) {
            ScriptInfo scriptInfo = attrs.getScriptInfo();
            addIfPresent(metadataList, MetadataField.DTAB_SCRIPT.with(scriptInfo.getScripts()));
            addIfPresent(metadataList, MetadataField.DTAB_SCRIPT_ID_ROLE.with(scriptInfo.getScriptIdRole()));
            addIfPresent(metadataList, MetadataField.DTAB_USED_SCRIPTS.with(scriptInfo.getUsedScripts()));
        }

        // ========== Seals (nested in SealInfo) ==========
        // SealInfo is a nested object, so we need to check if it's not null
        if (attrs.getSealInfo() != null) {
            SealInfo seal = attrs.getSealInfo();
            addIfPresent(metadataList, MetadataField.DTAB_SEAL.with(seal.getSeal()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_ID.with(seal.getSealId()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_DOC_ID.with(seal.getDocumentIds()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_INSCRIPTION.with(seal.getInscriptions()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_COLOR.with(seal.getColors()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_FORM.with(seal.getForms()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_SIZE.with(seal.getSizes()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_REFERENCE.with(seal.getReferences()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_COMMENT.with(seal.getComments()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_LINKS.with(seal.getLinks()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_NAME_SCRIPT.with(seal.getNameOfScripts()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_COMMENT_USED_SCRIPTS.with(seal.getCommentUsedScripts()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_COMPARE.with(seal.getCompare()));
            addIfPresent(metadataList, MetadataField.DTAB_SEAL_IMAGE_FILES.with(seal.getImageFiles()));
        };

        addIfPresent(metadataList, MetadataField.DTAB_GPOS.with(attrs.getGeographicPosition()));
        addIfPresent(metadataList, MetadataField.DTAB_GROUPNO.with(attrs.getGroupNumber()));

        // ========== Files ==========
        if (attrs.getFileReferences() != null) {
            FileReferences fileReferences = attrs.getFileReferences();
            addIfPresent(metadataList, MetadataField.DTAB_TRANSCRIPTION_FILES.with(fileReferences.getTranscriptionFiles()));
            addIfPresent(metadataList, MetadataField.DTAB_PREVIEW_IMAGE_FILES.with(fileReferences.getPreviewImageFiles()));
            addIfPresent(metadataList, MetadataField.DTAB_HTML_FILES.with(fileReferences.getHtmlFiles()));
            addIfPresent(metadataList, MetadataField.DTAB_OTHER_FILES.with(fileReferences.getOtherFiles()));
        }

        // ========== Multi-seal handling ==========
        // If multiSeal is a list, use with(List)
        // addIfPresent(metadataList, MetadataField.DTAB_SEAL.with(attrs.getMultiSeal()));

        // Set all metadata
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