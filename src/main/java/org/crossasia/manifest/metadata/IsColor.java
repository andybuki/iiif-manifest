package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class IsColor {
    @NotNull
    public static Metadata getMetadataIsColor(DllmAttributes dllmAttributes) {
        return new Metadata(new Label( "is_color"),
                new Value(dllmAttributes.getDocuments_is_color()));

        /*
        *
        * return new Metadata(new Label(new I18n("en", "is_color")),
                new Value(new I18n("en",dllmAttributes.getDocuments_is_color())));
        * */
    }
}
