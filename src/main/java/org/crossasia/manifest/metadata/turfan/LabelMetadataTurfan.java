package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class LabelMetadataTurfan {
    public static I18n getLabelTitle(CollectionAttributes turfanAttributes) {
        I18n i18n_title = new I18n("de",  turfanAttributes.getTitle());
        //I18n i18n_title = new I18n("de",  turfanAttributes.getIdentifier()+": "+turfanAttributes.getTitle());
        return i18n_title;
    }
}
