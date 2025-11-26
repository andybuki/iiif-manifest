package org.crossasia.manifest.canvas.model;

import org.json.JSONArray;

public class PageData {
    private String id;
    private String name;
    private String position;
    private String dcIdentifier;
    private String title;
    private String description;
    private String place;
    private String collection;
    private String date;
    private String year;
    private String keyword;
    private String source;
    private String comment;
    private String noteDate;
    private String placeDetail;
    private String schemaIdentifier;
    private String turfanNumberPage;
    private String sender;
    private String recipient;
    private String person;
    private String spatial;
    private String index;
    private String medium;
    private String subject;
    private String dcndlNumber;
    private String image;
    private String alben;

    // Arrays
    private JSONArray personArray;
    private JSONArray spatialArray;
    private JSONArray indexArray;
    private JSONArray mediumArray;
    private JSONArray subjectArray;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getDcIdentifier() { return dcIdentifier; }
    public void setDcIdentifier(String dcIdentifier) { this.dcIdentifier = dcIdentifier; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public String getCollection() { return collection; }
    public void setCollection(String collection) { this.collection = collection; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public String getNoteDate() { return noteDate; }
    public void setNoteDate(String noteDate) { this.noteDate = noteDate; }

    public String getPlaceDetail() { return placeDetail; }
    public void setPlaceDetail(String placeDetail) { this.placeDetail = placeDetail; }

    public String getSchemaIdentifier() { return schemaIdentifier; }
    public void setSchemaIdentifier(String schemaIdentifier) { this.schemaIdentifier = schemaIdentifier; }

    public String getTurfanNumberPage() { return turfanNumberPage; }
    public void setTurfanNumberPage(String turfanNumberPage) { this.turfanNumberPage = turfanNumberPage; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }

    public String getPerson() { return person; }
    public void setPerson(String person) { this.person = person; }

    public String getSpatial() { return spatial; }
    public void setSpatial(String spatial) { this.spatial = spatial; }

    public String getIndex() { return index; }
    public void setIndex(String index) { this.index = index; }

    public String getMedium() { return medium; }
    public void setMedium(String medium) { this.medium = medium; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getDcndlNumber() { return dcndlNumber; }
    public void setDcndlNumber(String dcndlNumber) { this.dcndlNumber = dcndlNumber; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getAlben() { return alben; }
    public void setAlben(String alben) { this.alben = alben; }

    public JSONArray getPersonArray() { return personArray; }
    public void setPersonArray(JSONArray personArray) { this.personArray = personArray; }

    public JSONArray getSpatialArray() { return spatialArray; }
    public void setSpatialArray(JSONArray spatialArray) { this.spatialArray = spatialArray; }

    public JSONArray getIndexArray() { return indexArray; }
    public void setIndexArray(JSONArray indexArray) { this.indexArray = indexArray; }

    public JSONArray getMediumArray() { return mediumArray; }
    public void setMediumArray(JSONArray mediumArray) { this.mediumArray = mediumArray; }

    public JSONArray getSubjectArray() { return subjectArray; }
    public void setSubjectArray(JSONArray subjectArray) { this.subjectArray = subjectArray; }
}
