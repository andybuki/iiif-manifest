package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;

public class SchemaPersonRoleB {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if (sugawaraAttributes.getSchema_personRolesB() != null) {
            for (int i = 0; i < sugawaraAttributes.getSchema_personRolesB().length(); i++) {
                list.add(sugawaraAttributes.getSchema_personRolesB().get(i).toString());
            }
            i18n = new I18n("en", list);
            metadata = new Metadata(new Label("en", "schema:personB"),
                    new Value(new I18n[]{i18n}));

            return metadata;
        } else if (sugawaraAttributes.getSchema_personRoleB() != null) {
            metadata = new Metadata(new Label( "en","schema:personB"),
                    new Value( new I18n("en", sugawaraAttributes.getSchema_personRoleB())));
            return metadata;

        } else {
            return metadata;
        }
    }
}
