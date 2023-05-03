package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;

public class KeywordTurfan {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> keywords = new ArrayList<>();
        if (turfanAttributes.getKeyword() != null) {
            for (int i = 0; i < turfanAttributes.getKeyword().length(); i++) {
                keywords.add(turfanAttributes.getKeyword().get(i).toString());
            }
            i18n = new I18n("de", keywords);
            metadata = new Metadata(new Label("de", "schema:keyword"),
                    new Value(new I18n[]{i18n}));
            return metadata;
        } else {
            metadata = null;
            return metadata;
        }
    }
}
