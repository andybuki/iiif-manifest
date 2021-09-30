package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;
import static org.crossasia.manifest.IIIFPresentationDlmnt.ORIGINAL_LANGUAGE;

public class FullLocationName {

    public static Metadata getMetadataFullLocationName(DllmAttributes dllmAttributes) {
        StringBuilder fullLocationNameBuilder = new StringBuilder();
        StringBuilder fullLocationNameBuilderLao = new StringBuilder();
        String district ="";
        String province ="";
        String address ="";
        String district_th ="";
        String province_th ="";
        String address_th ="";
        String collection = "";

        if (dllmAttributes.getLocation_name()!=null) {
            address = dllmAttributes.getLocation_name();
            fullLocationNameBuilder.append(address+", ");
        }

        if (dllmAttributes.getLocations_parent_parent_name()!=null) {
            district = dllmAttributes.getLocations_parent_parent_name();
            fullLocationNameBuilder.append(district+", ");
        }

        if (dllmAttributes.getLocations_parent_name()!=null) {
            province = dllmAttributes.getLocations_parent_name();
            fullLocationNameBuilder.append(province);
        }
        if(dllmAttributes.isIn_private_collection()==true) {
            collection = " In private possession";
            fullLocationNameBuilder.append(collection);
        }

        if (dllmAttributes.getLocation_name_lao()!=null) {
            address_th = dllmAttributes.getLocation_name_lao();
            fullLocationNameBuilderLao.append(address_th+", ");
        }

        if (dllmAttributes.getLocations_parent_parent_name_lao()!=null) {
            district_th = dllmAttributes.getLocations_parent_parent_name_lao();
            fullLocationNameBuilderLao.append(district_th+", ");
        }

        if (dllmAttributes.getLocations_parent_name_lao()!=null) {
            province_th = dllmAttributes.getLocations_parent_name_lao();
            fullLocationNameBuilderLao.append(province_th);
        }


        if (dllmAttributes.isIn_private_collection()==true) {
            return new Metadata(new Label(new I18n("en", "full_location_name")),
                    new Value(new I18n("none",fullLocationNameBuilder.toString())));
        } else if (dllmAttributes.isIn_private_collection()==true && dllmAttributes.getLocation_name()!=null) {
                return new Metadata(new Label(new I18n("en", "full_location_name")),
                        new Value(new I18n("en",dllmAttributes.getFull_location_name()),
                                new I18n(ORIGINAL_LANGUAGE, dllmAttributes.getFull_location_name_lao())));
        } else if (dllmAttributes.isIn_private_collection()==false && dllmAttributes.getLocation_name()==null) {
            return new Metadata(new Label(new I18n("none", "full_location_name")),
                    new Value("Unknown location"));
        } else {
            return new Metadata(new Label(new I18n("en", "full_location_name")),
                    new Value(new I18n("en", fullLocationNameBuilder.toString()),
                            new I18n(ORIGINAL_LANGUAGE, fullLocationNameBuilderLao.toString())));
        }
    }
}
