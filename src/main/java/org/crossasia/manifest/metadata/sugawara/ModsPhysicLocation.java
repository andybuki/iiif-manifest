package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
@Deprecated
public class ModsPhysicLocation {

    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        String physicalLocation = sugawaraAttributes.getPhysicalLocation();
        if (physicalLocation == null || physicalLocation.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(new Label( "none","mods:physicalLocation"),
                    new Value( new I18n("none", physicalLocation)));
            return metadata;

    }
}
