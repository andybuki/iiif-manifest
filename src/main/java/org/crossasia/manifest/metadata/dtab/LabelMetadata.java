package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.DtabAttributes;
public class LabelMetadata {

    public static I18n getLabelTitle(DtabAttributes dtabAttributes) {
        String title = dtabAttributes.getTitle();

        if (title == null || title.isEmpty()) {
            title = "Untitled";
        }

        return new I18n("en", title);
    }
}
