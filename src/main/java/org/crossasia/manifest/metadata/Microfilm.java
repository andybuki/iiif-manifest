package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class Microfilm {
    public static Metadata getMetadataMicrofilm(CollectionAttributes dllmAttributes) {
        Metadata metadata_microfilm = null;
        if(dllmAttributes.getMicrofilm_roll_number()!=null) {
            metadata_microfilm = new Metadata(new Label("otherIdentifier.roll"),
                    new Value(dllmAttributes.getMicrofilm_roll_number()));
            return metadata_microfilm;
        }
        else return metadata_microfilm;
    }
}
