package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class RechercheLink {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata = null;

        if(turfanAttributes.getRechercheLink()!=null) {
               metadata = new Metadata(new Label( "none","turfan:smbLink"),
                    new Value( new I18n("none", turfanAttributes.getRechercheLink())));
                return metadata;
        }
        else {
            return metadata;
        }
    }
}
