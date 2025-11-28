package org.crossasia.manifest.statics.collection;

/**
 * @deprecated Use {@link CollectionConfig#getSummary()} instead.
 *
 * Example migration:
 *   Before: Summary.TURFAN.getVal()
 *   After:  CollectionConfig.TURFAN.getSummary()
 */
@Deprecated
public enum Summary {

    TURFAN(CollectionConfig.TURFAN),
    SUGAWARA(CollectionConfig.SUGAWARA),
    DTAB(CollectionConfig.DTAB);

    private final CollectionConfig config;

    Summary(CollectionConfig config) {
        this.config = config;
    }

    public String getVal() {
        return config.getSummary();
    }
}