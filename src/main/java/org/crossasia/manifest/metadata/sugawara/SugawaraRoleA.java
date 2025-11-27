package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.PersonRole;

public class SugawaraRoleA {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        PersonRole roleA = sugawaraAttributes.getRoleA();

        if (roleA == null) {
            return null;
        }
        String role = roleA.getRole();

        if (role == null || role.isEmpty()) {
            return null;
        }
        Metadata metadata = new Metadata(
                new Label("none", "sugawara:RoleA"),
                new Value(new I18n("none", role))
        );
        return metadata;
    }
}
