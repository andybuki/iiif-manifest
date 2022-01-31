package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.crossasia.manifest.constants.PublicConstants;

import java.util.ArrayList;

public class Language {
    public static Metadata getMetadataLanguageRomanThai(DllmAttributes dllmAttributes) {
        ArrayList<String> languagesRomanArrayList = new ArrayList<>();
        ArrayList<String> languagesThaiArrayList = new ArrayList<>();

        Metadata metadata_language =new Metadata(new Label(""), new Value(""));
        if (dllmAttributes.getLanguages()!=null) {
            for (int i = 0; i < dllmAttributes.getLanguages().length(); i++) {
                languagesRomanArrayList.add(dllmAttributes.getLanguages().get(i).toString());
                languagesThaiArrayList.add(dllmAttributes.getLanguages_lao().get(i).toString());
                I18n i18n_language_Roman = new I18n("en", languagesRomanArrayList);
                I18n i18n_language_Thai = new I18n(PublicConstants.ORIGINAL_LANGUAGE, languagesThaiArrayList);
                metadata_language = new Metadata(new Label("en", "dc:language"),
                        new Value(new I18n[]{i18n_language_Roman, i18n_language_Thai}));
            }
        }

        if (dllmAttributes.getLanguages()==null &&
                dllmAttributes.getLanguages_lao()==null) {
            metadata_language = null;
        }

        return metadata_language;
    }
}
