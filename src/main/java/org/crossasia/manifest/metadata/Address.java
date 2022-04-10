package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.constants.PublicConstants;

import java.util.ArrayList;

import static org.crossasia.manifest.constants.PublicConstants.ORIGINAL_LANGUAGE_ENGLISH;
import static org.crossasia.manifest.presentations.IIIFPresentationDlllm.LANGUAGE_FOREING;

public class Address {
    public static Metadata getMetadataAddress(CollectionAttributes dllmAttributes) {
        ArrayList<String> addressRo = new ArrayList<>();
        ArrayList<String> addressTh = new ArrayList<>();

        Metadata metadata_address =new Metadata(new Label(""), new Value(""));
        if (dllmAttributes.getAddress_ro()!=null) {
                addressRo.add(dllmAttributes.getAddress_ro().get(0).toString());
            if (dllmAttributes.getDistrict_ro()!=null) {
                addressRo.add(dllmAttributes.getDistrict_ro().get(0).toString());
            }
                addressTh.add(dllmAttributes.getAddress_th().get(0).toString());
            if (dllmAttributes.getDistrict_th()!=null) {
                addressTh.add(dllmAttributes.getDistrict_th().get(0).toString());
            }
            if (dllmAttributes.getProvince_ro()!=null) {
                addressRo.add(dllmAttributes.getProvince_ro().get(0).toString());
            }
            if (dllmAttributes.getProvince_th()!=null) {
                addressTh.add(dllmAttributes.getProvince_th().get(0).toString());
            }
                I18n i18n_address_Roman = new I18n(ORIGINAL_LANGUAGE_ENGLISH, addressRo);
                I18n i18n_addressThai = new I18n(LANGUAGE_FOREING , addressTh);
                metadata_address = new Metadata(new Label(ORIGINAL_LANGUAGE_ENGLISH, "dc:place"),
                        new Value(new I18n[]{i18n_address_Roman, i18n_addressThai}));
        }

        if (dllmAttributes.getAddress_ro()==null &&
                dllmAttributes.getAddress_th()==null) {
            metadata_address = null;
        }

        return metadata_address;
    }
}
