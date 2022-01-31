package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.json.JSONArray;
import static org.crossasia.manifest.presentations.IIIFPresentationDlllm.ORIGINAL_LANGUAGE;
import java.util.ArrayList;

public class Description {
    public static Metadata getMetadataDescription(DllmAttributes dllmAttributes) {

        ArrayList<String> descriptionRomanArrayList = new ArrayList<>();
        ArrayList<String> descriptionThaiArrayList = new ArrayList<>();
        Metadata metadata_description = null;
        I18n i18n_description_Roman = null;
        I18n i18n_description_Thai = null;
        String microfilm ="";

        if (dllmAttributes.getMicrofilm_roll_number()!=null) {
            microfilm = "Microfilm roll no.:"+ dllmAttributes.getMicrofilm_roll_number();
            descriptionRomanArrayList.add(microfilm);
        }

        if (dllmAttributes.getPublic_remarks_english()!=null) {
                    descriptionRomanArrayList.add(dllmAttributes.getPublic_remarks_english());
                    /*i18n_description_Roman = new I18n("en", descriptionRomanArrayList);
                        descriptionRomanArrayList.add(microfilm);
                        metadata_description = new Metadata(new Label("en", "dc:description"),
                            new Value(new I18n[]{i18n_description_Roman }));*/
        }

        if  (dllmAttributes.getPublic_remarks_lao()!=null) {
            if (dllmAttributes.getPublic_remarks_lao() instanceof String)
                descriptionThaiArrayList.add((String) dllmAttributes.getPublic_remarks_lao());
            else
                descriptionThaiArrayList.add(String.valueOf((JSONArray) dllmAttributes.getPublic_remarks_lao()));
                /*i18n_description_Thai = new I18n(ORIGINAL_LANGUAGE, descriptionThaiArrayList);
                if(i18n_description_Thai==null) {
                    System.out.println("check");
                }
                if(i18n_description_Roman==null) {
                    metadata_description = new Metadata(new Label("en", "dc:description"),
                            new Value(new I18n[]{ i18n_description_Thai}));
                } else {

                    metadata_description = new Metadata(new Label("en", "dc:description"),
                            new Value(new I18n[]{i18n_description_Roman, i18n_description_Thai}));
                }*/
        }
        if (dllmAttributes.getDescription()!=null) {
            descriptionRomanArrayList.add(dllmAttributes.getDescription().toString());
            /*i18n_description_Roman = new I18n("en", descriptionRomanArrayList);
            if (dllmAttributes.getPublic_remarks_lao()!=null) {
                    metadata_description = new Metadata(new Label("en", "dc:description"),
                        new Value(new I18n[]{i18n_description_Roman, i18n_description_Thai}));
            } else {
                metadata_description = new Metadata(new Label("en", "dc:description"),
                        new Value(new I18n[]{i18n_description_Roman}));
            }*/
        }

        i18n_description_Thai = new I18n(ORIGINAL_LANGUAGE, descriptionThaiArrayList);
        i18n_description_Roman = new I18n("en", descriptionRomanArrayList);
        metadata_description = new Metadata(new Label("en", "dc:description"),
                new Value(new I18n[]{i18n_description_Roman, i18n_description_Thai}));

        if (dllmAttributes.getDescription()==null &&
                dllmAttributes.getPublic_remarks_lao()==null &&
                dllmAttributes.getPublic_remarks_english()==null) {
            metadata_description = null;
        }

        return metadata_description;
    }
}
