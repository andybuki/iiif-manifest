package org.crossasia.manifest.metadata.fields;

import org.crossasia.manifest.statics.collection.CollectionConfig;

/**
 * @deprecated Use {@link CollectionConfig#getCollectionName()} instead.
 *
 * Example migration:
 *   Before: Coll.kahlen.getVal()
 *   After:  CollectionConfig.KAHLEN.getCollectionName()
 */
@Deprecated
public enum Coll {

    xinjiang_legaldocuments(CollectionConfig.SUGAWARA),
    turfan(CollectionConfig.TURFAN),
    dllm(CollectionConfig.DLLM),
    kahlen(CollectionConfig.KAHLEN),
    dtab(CollectionConfig.DTAB),
    lanna(CollectionConfig.LANNA);

    private final CollectionConfig config;

    Coll(CollectionConfig config) {
        this.config = config;
    }

    public String getVal() {
        return config.getCollectionName();
    }

    /**
     * Get the underlying CollectionConfig
     */
    public CollectionConfig getConfig() {
        return config;
    }
}