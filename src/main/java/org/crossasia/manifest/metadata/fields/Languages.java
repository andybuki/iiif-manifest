package org.crossasia.manifest.metadata.fields;

import org.crossasia.manifest.statics.collection.CollectionConfig;

/**
 * @deprecated Use {@link CollectionConfig#getLanguage()} instead for collection-specific language,
 *             or use language codes directly ("en", "de", "lo", etc.)
 */
@Deprecated
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