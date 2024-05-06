package org.crossasia.manifest.attributes;

import org.json.JSONArray;

public class DtabAttributes {

    String dtabInvisible = "";
    String dtabArchiveSignatory = "";
    String dtabCommentPlace = "";
    JSONArray dtabSenderTb = null;
    String dtabSenderComment ="";
    String dtabCommentAboutTypesOfDocumentTb = "";
    JSONArray dtabSealId = null;
    String dtabDateDescriptionId = "";
    String dtabArchiveId = "";
    String dtabCommentAboutTypesOfDocument = "";
    String dtabDateId = "";
    JSONArray dtabSealDocID = null;
    String dcTitle = "";
    String dtabDescriptionDate = "";
    String schemaComment = "";
    JSONArray dtabSealNameOfScript = null;
    JSONArray dtabSealCommentUsedScripts = null;
    String id = "";
    String schemaText = "";
    String dtabUsedScripts = "";
    String dtabTranscriptionFiles = "";
    String dtabSenderCommentTb = "";
    String dtabGpos = "";
    JSONArray dtabSealColor = null;
    String dtabNameOfArchive = "";
    String dtabScriptIdRole = "";
    JSONArray dtabSenderId = null;
    JSONArray dtabSealSize = null;
    JSONArray dtabSealForm = null;
    String dtabRecipientTb = "";
    String dcDtate = "";
    JSONArray dtabScript = null;
    JSONArray dtabSender = null;
    JSONArray dtabPreviewImageFiles = null;
    String dtabGroupno = "";
    String dtabIdInArchive = "";
    String schemaName = "";
    String schemaRecipient = "";
    String dtabHtmlFiles ="";
    String dtabDocumentId = "";
    String dtabCommentPlaceTb = "";
    String dtabSeal ="";
    String dtabPlaceId ="";
    String dtabPlaceOfIssueId = "";
    String dtabTerminology ="";
    String dtabOtherFiles ="";
    String dtabProverbs ="";
    String dtabSenderRoleComment ="";
    JSONArray dtabReceiverId = null;

    JSONArray dtabReceiver = null;
    JSONArray dtabReceiverTb = null;

    String dtabReceiverComment = "";
    String dtabReceiverCommentTb = "";

    String schemaPlace = "";

