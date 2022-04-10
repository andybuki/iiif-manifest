
package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.crossasia.manifest.constants.PublicConstants;

import java.util.ArrayList;
import java.util.List;

public final class Language {
    private static Metadata metadataLanguage;
    private Language() {
    }

    public static Metadata getMetadataLanguageRomanThai(DllmAttributes dllmAttributes) {
        List<String> languagesRomanArrayList = new ArrayList<>();
        List<String> languagesThaiArrayList = new ArrayList<>();
        if (dllmAttributes.getLanguages()!=null) {
            metadataLanguage =new Metadata(new Label(""), new Value(""));
            for (var i = 0; i < dllmAttributes.getLanguages().length(); i++) {
                languagesRomanArrayList.add(dllmAttributes.getLanguages().get(i).toString());
                languagesThaiArrayList.add(dllmAttributes.getLanguages_lao().get(i).toString());
                var i18nLanguageRoman = new I18n("en", languagesRomanArrayList);
                var i18nLanguageThai = new I18n(PublicConstants.ORIGINAL_LANGUAGE, languagesThaiArrayList);
                metadataLanguage = new Metadata(new Label("en", "dc:language"),
                        new Value(new I18n[]{i18nLanguageRoman, i18nLanguageThai}));
            }
        }
        return metadataLanguage;
    }
}
