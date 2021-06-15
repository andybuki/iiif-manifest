package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class DocumentsRoll {

    public static Metadata getMetadataDocumentsRoll(DllmAttributes dllmAttributes) {

        Metadata metadata_roll = null;

        if(dllmAttributes.getDocuments_roll()!=null) {
            metadata_roll = new Metadata(new Label( "otherIdentifier.roll"),
                    new Value(dllmAttributes.getDocuments_roll()));
            return metadata_roll;
        }
        else return metadata_roll;

    }
}
