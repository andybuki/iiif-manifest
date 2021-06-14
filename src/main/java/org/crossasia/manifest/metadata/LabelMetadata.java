package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.DllmAttributes;

import java.util.ArrayList;

public class LabelMetadata {
    public static I18n getStringsLabel(DllmAttributes dllmAttributes) {
        ArrayList<String> titlesArrayList = new ArrayList<>();
        I18n i18n_title_Roman = new I18n("en", "No title (" + dllmAttributes.getDocuments_id() + ")");
        if (dllmAttributes.getDllm_title_roman()!=null) {
            for (int i = 0; i < dllmAttributes.getDllm_title_roman().length(); i++) {
                titlesArrayList.add(dllmAttributes.getDllm_title_roman().get(i).toString());
                titlesArrayList.add("  (" + dllmAttributes.getDocuments_id() + ")");
                i18n_title_Roman = new I18n("en", titlesArrayList);
            }
            return i18n_title_Roman;
        } else
            return i18n_title_Roman;
    }
}
