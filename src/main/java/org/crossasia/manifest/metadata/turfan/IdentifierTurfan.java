package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class IdentifierTurfan {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata = null;

        if(turfanAttributes.getIdentifier()!=null) {
            metadata = new Metadata(new Label( "none","dc:identifier"),
                    new Value(  turfanAttributes.getIdentifier()));
            return metadata;
        }
        else {
            metadata = null;
            return metadata;
        }
    }
}
