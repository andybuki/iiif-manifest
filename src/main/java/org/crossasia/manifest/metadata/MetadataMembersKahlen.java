package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;

import org.crossasia.manifest.attributes.KahlenAttributes;
import org.crossasia.manifest.metadata.kahlen.*;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MetadataMembersKahlen {
    public static List<Metadata> metadataMembersKahlen(KahlenAttributes kahlenAttributes, Manifest manifest) {
        Metadata metadata_place = Place.get(kahlenAttributes, manifest);
        Metadata metadata_title = Title.get(kahlenAttributes, manifest);
        Metadata metadata_date = Date.get(kahlenAttributes, manifest);
        Metadata metadata_subject = Subject.get(kahlenAttributes, manifest);
        Metadata metadata_index = Index.get(kahlenAttributes, manifest);
        Metadata metadata_keyword = Keywords.get(kahlenAttributes, manifest);
        Metadata metadata_identifier = Identifier.get(kahlenAttributes, manifest);

        ArrayList<Metadata> metadataArrayList = new ArrayList<>();
        metadataArrayList.add(metadata_identifier);
        metadataArrayList.add(metadata_place);
        metadataArrayList.add(metadata_title);
        metadataArrayList.add(metadata_date);
        metadataArrayList.add(metadata_subject);
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
