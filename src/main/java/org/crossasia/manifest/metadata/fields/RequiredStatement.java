package org.crossasia.manifest.metadata.fields;

import org.crossasia.manifest.statics.collection.CollectionConfig;

/**
 * @deprecated Use {@link CollectionConfig#getRequiredStatement()} and
 *             {@link CollectionConfig#REQUIRED_STATEMENT_LABEL} instead.
 *
 * Note: Required statement is now collection-specific in CollectionConfig.
 * The old REQUIRED constant defaulted to Kahlen's required statement.
 */
@Deprecated
public class RequiredStatement {
    public static final String REQUIRED = CollectionConfig.KAHLEN.getRequiredStatement();
    public static final String INFO = CollectionConfig.REQUIRED_STATEMENT_LABEL;
}