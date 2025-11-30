package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.*;
import org.crossasia.manifest.statics.collection.CollectionConfig;

import java.net.URI;

import static info.freelibrary.iiif.presentation.v3.properties.ViewingDirection.LEFT_TO_RIGHT;

/**
 * Adds static fields to manifests.
 * Uses CollectionConfig for all collection-specific values.
 *
 * Replaces hardcoded values from:
 * - org.crossasia.manifest.metadata.fields.Contexts
 * - org.crossasia.manifest.metadata.fields.Homepage
 * - org.crossasia.manifest.metadata.fields.Id
 * - org.crossasia.manifest.metadata.fields.PartOf
 * - org.crossasia.manifest.metadata.fields.Provider
 * - org.crossasia.manifest.metadata.fields.RequiredStatement
 * - org.crossasia.manifest.metadata.fields.Rights
 * - org.crossasia.manifest.metadata.fields.SummaryData
 */
public class StaticFields {

    /**
     * Add static fields to manifest using CollectionConfig.
     * This is the preferred method.
     *
     * @param id       Document ID
     * @param manifest The manifest to populate
     * @param title    Document title
     * @param config   Collection configuration
     */
    public static void staticFields(String id, Manifest manifest, String title, CollectionConfig config) {
        // Summary from collection config
        Summary summary = new Summary(config.getSummary());

        // Required statement from collection config
        RequiredStatement reqStmt = new RequiredStatement(
                new Label(config.getLanguage(), CollectionConfig.REQUIRED_STATEMENT_LABEL),
                new Value(new I18n(config.getLanguage(), config.getRequiredStatement()))
        );

        // Provider (shared across all collections)
        Provider provider = new Provider(
                CollectionConfig.PROVIDER_WEBSITE,
                CollectionConfig.PROVIDER_NAME
        );

        // Apply to manifest
        manifest.addContexts(CollectionConfig.CONTEXT);
        manifest.setViewingDirection(LEFT_TO_RIGHT);
        manifest.setRights(CollectionConfig.RIGHTS);

        manifest.setHomepages(new Homepage(
                URI.create(CollectionConfig.HOMEPAGE),
                new Label("en", CollectionConfig.HOMEPAGE_DESCRIPTION)
        ));

        // Build manifest ID using collection name
        manifest.setID(CollectionConfig.FEDORA + config.getCollectionName() + "/" + id + "/manifest");

        manifest.setSummary(summary);

        // PartOf from collection config
        manifest.setPartOfs(new PartOf(config.getPartOf(), "Collection"));

        manifest.setRequiredStatement(reqStmt);
        manifest.setProviders(provider);
    }

    /**
     * Add static fields with archive signatory (for collections like DTAB).
     *
     * @param id               Document ID
     * @param manifest         The manifest to populate
     * @param title            Document title
     * @param archiveSignatory Archive signatory info
     * @param config           Collection configuration
     */
    public static void staticFields(String id, Manifest manifest, String title,
                                    String archiveSignatory, CollectionConfig config) {
        // Summary with archive signatory appended
        Summary summary = new Summary(config.getSummary() + ": " + archiveSignatory);

        // Required statement from collection config
        RequiredStatement reqStmt = new RequiredStatement(
                new Label(config.getLanguage(), CollectionConfig.REQUIRED_STATEMENT_LABEL),
                new Value(new I18n(config.getLanguage(), config.getRequiredStatement()))
        );

        // Provider (shared across all collections)
        Provider provider = new Provider(
                CollectionConfig.PROVIDER_WEBSITE,
                CollectionConfig.PROVIDER_NAME
        );

        // Apply to manifest
        manifest.addContexts(CollectionConfig.CONTEXT);
        manifest.setViewingDirection(LEFT_TO_RIGHT);
        manifest.setRights(CollectionConfig.RIGHTS);

        manifest.setHomepages(new Homepage(
                URI.create(CollectionConfig.HOMEPAGE),
                new Label("en", CollectionConfig.HOMEPAGE_DESCRIPTION)
        ));

        // Build manifest ID using collection name
        manifest.setID(CollectionConfig.FEDORA + config.getCollectionName() + "/" + id + "/manifest");

        manifest.setSummary(summary);

        // PartOf from collection config
        manifest.setPartOfs(new PartOf(config.getPartOf(), "Collection"));

        manifest.setRequiredStatement(reqStmt);
        manifest.setProviders(provider);
    }

    // ========== Legacy methods for backward compatibility ==========

    /**
     * @deprecated Use {@link #staticFields(String, Manifest, String, CollectionConfig)} instead.
     * Defaults to KAHLEN collection for backward compatibility.
     */
    @Deprecated
    public static void staticFields(String id, Manifest manifest, String title) {
        staticFields(id, manifest, title, CollectionConfig.KAHLEN);
    }

    /**
     * @deprecated Use {@link #staticFields(String, Manifest, String, String, CollectionConfig)} instead.
     * Defaults to DTAB collection for backward compatibility.
     */
    @Deprecated
    public static void staticFields(String id, Manifest manifest, String title, String archiveSignatory) {
        staticFields(id, manifest, title, archiveSignatory, CollectionConfig.DTAB);
    }
}