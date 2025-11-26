package org.crossasia.manifest.attributes.domain;

import java.util.List;

public class PlaceInfo {
    private String place;
    private List<String> places;
    private String placeDetail;
    private String placeDetail2;
    private String placeId;
    private String placeOfIssueId;
    private String commentPlace;

    // Administrative levels
    private String adminLevel1;
    private String adminLevel2;
    private String placeType2;
    private String placeType3;

    private List<String> geographicReferences;

    public PlaceInfo() {}

    // Getters and setters
    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public List<String> getPlaces() { return places; }
    public void setPlaces(List<String> places) { this.places = places; }

    public String getPlaceDetail() { return placeDetail; }
    public void setPlaceDetail(String placeDetail) { this.placeDetail = placeDetail; }

    public String getPlaceDetail2() { return placeDetail2; }
    public void setPlaceDetail2(String placeDetail2) { this.placeDetail2 = placeDetail2; }

    public String getPlaceId() { return placeId; }
    public void setPlaceId(String placeId) { this.placeId = placeId; }

    public String getPlaceOfIssueId() { return placeOfIssueId; }
    public void setPlaceOfIssueId(String placeOfIssueId) { this.placeOfIssueId = placeOfIssueId; }

    public String getCommentPlace() { return commentPlace; }
    public void setCommentPlace(String commentPlace) { this.commentPlace = commentPlace; }

    public String getAdminLevel1() { return adminLevel1; }
    public void setAdminLevel1(String adminLevel1) { this.adminLevel1 = adminLevel1; }

    public String getAdminLevel2() { return adminLevel2; }
    public void setAdminLevel2(String adminLevel2) { this.adminLevel2 = adminLevel2; }

    public String getPlaceType2() { return placeType2; }
    public void setPlaceType2(String placeType2) { this.placeType2 = placeType2; }

    public String getPlaceType3() { return placeType3; }
    public void setPlaceType3(String placeType3) { this.placeType3 = placeType3; }

    public List<String> getGeographicReferences() { return geographicReferences; }
    public void setGeographicReferences(List<String> geographicReferences) {
        this.geographicReferences = geographicReferences;
    }
}