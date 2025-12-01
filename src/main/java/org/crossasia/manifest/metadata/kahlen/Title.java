package org.crossasia.manifest.metadata.kahlen;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.KahlenAttributes;
@Deprecated
public class Title {
    public static Metadata get(KahlenAttributes kahlenAttributes, Manifest manifest) {
        Metadata metadata = null;
        if(kahlenAttributes.getTitle()!="") {
            metadata = new Metadata(new Label( "en","dc:title"),
                    new Value( new I18n("en", kahlenAttributes.getTitle())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
