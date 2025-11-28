package org.crossasia.manifest.canvas;

import org.crossasia.manifest.canvas.model.PageData;
import org.crossasia.manifest.statics.collection.CollectionConfig;

/**
 * Kahlen-specific canvas creator.
 *
 * Replaces the old CanvasKahlen.java class.
 *
 * Kahlen collection has unique behaviors:
 * 1. Always uses position "1" for fetching image dimensions (regardless of actual page)
 * 2. Always uses position "1" for thumbnail
 * 3. Uses STRING type for ID extraction
 */
public class KahlenCanvasCreator extends CanvasCreator {

    public KahlenCanvasCreator() {
        super(CollectionConfig.KAHLEN);
    }

    /**
     * Kahlen always uses position "1" for dimensions.
     * This is different from other collections that use the actual page position.
     */
    @Override
    protected String getPositionForDimensions(PageData pageData, int pageIndex) {
        return "1";
    }

    /**
     * Kahlen always uses position "1" for thumbnail.
     */
    @Override
    protected String getThumbnailPosition(String firstPosition) {
        return "1";
    }
}