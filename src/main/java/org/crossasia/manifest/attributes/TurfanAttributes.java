package org.crossasia.manifest.attributes;

import org.crossasia.manifest.attributes.base.BaseCollectionAttributes;

import java.util.List;

public class TurfanAttributes extends BaseCollectionAttributes {
    private String date;
    private List<String> subjects;
    private List<String> places;
    private List<String> indexes;
    private String keyword;
    private String label;

    public TurfanAttributes() {
        super();
    }

    // Getters and setters
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public List<String> getSubjects() { return subjects; }
    public void setSubjects(List<String> subjects) { this.subjects = subjects; }

    public List<String> getPlaces() { return places; }
    public void setPlaces(List<String> places) { this.places = places; }

    public List<String> getIndexes() { return indexes; }
    public void setIndexes(List<String> indexes) { this.indexes = indexes; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
}