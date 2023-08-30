package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

public class CrossasiaAdminLevel1 {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        Metadata metadata = null;

        if(sugawaraAttributes.getCrossasia_adminlevel1()!=null) {
            metadata = new Metadata(new Label( "en","crossasia:adminlevel1"),
                    new Value( new I18n("en", sugawaraAttributes.getCrossasia_adminlevel1())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
