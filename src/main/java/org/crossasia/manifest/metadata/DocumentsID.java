package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class DocumentsID {

    public static Metadata getMetadataDocumentsID(CollectionAttributes dllmAttributes) {
        Metadata metadata_id = null;

        if(dllmAttributes.getDocuments_id()!=null) {
            metadata_id = new Metadata(new Label( "dc:identifier"),
                    new Value(dllmAttributes.getDocuments_id()));
            return metadata_id;
        }
        else return metadata_id;

    }
}
