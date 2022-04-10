package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class DocumentsRoll {

    public static Metadata getMetadataDocumentsRoll(CollectionAttributes dllmAttributes) {

        Metadata metadata_roll = null;

        if(dllmAttributes.getMicrofilm_roll_number()!=null) {
            metadata_roll = new Metadata(new Label( "otherIdentifier.roll"),
                    new Value(dllmAttributes.getMicrofilm_roll_number()));
            return metadata_roll;
        }
        else return metadata_roll;

    }
}
