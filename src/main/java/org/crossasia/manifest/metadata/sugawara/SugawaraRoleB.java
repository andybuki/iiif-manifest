package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.PersonRole;
@Deprecated
public class SugawaraRoleB {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        PersonRole roleB = sugawaraAttributes.getRoleB();

        if (roleB == null) {
            return null;
        }

        String role = roleB.getRole();

        if (role == null || role.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "sugawara:RoleB"),
                new Value(new I18n("en", role))
        );

        return metadata;
    }
}
