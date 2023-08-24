package org.crossasia.manifest.statics.collection;

public enum Label {
    TURFAN("Turfan Sammlung - Akten"),
    SUGAWARA("Sugawara Collection");
    private String value;
    Label(String value) {
        this.value = value;
    }

    public String getVal() {
        return value;
    }
}
