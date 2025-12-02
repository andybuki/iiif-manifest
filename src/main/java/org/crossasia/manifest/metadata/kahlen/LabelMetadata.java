package org.crossasia.manifest.metadata.kahlen;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.CollectionAttributes;

/**
 * Helper class for extracting Kahlen collection titles.
 *
 * @deprecated This class provides backward compatibility.
 *             Consider using MetadataBuilder for new implementations.
 */
@Deprecated
public class LabelMetadata {
    /**
     * Extracts and formats the title from collection attributes.
     *
     * @param collectionAttributes the collection attributes containing the title
     * @return I18n object with the title, or "Untitled" if no title is present
     */
    public static I18n getLabelTitle(CollectionAttributes collectionAttributes) {
        String title = collectionAttributes.getTitle();

        if (title == null || title.isEmpty()) {
            title = "Untitled";
        }

        return new I18n("en", title);
    }
}
