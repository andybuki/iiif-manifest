package org.crossasia.manifest.presentations;

import info.freelibrary.iiif.presentation.v3.*;

import java.util.ArrayList;

public class AnnotatedPage {
    public static void addAnnotatedPage(Manifest manifest, String canvasID, String annoID, String annoPageID, Canvas canvas, ArrayList<Canvas> canvases, ImageContent imageContent, int pages_position) {
        AnnotationPage<PaintingAnnotation> annoPage;
        PaintingAnnotation anno;
        annoPage = new AnnotationPage<>(annoPageID);
        anno = new PaintingAnnotation(annoID, canvas);
        annoPage.addAnnotations(anno.setBodies(imageContent).setTarget(canvasID));
        canvases.add(canvas.setPaintingPages(annoPage));
        canvas.setLabel("[ "+ pages_position +" ]");
        manifest.setCanvases(canvases);
    }
}
