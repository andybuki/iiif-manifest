package org.crossasia.manifest.metadata.kahlen;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.KahlenAttributes;

public class Keywords {
    public static Metadata get(KahlenAttributes kahlenAttributes, Manifest manifest) {
        Metadata metadata = null;
        if(kahlenAttributes.getKeyword()!="") {
            metadata = new Metadata(new Label( "en","schema:keywords"),
                    new Value( new I18n("en", kahlenAttributes.getKeyword())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
