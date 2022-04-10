
package org.crossasia.manifest.constants;

public enum OriginalLanguage    {
    THAI ("th"),
    LAO ("lo"),
    ENGLISH("en");

    private String name;

    OriginalLanguage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}




