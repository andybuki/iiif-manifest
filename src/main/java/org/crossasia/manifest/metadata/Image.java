package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class Image {

    public static Metadata getMetadataImage(CollectionAttributes dllmAttributes) {
        Metadata metadata_image = null;

        if(dllmAttributes.getImage()!=null) {
            metadata_image = new Metadata(new Label( "schema:image"),
                    new Value(dllmAttributes.getImage()));
            return metadata_image;
        }
        else return metadata_image;

    }
}
