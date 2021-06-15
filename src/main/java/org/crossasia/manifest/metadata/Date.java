package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class Date {

    public static Metadata getMetadataDate(DllmAttributes dllmAttributes) {

        Metadata metadata_date = null;

        if(dllmAttributes.getDocuments_date_written()!=null) {
            metadata_date = new Metadata(new Label( "dc:date"),
                    new Value( dllmAttributes.getDocuments_date_written()));
            return metadata_date;
        }
        else {
            metadata_date = null;
            return metadata_date;
        }
    }
}
