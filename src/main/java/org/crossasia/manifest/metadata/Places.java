package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static org.crossasia.manifest.IIIFPresentationDlmnt.ORIGINAL_LANGUAGE;

public class Places {
    @NotNull
    public static Metadata getMetadataPlaces(DllmAttributes dllmAttributes) {
        ArrayList<String> placesArrayList = new ArrayList<>();
        ArrayList<String> placesArrayListLao = new ArrayList<>();
        placesArrayList.add(dllmAttributes.getLocations_parent_parent_name());
        placesArrayList.add(dllmAttributes.getLocations_parent_name());
        placesArrayList.add(dllmAttributes.getLocation_name());
        //String collection = null;

        if( dllmAttributes.isIn_private_collection()==true) {
            String collection = "In private possession";
            placesArrayList.add(collection);
        }
        placesArrayListLao.add(dllmAttributes.getLocations_parent_parent_name_lao());
        placesArrayListLao.add(dllmAttributes.getLocations_parent_name_lao());
        placesArrayListLao.add(dllmAttributes.getLocation_name_lao());
        I18n places_roman = new I18n("en", placesArrayList);
        I18n places_lao = new I18n(ORIGINAL_LANGUAGE, placesArrayListLao);

        if (!placesArrayList.isEmpty())
        return new Metadata(new Label(new I18n("en", "dc:place")),
                new Value(new I18n [] {places_roman, places_lao}));
        else
            return new Metadata(new Label(new I18n("none", "dc:place")),
                    new Value("In private possession"));
    }
}
