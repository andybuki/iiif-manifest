package org.crossasia.manifest.attributes;

import org.json.JSONArray;

public class KahlenAttributes {
    private String id;
    private String identifier;
    private String title;
    private String date;
    private JSONArray subjects;
    private String subject;
    private JSONArray  places;
    private String  place;
    private JSONArray  indexes;
    private String  index;
    private String keyword;
    private String label;

    public KahlenAttributes(String id, String identifier, String title, String date, JSONArray subjects, String subject, JSONArray places, String place, JSONArray indexes, String index, String keyword, String label) {
        this.id = id;
        this.identifier = identifier;
        this.title = title;
        this.date = date;
        this.subjects = subjects;
        this.subject = subject;
        this.places = places;
        this.place = place;
        this.indexes = indexes;
        this.index = index;
        this.keyword = keyword;
        this.label = label;
    }

    public KahlenAttributes() {

    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public JSONArray getSubjects() {
        return subjects;
    }

    public void setSubjects(JSONArray subjects) {
        this.subjects = subjects;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public JSONArray getPlaces() {
        return places;
    }

    public void setPlaces(JSONArray places) {
        this.places = places;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public JSONArray getIndexes() {
        return indexes;
    }

    public void setIndexes(JSONArray indexes) {
        this.indexes = indexes;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
