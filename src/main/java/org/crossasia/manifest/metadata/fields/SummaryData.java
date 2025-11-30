package org.crossasia.manifest.metadata.fields;

import org.crossasia.manifest.statics.collection.CollectionConfig;

/**
 * @deprecated Use {@link CollectionConfig#getSummary()} instead.
 *
 * Note: Summary is now collection-specific in CollectionConfig.
 * The old SUMMARY constant defaulted to Kahlen's summary.
 */
@Deprecated
public class SummaryData {
    public static final String SUMMARY = CollectionConfig.KAHLEN.getSummary();
}