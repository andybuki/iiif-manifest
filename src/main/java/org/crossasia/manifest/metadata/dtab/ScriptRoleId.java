package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.ScriptInfo;
@Deprecated
public class ScriptRoleId {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        ScriptInfo scriptInfo = dtabAttributes.getScriptInfo();

        if (scriptInfo == null) {
            return null;
        }

        String scriptIdRole = scriptInfo.getScriptIdRole();

        if (scriptIdRole == null || scriptIdRole.isEmpty()) {
            return null;
        }
        I18n i18n = new I18n("none", scriptIdRole);

        Metadata metadata = new Metadata(
                new Label("none", "dtab:script_id_role"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