    public DtabAttributes(String dtabInvisible, String dtabArchiveSignatory, String dtabCommentPlace,
                          JSONArray dtabSenderTb, String dtabSenderComment,
                          String dtabCommentAboutTypesOfDocumentTb, JSONArray dtabSealId,
                          String dtabDateDescriptionId, String dtabArchiveId,
                          String dtabCommentAboutTypesOfDocument, String dtabDateId,
                          JSONArray dtabSealDocID, String dcTitle, String dtabDescriptionDate,
                          String schemaComment, JSONArray dtabSealNameOfScript,
                          JSONArray dtabSealCommentUsedScripts, String id, String schemaText,
                          String dtabUsedScripts, String dtabTranscriptionFiles, String dtabSenderCommentTb, String dtabGpos,
                          JSONArray dtabSealColor, String dtabNameOfArchive, String dtabScriptIdRole,
                          JSONArray dtabSenderId, JSONArray dtabSealSize, JSONArray dtabSealForm, String dtabRecipientTb,
                          String dcDtate, JSONArray dtabScript, JSONArray dtabSender, JSONArray dtabPreviewImageFiles,
                          String dtabGroupno, String dtabIdInArchive, String schemaName, String schemaRecipient,
                          String dtabHtmlFiles, String dtabDocumentId, String dtabCommentPlaceTb, String dtabSeal,
                          String dtabPlaceId, String dtabPlaceOfIssueId, String dtabTerminology, String dtabOtherFiles,
                          String dtabProverbs, String dtabSenderRoleComment, JSONArray dtabReceiverId, JSONArray dtabReceiver,
                          JSONArray dtabReceiverTb, String dtabReceiverComment, String dtabReceiverCommentTb, String schemaPlace) {
        this.dtabInvisible = dtabInvisible;
        this.dtabArchiveSignatory = dtabArchiveSignatory;
        this.dtabCommentPlace = dtabCommentPlace;
        this.dtabSenderTb = dtabSenderTb;
        this.dtabSenderComment = dtabSenderComment;
        this.dtabCommentAboutTypesOfDocumentTb = dtabCommentAboutTypesOfDocumentTb;
        this.dtabSealId = dtabSealId;
        this.dtabDateDescriptionId = dtabDateDescriptionId;
        this.dtabArchiveId = dtabArchiveId;
        this.dtabCommentAboutTypesOfDocument = dtabCommentAboutTypesOfDocument;
        this.dtabDateId = dtabDateId;
        this.dtabSealDocID = dtabSealDocID;
        this.dcTitle = dcTitle;
        this.dtabDescriptionDate = dtabDescriptionDate;
        this.schemaComment = schemaComment;
        this.dtabSealNameOfScript = dtabSealNameOfScript;
        this.dtabSealCommentUsedScripts = dtabSealCommentUsedScripts;
        this.id = id;
        this.schemaText = schemaText;
        this.dtabUsedScripts = dtabUsedScripts;
        this.dtabTranscriptionFiles = dtabTranscriptionFiles;
        this.dtabSenderCommentTb = dtabSenderCommentTb;
        this.dtabGpos = dtabGpos;
        this.dtabSealColor = dtabSealColor;
        this.dtabNameOfArchive = dtabNameOfArchive;
        this.dtabScriptIdRole = dtabScriptIdRole;
        this.dtabSenderId = dtabSenderId;
        this.dtabSealSize = dtabSealSize;
        this.dtabSealForm = dtabSealForm;
        this.dtabRecipientTb = dtabRecipientTb;
        this.dcDtate = dcDtate;
        this.dtabScript = dtabScript;
        this.dtabSender = dtabSender;
        this.dtabPreviewImageFiles = dtabPreviewImageFiles;
        this.dtabGroupno = dtabGroupno;
        this.dtabIdInArchive = dtabIdInArchive;
        this.schemaName = schemaName;
        this.schemaRecipient = schemaRecipient;
        this.dtabHtmlFiles = dtabHtmlFiles;
        this.dtabDocumentId = dtabDocumentId;
        this.dtabCommentPlaceTb = dtabCommentPlaceTb;
        this.dtabSeal = dtabSeal;
        this.dtabPlaceId = dtabPlaceId;
        this.dtabPlaceOfIssueId = dtabPlaceOfIssueId;
        this.dtabTerminology = dtabTerminology;
        this.dtabOtherFiles = dtabOtherFiles;
        this.dtabProverbs = dtabProverbs;
        this.dtabSenderRoleComment = dtabSenderRoleComment;
        this.dtabReceiverId = dtabReceiverId;
        this.dtabReceiver = dtabReceiver;
        this.dtabReceiverTb = dtabReceiverTb;
        this.dtabReceiverComment = dtabReceiverComment;
        this.dtabReceiverCommentTb = dtabReceiverCommentTb;
        this.schemaPlace = schemaPlace;
    }

    public DtabAttributes() {

    }

    public String getDtabInvisible() {
        return dtabInvisible;
    }

    public void setDtabInvisible(String dtabInvisible) {
        this.dtabInvisible = dtabInvisible;
    }

    public String getDtabArchiveSignatory() {
        return dtabArchiveSignatory;
    }

    public void setDtabArchiveSignatory(String dtabArchiveSignatory) {
        this.dtabArchiveSignatory = dtabArchiveSignatory;
    }

    public String getDtabCommentPlace() {
        return dtabCommentPlace;
    }

    public void setDtabCommentPlace(String dtabCommentPlace) {
        this.dtabCommentPlace = dtabCommentPlace;
    }

    public JSONArray getDtabSenderTb() {
        return dtabSenderTb;
    }

    public void setDtabSenderTb(JSONArray dtabSenderTb) {
        this.dtabSenderTb = dtabSenderTb;
    }

    public String getDtabSenderComment() {
        return dtabSenderComment;
    }

    public void setDtabSenderComment(String dtabSenderComment) {
        this.dtabSenderComment = dtabSenderComment;
    }

    public String getDtabCommentAboutTypesOfDocumentTb() {
        return dtabCommentAboutTypesOfDocumentTb;
    }

    public void setDtabCommentAboutTypesOfDocumentTb(String dtabCommentAboutTypesOfDocumentTb) {
        this.dtabCommentAboutTypesOfDocumentTb = dtabCommentAboutTypesOfDocumentTb;
    }

    public JSONArray getDtabSealId() {
        return dtabSealId;
    }

    public void setDtabSealId(JSONArray dtabSealId) {
        this.dtabSealId = dtabSealId;
    }

    public String getDtabDateDescriptionId() {
        return dtabDateDescriptionId;
    }

    public void setDtabDateDescriptionId(String dtabDateDescriptionId) {
        this.dtabDateDescriptionId = dtabDateDescriptionId;
    }

    public String getDtabArchiveId() {
        return dtabArchiveId;
    }

    public void setDtabArchiveId(String dtabArchiveId) {
        this.dtabArchiveId = dtabArchiveId;
    }

