package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConnecterDtab {
    public static void invisible (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:invisible")) {
            dtabAttributes.setInvisible(JsonConverter.getString(jsonObj, "dtab:invisible"));
        }
    }

    public static void archiveSignatory (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:archive_signatory")) {
            ArchiveInfo archiveInfo = dtabAttributes.getArchiveInfo();
            if (archiveInfo == null) {
                archiveInfo = new ArchiveInfo();
                dtabAttributes.setArchiveInfo(archiveInfo);
            }
            archiveInfo.setArchiveSignatory(JsonConverter.getString(jsonObj, "dtab:archive_signatory"));
        }
    }
    public static void commentPlace (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:commentPlace")) {
            PlaceInfo placeInfo = dtabAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                dtabAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setCommentPlace(JsonConverter.getString(jsonObj, "dtab:commentPlace"));
        }
    }
    public static void senderTb (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_tb")) {
            PersonRole sender = dtabAttributes.getSender();
            if (sender == null) {
                sender = new PersonRole();
                dtabAttributes.setSender(sender);
            }
            sender.setPersonNames(JsonConverter.getStringList(jsonObj, "dtab:sender_tb"));

        }
    }

    public static void senderComment (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_comment")) {
            PersonRole sender = dtabAttributes.getSender();
            if (sender == null) {
                sender = new PersonRole();
                dtabAttributes.setSender(sender);
            }
            sender.setRoleComment(JsonConverter.getString(jsonObj, "dtab:sender_comment"));

        }
    }

    public static void commentAboutTypesOfDocumentTb (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:commentAboutTypesOfDocument")) {
            dtabAttributes.setCommentAboutTypesOfDocument(JsonConverter.getString(jsonObj, "dtab:commentAboutTypesOfDocument"));
        }
    }

    public static void sealId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_id")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setSealIds(JsonConverter.getStringList(jsonObj, "dtab:seal_id"));
        }
    }
    public static void dateDescriptionId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:date_description_id")) {
            DateInfo dateInfo = dtabAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                dtabAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setDescriptionDate(JsonConverter.getString(jsonObj, "dtab:date_description_id"));
        }
    }

    public static void archiveId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:archive_id")) {
            ArchiveInfo archiveInfo = dtabAttributes.getArchiveInfo();
            if (archiveInfo == null) {
                archiveInfo = new ArchiveInfo();
                dtabAttributes.setArchiveInfo(archiveInfo);
            }
            archiveInfo.setArchiveId(JsonConverter.getString(jsonObj, "dtab:archiveId"));
        }
    }

    public static void commentAboutTypesOfDocument (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:comment_about_types_of_document")) {
            dtabAttributes.setCommentAboutTypesOfDocument(JsonConverter.getString(jsonObj, "dtab:comment_about_types_of_document"));
        }
    }

    public static void dateId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:date_id")) {
            DateInfo dateInfo = dtabAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                dtabAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setDateId(JsonConverter.getString(jsonObj, "dtab:date_id"));

        }
    }

    public static void sealDocID (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_docID")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setDocumentIds(JsonConverter.getStringList(jsonObj, "dtab:seal_docID"));
        }
    }

    public static void dcTitle (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:title")) {
            dtabAttributes.setTitle((String) jsonObj.get("dc:title"));
        }
    }

    public static void descriptionDate (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:descriptionDate")) {
            DateInfo dateInfo = dtabAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                dtabAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setDescriptionDate(JsonConverter.getString(jsonObj, "dtab:descriptionDate"));
        }
    }

    public static void schemaComment (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:comment")) {
            dtabAttributes.setComment(JsonConverter.getString(jsonObj, "schema:comment"));
        }
    }

    public static void sealNameOfScript (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_script")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }

            dtabAttributes.setDtabSealNameOfScript((JSONArray) jsonObj.get("dtab:seal_script"));
        }
    }

    public static void sealCommentUsedScripts (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_comment_used_scripts")) {
            dtabAttributes.setDtabSealCommentUsedScripts((JSONArray) jsonObj.get("dtab:seal_comment_used_scripts"));
        }
    }

    public static void id (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("id")) {
            dtabAttributes.setId((String) jsonObj.get("id"));
        }
    }

    public static void schemaText (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:text")) {
            dtabAttributes.setText(JsonConverter.getString(jsonObj, "schema:text"));
        }
    }

    public static void usedScripts (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:used_scripts")) {
            ScriptInfo scriptInfo = dtabAttributes.getScriptInfo();
            if (scriptInfo == null) {
                scriptInfo = new ScriptInfo();
                dtabAttributes.setScriptInfo(scriptInfo);
            }
            scriptInfo.setUsedScripts((String) jsonObj.get("dtab:used_scripts"));
        }
    }

    public static void multiSeal (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_info")) {
            dtabAttributes.setDtabMultiSeal((JSONArray) jsonObj.get("dtab:seal_info"));
        }
    }

    public static void transcriptionFiles (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:transcription_files")) {
            dtabAttributes.setDtabTranscriptionFiles((String) jsonObj.get("dtab:transcription_files"));
        }
    }

    public static void senderCommentTb (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_comment_tb")) {
            dtabAttributes.setDtabSenderCommentTb((String) jsonObj.get("dtab:sender_comment_tb"));
        }
    }

    public static void gpos (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:gpos")) {
            dtabAttributes.setGeographicPosition(JsonConverter.getString(jsonObj, "dtab:gpos"));
        }
    }

    public static void sealColor (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_color_orig")) {
            dtabAttributes.setDtabSealColor((JSONArray) jsonObj.get("dtab:seal_color_orig"));
        }
    }

    public static void sealInscription (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_inscription")) {
            dtabAttributes.setDtabSealInscription((JSONArray) jsonObj.get("dtab:seal_inscription"));
        }
    }

    public static void sealReference (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_reference")) {
            dtabAttributes.setDtabSealReference((JSONArray) jsonObj.get("dtab:seal_reference"));
        }
    }

    public static void sealComment (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_comment")) {
            dtabAttributes.setDtabSealComment((JSONArray) jsonObj.get("dtab:seal_comment"));
        }
    }

    public static void sealLinks (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_docID")) {
            dtabAttributes.setDtabSealLinks((JSONArray) jsonObj.get("dtab:seal_docID"));
        }
    }

    public static void nameOfArchive (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:name_of_archive")) {
            ArchiveInfo archiveInfo = dtabAttributes.getArchiveInfo();
            if (archiveInfo == null) {
                archiveInfo = new ArchiveInfo();
                dtabAttributes.setArchiveInfo(archiveInfo);
            }
            archiveInfo.setArchiveName(JsonConverter.getString(jsonObj, "dtab:nameOfArchive"));
        }
    }

    public static void scriptIdRole (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:script_id_role")) {
            dtabAttributes.setDtabScriptIdRole((String) jsonObj.get("dtab:script_id_role"));
        }
    }

    public static void senderId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_id")) {
            dtabAttributes.setDtabSenderId((JSONArray) jsonObj.get("dtab:sender_id"));
        }
    }

    public static void sealSize (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_size")) {
            dtabAttributes.setDtabSealSize((JSONArray) jsonObj.get("dtab:seal_size"));
        }
    }

    public static void sealForm (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_form_orig")) {
            dtabAttributes.setDtabSealForm((JSONArray) jsonObj.get("dtab:seal_form_orig"));
        }
    }

    public static void sealFormNEW (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_form")) {
            dtabAttributes.setSeal_formNEW((JSONArray) jsonObj.get("dtab:seal_form"));
        }
    }

    public static void sealColorNEW (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_color")) {
            dtabAttributes.setSeal_colorNEW((JSONArray) jsonObj.get("dtab:seal_color"));
        }
    }

    public static void sealImageFiles (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_image_files")) {
            dtabAttributes.setSeal_image_files((JSONArray) jsonObj.get("dtab:seal_image_files"));
        }
    }

    public static void sealCompare (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_compare")) {
            dtabAttributes.setSeal_compare((JSONArray) jsonObj.get("dtab:seal_compare"));
        }
    }

    public static void recipientTb (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:recipient_tb")) {
            dtabAttributes.setDtabRecipientTb((String) jsonObj.get("dtab:recipient_tb"));
        }
    }

    public static void dcDate (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:date")) {
            dtabAttributes.setDcDtate((String) jsonObj.get("dc:date"));
        }
    }

    public static void script (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:script")) {
            dtabAttributes.setDtabScript((JSONArray) jsonObj.get("dtab:script"));
        }
    }

    public static void sender (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender")) {
            dtabAttributes.setDtabSender((JSONArray) jsonObj.get("dtab:sender"));
        }
    }

    public static void previewImageFiles (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:preview_image_files")) {
            dtabAttributes.setDtabPreviewImageFiles((JSONArray) jsonObj.get("dtab:preview_image_files"));
        }
    }

    public static void groupno (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:groupno")) {
            dtabAttributes.setGroupNumber(JsonConverter.getString(jsonObj, "dtab:groupno"));
        }
    }

    public static void idInArchive (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:idInArchiv")) {
            ArchiveInfo archiveInfo = dtabAttributes.getArchiveInfo();
            if (archiveInfo == null) {
                archiveInfo = new ArchiveInfo();
                dtabAttributes.setArchiveInfo(archiveInfo);
            }
            archiveInfo.setIdInArchive(JsonConverter.getString(jsonObj, "dtab:idInArchive"));
        }
    }

    public static void schemaName (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:name")) {
            dtabAttributes.setSchemaName((String) jsonObj.get("schema:name"));
        }
    }

    public static void schemaRecipient (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:recipient")) {
            dtabAttributes.setSchemaRecipient((String) jsonObj.get("schema:recipient"));
        }
    }

    public static void htmlFiles (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:html_files")) {
            dtabAttributes.setDtabHtmlFiles((String) jsonObj.get("dtab:html_files"));
        }
    }

    public static void documentId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:documentId")) {
            dtabAttributes.setDocumentId(JsonConverter.getString(jsonObj, "dtab:documentId"));
        }
    }

    public static void commentPlaceTb (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:comment_place_tb")) {
            dtabAttributes.setDtabCommentPlaceTb((String) jsonObj.get("dtab:comment_place_tb"));
        }
    }

    public static void seal (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal")) {
            dtabAttributes.setDtabSeal((String) jsonObj.get("dtab:seal"));
        }
    }

    public static void placeId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:placeId")) {
            PlaceInfo placeInfo = dtabAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                dtabAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlaceId(JsonConverter.getString(jsonObj, "dtab:placeId"));
        }
    }

    public static void placeOfIssueId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:placeOfIssueId")) {
            PlaceInfo placeInfo = dtabAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                dtabAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlaceOfIssueId(JsonConverter.getString(jsonObj, "dtab:placeOfIssueId"));
        }
    }

    public static void terminology (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:terminology")) {
            dtabAttributes.setTerminology(JsonConverter.getString(jsonObj, "dtab:terminology"));
        }
    }

    public static void otherFiles (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:other_files")) {
            dtabAttributes.setDtabOtherFiles((String) jsonObj.get("dtab:other_files"));
        }
    }

    public static void proverbs (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:proverbs")) {
            dtabAttributes.setProverbs(JsonConverter.getString(jsonObj, "dtab:proverbs"));
        }
    }

    public static void senderRoleComment (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_role_comment")) {
            dtabAttributes.setDtabSenderRoleComment((String) jsonObj.get("dtab:sender_role_comment"));
        }
    }

    public static void receiverId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:receiver_id")) {
            dtabAttributes.setDtabReceiverId((JSONArray) jsonObj.get("dtab:receiver_id"));
        }
    }

    public static void receiver (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:receiver")) {
            dtabAttributes.setDtabReceiver((JSONArray) jsonObj.get("dtab:receiver"));
        }
    }

    public static void receiverTb (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:receiver_tb")) {
            dtabAttributes.setDtabReceiverTb((JSONArray) jsonObj.get("dtab:receiver_tb"));
        }
    }

    public static void receiverComment (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:receiver_comment")) {
            dtabAttributes.setDtabReceiverComment((String) jsonObj.get("dtab:receiver_comment"));
        }
    }

    public static void receiverCommentTb (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:receiver_comment_tb")) {
            dtabAttributes.setDtabReceiverCommentTb((String) jsonObj.get("dtab:receiver_comment_tb"));
        }
    }

    public static void placeComment (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:place_comment")) {
            dtabAttributes.setDtabCommentPlace((String) jsonObj.get("dtab:place_comment"));
        }
    }

    public static void place (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:place")) {
            dtabAttributes.setSchemaPlace((String) jsonObj.get("schema:place"));
        }
    }
}
