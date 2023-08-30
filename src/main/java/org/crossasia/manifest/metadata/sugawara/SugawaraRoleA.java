package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

public class SugawaraRoleA {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        Metadata metadata = null;

        if(sugawaraAttributes.getSugawara_RoleA()!="") {
            metadata = new Metadata(new Label( "none","sugawara:RoleA"),
                    new Value( new I18n("none", sugawaraAttributes.getSugawara_RoleA())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
