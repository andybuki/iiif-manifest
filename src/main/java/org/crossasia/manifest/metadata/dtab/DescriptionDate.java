package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

public class DescriptionDate {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        Metadata metadata = null;
        if(dtabAttributes.getDtabDescriptionDate()!="") {
            metadata = new Metadata(new Label( "none","dtab:description_date"),
                    new Value( new I18n("none", dtabAttributes.getDtabDescriptionDate())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
