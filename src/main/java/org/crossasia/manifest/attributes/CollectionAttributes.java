package org.crossasia.manifest.attributes;

import org.json.JSONArray;

public class CollectionAttributes {

    private String id;
    private String title;
    private JSONArray  date;
    private JSONArray keyword;
    private JSONArray  place;
    private JSONArray seeAlso;
    private JSONArray invnumber;
    private JSONArray collection;
    private String placeDetail;
    private JSONArray dsrLink;
    private JSONArray siteNameGer;
    private JSONArray siteID;
    private String placeDetail2;
    private JSONArray type;
    private JSONArray objId;
    private String identifier;
    private String rechercheLink;
    private String langeBeschreibung;
    private JSONArray georgBezug;
    private String description;
    private JSONArray descriptions;
    private String noteDate;

    private String noteIdentifier;
    private String comment;
    private String creator;
    private String noteCreator;
    private String format;
    private String source;
    private String creditText;

    private JSONArray schemaIdentifier;

    private String requirements;

    public CollectionAttributes(String id, String title, JSONArray date, JSONArray keyword, JSONArray place, JSONArray seeAlso, JSONArray invnumber, JSONArray collection, String placeDetail, JSONArray dsrLink, JSONArray siteNameGer, JSONArray siteID, String placeDetail2, JSONArray type, JSONArray objId, String identifier, String rechercheLink, String langeBeschreibung, JSONArray georgBezug, String description, JSONArray descriptions, String noteDate, String noteIdentifier, String comment, String creator, String noteCreator, String format, String source, String creditText, JSONArray schemaIdentifier, String requirements) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.keyword = keyword;
        this.place = place;
        this.seeAlso = seeAlso;
        this.invnumber = invnumber;
        this.collection = collection;
        this.placeDetail = placeDetail;
        this.dsrLink = dsrLink;
        this.siteNameGer = siteNameGer;
        this.siteID = siteID;
        this.placeDetail2 = placeDetail2;
        this.type = type;
        this.objId = objId;
        this.identifier = identifier;
        this.rechercheLink = rechercheLink;
        this.langeBeschreibung = langeBeschreibung;
        this.georgBezug = georgBezug;
        this.description = description;
        this.descriptions = descriptions;
        this.noteDate = noteDate;
        this.noteIdentifier = noteIdentifier;
        this.comment = comment;
        this.creator = creator;
        this.noteCreator = noteCreator;
        this.format = format;
        this.source = source;
        this.creditText = creditText;
        this.schemaIdentifier = schemaIdentifier;
        this.requirements = requirements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JSONArray getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(JSONArray descriptions) {
        this.descriptions = descriptions;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public JSONArray getSchemaIdentifier() {
        return schemaIdentifier;
    }

    public void setSchemaIdentifier(JSONArray schemaIdentifier) {
        this.schemaIdentifier = schemaIdentifier;
    }

    public String getNoteIdentifier() {
        return noteIdentifier;
    }

    public void setNoteIdentifier(String noteIdentifier) {
        this.noteIdentifier = noteIdentifier;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getNoteCreator() {
        return noteCreator;
    }

    public void setNoteCreator(String noteCreator) {
        this.noteCreator = noteCreator;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreditText() {
        return creditText;
    }

    public void setCreditText(String creditText) {
        this.creditText = creditText;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getRechercheLink() {
        return rechercheLink;
    }

    public void setRechercheLink(String rechercheLink) {
        this.rechercheLink = rechercheLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLangeBeschreibung() {
        return langeBeschreibung;
    }

    public void setLangeBeschreibung(String langeBeschreibung) {
        this.langeBeschreibung = langeBeschreibung;
    }

    public JSONArray getGeorgBezug() {
        return georgBezug;
    }

    public void setGeorgBezug(JSONArray georgBezug) {
        this.georgBezug = georgBezug;
    }


    public CollectionAttributes() {

    }

    public JSONArray getPlace() {
        return place;
    }

    public void setPlace(JSONArray place) {
        this.place = place;
    }

    public JSONArray getSeeAlso() {
        return seeAlso;
    }

    public void setSeeAlso(JSONArray seeAlso) {
        this.seeAlso = seeAlso;
    }

    public JSONArray getInvnumber() {
        return invnumber;
    }

    public void setInvnumber(JSONArray invnumber) {
        this.invnumber = invnumber;
    }

    public JSONArray getCollection() {
        return collection;
    }

    public void setCollection(JSONArray collection) {
        this.collection = collection;
    }

    public String getPlaceDetail() {
        return placeDetail;
    }

    public void setPlaceDetail(String placeDetail) {
        this.placeDetail = placeDetail;
    }

    public JSONArray getDsrLink() {
        return dsrLink;
    }

    public void setDsrLink(JSONArray dsrLink) {
        this.dsrLink = dsrLink;
    }

    public JSONArray getSiteNameGer() {
        return siteNameGer;
    }

    public void setSiteNameGer(JSONArray siteNameGer) {
        this.siteNameGer = siteNameGer;
    }

    public JSONArray getSiteID() {
        return siteID;
    }

    public void setSiteID(JSONArray siteID) {
        this.siteID = siteID;
    }

    public String getPlaceDetail2() {
        return placeDetail2;
    }

    public void setPlaceDetail2(String placeDetail2) {
        this.placeDetail2 = placeDetail2;
    }

    public JSONArray getType() {
        return type;
    }

    public void setType(JSONArray type) {
        this.type = type;
    }

    public JSONArray getObjId() {
        return objId;
    }

    public void setObjId(JSONArray objId) {
        this.objId = objId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JSONArray getDate() {
        return date;
    }

    public void setDate(JSONArray date) {
        this.date = date;
    }

    public JSONArray getKeyword() {
        return keyword;
    }

    public void setKeyword(JSONArray keyword) {
        this.keyword = keyword;
    }


}
