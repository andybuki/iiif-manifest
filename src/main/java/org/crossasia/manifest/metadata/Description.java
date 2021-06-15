package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;

import java.util.ArrayList;

public class Description {
    public static Metadata getMetadataDescription(DllmAttributes dllmAttributes) {

        ArrayList<String> descriptionRomanArrayList = new ArrayList<>();
        ArrayList<String> descriptionThaiArrayList = new ArrayList<>();
        Metadata metadata_description = new Metadata(new Label(""), new Value(""));
        I18n i18n_description_Roman = null;
        I18n i18n_description_Thai = null;

        if (dllmAttributes.getPublic_remarks_english()!=null) {
                for (int i = 0; i < dllmAttributes.getPublic_remarks_english().length(); i++) {
                    descriptionRomanArrayList.add(dllmAttributes.getPublic_remarks_english().get(i).toString());
                    i18n_description_Roman = new I18n("en", descriptionRomanArrayList);
                    metadata_description = new Metadata(new Label("en", "dc:description"),
                            new Value(new I18n[]{i18n_description_Roman}));
                }
        }

        if  (dllmAttributes.getPublic_remarks_lao()!=null) {
            for (int i = 0; i < dllmAttributes.getPublic_remarks_lao().length(); i++) {
                descriptionThaiArrayList.add(dllmAttributes.getPublic_remarks_lao().get(i).toString());
                i18n_description_Thai = new I18n("lo", descriptionThaiArrayList);
                if(i18n_description_Thai==null) {
                    System.out.println("check");
                }
                if(i18n_description_Roman==null) {
                    metadata_description = new Metadata(new Label("en", "dc:description"),
                            new Value(new I18n[]{ i18n_description_Thai}));
                } else {
                    metadata_description = new Metadata(new Label("en", "dc:description"),
                            new Value(new I18n[]{i18n_description_Roman, i18n_description_Thai}));
                }


            }
        }
        if (dllmAttributes.getDescription()!=null) {
            descriptionRomanArrayList.add(dllmAttributes.getDescription().toString());
            i18n_description_Roman = new I18n("en", descriptionRomanArrayList);
            if (dllmAttributes.getPublic_remarks_lao()!=null) {
                metadata_description = new Metadata(new Label("en", "dc:description"),
                        new Value(new I18n[]{i18n_description_Roman, i18n_description_Thai}));
            } else {
                metadata_description = new Metadata(new Label("en", "dc:description"),
                        new Value(new I18n[]{i18n_description_Roman}));
            }

        }

        if (dllmAttributes.getDescription()==null &&
                dllmAttributes.getPublic_remarks_lao()==null &&
                dllmAttributes.getPublic_remarks_english()==null) {
            metadata_description = null;
        }




        return metadata_description;
    }
}
