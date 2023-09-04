package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;

public class DctermsIdentifier {

    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        Metadata metadata = null;

        if(sugawaraAttributes.getDcterms_identifier()!=null) {
            metadata = new Metadata(new Label( "none","dc:identifier"),
                    new Value( new I18n("none", sugawaraAttributes.getDcterms_identifier()
                            .replace("sugawara","KCDC"))));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
