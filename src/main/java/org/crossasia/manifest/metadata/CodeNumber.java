package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class CodeNumber {

    public static Metadata getMetadataDocumentsCodeNumber(CollectionAttributes dllmAttributes) {

        Metadata metadata_code_number = null;

        if(dllmAttributes.getDocuments_code_number()!=null){
            metadata_code_number = new Metadata(new Label( "otherIdentifier.code_number"),
                    new Value(dllmAttributes.getDocuments_code_number()));
            return metadata_code_number;
        } else if (dllmAttributes.getCode_number()!="") {
            metadata_code_number = new Metadata(new Label( "otherIdentifier.code_number"),
                    new Value(dllmAttributes.getCode_number()));
            return metadata_code_number;
        }
        else return metadata_code_number;
    }
}
