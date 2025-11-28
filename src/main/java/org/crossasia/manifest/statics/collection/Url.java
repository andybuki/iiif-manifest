package org.crossasia.manifest.statics.collection;

/**
 * @deprecated Use {@link CollectionConfig#getCollectionUrl()} instead.
 *
 * Example migration:
 *   Before: Url.TURFAN.getVal()
 *   After:  CollectionConfig.TURFAN.getCollectionUrl()
 */
@Deprecated
public enum Url {

    TURFAN(CollectionConfig.TURFAN),
    SUGAWARA(CollectionConfig.SUGAWARA),
    KAHLEN(CollectionConfig.KAHLEN),
    DTAB(CollectionConfig.DTAB);

    private final CollectionConfig config;

    Url(CollectionConfig config) {
        this.config = config;
    }

    public String getVal() {
        return config.getCollectionUrl();
    }
}