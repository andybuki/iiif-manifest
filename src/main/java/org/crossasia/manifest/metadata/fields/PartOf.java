package org.crossasia.manifest.metadata.fields;

import org.crossasia.manifest.statics.collection.CollectionConfig;

/**
 * @deprecated Use {@link CollectionConfig#getPartOf()} instead.
 *
 * Note: PartOf is now collection-specific in CollectionConfig.
 * The old PARTOF constant defaulted to Kahlen's partOf URL.
 */
@Deprecated
public class PartOf {
    public static final String PARTOF = CollectionConfig.KAHLEN.getPartOf();
}