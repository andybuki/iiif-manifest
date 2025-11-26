package org.crossasia.manifest.metadata.kahlen;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.KahlenAttributes;

public class Identifier {
    public static Metadata get(KahlenAttributes kahlenAttributes, Manifest manifest) {
        Metadata metadata = null;
        if(kahlenAttributes.getIdentifier()!="") {
            metadata = new Metadata(new Label( "en","dc:identifier"),
                    new Value( new I18n("en", kahlenAttributes.getIdentifier())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
