package org.crossasia.manifest.metadata.tap;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.KahlenAttributes;
import org.crossasia.manifest.attributes.TapAttributes;

public class LabelMetadata {
    public static I18n getLabelTitle(TapAttributes tapAttributes) {

        I18n i18n_title = new I18n("en",  tapAttributes.getLabel());
        return i18n_title;
    }
}
