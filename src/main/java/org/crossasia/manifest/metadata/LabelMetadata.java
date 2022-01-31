package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.DllmAttributes;

import static org.crossasia.manifest.presentations.IIIFPresentationDlllm.ORIGINAL_LANGUAGE;
import java.util.ArrayList;

public class LabelMetadata {
    public static I18n getStringsLabel(DllmAttributes dllmAttributes) {
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

    public static I18n getStringsLabelThai(DllmAttributes dllmAttributes) {
        ArrayList<String> titlesThaiArrayList = new ArrayList<>();
        I18n i18n_title_Thai = null;
        if (dllmAttributes.getDllm_title_lao()!=null) {
            for (int i = 0; i < dllmAttributes.getDllm_title_lao().length(); i++) {
                titlesThaiArrayList.add(dllmAttributes.getDllm_title_lao().get(i).toString());
                i18n_title_Thai = new I18n(ORIGINAL_LANGUAGE, titlesThaiArrayList);
            }
            return i18n_title_Thai;
        } else {
            i18n_title_Thai = null;
            return i18n_title_Thai;
        }
    }

    public static I18n getStringsLabelBoth(DllmAttributes dllmAttributes) {
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


    public static I18n getStringsLabelNoTitleBoth(DllmAttributes dllmAttributes) {
        I18n i18n_title_no_title = new I18n("none", "no title (" + "ໂດຍບໍ່ມີຫົວຂໍ້ " +  dllmAttributes.getDocuments_id() + ")");
        return i18n_title_no_title;
    }

    public static I18n getStringsLabelNoTitle(DllmAttributes dllmAttributes) {
        I18n i18n_title_no_title = new I18n("en", "no title (" + dllmAttributes.getDocuments_id() + ")");
        return i18n_title_no_title;
    }

    public static I18n getStringsLabelNoTitleThai(DllmAttributes dllmAttributes) {
        I18n i18n_title_no_title_thai = new I18n(ORIGINAL_LANGUAGE, "ໂດຍບໍ່ມີຫົວຂໍ້ (" + dllmAttributes.getDocuments_id() + ")");
        return i18n_title_no_title_thai;
    }
}
