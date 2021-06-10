package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;

import java.util.ArrayList;

public class Script {
    public static Metadata getMetadataScript(DllmAttributes dllmAttributes) {

        ArrayList<String> scriptRomanArrayList = new ArrayList<>();
        ArrayList<String> scriptThaiArrayList = new ArrayList<>();
        Metadata metadata_script = null;

        if (dllmAttributes.getScripts()!=null) {

            for (int i = 0; i < dllmAttributes.getScripts().length(); i++) {
                scriptRomanArrayList.add(dllmAttributes.getScripts().get(i).toString());
                scriptThaiArrayList.add(dllmAttributes.getScripts_lao().get(i).toString());
                I18n i18n_script_Roman = new I18n("en", scriptRomanArrayList);
                I18n i18n_script_Thai = new I18n("lo", scriptThaiArrayList);
                metadata_script = new Metadata(new Label("en", "dc:subject"),
                        new Value(new I18n[]{i18n_script_Roman, i18n_script_Thai}));
            }
        }

        return metadata_script;
    }
}
