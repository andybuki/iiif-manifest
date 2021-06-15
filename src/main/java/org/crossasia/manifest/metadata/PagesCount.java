package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class PagesCount {

    public static Metadata getMetadataPagesCount(DllmAttributes dllmAttributes) {
        Metadata metadata_pages_count= null;

        if(dllmAttributes.getDocuments_pages_count()!=0) {
            metadata_pages_count = new Metadata(new Label("pages_count"),
                    new Value(String.valueOf((dllmAttributes.getDocuments_pages_count()))));
            return metadata_pages_count;
        }
        else return metadata_pages_count;
    }
}
