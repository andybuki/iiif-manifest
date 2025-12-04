package org.crossasia.manifest.canvas.builder;

import info.freelibrary.iiif.presentation.v3.AnnotationPage;
import info.freelibrary.iiif.presentation.v3.ImageContent;
import info.freelibrary.iiif.presentation.v3.PaintingAnnotation;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.services.ImageService3;
import org.crossasia.manifest.canvas.metadata.MetadataBuilder;
import org.crossasia.manifest.canvas.model.PageData;
import org.crossasia.manifest.canvas.service.ImageInfoFetcher;

public class CanvasBuilder {

    private final String serverUrl;
    private final String manifestCollection;
    private final String thumbnailPath;

    public CanvasBuilder(String serverUrl, String manifestCollection, String thumbnailPath) {
        this.serverUrl = serverUrl;
        this.manifestCollection = manifestCollection;
        this.thumbnailPath = thumbnailPath;
    }

    /**
     * Builds a complete IIIF Canvas from PageData with custom label.
     *
     * @param id          Document ID
     * @param pageData    Page data
     * @param dimensions  Image dimensions
     * @param canvasLabel Custom label for canvas (e.g., from schema:caption)
     * @return Built canvas
     */
    public info.freelibrary.iiif.presentation.v3.Canvas buildCanvas(
            String id,
            PageData pageData,
            ImageInfoFetcher.ImageDimensions dimensions,
            String canvasLabel) {

        String position = pageData.getPosition();
        String manifestId = serverUrl + manifestCollection + id + "+" + position;
        String canvasId = manifestId + "/canvas";
        String imageId = manifestId + "/full/full/0/default.jpg";
        String annoId = manifestId + "/annotation";
        String annoPageId = manifestId;

        // Create canvas
        info.freelibrary.iiif.presentation.v3.Canvas canvas =
                new info.freelibrary.iiif.presentation.v3.Canvas(canvasId)
                        .setWidthHeight(dimensions.getWidth(), dimensions.getHeight());

        // Set metadata
        canvas.setMetadata(MetadataBuilder.buildMetadata(pageData));

        // Set label - use custom label if provided, otherwise fall back to name-based label
        if (canvasLabel != null && !canvasLabel.isEmpty()) {
            // Use Label with "none" language
            canvas.setLabel(new Label("none", canvasLabel));
        } else {
            setLabelFromName(canvas, pageData.getName());
        }

        // Set thumbnail
        String thumbnailUri = serverUrl + manifestCollection + id + "+" + position + thumbnailPath;
        canvas.setThumbnails(new ImageContent(thumbnailUri));

        // Create image content
        ImageContent imageContent = new ImageContent(imageId)
                .setWidthHeight(dimensions.getWidth(), dimensions.getHeight());

        ImageService3 imageService = new ImageService3(
                ImageService3.Profile.LEVEL_TWO,
                serverUrl + manifestCollection + id + "+" + position
        );
        imageContent.setServices(imageService);

        // Create annotation page
        AnnotationPage<PaintingAnnotation> annoPage = new AnnotationPage<>(annoPageId);
        PaintingAnnotation anno = new PaintingAnnotation(annoId, canvas);
        annoPage.addAnnotations(anno.setBodies(imageContent).setTarget(canvasId));

        canvas.setPaintingPages(annoPage);

        return canvas;
    }

    /**
     * Builds a complete IIIF Canvas from PageData (backward compatible).
     * Uses name-based label.
     */
    public info.freelibrary.iiif.presentation.v3.Canvas buildCanvas(
            String id,
            PageData pageData,
            ImageInfoFetcher.ImageDimensions dimensions) {
        // Call new method with null label to use default name-based behavior
        return buildCanvas(id, pageData, dimensions, null);
    }

    /**
     * Sets label from page name (original behavior).
     */
    private void setLabelFromName(info.freelibrary.iiif.presentation.v3.Canvas canvas, String name) {
        if (name != null && name.contains("/")) {
            String[] nameParts = name.split("/");
            String namePart = nameParts[nameParts.length - 1];
            canvas.setLabel(new Label("none", "canvas: " + namePart.replace(".jpg", "")));
        } else if (name != null) {
            canvas.setLabel(new Label("none", "canvas: " + name.replace(".jpg", "")));
        }
    }
}