package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

public class DateId {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        Metadata metadata = null;
        if(dtabAttributes.getDtabDateId()!="") {
            metadata = new Metadata(new Label( "none","dtab:date_id"),
                    new Value( new I18n("none", dtabAttributes.getDtabDateId())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
