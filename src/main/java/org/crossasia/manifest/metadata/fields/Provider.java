package org.crossasia.manifest.metadata.fields;

import org.crossasia.manifest.statics.collection.CollectionConfig;

/**
 * @deprecated Use {@link CollectionConfig#PROVIDER_WEBSITE} and {@link CollectionConfig#PROVIDER_NAME} instead.
 */
@Deprecated
public class Provider {
    public static final String WEBSITE = CollectionConfig.PROVIDER_WEBSITE;
    public static final String PROVIDER = CollectionConfig.PROVIDER_NAME;
}