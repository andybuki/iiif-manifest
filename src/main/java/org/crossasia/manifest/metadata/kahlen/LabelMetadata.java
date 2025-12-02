package org.crossasia.manifest.metadata.kahlen;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.KahlenAttributes;

public class LabelMetadata {

    public static I18n getLabelTitle(KahlenAttributes kahlenAttributes) {
        String title = kahlenAttributes.getTitle();

        if (title == null || title.isEmpty()) {
            title = "Untitled";
        }

        return new I18n("en", title);
    }
}