    public String getDtabCommentAboutTypesOfDocument() {
        return dtabCommentAboutTypesOfDocument;
    }

    public void setDtabCommentAboutTypesOfDocument(String dtabCommentAboutTypesOfDocument) {
        this.dtabCommentAboutTypesOfDocument = dtabCommentAboutTypesOfDocument;
    }

    public String getDtabDateId() {
        return dtabDateId;
    }

    public void setDtabDateId(String dtabDateId) {
        this.dtabDateId = dtabDateId;
    }

    public JSONArray getDtabSealDocID() {
        return dtabSealDocID;
    }

    public void setDtabSealDocID(JSONArray dtabSealDocID) {
        this.dtabSealDocID = dtabSealDocID;
    }

    public String getDcTitle() {
        return dcTitle;
    }

    public void setDcTitle(String dcTitle) {
        this.dcTitle = dcTitle;
    }

    public String getDtabDescriptionDate() {
        return dtabDescriptionDate;
    }

    public void setDtabDescriptionDate(String dtabDescriptionDate) {
        this.dtabDescriptionDate = dtabDescriptionDate;
    }

    public String getSchemaComment() {
        return schemaComment;
    }

    public void setSchemaComment(String schemaComment) {
        this.schemaComment = schemaComment;
    }

    public JSONArray getDtabSealNameOfScript() {
        return dtabSealNameOfScript;
    }

    public void setDtabSealNameOfScript(JSONArray dtabSealNameOfScript) {
        this.dtabSealNameOfScript = dtabSealNameOfScript;
    }

    public JSONArray getDtabSealCommentUsedScripts() {
        return dtabSealCommentUsedScripts;
    }

