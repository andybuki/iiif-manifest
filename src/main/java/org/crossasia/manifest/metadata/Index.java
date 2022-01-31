package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.crossasia.manifest.constants.PublicConstants;

import java.util.ArrayList;

public class Index {
    public static Metadata getMetadataIndex(DllmAttributes dllmAttributes) {

        ArrayList<String> indexRomanArrayList = new ArrayList<>();
        ArrayList<String> indexThaiArrayList = new ArrayList<>();

        Metadata metadata_index = new Metadata(new Label(""), new Value(""));
        I18n i18n_index_Roman = null;
        I18n i18n_index_Thai = null;

        if (dllmAttributes.getTitle_search_roman()!=null) {
            for (int i = 0; i < dllmAttributes.getTitle_search_roman().length(); i++) {
                indexRomanArrayList.add(dllmAttributes.getTitle_search_roman().get(i).toString());
            }
        }
        if (dllmAttributes.getTitle_search_lao()!=null) {
            for (int i = 0; i < dllmAttributes.getTitle_search_lao().length(); i++) {
                if (dllmAttributes.getTitle_search_lao() != null) {
                    indexThaiArrayList.add(dllmAttributes.getTitle_search_lao().get(i).toString());
                }
            }
        }
        if (dllmAttributes.getPlmp_title_lao()!=null) {
            for (int i = 0; i < dllmAttributes.getPlmp_title_lao().length(); i++) {
                    indexThaiArrayList.add(dllmAttributes.getPlmp_title_lao().get(i).toString());
            }
        }

        if (!indexRomanArrayList.isEmpty())
            i18n_index_Roman = new I18n("en", indexRomanArrayList);
        if (!indexThaiArrayList.isEmpty())
            i18n_index_Thai = new I18n(PublicConstants.ORIGINAL_LANGUAGE, indexThaiArrayList);


        if (!indexRomanArrayList.isEmpty() && !indexThaiArrayList.isEmpty())
            metadata_index = new Metadata(new Label("en", "index"),
                    new Value(new I18n[]{i18n_index_Thai, i18n_index_Roman }));

        if (!indexRomanArrayList.isEmpty() && indexThaiArrayList.isEmpty())
            metadata_index = new Metadata(new Label("en", "index"),
                    new Value(new I18n[]{i18n_index_Roman }));

        if (indexRomanArrayList.isEmpty() && !indexThaiArrayList.isEmpty())
            metadata_index = new Metadata(new Label("en", "index"),
                    new Value(new I18n[]{i18n_index_Thai }));

        if (dllmAttributes.getTitle_search_roman()==null && dllmAttributes.getTitle_search_lao()==null &&
                dllmAttributes.getPlmp_title_lao()==null ) {
            metadata_index = null;
        }

        return metadata_index;
    }
}
