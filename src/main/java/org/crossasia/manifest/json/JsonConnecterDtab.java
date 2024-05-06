package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConnecterDtab {
    public static void invisible (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:invisible")) {
            dtabAttributes.setDtabInvisible((String) jsonObj.get("dtab:invisible"));
        }
    }

    public static void archiveSignatory (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:archive_signatory")) {
            dtabAttributes.setDtabArchiveSignatory((String) jsonObj.get("dtab:archive_signatory"));
        }
    }
    public static void commentPlace (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:comment_place")) {
            dtabAttributes.setDtabCommentPlace((String) jsonObj.get("dtab:comment_place"));
        }
    }
    public static void senderTb (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_tb")) {
            dtabAttributes.setDtabSenderTb((JSONArray) jsonObj.get("dtab:sender_tb"));
        }
    }

    public static void senderComment (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_comment")) {
            dtabAttributes.setDtabSenderComment((String) jsonObj.get("dtab:sender_comment"));
        }
    }

    public static void commentAboutTypesOfDocumentTb (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:comment_about_types_of_document_tb")) {
            dtabAttributes.setDtabCommentAboutTypesOfDocumentTb((String) jsonObj.get("dtab:comment_about_types_of_document_tb"));
        }
    }

    public static void sealId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_id")) {
            dtabAttributes.setDtabSealId((JSONArray) jsonObj.get("dtab:seal_id"));
        }
    }
    public static void dateDescriptionId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:date_description_id")) {
            dtabAttributes.setDtabDateDescriptionId((String) jsonObj.get("dtab:date_description_id"));
        }
    }

    public static void archiveId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:archive_id")) {
            dtabAttributes.setDtabArchiveId((String) jsonObj.get("dtab:archive_id"));
        }
    }

    public static void commentAboutTypesOfDocument (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:comment_about_types_of_document")) {
            dtabAttributes.setDtabCommentAboutTypesOfDocument((String) jsonObj.get("dtab:comment_about_types_of_document"));
        }
    }

    public static void dateId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:date_id")) {
            dtabAttributes.setDtabDateId((String) jsonObj.get("dtab:date_id"));
        }
    }

    public static void sealDocID (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_docID")) {
            dtabAttributes.setDtabSealDocID((JSONArray) jsonObj.get("dtab:seal_docID"));
        }
    }

    public static void dcTitle (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:title")) {
            dtabAttributes.setDcTitle((String) jsonObj.get("dc:title"));
        }
    }

    public static void descriptionDate (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:description_date")) {
            dtabAttributes.setDtabDescriptionDate((String) jsonObj.get("dtab:description_date"));
        }
    }

    public static void schemaComment (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:comment")) {
            dtabAttributes.setSchemaComment((String) jsonObj.get("schema:comment"));
        }
    }

    public static void sealNameOfScript (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_name_of_script")) {
            dtabAttributes.setDtabSealNameOfScript((JSONArray) jsonObj.get("dtab:seal_name_of_script"));
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
            if (jsonObj.get("schema:text") instanceof String) {
            dtabAttributes.setSchemaText((String) jsonObj.get("schema:text"));
            } else {
                System.out.println("xa");
            }
        }
    }

    public static void usedScripts (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:used_scripts")) {
            dtabAttributes.setDtabUsedScripts((String) jsonObj.get("dtab:used_scripts"));
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
            dtabAttributes.setDtabGpos((String) jsonObj.get("dtab:gpos"));
        }
    }

    public static void sealColor (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_color")) {
            dtabAttributes.setDtabSealColor((JSONArray) jsonObj.get("dtab:seal_color"));
        }
    }

    public static void nameOfArchive (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:name_of_archive")) {
            dtabAttributes.setDtabNameOfArchive((String) jsonObj.get("dtab:name_of_archive"));
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
        if (jsonObj.has("dtab:seal_form")) {
            dtabAttributes.setDtabSealForm((JSONArray) jsonObj.get("dtab:seal_form"));
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
            dtabAttributes.setDtabGroupno((String) jsonObj.get("dtab:groupno"));
        }
    }

    public static void idInArchive (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:id_in_archive")) {
            dtabAttributes.setDtabIdInArchive((String) jsonObj.get("dtab:id_in_archive"));
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
        if (jsonObj.has("dtab:document_id")) {
            dtabAttributes.setDtabDocumentId((String) jsonObj.get("dtab:document_id"));
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
        if (jsonObj.has("dtab:place_id")) {
            dtabAttributes.setDtabPlaceId((String) jsonObj.get("dtab:place_id"));
        }
    }

    public static void placeOfIssueId (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:place_of_issue_id")) {
            dtabAttributes.setDtabPlaceOfIssueId((String) jsonObj.get("dtab:place_of_issue_id"));
        }
    }

    public static void terminology (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:terminology")) {
            dtabAttributes.setDtabTerminology((String) jsonObj.get("dtab:terminology"));
        }
    }

    public static void otherFiles (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:other_files")) {
            dtabAttributes.setDtabOtherFiles((String) jsonObj.get("dtab:other_files"));
        }
    }

    public static void proverbs (DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:proverbs")) {
            dtabAttributes.setDtabProverbs((String) jsonObj.get("dtab:proverbs"));
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
