package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConnecterDtab {

    public static void invisible(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:invisible")) {
            dtabAttributes.setInvisible(JsonConverter.getString(jsonObj, "dtab:invisible"));
        }
    }

    public static void archiveSignatory(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:archive_signatory")) {
            ArchiveInfo archiveInfo = dtabAttributes.getArchiveInfo();
            if (archiveInfo == null) {
                archiveInfo = new ArchiveInfo();
                dtabAttributes.setArchiveInfo(archiveInfo);
            }
            archiveInfo.setArchiveSignatory(JsonConverter.getString(jsonObj, "dtab:archive_signatory"));
        }
    }

    public static void commentPlace(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:commentPlace")) {
            PlaceInfo placeInfo = dtabAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                dtabAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setCommentPlace(JsonConverter.getString(jsonObj, "dtab:commentPlace"));
        }
    }

    public static void senderTb(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_tb")) {
            PersonRole sender = dtabAttributes.getSender();
            if (sender == null) {
                sender = new PersonRole();
                dtabAttributes.setSender(sender);
            }
            sender.setPersonNames(JsonConverter.getStringList(jsonObj, "dtab:sender_tb"));
        }
    }

    public static void senderComment(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_comment")) {
            PersonRole sender = dtabAttributes.getSender();
            if (sender == null) {
                sender = new PersonRole();
                dtabAttributes.setSender(sender);
            }
            sender.setRoleComment(JsonConverter.getString(jsonObj, "dtab:sender_comment"));
        }
    }

    public static void commentAboutTypesOfDocumentTb(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:commentAboutTypesOfDocument")) {
            dtabAttributes.setCommentAboutTypesOfDocument(JsonConverter.getString(jsonObj, "dtab:commentAboutTypesOfDocument"));
        }
    }

    public static void sealId(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_id")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setSealIds(JsonConverter.getStringList(jsonObj, "dtab:seal_id"));
        }
    }

    public static void dateDescriptionId(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:date_description_id")) {
            DateInfo dateInfo = dtabAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                dtabAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setDescriptionDate(JsonConverter.getString(jsonObj, "dtab:date_description_id"));
        }
    }

    public static void archiveId(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:archive_id")) {
            ArchiveInfo archiveInfo = dtabAttributes.getArchiveInfo();
            if (archiveInfo == null) {
                archiveInfo = new ArchiveInfo();
                dtabAttributes.setArchiveInfo(archiveInfo);
            }
            archiveInfo.setArchiveId(JsonConverter.getString(jsonObj, "dtab:archive_id"));
        }
    }

    public static void commentAboutTypesOfDocument(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:comment_about_types_of_document")) {
            dtabAttributes.setCommentAboutTypesOfDocument(JsonConverter.getString(jsonObj, "dtab:comment_about_types_of_document"));
        }
    }

    public static void dateId(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:date_id")) {
            DateInfo dateInfo = dtabAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                dtabAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setDateId(JsonConverter.getString(jsonObj, "dtab:date_id"));
        }
    }

    public static void sealDocID(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_docID")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setDocumentIds(JsonConverter.getStringList(jsonObj, "dtab:seal_docID"));
        }
    }

    public static void dcTitle(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:title")) {
            dtabAttributes.setTitle(JsonConverter.getString(jsonObj, "dc:title"));
        }
    }

    public static void descriptionDate(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:descriptionDate")) {
            DateInfo dateInfo = dtabAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                dtabAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setDescriptionDate(JsonConverter.getString(jsonObj, "dtab:descriptionDate"));
        }
    }

    public static void schemaComment(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:comment")) {
            dtabAttributes.setComment(JsonConverter.getString(jsonObj, "schema:comment"));
        }
    }

    public static void sealNameOfScript(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_script")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setNameOfScripts(JsonConverter.getStringList(jsonObj, "dtab:seal_script"));
        }
    }

    public static void sealCommentUsedScripts(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_comment_used_scripts")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setCommentUsedScripts(JsonConverter.getStringList(jsonObj, "dtab:seal_comment_used_scripts"));
        }
    }

    public static void id(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("id")) {
            dtabAttributes.setId(JsonConverter.getString(jsonObj, "id"));
        }
    }

    public static void schemaText(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:text")) {
            dtabAttributes.setText(JsonConverter.getString(jsonObj, "schema:text"));
        }
    }

    public static void usedScripts(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:used_scripts")) {
            ScriptInfo scriptInfo = dtabAttributes.getScriptInfo();
            if (scriptInfo == null) {
                scriptInfo = new ScriptInfo();
                dtabAttributes.setScriptInfo(scriptInfo);
            }
            scriptInfo.setUsedScripts(JsonConverter.getString(jsonObj, "dtab:used_scripts"));
        }
    }

    public static void multiSeal(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_info")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setMultiSeal(JsonConverter.getStringList(jsonObj, "dtab:seal_info"));
        }
    }

    public static void transcriptionFiles(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:transcription_files")) {
            FileReferences fileReferences = dtabAttributes.getFileReferences();
            if (fileReferences == null) {
                fileReferences = new FileReferences();
                dtabAttributes.setFileReferences(fileReferences);
            }
            fileReferences.setTranscriptionFiles(JsonConverter.getString(jsonObj, "dtab:transcription_files"));
        }
    }

    public static void senderCommentTb(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_comment_tb")) {
            PersonRole sender = dtabAttributes.getSender();
            if (sender == null) {
                sender = new PersonRole();
                dtabAttributes.setSender(sender);
            }
            sender.setRoleComment(JsonConverter.getString(jsonObj, "dtab:sender_comment_tb"));
        }
    }

    public static void gpos(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:gpos")) {
            dtabAttributes.setGeographicPosition(JsonConverter.getString(jsonObj, "dtab:gpos"));
        }
    }

    public static void sealColor(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_color_orig")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setColors(JsonConverter.getStringList(jsonObj, "dtab:seal_color_orig"));
        }
    }

    public static void sealInscription(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_inscription")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setInscriptions(JsonConverter.getStringList(jsonObj, "dtab:seal_inscription"));
        }
    }

    public static void sealReference(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_reference")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setReferences(JsonConverter.getStringList(jsonObj, "dtab:seal_reference"));
        }
    }

    public static void sealComment(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_comment")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setComments(JsonConverter.getStringList(jsonObj, "dtab:seal_comment"));
        }
    }

    public static void sealLinks(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_docID")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setLinks(JsonConverter.getStringList(jsonObj, "dtab:seal_docID"));
        }
    }

    public static void nameOfArchive(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:name_of_archive")) {
            ArchiveInfo archiveInfo = dtabAttributes.getArchiveInfo();
            if (archiveInfo == null) {
                archiveInfo = new ArchiveInfo();
                dtabAttributes.setArchiveInfo(archiveInfo);
            }
            archiveInfo.setArchiveName(JsonConverter.getString(jsonObj, "dtab:name_of_archive"));
        }
    }

    public static void scriptIdRole(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:script_id_role")) {
            ScriptInfo scriptInfo = dtabAttributes.getScriptInfo();
            if (scriptInfo == null) {
                scriptInfo = new ScriptInfo();
                dtabAttributes.setScriptInfo(scriptInfo);
            }
            scriptInfo.setScriptIdRole(JsonConverter.getString(jsonObj, "dtab:script_id_role"));
        }
    }

    public static void senderId(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_id")) {
            PersonRole sender = dtabAttributes.getSender();
            if (sender == null) {
                sender = new PersonRole();
                dtabAttributes.setSender(sender);
            }
            sender.setPersonId(JsonConverter.getString(jsonObj, "dtab:sender_id"));
        }
    }

    public static void sealSize(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_size")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setSizes(JsonConverter.getStringList(jsonObj, "dtab:seal_size"));
        }
    }

    public static void sealForm(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_form_orig")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setForms(JsonConverter.getStringList(jsonObj, "dtab:seal_form_orig"));
        }
    }

    public static void sealFormNEW(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_form")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setForms(JsonConverter.getStringList(jsonObj, "dtab:seal_form"));
        }
    }

    public static void sealColorNEW(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_color")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setColors(JsonConverter.getStringList(jsonObj, "dtab:seal_color"));
        }
    }

    public static void sealImageFiles(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_image_files")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setImageFiles(JsonConverter.getStringList(jsonObj, "dtab:seal_image_files"));
        }
    }

    public static void sealCompare(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal_compare")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setCompare(JsonConverter.getStringList(jsonObj, "dtab:seal_compare"));
        }
    }

    public static void recipientTb(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:recipient_tb")) {
            PersonRole receiver = dtabAttributes.getReceiver();
            if (receiver == null) {
                receiver = new PersonRole();
                dtabAttributes.setReceiver(receiver);
            }
            receiver.setPersonName(JsonConverter.getString(jsonObj, "dtab:recipient_tb"));
        }
    }

    public static void dcDate(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:date")) {
            DateInfo dateInfo = dtabAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                dtabAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setDate(JsonConverter.getString(jsonObj, "dc:date"));
        }
    }

    public static void script(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:script")) {
            ScriptInfo scriptInfo = dtabAttributes.getScriptInfo();
            if (scriptInfo == null) {
                scriptInfo = new ScriptInfo();
                dtabAttributes.setScriptInfo(scriptInfo);
            }
            scriptInfo.setScripts(JsonConverter.getStringList(jsonObj, "dtab:script"));
        }
    }

    public static void sender(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender")) {
            PersonRole sender = dtabAttributes.getSender();
            if (sender == null) {
                sender = new PersonRole();
                dtabAttributes.setSender(sender);
            }
            sender.setPersonNames(JsonConverter.getStringList(jsonObj, "dtab:sender"));
        }
    }

    public static void previewImageFiles(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:preview_image_files")) {
            FileReferences fileReferences = dtabAttributes.getFileReferences();
            if (fileReferences == null) {
                fileReferences = new FileReferences();
                dtabAttributes.setFileReferences(fileReferences);
            }
            fileReferences.setPreviewImageFiles(JsonConverter.getStringList(jsonObj, "dtab:preview_image_files"));
        }
    }

    public static void groupno(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:groupno")) {
            dtabAttributes.setGroupNumber(JsonConverter.getString(jsonObj, "dtab:groupno"));
        }
    }

    public static void idInArchive(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:idInArchiv")) {
            ArchiveInfo archiveInfo = dtabAttributes.getArchiveInfo();
            if (archiveInfo == null) {
                archiveInfo = new ArchiveInfo();
                dtabAttributes.setArchiveInfo(archiveInfo);
            }
            archiveInfo.setIdInArchive(JsonConverter.getString(jsonObj, "dtab:idInArchiv"));
        }
    }

    public static void schemaName(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:name")) {
            PersonRole sender = dtabAttributes.getSender();
            if (sender == null) {
                sender = new PersonRole();
                dtabAttributes.setSender(sender);
            }
            sender.setPersonName(JsonConverter.getString(jsonObj, "schema:name"));
        }
    }

    public static void schemaRecipient(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:recipient")) {
            PersonRole receiver = dtabAttributes.getReceiver();
            if (receiver == null) {
                receiver = new PersonRole();
                dtabAttributes.setReceiver(receiver);
            }
            receiver.setPersonName(JsonConverter.getString(jsonObj, "schema:recipient"));
        }
    }

    public static void htmlFiles(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:html_files")) {
            FileReferences fileReferences = dtabAttributes.getFileReferences();
            if (fileReferences == null) {
                fileReferences = new FileReferences();
                dtabAttributes.setFileReferences(fileReferences);
            }
            fileReferences.setHtmlFiles(JsonConverter.getString(jsonObj, "dtab:html_files"));
        }
    }

    public static void documentId(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:documentId")) {
            dtabAttributes.setDocumentId(JsonConverter.getString(jsonObj, "dtab:documentId"));
        }
    }

    public static void commentPlaceTb(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:comment_place_tb")) {
            PlaceInfo placeInfo = dtabAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                dtabAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setCommentPlace(JsonConverter.getString(jsonObj, "dtab:comment_place_tb"));
        }
    }

    public static void seal(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:seal")) {
            SealInfo sealInfo = dtabAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                dtabAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setSeal(JsonConverter.getString(jsonObj, "dtab:seal"));
        }
    }

    public static void placeId(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:placeId")) {
            PlaceInfo placeInfo = dtabAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                dtabAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlaceId(JsonConverter.getString(jsonObj, "dtab:placeId"));
        }
    }

    public static void placeOfIssueId(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:placeOfIssueId")) {
            PlaceInfo placeInfo = dtabAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                dtabAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlaceOfIssueId(JsonConverter.getString(jsonObj, "dtab:placeOfIssueId"));
        }
    }

    public static void terminology(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:terminology")) {
            dtabAttributes.setTerminology(JsonConverter.getString(jsonObj, "dtab:terminology"));
        }
    }

    public static void otherFiles(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:other_files")) {
            FileReferences fileReferences = dtabAttributes.getFileReferences();
            if (fileReferences == null) {
                fileReferences = new FileReferences();
                dtabAttributes.setFileReferences(fileReferences);
            }
            fileReferences.setOtherFiles(JsonConverter.getString(jsonObj, "dtab:other_files"));
        }
    }

    public static void proverbs(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:proverbs")) {
            dtabAttributes.setProverbs(JsonConverter.getString(jsonObj, "dtab:proverbs"));
        }
    }

    public static void senderRoleComment(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:sender_role_comment")) {
            PersonRole sender = dtabAttributes.getSender();
            if (sender == null) {
                sender = new PersonRole();
                dtabAttributes.setSender(sender);
            }
            sender.setRoleComment(JsonConverter.getString(jsonObj, "dtab:sender_role_comment"));
        }
    }

    public static void receiverId(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:receiver_id")) {
            PersonRole receiver = dtabAttributes.getReceiver();
            if (receiver == null) {
                receiver = new PersonRole();
                dtabAttributes.setReceiver(receiver);
            }
            receiver.setPersonId(JsonConverter.getString(jsonObj, "dtab:receiver_id"));
        }
    }

    public static void receiver(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:receiver")) {
            PersonRole receiver = dtabAttributes.getReceiver();
            if (receiver == null) {
                receiver = new PersonRole();
                dtabAttributes.setReceiver(receiver);
            }
            receiver.setPersonNames(JsonConverter.getStringList(jsonObj, "dtab:receiver"));
        }
    }

    public static void receiverTb(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:receiver_tb")) {
            PersonRole receiver = dtabAttributes.getReceiver();
            if (receiver == null) {
                receiver = new PersonRole();
                dtabAttributes.setReceiver(receiver);
            }
            receiver.setPersonNames(JsonConverter.getStringList(jsonObj, "dtab:receiver_tb"));
        }
    }

    public static void receiverComment(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:receiver_comment")) {
            PersonRole receiver = dtabAttributes.getReceiver();
            if (receiver == null) {
                receiver = new PersonRole();
                dtabAttributes.setReceiver(receiver);
            }
            receiver.setRoleComment(JsonConverter.getString(jsonObj, "dtab:receiver_comment"));
        }
    }

    public static void receiverCommentTb(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:receiver_comment_tb")) {
            PersonRole receiver = dtabAttributes.getReceiver();
            if (receiver == null) {
                receiver = new PersonRole();
                dtabAttributes.setReceiver(receiver);
            }
            receiver.setRoleComment(JsonConverter.getString(jsonObj, "dtab:receiver_comment_tb"));
        }
    }

    public static void placeComment(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dtab:place_comment")) {
            PlaceInfo placeInfo = dtabAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                dtabAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setCommentPlace(JsonConverter.getString(jsonObj, "dtab:place_comment"));
        }
    }

    public static void place(DtabAttributes dtabAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:place")) {
            PlaceInfo placeInfo = dtabAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                dtabAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlace(JsonConverter.getString(jsonObj, "schema:place"));
        }
    }
}
