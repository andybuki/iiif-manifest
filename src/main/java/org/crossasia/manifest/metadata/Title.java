package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.constants.PublicConstants;

import java.util.ArrayList;

import static org.crossasia.manifest.metadata.LabelMetadata.*;

public class Title {
    public static Metadata getMetadataTitle(CollectionAttributes dllmAttributes) {
        ArrayList<String> titlesRomanArrayList = new ArrayList<>();
        ArrayList<String> titlesThaiArrayList = new ArrayList<>();
        Metadata metadata_titles = new Metadata(new Label(""), new Value(""));

        if (dllmAttributes.getDllm_title_roman()!=null || dllmAttributes.getDllm_title_lao()!=null) {
            I18n i18n_title_Roman = null;
            I18n i18n_title_Thai = null;
            for (int i = 0; i < dllmAttributes.getDllm_title_roman().length(); i++) {
                titlesRomanArrayList.add(dllmAttributes.getDllm_title_roman().get(i).toString());
                i18n_title_Roman = new I18n("en", titlesRomanArrayList);
            }
            if (dllmAttributes.getDllm_title_lao()!=null) {
                for (int i = 0; i < dllmAttributes.getDllm_title_lao().length(); i++) {
                    titlesThaiArrayList.add(dllmAttributes.getDllm_title_lao().get(i).toString());
                    i18n_title_Thai = new I18n(PublicConstants.ORIGINAL_LANGUAGE, titlesThaiArrayList);
                }
                metadata_titles = new Metadata(new Label("en", "title"),
                        new Value(new I18n[]{i18n_title_Roman, i18n_title_Thai}));
            } else
                metadata_titles = new Metadata(new Label("en", "title"),
                        new Value(new I18n[]{i18n_title_Roman}));
        }

        if (dllmAttributes.getDllm_title_lao()==null &&
                dllmAttributes.getDllm_title_roman()==null ) {
            metadata_titles = new Metadata(new Label("en", "title"),
                    new Value(new I18n[]{getStringsLabelNoTitle(dllmAttributes), getStringsLabelNoTitleThai(dllmAttributes)}));
        }

        return metadata_titles;
    }

    public static Metadata getMetadataPhotoTitle(CollectionAttributes dllmAttributes) {
        ArrayList<String> titlesRomanArrayList = new ArrayList<>();
        ArrayList<String> titlesThaiArrayList = new ArrayList<>();
        Metadata metadata_titles = new Metadata(new Label(""), new Value(""));

        if (dllmAttributes.getDllm_title_lao()==null &&
                dllmAttributes.getDllm_title_roman()==null ) {
            /*metadata_titles = new Metadata(new Label("en", "title"),
                    new Value(new I18n[]{getStringsLabelFromAddress(dllmAttributes), getStringsLabelFromAddressThai(dllmAttributes)}));*/
            metadata_titles = new Metadata(new Label("en", "title"),
                    new Value(new I18n[]{getStringsLabelFromAddress(dllmAttributes), getStringsLabelFromAddressThai(dllmAttributes)}));
        }

        return metadata_titles;
    }
}
