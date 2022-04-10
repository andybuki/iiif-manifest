package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.constants.PublicConstants;

import java.util.ArrayList;

public class LabelMetadata {
    public static I18n getStringsLabel(CollectionAttributes dllmAttributes) {
        ArrayList<String> titlesArrayList = new ArrayList<>();
        I18n i18n_title_no_title = new I18n("en", "no title (" + dllmAttributes.getDocuments_id() + ")");
        I18n i18n_title_Roman = null;
        if (dllmAttributes.getDllm_title_roman()!=null) {
            for (int i = 0; i < dllmAttributes.getDllm_title_roman().length(); i++) {
                titlesArrayList.add(dllmAttributes.getDllm_title_roman().get(i).toString());
                i18n_title_Roman = new I18n("en", titlesArrayList);
            }
            return i18n_title_Roman;
        } else {
            //titlesArrayList.add(" No title (" + dllmAttributes.getDocuments_id() + ")");
            //i18n_title_Roman = new I18n("en", titlesArrayList);
            i18n_title_Roman = null;
            return i18n_title_Roman;
        }
    }

    public static I18n getStringsLabelThai(CollectionAttributes dllmAttributes) {
        ArrayList<String> titlesThaiArrayList = new ArrayList<>();
        I18n i18n_title_Thai = null;
        if (dllmAttributes.getDllm_title_lao()!=null) {
            for (int i = 0; i < dllmAttributes.getDllm_title_lao().length(); i++) {
                titlesThaiArrayList.add(dllmAttributes.getDllm_title_lao().get(i).toString());
                i18n_title_Thai = new I18n(PublicConstants.ORIGINAL_LANGUAGE, titlesThaiArrayList);
            }
            return i18n_title_Thai;
        } else {
            i18n_title_Thai = null;
            return i18n_title_Thai;
        }
    }

    public static I18n getStringsLabelBoth(CollectionAttributes dllmAttributes) {
        ArrayList<String> titlesThaiArrayList = new ArrayList<>();
        ArrayList<String> titlesArrayList = new ArrayList<>();

        if (dllmAttributes.getDllm_title_roman()!=null) {
            for (int i = 0; i < dllmAttributes.getDllm_title_roman().length(); i++) {
                titlesArrayList.add(dllmAttributes.getDllm_title_roman().get(i).toString());
            }
        }

        if (dllmAttributes.getDllm_title_lao()!=null) {
            for (int i = 0; i < dllmAttributes.getDllm_title_lao().length(); i++) {
                titlesThaiArrayList.add(dllmAttributes.getDllm_title_lao().get(i).toString());
            }
        }
        I18n i18n_title = new I18n("none", titlesArrayList.toString().
                replace(","," / ")
                .replace("[","").replace("]","") + " ("+ titlesThaiArrayList.toString()
                .replace("[","").replace("]","")
                .replace(","," / ")+ ")");
        return i18n_title;
    }


    public static I18n getStringsLabelNoTitleBoth(CollectionAttributes dllmAttributes) {
        I18n i18n_title_no_title = new I18n("none", "no title (" + "ໂດຍບໍ່ມີຫົວຂໍ້ " +  dllmAttributes.getDocuments_id() + ")");
        return i18n_title_no_title;
    }

    public static I18n getStringsLabelNoTitleBothLanna(CollectionAttributes dllmAttributes) {
        I18n i18n_title_no_title = new I18n("none", "no title (" + "ไม่มีชื่อเรื่อง " +  dllmAttributes.getDocuments_id() + ")");
        return i18n_title_no_title;
    }

    public static I18n getStringsLabelNoTitle(CollectionAttributes dllmAttributes) {
        I18n i18n_title_no_title = new I18n("en", "no title (" + dllmAttributes.getDocuments_id() + ")");
        return i18n_title_no_title;
    }

    public static I18n getStringsLabelNoTitleThai(CollectionAttributes dllmAttributes) {
        I18n i18n_title_no_title_thai = new I18n(PublicConstants.ORIGINAL_LANGUAGE, "ໂດຍບໍ່ມີຫົວຂໍ້ (" + dllmAttributes.getDocuments_id() + ")");
        return i18n_title_no_title_thai;
    }

    public static I18n getStringsLabelFromAddress(CollectionAttributes dllmAttributes) {
        I18n i18n_title_from_address = new I18n(PublicConstants.ORIGINAL_LANGUAGE_ENGLISH, dllmAttributes.getAddress_ro().get(0) +" (" +
                dllmAttributes.getDistrict_ro().get(0) + ") : "+ dllmAttributes.getSubject_ro());
        return i18n_title_from_address;
    }

    public static I18n getStringsLabelFromAddressThai(CollectionAttributes dllmAttributes) {
        I18n i18n_title_from_address = new I18n(PublicConstants.ORIGINAL_LANGUAGE, dllmAttributes.getAddress_th().get(0) +" (" +
                dllmAttributes.getDistrict_th().get(0) + ") : "+ dllmAttributes.getSubject_th());
        return i18n_title_from_address;
    }
}
