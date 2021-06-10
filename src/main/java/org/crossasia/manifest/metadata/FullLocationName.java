package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class FullLocationName {
    @NotNull
    public static Metadata getMetadataFullLocationName(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "full_location_name")),
                new Value(new I18n("en",dllmAttributes.getFull_location_name()),
                        new I18n("lo", dllmAttributes.getFull_location_name_lao())));
    }
}
