package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class IsComplete {

    public static Metadata getMetadataIsComplete(DllmAttributes dllmAttributes) {

        Metadata metadata_is_complete = null;

        if(dllmAttributes.getDocuments_is_complete()!=null) {
            metadata_is_complete = new Metadata(new Label( "is_complete"),
                    new Value(dllmAttributes.getDocuments_is_complete()));
            return metadata_is_complete;
        }
        else return metadata_is_complete;



    }
}
