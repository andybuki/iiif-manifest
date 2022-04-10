package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.constants.PublicConstants;

public class LocationTypes {

    public static Metadata getMetadataLocationTypesName(CollectionAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "location_type")),
                new Value(new I18n("en",dllmAttributes.getLocation_types_name()),
                        new I18n(PublicConstants.ORIGINAL_LANGUAGE, dllmAttributes.getLocation_types_name_lao())));
    }
}
