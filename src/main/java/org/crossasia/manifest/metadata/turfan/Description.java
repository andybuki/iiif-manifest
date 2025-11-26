package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;
import java.util.Collections;

public class Description {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if(turfanAttributes.getDescriptions()!=null) {

            for (int i = 0; i < turfanAttributes.getDescriptions().size(); i++) {
                if (turfanAttributes.getDescriptions().get(i).toString().contains(";")) {
                    String [] descrs = turfanAttributes.getDescriptions().get(i).toString().split(";");
                    Collections.addAll(list, descrs);
                } else{
                    list.add(turfanAttributes.getDescriptions().get(i).toString());
                }
            }
            i18n = new I18n("de", list);
            metadata = new Metadata(new Label("de", "dc:description"),
                    new Value(new I18n[]{i18n}));
            return metadata;
        }
        else {
            return metadata;
        }
    }

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
       ArrayList<T> newList = new ArrayList<T>();
            for (T element : list) {
                if (!newList.contains(element)) {
                    newList.add(element);
                }
            }
       return newList;
    }
}
