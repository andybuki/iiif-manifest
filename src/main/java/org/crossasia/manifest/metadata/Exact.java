package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class Exact {
    public static Metadata getMetadataExact(CollectionAttributes dllmAttributes) {

        Metadata metadata_exact = null;

        if(dllmAttributes.getExact()) {
            metadata_exact = new Metadata(new Label( "exact_coordinates"),
                    new Value(String.valueOf(dllmAttributes.getExact())));
            return metadata_exact;
        }
        else return metadata_exact;

    }
}
