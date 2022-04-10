package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class Position {

    public static Metadata getMetadataPosition(CollectionAttributes dllmAttributes) {

        Metadata metadata_position = null;

        if(dllmAttributes.getPosition()!=0) {
            metadata_position = new Metadata(new Label( "schema:position"),
                    new Value(String.valueOf(dllmAttributes.getPosition())));
            return metadata_position;
        }
        else return metadata_position;
    }
}
