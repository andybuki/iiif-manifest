package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class LatLon {
    @NotNull
    public static Metadata getMetadataLatitude(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "schema:latitude")),
                new Value(new I18n("en", String.valueOf(dllmAttributes.getLocations_gps_lat()))));
    }

    @NotNull
    public static Metadata getMetadataLongitude(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "schema:longitude")),
                new Value(new I18n("en", String.valueOf(dllmAttributes.getLocations_gps_lon()))));
    }
}
