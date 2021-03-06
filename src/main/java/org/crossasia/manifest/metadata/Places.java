package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.constants.PublicConstants;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class Places {
    @NotNull
    public static Metadata getMetadataPlaces(CollectionAttributes dllmAttributes) {
        ArrayList<String> placesArrayList = new ArrayList<>();
        ArrayList<String> placesArrayListLao = new ArrayList<>();
        if (dllmAttributes.getLocations_parent_parent_name()!=null)
            placesArrayList.add(dllmAttributes.getLocations_parent_parent_name());

        if (dllmAttributes.getLocations_parent_name()!=null)
            placesArrayList.add(dllmAttributes.getLocations_parent_name());

        if (dllmAttributes.getLocation_name()!=null)
            placesArrayList.add(dllmAttributes.getLocation_name());
        //String collection = null;

        if( dllmAttributes.isIn_private_collection()==true) {
            String collection = "Private collection";
            placesArrayList.add(collection);
        }

        if (dllmAttributes.getLocations_parent_parent_name_lao()!=null)
            placesArrayListLao.add(dllmAttributes.getLocations_parent_parent_name_lao());

        if (dllmAttributes.getLocations_parent_name_lao()!=null)
            placesArrayListLao.add(dllmAttributes.getLocations_parent_name_lao());

        if (dllmAttributes.getLocation_name_lao()!=null)
            placesArrayListLao.add(dllmAttributes.getLocation_name_lao());

        I18n places_roman = new I18n("en", placesArrayList);
        I18n places_lao = new I18n(PublicConstants.ORIGINAL_LANGUAGE, placesArrayListLao);

        if (dllmAttributes.isIn_private_collection()==true)
            return new Metadata(new Label(new I18n("en", "dc:place")),
                    new Value("In private possession"));
        else if (dllmAttributes.isIn_private_collection()==true && dllmAttributes.getLocation_name()!=null)
            return new Metadata(new Label(new I18n("en", "dc:place")),
                        new Value(new I18n [] {places_roman, places_lao}));
        else if (dllmAttributes.isIn_private_collection()==false && dllmAttributes.getLocation_name()==null) {
            return new Metadata(new Label(new I18n("en", "dc:place")),
                    new Value("Unknown location"));
        } else
            return new Metadata(new Label(new I18n("en", "dc:place")),
                    new Value(new I18n [] {places_roman, places_lao}));
    }
}
