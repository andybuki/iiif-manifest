package org.crossasia.manifest.statics.collection;

public enum Data {

    TURFAN("https://itr02.crossasia.org/fcrepo/rest/turfan/akten"),
    SUGAWARA("https://itr02.crossasia.org/fcrepo/rest/xinjiang-legaldocuments"),
    DTAB("https://itr02.crossasia.org/fcrepo/rest/dtab");
    private String value;
    Data(String value) {
        this.value = value;
    }

    public String getVal() {
        return value;
    }
}
