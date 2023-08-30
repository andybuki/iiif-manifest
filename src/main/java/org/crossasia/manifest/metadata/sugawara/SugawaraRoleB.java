package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

public class SugawaraRoleB {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        Metadata metadata = null;

        if(sugawaraAttributes.getSugawara_RoleB()!="") {
            metadata = new Metadata(new Label( "en","sugawara:RoleB"),
                    new Value( new I18n("en", sugawaraAttributes.getSugawara_RoleB())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
