package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

public class Proverbs {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        Metadata metadata = null;
        if(dtabAttributes.getDtabProverbs()!="") {
            metadata = new Metadata(new Label( "en","dtab:proverbs"),
                    new Value( new I18n("en", dtabAttributes.getDtabProverbs())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
