package org.crossasia.manifest.canvas;

import org.crossasia.manifest.canvas.model.PageData;
import org.crossasia.manifest.statics.collection.CollectionConfig;

/**
 * Kahlen-specific canvas creator.
 *
 * Kahlen collection has a unique behavior: it always uses position "1"
 * for fetching image dimensions, regardless of the actual page position.
 */
public class KahlenCanvasCreator extends CanvasCreator {

    public KahlenCanvasCreator() {
        super(CollectionConfig.KAHLEN);
    }

    /**
     * Kahlen always uses position "1" for dimensions
     */
    @Override
    protected String getPositionForDimensions(PageData pageData, int pageIndex) {
        return "1";
    }
}