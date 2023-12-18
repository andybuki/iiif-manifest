package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import org.crossasia.manifest.attributes.SugawaraAttributes;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MetadataMembers {
    public static List<Metadata> metadataMembers(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        Metadata metadata_date = Date.get(sugawaraAttributes, manifest);
        Metadata metadata_place = Place.get(sugawaraAttributes, manifest);
        Metadata metadata_collection = CollectionSugawara.get(sugawaraAttributes, manifest);
        Metadata metadata_dcterms_identifier = DctermsIdentifier.get(sugawaraAttributes, manifest);
        Metadata metadata_mods_physics_location = ModsPhysicLocation.get(sugawaraAttributes, manifest);
        Metadata metadata_sugawara_folger = SugawaraFolger.get(sugawaraAttributes, manifest);
        Metadata metadata_schema_category = SchemaCategory.get(sugawaraAttributes, manifest);
        Metadata metadata_dcterms_subject = DctermsSubject.get(sugawaraAttributes, manifest);
        Metadata metadata_dcterms_description = DctermsDescription.get(sugawaraAttributes, manifest);
        Metadata metadata_physical_data = SugawaraPhysicalData.get(sugawaraAttributes, manifest);
        Metadata metadata_phystype = SugawaraPhystype.get(sugawaraAttributes, manifest);
        Metadata metadata_sugawara_taxStamp = SugawaraTaxStamp.get(sugawaraAttributes, manifest);
        Metadata metadata_sugawara_document = SugawaraDocument.get(sugawaraAttributes, manifest);
        Metadata metadata_crossasia_dateOriginal =  CrossasiaDateOriginal.get(sugawaraAttributes, manifest);
        Metadata metadata_crossasia_yearOriginal = CrossasiaYearOriginal.get(sugawaraAttributes, manifest);
        Metadata metadata_sugawara_hijuriYear = SugawaraHijuriYear.get(sugawaraAttributes, manifest);
        Metadata metadata_sugawara_hijuriMonth = SugawaraHijuriMonth.get(sugawaraAttributes, manifest);
        Metadata metadata_sugawara_dow = SugawaraDow.get(sugawaraAttributes, manifest);
        Metadata metadata_crossasia_wholeDate = SugawaraCrossasiaWholeDate.get(sugawaraAttributes, manifest);
        Metadata metadata_crossasia_adminlevel1 = CrossasiaAdminLevel1.get(sugawaraAttributes, manifest);
        Metadata metadata_crossasia_adminlevel2 = CrossasiaAdminLevel2.get(sugawaraAttributes, manifest);
        Metadata metadata_crossasia_placeType2 = CrossasiaPlaceType2.get(sugawaraAttributes, manifest);
        Metadata metadata_crossasia_placeType3 = CrossasiaPlaceType3.get(sugawaraAttributes, manifest);
        Metadata metadata_sugawara_place = SugawaraPlace.get(sugawaraAttributes, manifest);
        Metadata metadata_sugawara_personRoleA = SugawaraPersonRoleA.get(sugawaraAttributes, manifest);
        Metadata metadata_sugawara_roleA = SugawaraRoleA.get(sugawaraAttributes, manifest);
        Metadata metadata_schema_personRoleB = SchemaPersonRoleB.get(sugawaraAttributes, manifest);
        Metadata metadata_sugawara_roleB = SugawaraRoleB.get(sugawaraAttributes, manifest);
        Metadata metadata_sugawara_seal = SugawaraSeal.get(sugawaraAttributes, manifest);
        Metadata metadata_dcterms_language = SugawaraDctermsLanguage.get(sugawaraAttributes, manifest);
        Metadata metadata_crossasia_language = SugawaraCrossasiaLanguage.get(sugawaraAttributes, manifest);
        //Metadata metadata_dc_description = SugawaraDCDescription.get(sugawaraAttributes,manifest);
        Metadata metadata_schema_citation = SchemaCitation.get(sugawaraAttributes,manifest);
        Metadata metadata_schema_grant = SchemaGrant.get(sugawaraAttributes,manifest);
        Metadata metadata_dcterms_extent = SugawaraDCTermsExtent.get(sugawaraAttributes,manifest);
        Metadata metadata_schema_abstract = SchemaAbstract.get(sugawaraAttributes, manifest);
        ArrayList<Metadata> metadataArrayList = new ArrayList<>();

        metadataArrayList.add(metadata_dcterms_identifier);
        metadataArrayList.add(metadata_mods_physics_location);
        metadataArrayList.add(metadata_sugawara_folger);
        metadataArrayList.add(metadata_schema_category);
        metadataArrayList.add(metadata_dcterms_subject);
        metadataArrayList.add(metadata_dcterms_description);
        metadataArrayList.add(metadata_physical_data);
        metadataArrayList.add(metadata_phystype);
        metadataArrayList.add(metadata_sugawara_taxStamp);
        metadataArrayList.add(metadata_sugawara_document);
        metadataArrayList.add(metadata_crossasia_dateOriginal);
        metadataArrayList.add(metadata_crossasia_yearOriginal);
        metadataArrayList.add(metadata_sugawara_hijuriYear);
        metadataArrayList.add(metadata_sugawara_hijuriMonth);
        metadataArrayList.add(metadata_sugawara_dow);
        metadataArrayList.add(metadata_crossasia_wholeDate);
        metadataArrayList.add(metadata_date);
        metadataArrayList.add(metadata_crossasia_adminlevel1);
        metadataArrayList.add(metadata_crossasia_adminlevel2);
        metadataArrayList.add(metadata_crossasia_placeType2);
        metadataArrayList.add(metadata_crossasia_placeType3);
        metadataArrayList.add(metadata_sugawara_place);
        metadataArrayList.add(metadata_place);
        metadataArrayList.add(metadata_sugawara_personRoleA);
        metadataArrayList.add(metadata_sugawara_roleA);
        metadataArrayList.add(metadata_schema_personRoleB);
        metadataArrayList.add(metadata_sugawara_roleB);
        metadataArrayList.add(metadata_sugawara_seal);
        metadataArrayList.add(metadata_dcterms_language);
        metadataArrayList.add(metadata_crossasia_language);
        metadataArrayList.add(metadata_schema_abstract);
        //metadataArrayList.add(metadata_dc_description);
        metadataArrayList.add(metadata_schema_citation);
        metadataArrayList.add(metadata_schema_grant);
        metadataArrayList.add(metadata_dcterms_extent);
        metadataArrayList.add(metadata_collection);

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
