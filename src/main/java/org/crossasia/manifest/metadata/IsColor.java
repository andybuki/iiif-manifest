package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class IsColor {

    public static Metadata getMetadataIsColor(DllmAttributes dllmAttributes) {

        Metadata metadata_is_color = null;

        if(dllmAttributes.getDocuments_is_color()!=null) {
            metadata_is_color = new Metadata(new Label( "is_color"),
                    new Value(dllmAttributes.getDocuments_is_color()));
            return metadata_is_color;
        }
        else return metadata_is_color;

    }
}
