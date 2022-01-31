package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class LatLon {

    public static Metadata getMetadataLatitude(DllmAttributes dllmAttributes) {

        Metadata metadata_is_latitude= null;

        if(dllmAttributes.getLocations_gps_lat()!=0) {
            metadata_is_latitude = new Metadata(new Label( "schema:latitude"),
                    new Value(String.valueOf(dllmAttributes.getLocations_gps_lat())));
            return metadata_is_latitude;
        } else if (dllmAttributes.getLatitude()!=null) {
            metadata_is_latitude = new Metadata(new Label( "schema:latitude"),
                    new Value(String.valueOf(dllmAttributes.getLatitude().get(0))));
            return metadata_is_latitude;
        }
        else return metadata_is_latitude;

    }


    public static Metadata getMetadataLongitude(DllmAttributes dllmAttributes) {

        Metadata metadata_is_longitude= null;
        if(dllmAttributes.getLocations_gps_lon()!=0) {
            metadata_is_longitude = new Metadata(new Label("schema:longitude"),
                    new Value(String.valueOf(dllmAttributes.getLocations_gps_lon())));
            return metadata_is_longitude;
        } else if (dllmAttributes.getLongitude()!=null) {
            metadata_is_longitude = new Metadata(new Label("schema:longitude"),
                    new Value(String.valueOf(dllmAttributes.getLongitude().get(0))));
            return metadata_is_longitude;
        }
        else return metadata_is_longitude;

    }
}
