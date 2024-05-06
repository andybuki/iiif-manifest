package org.crossasia.manifest.statics.collection;

public enum Url {

    TURFAN("https://itr02.crossasia.org/fcrepo/rest/turfan/collection"),
    SUGAWARA("https://itr02.crossasia.org/fcrepo/rest/xinjiang-legaldocuments/collection"),
    DTAB("https://itr02.crossasia.org/fcrepo/rest/dtab/collection");
    private String value;
    Url(String value) {
        this.value = value;
    }

    public String getVal() {
        return value;
    }
}
