package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;

import java.util.ArrayList;
import java.util.List;

public class Extent {
    public static Metadata getMetadataExtent(DllmAttributes dllmAttributes) {

        Metadata metadata_extent = null;
        int number_of_digital_images = 0;
        int number_of_fascicles = 0;
        int number_of_folios = 0;

        StringBuilder extentBuilder = new StringBuilder();

        if (dllmAttributes.getDocuments_number_of_fascicles()!=0) {
            number_of_fascicles =  dllmAttributes.getDocuments_number_of_fascicles();
            extentBuilder.append(number_of_fascicles + " fascicle(s), ");
        }

        if (dllmAttributes.getDocuments_number_of_folios()!=0) {
            number_of_folios =  dllmAttributes.getDocuments_number_of_folios();
            extentBuilder.append(number_of_folios +" folio(s) ");
        }
        //16 fascicle(s), 342 folio(s)(99 img.)
        if (dllmAttributes.getDocuments_pages_count()!=0) {
            number_of_digital_images = dllmAttributes.getDocuments_pages_count();
            extentBuilder.append("(" +number_of_digital_images+" img.)");
        }
        //extentBuilder.append(extent);
        metadata_extent = new Metadata(new Label(new I18n("en", "dc:extent")),
                new Value(new I18n("none", extentBuilder.toString())));
        return metadata_extent;

    }
}
