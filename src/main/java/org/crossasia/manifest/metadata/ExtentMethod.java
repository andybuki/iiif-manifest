package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class ExtentMethod {

    public static Metadata getMetadataExtentMethod(CollectionAttributes dllmAttributes) {

        Metadata metadata_extent = null;

        if(dllmAttributes.getExtent()!=null) {
            metadata_extent = new Metadata(new Label(new I18n("en", "dc:extent")),
                    new Value(new I18n("en",dllmAttributes.getExtent())));
            return metadata_extent;
        }
        else return metadata_extent;

    }
}
