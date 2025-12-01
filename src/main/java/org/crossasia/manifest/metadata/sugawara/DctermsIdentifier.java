package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.PlaceInfo;
@Deprecated
public class DctermsIdentifier {

    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        String identifier = sugawaraAttributes.getIdentifier();
        if (identifier == null || identifier.isEmpty()) {
            return null;
        }

        return new Metadata(new Label( "none","dc:identifier"),
                    new Value( new I18n("none", identifier
                            .replace("sugawara","KCDC"))));


    }
}
