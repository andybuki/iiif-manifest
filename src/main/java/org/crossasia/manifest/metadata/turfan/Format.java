package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class Format {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata = null;

        if(turfanAttributes.getFormat()!=null) {
            metadata = new Metadata(new Label( "de","dcterms:format"),
                    new Value( new I18n("de", turfanAttributes.getFormat())));
            return metadata;
        }
        else {
            metadata = null;
            return metadata;
        }
    }
}
