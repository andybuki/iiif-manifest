package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class DctermsSubject {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        List<String> subjects = sugawaraAttributes.getSubjects();

        if (subjects != null && !subjects.isEmpty()) {
            I18n i18n = new I18n("en", subjects);

            Metadata metadata = new Metadata(
                    new Label("en", "dcterms:subject"),
                    new Value(new I18n[]{i18n})
            );

            return metadata;

        }
        return null;
    }
}
