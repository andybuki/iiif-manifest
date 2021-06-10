package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class ExtentMethod {
    @NotNull
    public static Metadata getMetadataExtentMethod(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "dc:extent")),
                new Value(new I18n("en",dllmAttributes.getExtent())));
    }
}
