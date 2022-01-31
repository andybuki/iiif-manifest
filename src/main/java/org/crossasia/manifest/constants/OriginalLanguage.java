package org.crossasia.manifest.constants;

public enum OriginalLanguage {
    Thai ("th"),
    Lao ("lo"),
    English("en");

    private String name;

    OriginalLanguage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}




