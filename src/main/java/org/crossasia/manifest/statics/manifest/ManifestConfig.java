package org.crossasia.manifest.statics.manifest;

/**
 * Shared manifest configuration used across all collections.
 * For collection-specific settings, see CollectionConfig.
 */
public final class ManifestConfig {

    private ManifestConfig() {
        // Prevent instantiation
    }

    // ========== Server & Paths ==========
    public static final String SERVER = "https://iiif-content.crossasia.org/xasia/";
    public static final String THUMBNAIL_PATH = "/full/150,/0/default.jpg";
    public static final String FULL_IMAGE_PATH = "/full/full/0/default.jpg";

    // ========== Branding ==========
    public static final String LOGO_LINK = "https://crossasia.org/fileadmin/templates/img/xa1.png";

    // ========== Localization ==========
    public static final String DEFAULT_LANGUAGE = "en";

    // ========== Rights & Attribution ==========
    public static final String MANIFEST_RIGHTS = "https://creativecommons.org/licenses/by-nc-sa/4.0/";
    public static final String MANIFEST_REQUIRED_STATEMENT =
            "Images and metadata are made available by the National Library of Laos (CC BY-NC 4.0) via the Staatsbibliothek zu Berlin | CrossAsia";

    // ========== Homepage ==========
    public static final String MANIFEST_HOMEPAGE = "https://iiif.crossasia.org";
    public static final String MANIFEST_HOMEPAGE_LABEL = "Crossasia IIIF collections";

    // ========== URL Builders ==========

    /**
     * Build thumbnail URL for a specific image
     */
    public static String buildThumbnailUrl(String manifestCollection, String id, String position) {
        return SERVER + manifestCollection + id + "+" + position + THUMBNAIL_PATH;
    }

    /**
     * Build full image URL
     */
    public static String buildImageUrl(String manifestCollection, String id, String position) {
        return SERVER + manifestCollection + id + "+" + position + FULL_IMAGE_PATH;
    }

    /**
     * Build info.json URL for IIIF image API
     */
    public static String buildInfoUrl(String baseUrl, String collectionName, String id, String position) {
        return baseUrl + collectionName + "+" + id + "+" + position + "/info.json";
    }
}