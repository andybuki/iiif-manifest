package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.ScriptInfo;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class SugawaraCrossasiaLanguage {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        ScriptInfo scriptInfo = sugawaraAttributes.getScriptInfo();

        if (scriptInfo == null) {
            return null;
        }

        List<String> languages = scriptInfo.getLanguages();

        if (languages == null || languages.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("en", languages);

        Metadata metadata = new Metadata(
                new Label("en", "crossasia:language"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
