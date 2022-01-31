package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;

import static org.crossasia.manifest.IIIFPresentationDlllm.ORIGINAL_LANGUAGE;
import java.util.ArrayList;

public class Categories {
    public static Metadata getMetadataCategories(DllmAttributes dllmAttributes) {

        ArrayList<String> categoriesRomanArrayList = new ArrayList<>();
        ArrayList<String> categoriesThaiArrayList = new ArrayList<>();
        Metadata metadata_categories = null;
        I18n i18n_categories_Roman = null;
        I18n i18n_categories_Thai = null;

        if (dllmAttributes.getCategories_name()!=null) {
            for (int i = 0; i < dllmAttributes.getCategories_name().length(); i++) {
                categoriesRomanArrayList.add(dllmAttributes.getCategories_name().get(i).toString());
                i18n_categories_Roman = new I18n("en", categoriesRomanArrayList);
                metadata_categories = new Metadata(new Label("en", "dc:subject"),
                        new Value(new I18n[]{i18n_categories_Roman}));
            }
        }
        if (dllmAttributes.getCategories_name_lao()!=null) {
            for (int j = 0; j < dllmAttributes.getCategories_name_lao().length(); j++) {
                categoriesThaiArrayList.add(dllmAttributes.getCategories_name_lao().get(j).toString());
                i18n_categories_Thai = new I18n(ORIGINAL_LANGUAGE, categoriesThaiArrayList);
                metadata_categories = new Metadata(new Label("en", "dc:subject"),
                        new Value(new I18n[]{i18n_categories_Roman, i18n_categories_Thai}));
            }

        }

        return metadata_categories;
    }
}