    public void setDtabSealCommentUsedScripts(JSONArray dtabSealCommentUsedScripts) {
        this.dtabSealCommentUsedScripts = dtabSealCommentUsedScripts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchemaText() {
        return schemaText;
    }

    public void setSchemaText(String schemaText) {
        this.schemaText = schemaText;
    }

    public String getDtabUsedScripts() {
        return dtabUsedScripts;
    }

    public void setDtabUsedScripts(String dtabUsedScripts) {
        this.dtabUsedScripts = dtabUsedScripts;
    }

    public String getDtabTranscriptionFiles() {
        return dtabTranscriptionFiles;
    }

    public void setDtabTranscriptionFiles(String dtabTranscriptionFiles) {
        this.dtabTranscriptionFiles = dtabTranscriptionFiles;
    }

    public String getDtabSenderCommentTb() {
        return dtabSenderCommentTb;
    }

    public void setDtabSenderCommentTb(String dtabSenderCommentTb) {
        this.dtabSenderCommentTb = dtabSenderCommentTb;
    }

    public String getDtabGpos() {
        return dtabGpos;
    }

    public void setDtabGpos(String dtabGpos) {
        this.dtabGpos = dtabGpos;
    }

    public JSONArray getDtabSealColor() {
        return dtabSealColor;
    }

    public void setDtabSealColor(JSONArray dtabSealColor) {
        this.dtabSealColor = dtabSealColor;
    }

    public String getDtabNameOfArchive() {
        return dtabNameOfArchive;
    }

    public void setDtabNameOfArchive(String dtabNameOfArchive) {
        this.dtabNameOfArchive = dtabNameOfArchive;
    }

    public String getDtabScriptIdRole() {
        return dtabScriptIdRole;
    }

    public void setDtabScriptIdRole(String dtabScriptIdRole) {
        this.dtabScriptIdRole = dtabScriptIdRole;
    }

    public JSONArray getDtabSenderId() {
        return dtabSenderId;
    }

    public void setDtabSenderId(JSONArray dtabSenderId) {
        this.dtabSenderId = dtabSenderId;
    }

    public JSONArray getDtabSealSize() {
        return dtabSealSize;
    }

    public void setDtabSealSize(JSONArray dtabSealSize) {
        this.dtabSealSize = dtabSealSize;
    }

    public JSONArray getDtabSealForm() {
        return dtabSealForm;
    }

    public void setDtabSealForm(JSONArray dtabSealForm) {
        this.dtabSealForm = dtabSealForm;
    }

    public String getDtabRecipientTb() {
        return dtabRecipientTb;
    }

    public void setDtabRecipientTb(String dtabRecipientTb) {
        this.dtabRecipientTb = dtabRecipientTb;
    }

    public String getDcDtate() {
        return dcDtate;
    }

    public void setDcDtate(String dcDtate) {
        this.dcDtate = dcDtate;
    }

    public JSONArray getDtabScript() {
        return dtabScript;
    }

    public void setDtabScript(JSONArray dtabScript) {
        this.dtabScript = dtabScript;
    }

    public JSONArray getDtabSender() {
        return dtabSender;
    }

    public void setDtabSender(JSONArray dtabSender) {
        this.dtabSender = dtabSender;
    }

    public JSONArray getDtabPreviewImageFiles() {
        return dtabPreviewImageFiles;
    }

    public void setDtabPreviewImageFiles(JSONArray dtabPreviewImageFiles) {
        this.dtabPreviewImageFiles = dtabPreviewImageFiles;
    }

    public String getDtabGroupno() {
        return dtabGroupno;
    }

    public void setDtabGroupno(String dtabGroupno) {
        this.dtabGroupno = dtabGroupno;
    }

    public String getDtabIdInArchive() {
        return dtabIdInArchive;
    }

    public void setDtabIdInArchive(String dtabIdInArchive) {
        this.dtabIdInArchive = dtabIdInArchive;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getSchemaRecipient() {
        return schemaRecipient;
    }

    public void setSchemaRecipient(String schemaRecipient) {
        this.schemaRecipient = schemaRecipient;
    }

    public String getDtabHtmlFiles() {
        return dtabHtmlFiles;
    }

    public void setDtabHtmlFiles(String dtabHtmlFiles) {
        this.dtabHtmlFiles = dtabHtmlFiles;
    }

    public String getDtabDocumentId() {
        return dtabDocumentId;
    }

    public void setDtabDocumentId(String dtabDocumentId) {
        this.dtabDocumentId = dtabDocumentId;
    }

    public String getDtabCommentPlaceTb() {
        return dtabCommentPlaceTb;
    }

    public void setDtabCommentPlaceTb(String dtabCommentPlaceTb) {
        this.dtabCommentPlaceTb = dtabCommentPlaceTb;
    }

    public String getDtabSeal() {
        return dtabSeal;
    }

    public void setDtabSeal(String dtabSeal) {
        this.dtabSeal = dtabSeal;
    }

    public String getDtabPlaceId() {
        return dtabPlaceId;
    }

    public void setDtabPlaceId(String dtabPlaceId) {
        this.dtabPlaceId = dtabPlaceId;
    }

    public String getDtabPlaceOfIssueId() {
        return dtabPlaceOfIssueId;
    }

    public void setDtabPlaceOfIssueId(String dtabPlaceOfIssueId) {
        this.dtabPlaceOfIssueId = dtabPlaceOfIssueId;
    }

    public String getDtabTerminology() {
        return dtabTerminology;
    }

    public void setDtabTerminology(String dtabTerminology) {
        this.dtabTerminology = dtabTerminology;
    }

    public String getDtabOtherFiles() {
        return dtabOtherFiles;
    }

    public void setDtabOtherFiles(String dtabOtherFiles) {
        this.dtabOtherFiles = dtabOtherFiles;
    }

    public String getDtabProverbs() {
        return dtabProverbs;
    }

    public void setDtabProverbs(String dtabProverbs) {
        this.dtabProverbs = dtabProverbs;
    }

    public String getDtabSenderRoleComment() {
        return dtabSenderRoleComment;
    }

    public void setDtabSenderRoleComment(String dtabSenderRoleComment) {
        this.dtabSenderRoleComment = dtabSenderRoleComment;
    }

    public JSONArray getDtabReceiverId() {
        return dtabReceiverId;
    }

    public void setDtabReceiverId(JSONArray dtabReceiverId) {
        this.dtabReceiverId = dtabReceiverId;
    }

    public JSONArray getDtabReceiver() {
        return dtabReceiver;
    }

    public void setDtabReceiver(JSONArray dtabReceiver) {
        this.dtabReceiver = dtabReceiver;
    }

    public JSONArray getDtabReceiverTb() {
        return dtabReceiverTb;
    }

    public void setDtabReceiverTb(JSONArray dtabReceiverTb) {
        this.dtabReceiverTb = dtabReceiverTb;
    }

    public String getDtabReceiverComment() {
        return dtabReceiverComment;
    }

    public void setDtabReceiverComment(String dtabReceiverComment) {
        this.dtabReceiverComment = dtabReceiverComment;
    }

    public String getDtabReceiverCommentTb() {
        return dtabReceiverCommentTb;
    }

    public void setDtabReceiverCommentTb(String dtabReceiverCommentTb) {
        this.dtabReceiverCommentTb = dtabReceiverCommentTb;
    }

    public String getSchemaPlace() {
        return schemaPlace;
    }

    public void setSchemaPlace(String schemaPlace) {
        this.schemaPlace = schemaPlace;
    }
}
