package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import static org.crossasia.manifest.IIIFPresentationDlmnt.ORIGINAL_LANGUAGE;
import java.util.ArrayList;

public class Keywords {
    public static Metadata getMetadataKeywords(DllmAttributes dllmAttributes) {

        ArrayList<String> keywordsRomanArrayList = new ArrayList<>();
        ArrayList<String> keywordsThaiArrayList = new ArrayList<>();
        Metadata metadata_keywords =new Metadata(new Label(""), new Value(""));
        I18n i18n_keywords_Roman = null;
        I18n i18n_keywords_Thai = null;
        //Metadata metadata_keywords = new Metadata(new Label("en",""), new Value("en",""));
        if (dllmAttributes.getAncillary_terms_roman()!=null) {
            for (int i = 0; i < dllmAttributes.getAncillary_terms_roman().length(); i++) {
                keywordsRomanArrayList.add(dllmAttributes.getAncillary_terms_roman().get(i).toString());
                i18n_keywords_Roman = new I18n("en", keywordsRomanArrayList);
                metadata_keywords = new Metadata(new Label("en", "schema:keywords"),
                        new Value(new I18n[]{i18n_keywords_Roman }));
            }
        }
        if (dllmAttributes.getAncillary_terms_lao()!=null) {
            for (int i = 0; i < dllmAttributes.getAncillary_terms_lao().length(); i++) {
                keywordsThaiArrayList.add(dllmAttributes.getAncillary_terms_lao().get(i).toString());
                i18n_keywords_Thai = new I18n(ORIGINAL_LANGUAGE, keywordsThaiArrayList);
                metadata_keywords = new Metadata(new Label("en", "schema:keywords"),
                        new Value(new I18n[]{ i18n_keywords_Roman,i18n_keywords_Thai}));
            }
        }

        if (dllmAttributes.getAncillary_terms_roman()==null &&
                dllmAttributes.getAncillary_terms_lao()==null) {
            metadata_keywords = null;
        }

        return metadata_keywords;
    }
}
