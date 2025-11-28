package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import org.crossasia.manifest.attributes.CollectionAttributes;


import org.crossasia.manifest.metadata.turfan.*;
import org.crossasia.manifest.metadata.turfan.Date;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MetadataMembersTurfan {
    public static List<Metadata> metadataMembersTurfan(CollectionAttributes turfanAttributes, Manifest manifest) {
        Metadata metadata_place = Comment.get(turfanAttributes, manifest);
        Metadata metadata_title = Creator.get(turfanAttributes, manifest);
        Metadata metadata_date = CreditText.get(turfanAttributes, manifest);
        //Metadata metadata_subject = Date.get(turfanAttributes, manifest);
        Metadata metadata_index = Description.get(turfanAttributes, manifest);
        Metadata metadata_keyword = DsrLink.get(turfanAttributes, manifest);
        Metadata metadata_identifier = Format.get(turfanAttributes, manifest);

        ArrayList<Metadata> metadataArrayList = new ArrayList<>();
        metadataArrayList.add(metadata_identifier);
        metadataArrayList.add(metadata_place);
        metadataArrayList.add(metadata_title);
        metadataArrayList.add(metadata_date);
        //metadataArrayList.add(metadata_subject);
        metadataArrayList.add(metadata_index);
        metadataArrayList.add(metadata_keyword);

        Iterator<Metadata> iter = metadataArrayList.iterator();

        while (iter.hasNext()) {
            Metadata md = iter.next();
            if (md==null)
                iter.remove();
        }
        manifest.setMetadata(metadataArrayList);
        return metadataArrayList;
    }
}
