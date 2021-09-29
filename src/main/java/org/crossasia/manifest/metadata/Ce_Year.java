package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;

public class Ce_Year {

    public static Metadata getMetadataCeYear(DllmAttributes dllmAttributes) {

        Metadata metadata_ce_year = null;

        if(dllmAttributes.getCe_year()!=0) {
            metadata_ce_year = new Metadata(new Label( "dc:date"),
                    new Value(String.valueOf(dllmAttributes.getCe_year())));
            return metadata_ce_year;
        }
        else return metadata_ce_year;
    }
}
