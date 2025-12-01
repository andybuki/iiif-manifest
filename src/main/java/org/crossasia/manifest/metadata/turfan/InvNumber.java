package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class InvNumber {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {
        List<String> inventoryNumbers = turfanAttributes.getInventoryNumbers();

        if (inventoryNumbers == null || inventoryNumbers.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("none", inventoryNumbers);

        Metadata metadata = new Metadata(
                new Label("none", "turfan:invNumber"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
