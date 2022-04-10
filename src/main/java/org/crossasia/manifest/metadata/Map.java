package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class Map {
    public static Metadata getMapLink(CollectionAttributes dllmAttributes) {

        Metadata map= null;

        if(dllmAttributes.getLocations_gps_lat()!=0) {
            map = new Metadata(new Label( "map"),
                    new Value("<a href=\"#\" onClick=\"MyWindow=window.open('https://www.openstreetmap.org/?mlat="+
                            String.valueOf(dllmAttributes.getLocations_gps_lat())+"&mlon="
                                    +String.valueOf(dllmAttributes.getLocations_gps_lon())+"#map=16/"
                                    +String.valueOf(dllmAttributes.getLocations_gps_lat())+"/"+
                                    String.valueOf(dllmAttributes.getLocations_gps_lon())+
                                            "','Map','width=500,height=500'); return false;\">Map view</a>"));
            return map;
        } else if (dllmAttributes.getLatitude()!=null) {
            map = new Metadata(new Label( "map"),
                    new Value("<a href=\"#\" onClick=\"MyWindow=window.open('https://www.openstreetmap.org/?mlat="
                            +String.valueOf(dllmAttributes.getLatitude().get(0))+"&mlon="
                            +String.valueOf(dllmAttributes.getLongitude().get(0))
                            +"#map=16/"+String.valueOf(dllmAttributes.getLatitude().get(0))+"/"+String.valueOf(dllmAttributes.getLongitude().get(0))+"','Map','width=500,height=500'); return false;\">Map view</a>"));
            return map;
        }
        else return map;
    }
}
