package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class Website {
    public static Metadata getMetadataWebsite(CollectionAttributes dllmAttributes) {

        Metadata metadata_website = null;

        if(dllmAttributes.getWebsite()!=null) {
            metadata_website = new Metadata(new Label( "schema:website"),
                    new Value(String.valueOf(dllmAttributes.getWebsite().get(0))));
            return metadata_website;
        }
        else return metadata_website;

    }
}
