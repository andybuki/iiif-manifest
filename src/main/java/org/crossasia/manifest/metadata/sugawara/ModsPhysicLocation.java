package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

public class ModsPhysicLocation {

    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        Metadata metadata = null;

        if(sugawaraAttributes.getMods_physicalLocation()!=null) {
            metadata = new Metadata(new Label( "none","mods:physicalLocation"),
                    new Value( new I18n("none", sugawaraAttributes.getMods_physicalLocation())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
