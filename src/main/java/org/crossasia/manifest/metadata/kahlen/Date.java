package org.crossasia.manifest.metadata.kahlen;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.KahlenAttributes;

public class Date {
    public static Metadata get(KahlenAttributes kahlenAttributes, Manifest manifest) {
        Metadata metadata = null;
        if(kahlenAttributes.getDate()!="") {
            metadata = new Metadata(new Label( "en","dcterms:date"),
                    new Value( new I18n("en", kahlenAttributes.getDate())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
