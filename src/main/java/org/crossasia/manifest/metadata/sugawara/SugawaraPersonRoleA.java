package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.PersonRole;

import java.util.ArrayList;
import java.util.List;

public class SugawaraPersonRoleA {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        PersonRole roleA = sugawaraAttributes.getRoleA();

        if (roleA == null) {
            return null;
        }

        List<String> personNames = roleA.getPersonNames();

        if (personNames == null || personNames.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("en", personNames);

        Metadata metadata = new Metadata(
                new Label("en", "schema:personA"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
