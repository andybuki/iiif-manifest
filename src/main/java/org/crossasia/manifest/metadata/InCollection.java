package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class InCollection {

    public static Metadata getInCollection(CollectionAttributes dllmAttributes) {

        Metadata metadata_in_collection = null;

        if(dllmAttributes.getIn_collection()!=null) {
            metadata_in_collection = new Metadata(new Label( "in_collection"),
                    new Value(dllmAttributes.getIn_collection().toUpperCase()));
            return metadata_in_collection;
        }
        else return metadata_in_collection;
    }
}
