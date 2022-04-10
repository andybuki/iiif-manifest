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

public class Categories {
    public static Metadata getMetadataCategories(CollectionAttributes dllmAttributes) {

        ArrayList<String> categoriesRomanArrayList = new ArrayList<>();
        ArrayList<String> categoriesThaiArrayList = new ArrayList<>();
        Metadata metadata_categories = null;
        I18n i18n_categories_Roman = null;
        I18n i18n_categories_Thai = null;

        if (dllmAttributes.getCategories_name()!=null) {
            for (int i = 0; i < dllmAttributes.getCategories_name().length(); i++) {
                categoriesRomanArrayList.add(dllmAttributes.getCategories_name().get(i).toString());
                i18n_categories_Roman = new I18n(ORIGINAL_LANGUAGE_ENGLISH, categoriesRomanArrayList);
                metadata_categories = new Metadata(new Label(ORIGINAL_LANGUAGE_ENGLISH, "dc:subject"),
                        new Value(new I18n[]{i18n_categories_Roman}));
            }
        }
        if (dllmAttributes.getCategories_name_lao()!=null) {
            for (int j = 0; j < dllmAttributes.getCategories_name_lao().length(); j++) {
                categoriesThaiArrayList.add(dllmAttributes.getCategories_name_lao().get(j).toString());
                i18n_categories_Thai = new I18n(LANGUAGE_FOREING, categoriesThaiArrayList);
                metadata_categories = new Metadata(new Label(ORIGINAL_LANGUAGE_ENGLISH, "dc:subject"),
                        new Value(new I18n[]{i18n_categories_Roman, i18n_categories_Thai}));
            }

        }
        return metadata_categories;
    }
}
