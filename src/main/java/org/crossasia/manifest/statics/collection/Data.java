package org.crossasia.manifest.statics.collection;

/**
 * @deprecated Use {@link CollectionConfig#getDataUrl()} instead.
 *
 * Example migration:
 *   Before: Data.TURFAN.getVal()
 *   After:  CollectionConfig.TURFAN.getDataUrl()
 */
@Deprecated
public enum Data {

    TURFAN(CollectionConfig.TURFAN),
    SUGAWARA(CollectionConfig.SUGAWARA),
    DTAB(CollectionConfig.DTAB);

    private final CollectionConfig config;

    Data(CollectionConfig config) {
        this.config = config;
    }

    public String getVal() {
        return config.getDataUrl();
    }
}