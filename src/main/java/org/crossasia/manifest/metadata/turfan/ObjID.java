package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import java.util.List;
@Deprecated
public class ObjID {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        List<String> objectIds = turfanAttributes.getObjectIds();

        if (objectIds == null || objectIds.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("none", objectIds);

        Metadata metadata = new Metadata(
                new Label("none", "smb:objId"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
