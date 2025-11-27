package org.crossasia.manifest.attributes;

import org.crossasia.manifest.attributes.base.BaseCollectionAttributes;
import org.crossasia.manifest.attributes.domain.*;

public class DtabAttributes extends BaseCollectionAttributes {
    private DateInfo dateInfo;
    private PlaceInfo placeInfo;
    private ArchiveInfo archiveInfo;
    private SealInfo sealInfo;
    private ScriptInfo scriptInfo;
    private FileReferences fileReferences;

    // Document metadata
    private String documentId;
    private String groupNumber;
    private String invisible;
    private String geographicPosition;

    // Communication
    private PersonRole sender;
    private PersonRole receiver;

    // Document type
    private String commentAboutTypesOfDocument;

    // Content
    private String text;
    private String comment;
    private String terminology;
    private String proverbs;

    public DtabAttributes() {
        super();
    }

    // Getters and setters
    public DateInfo getDateInfo() { return dateInfo; }
    public void setDateInfo(DateInfo dateInfo) { this.dateInfo = dateInfo; }

    public PlaceInfo getPlaceInfo() { return placeInfo; }
    public void setPlaceInfo(PlaceInfo placeInfo) { this.placeInfo = placeInfo; }

    public ArchiveInfo getArchiveInfo() { return archiveInfo; }
    public void setArchiveInfo(ArchiveInfo archiveInfo) { this.archiveInfo = archiveInfo; }

    public SealInfo getSealInfo() { return sealInfo; }
    public void setSealInfo(SealInfo sealInfo) { this.sealInfo = sealInfo; }

    public ScriptInfo getScriptInfo() { return scriptInfo; }
    public void setScriptInfo(ScriptInfo scriptInfo) { this.scriptInfo = scriptInfo; }

    public FileReferences getFileReferences() { return fileReferences; }
    public void setFileReferences(FileReferences fileReferences) {
        this.fileReferences = fileReferences;
    }

    public String getDocumentId() { return documentId; }
    public void setDocumentId(String documentId) { this.documentId = documentId; }

    public String getGroupNumber() { return groupNumber; }
    public void setGroupNumber(String groupNumber) { this.groupNumber = groupNumber; }

    public String getInvisible() { return invisible; }
    public void setInvisible(String invisible) { this.invisible = invisible; }

    public String getGeographicPosition() { return geographicPosition; }
    public void setGeographicPosition(String geographicPosition) {
        this.geographicPosition = geographicPosition;
    }

    public PersonRole getSender() { return sender; }
    public void setSender(PersonRole sender) { this.sender = sender; }

    public PersonRole getReceiver() { return receiver; }
    public void setReceiver(PersonRole receiver) { this.receiver = receiver; }

    public String getCommentAboutTypesOfDocument() { return commentAboutTypesOfDocument; }
    public void setCommentAboutTypesOfDocument(String commentAboutTypesOfDocument) {
        this.commentAboutTypesOfDocument = commentAboutTypesOfDocument;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public String getTerminology() { return terminology; }
    public void setTerminology(String terminology) { this.terminology = terminology; }

    public String getProverbs() { return proverbs; }
    public void setProverbs(String proverbs) { this.proverbs = proverbs; }
}