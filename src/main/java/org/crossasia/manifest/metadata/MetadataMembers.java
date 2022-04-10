package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;
import java.util.Iterator;

public class MetadataMembers {
   public static void metadataMembers(CollectionAttributes dllmAttributes, Manifest manifest) {
        //Metadata metadata_title = getMetadataTitlesRomanThai(dllmAttributes, manifest);
        Metadata metadata_title = Title.getMetadataTitle(dllmAttributes);
        //Metadata metadata_title = Title.getMetadataPhotoTitle(dllmAttributes);
        Metadata metadata_language = Language.getMetadataLanguageRomanThai(dllmAttributes);

        Metadata metadata_documentsID = DocumentsID.getMetadataDocumentsID(dllmAttributes);
        Metadata metadata_documentsCodeNumber = CodeNumber.getMetadataDocumentsCodeNumber(dllmAttributes);
        Metadata metadata_documents_roll = DocumentsRoll.getMetadataDocumentsRoll(dllmAttributes);

        Metadata metadata_extent = ExtentMethod.getMetadataExtentMethod(dllmAttributes);
        Metadata metadata_description = Description.getMetadataDescription(dllmAttributes);
        Metadata metadata_in_collection= InCollection.getInCollection(dllmAttributes);

        Metadata metadataDllmOriginal = OriginalDllm.getMetadataDllmOriginal(dllmAttributes);
        Metadata metadata_place = Places.getMetadataPlaces(dllmAttributes);
        Metadata metadata_full_location_name = FullLocationName.getMetadataFullLocationName(dllmAttributes);

        Metadata metadata_has_colophon = HasColophon.getMetadataHasColophon(dllmAttributes);
        Metadata metadata_is_illustrated = IsIllustrated.getMetadataIsIllustrated(dllmAttributes);
        Metadata metadata_is_color= IsColor.getMetadataIsColor(dllmAttributes);
        Metadata metadata_bundle_id= BundleID.getMetadataBundleID(dllmAttributes);

        Metadata metadata_is_complete= IsComplete.getMetadataIsComplete(dllmAttributes);
        Metadata metadata_pages_count= PagesCount.getMetadataPagesCount(dllmAttributes);
        Metadata metadata_material= Material.getMetadataMaterial(dllmAttributes);
        Metadata metadata_location_types_name= LocationTypes.getMetadataLocationTypesName(dllmAttributes);

        Metadata metadata_latitude= LatLon.getMetadataLatitude(dllmAttributes);
        Metadata metadata_longitude= LatLon.getMetadataLongitude(dllmAttributes);
        Metadata metadata_map= Map.getMapLink(dllmAttributes);
        Metadata metadata_keywords= Keywords.getMetadataKeywords(dllmAttributes);
        Metadata metadata_categories= Categories.getMetadataCategories(dllmAttributes);

        Metadata metadata_script= Script.getMetadataScript(dllmAttributes);
        Metadata metadata_index= Index.getMetadataIndex(dllmAttributes);
        Metadata metadata_legibilities= Legibilities.getMetadataLegibilities(dllmAttributes);
        Metadata metadata_conditions= Conditions.getMetadataConditions(dllmAttributes);

        Metadata metadata_date= Date.getMetadataDate(dllmAttributes);
        Metadata metadata_date_original= DateOriginal.getMetadataDateOriginal(dllmAttributes);
        Metadata metadata_microfilms= Microfilm.getMetadataMicrofilm(dllmAttributes);
        Metadata metadata_extent_collection= Extent.getMetadataExtent(dllmAttributes);

        Metadata metadata_alternative_collection= Alternative.getMetadataAlternative(dllmAttributes);
        Metadata metadata_exact_collection= Exact.getMetadataExact(dllmAttributes);
        Metadata metadata_ce_year_collection= Ce_Year.getMetadataCeYear(dllmAttributes);
        Metadata metadata_date_original_lana_collection= DateOriginalLana.getMetadataDateOriginal(dllmAttributes);

        Metadata metadata_position= Position.getMetadataPosition(dllmAttributes);
        Metadata metadata_website= Website.getMetadataWebsite(dllmAttributes);
        Metadata metadata_address= Address.getMetadataAddress(dllmAttributes);
        Metadata metadata_subject= Subject.getMetadataSubject(dllmAttributes);

        Metadata metadata_image= Image.getMetadataImage(dllmAttributes);

        ArrayList<Metadata> metadataArrayList = new ArrayList<>();

        metadataArrayList.add(metadata_title);
        metadataArrayList.add(metadata_language);
        metadataArrayList.add(metadata_documentsID);

        metadataArrayList.add(metadata_documentsCodeNumber);
        metadataArrayList.add(metadata_documents_roll);
        metadataArrayList.add(metadata_extent);
        metadataArrayList.add(metadata_place);

        metadataArrayList.add(metadata_full_location_name);
        metadataArrayList.add(metadataDllmOriginal);
        metadataArrayList.add(metadata_description);
        metadataArrayList.add(metadata_has_colophon);

        metadataArrayList.add(metadata_is_illustrated);
        metadataArrayList.add(metadata_is_color);
        metadataArrayList.add(metadata_bundle_id);
        metadataArrayList.add(metadata_is_complete);
        metadataArrayList.add(metadata_in_collection);

        metadataArrayList.add(metadata_pages_count);
        metadataArrayList.add(metadata_material);
        metadataArrayList.add(metadata_location_types_name);

        metadataArrayList.add(metadata_latitude);
        metadataArrayList.add(metadata_longitude);
        metadataArrayList.add(metadata_keywords);
        metadataArrayList.add(metadata_categories);

        metadataArrayList.add(metadata_script);
        metadataArrayList.add(metadata_index);
        metadataArrayList.add(metadata_legibilities);
        metadataArrayList.add(metadata_conditions);

        metadataArrayList.add(metadata_date);
        metadataArrayList.add(metadata_date_original);
        metadataArrayList.add(metadata_microfilms);
        metadataArrayList.add(metadata_map);
        //metadataArrayList.add(metadata_extent_collection);

        metadataArrayList.add(metadata_alternative_collection);
        metadataArrayList.add(metadata_exact_collection);
        metadataArrayList.add(metadata_ce_year_collection);
        //metadataArrayList.add(metadata_date_original_lana_collection);
        metadataArrayList.add(metadata_position);

        metadataArrayList.add(metadata_website);
        metadataArrayList.add(metadata_address);
        metadataArrayList.add(metadata_subject);

        metadataArrayList.add(metadata_image);

        Iterator<Metadata> iter = metadataArrayList.iterator();

        while (iter.hasNext()) {
            Metadata md = iter.next();
            if (md==null)
                iter.remove();
        }
        manifest.setMetadata(metadataArrayList);
    }
}
