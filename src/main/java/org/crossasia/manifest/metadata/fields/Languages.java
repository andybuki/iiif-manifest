package org.crossasia.manifest.metadata.fields;

public enum Languages {
    EN("en"),
    LO("lo"),
    TH("th"),
    TB("bo"),
    DE("de");

    private String value;
    Languages(String value) {
        this.value = value;
    }

    public String getVal() {
        return value;
    }
}
