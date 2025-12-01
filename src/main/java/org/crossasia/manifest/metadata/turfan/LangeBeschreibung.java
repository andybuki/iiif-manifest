package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;
import java.util.Collections;
@Deprecated
public class LangeBeschreibung {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        String longDescription = turfanAttributes.getLongDescription();

        if (longDescription == null || longDescription.isEmpty()) {
            return null;
        }

        ArrayList<String> list = new ArrayList<>();

        if (longDescription.contains(";")) {
            String[] parts = longDescription.split(";");
            Collections.addAll(list, parts);
        } else {
            list.add(longDescription);
        }

        I18n i18n = new I18n("de", list);

        Metadata metadata = new Metadata(
                new Label("de", "smb:langeBeschreibung"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
