package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.ScriptInfo;

import java.util.ArrayList;
import java.util.List;

public class Script {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        ScriptInfo scriptInfo = dtabAttributes.getScriptInfo();

        if (scriptInfo == null) {
            return null;
        }

        List<String> scripts = scriptInfo.getScripts();

        if (scripts == null || scripts.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("en", scripts);

        Metadata metadata = new Metadata(
                new Label("en", "dtab:script"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
