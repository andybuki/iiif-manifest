package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class LocationTypes {

    public static Metadata getMetadataLocationTypesName(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "location_type")),
                new Value(new I18n("en",dllmAttributes.getLocation_types_name()),
                        new I18n("lo", dllmAttributes.getLocation_types_name_lao())));
    }
}
