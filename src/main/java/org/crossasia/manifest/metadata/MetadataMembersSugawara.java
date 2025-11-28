package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;

import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.metadata.sugawara.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MetadataMembersSugawara {
    public static List<Metadata> metadataMembersSugawara(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        Metadata metadata_place = Place.get(sugawaraAttributes, manifest);
        Metadata metadata_title = SugawaraPhystype.get(sugawaraAttributes, manifest);
        Metadata metadata_date = Date.get(sugawaraAttributes, manifest);
        Metadata metadata_subject = SugawaraRoleA.get(sugawaraAttributes, manifest);
        Metadata metadata_index = SugawaraRoleB.get(sugawaraAttributes, manifest);
        Metadata metadata_keyword = SugawaraSeal.get(sugawaraAttributes, manifest);
        Metadata metadata_identifier = SugawaraTaxStamp.get(sugawaraAttributes, manifest);

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
