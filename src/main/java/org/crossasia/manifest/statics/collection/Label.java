package org.crossasia.manifest.statics.collection;

/**
 * @deprecated Use {@link CollectionConfig#getLabel()} instead.
 *
 * Example migration:
 *   Before: Label.TURFAN.getVal()
 *   After:  CollectionConfig.TURFAN.getLabel()
 */
@Deprecated
public enum Label {

    TURFAN(CollectionConfig.TURFAN),
    SUGAWARA(CollectionConfig.SUGAWARA),
    DTAB(CollectionConfig.DTAB);

    private final CollectionConfig config;

    Label(CollectionConfig config) {
        this.config = config;
    }

    public String getVal() {
        return config.getLabel();
    }
}