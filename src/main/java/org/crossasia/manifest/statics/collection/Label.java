package org.crossasia.manifest.statics.collection;

public enum Label {
    TURFAN("Turfan Sammlung - Akten"),
    SUGAWARA("Kashgar Contractual Documents Collection"),
    DTAB("DTAB Collection");
    private String value;
    Label(String value) {
        this.value = value;
    }

    public String getVal() {
        return value;
    }
}
