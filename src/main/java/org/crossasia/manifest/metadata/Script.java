package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.constants.PublicConstants;

import java.util.ArrayList;

public class Script {
    public static Metadata getMetadataScript(CollectionAttributes dllmAttributes) {

        ArrayList<String> scriptRomanArrayList = new ArrayList<>();
        ArrayList<String> scriptThaiArrayList = new ArrayList<>();
        Metadata metadata_script = null;

        if (dllmAttributes.getScripts()!=null) {

            for (int i = 0; i < dllmAttributes.getScripts().length(); i++) {
                scriptRomanArrayList.add(dllmAttributes.getScripts().get(i).toString().replaceAll("\u200b",""));
                scriptThaiArrayList.add(dllmAttributes.getScripts_lao().get(i).toString().replaceAll("\u200b",""));
                I18n i18n_script_Roman = new I18n("en", scriptRomanArrayList);
                I18n i18n_script_Thai = new I18n(PublicConstants.ORIGINAL_LANGUAGE, scriptThaiArrayList);
                metadata_script = new Metadata(new Label("en", "script"),
                        new Value(new I18n[]{i18n_script_Roman, i18n_script_Thai}));
            }
        }

        return metadata_script;
    }
}
