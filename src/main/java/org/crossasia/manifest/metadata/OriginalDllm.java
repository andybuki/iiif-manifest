package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;

public class OriginalDllm {
    @NotNull
    public static Metadata getMetadataDllmOriginal(DllmAttributes dllmAttributes) {
        ArrayList<String> dllmArrayList = new ArrayList<>();

        dllmArrayList.add("documents_id : " + dllmAttributes.getDocuments_id());
        dllmArrayList.add("documents_code_number : " +dllmAttributes.getDocuments_code_number());
        dllmArrayList.add("documents_roll : " +dllmAttributes.getDocuments_roll());
        dllmArrayList.add("documents_number_of_fascicles : " +String.valueOf(dllmAttributes.getDocuments_number_of_fascicles()));
        dllmArrayList.add("documents_number_of_folios : " +String.valueOf(dllmAttributes.getDocuments_number_of_folios()));
        dllmArrayList.add("locations_is_top_level : " +String.valueOf(dllmAttributes.getLocations_is_top_level()));
        dllmArrayList.add("locations_parent_parent_id : " +String.valueOf(dllmAttributes.getLocations_parent_parent_id()));
        dllmArrayList.add("full_location_name : " +dllmAttributes.getFull_location_name());
        dllmArrayList.add("full_location_name_lao : " +dllmAttributes.getFull_location_name_lao());
        dllmArrayList.add("documents_has_colophon : " +dllmAttributes.getDocuments_has_colophon());
        dllmArrayList.add("documents_is_illustrated : " +dllmAttributes.getDocuments_is_illustrated());
        dllmArrayList.add("documents_is_color : " +dllmAttributes.getDocuments_is_color());

        dllmArrayList.add("documents_bundle_id : " +dllmAttributes.getDocuments_bundle_id());
        dllmArrayList.add("locations_id : " +String.valueOf(dllmAttributes.getLocations_id()));
        dllmArrayList.add("locations_parent_id : " +String.valueOf(dllmAttributes.getLocations_parent_id()));
        dllmArrayList.add("documents_position_in_bundle : "+String.valueOf(dllmAttributes.getDocuments_position_in_bundle()));
        dllmArrayList.add("documents_is_complete : " +dllmAttributes.getDocuments_is_complete());
        dllmArrayList.add("documents_pages_count : " +String.valueOf(dllmAttributes.getDocuments_pages_count()));

        dllmArrayList.add("materials_name : " +dllmAttributes.getMaterials_name());
        dllmArrayList.add("materials_name_lao : " +dllmAttributes.getMaterials_name_lao());

        dllmArrayList.add("location_types_name : " +dllmAttributes.getLocation_types_name());
        dllmArrayList.add("location_types_name_lao : " +dllmAttributes.getLocation_types_name_lao());
        dllmArrayList.add("locations_rgt : " +String.valueOf(dllmAttributes.getLocations_rgt()));
        dllmArrayList.add("locations_lft : " +String.valueOf(dllmAttributes.getLocations_lft()));
        dllmArrayList.add("locations_dllm_loc_code : " +String.valueOf(dllmAttributes.getLocations_dllm_loc_code()));
        dllmArrayList.add("locations_gps_lat : " +String.valueOf(dllmAttributes.getLocations_gps_lat()));
        dllmArrayList.add("locations_gps_lon : " +String.valueOf(dllmAttributes.getLocations_gps_lon()));

        if (dllmAttributes.getAncillary_terms_roman()!= null)
            dllmArrayList.add("ancillary_terms_roman : " +String.valueOf(dllmAttributes.getAncillary_terms_roman())); //ARRAY

        if (dllmAttributes.getAncillary_terms_lao()!= null)
            dllmArrayList.add("ancillary_terms_lao : " +String.valueOf(dllmAttributes.getAncillary_terms_lao())); //ARRAY

        if (dllmAttributes.getPublic_remarks_english()!= null)
            dllmArrayList.add("public_remarks_english : " +String.valueOf(dllmAttributes.getPublic_remarks_english()));  //ARRAY

        if (dllmAttributes.getPublic_remarks_lao()!= null)
            dllmArrayList.add("public_remarks_lao : " +String.valueOf(dllmAttributes.getPublic_remarks_lao()));  //ARRAY

        if (dllmAttributes.getPublic_remarks_lao()!= null)
            dllmArrayList.add("categories_name : " +String.valueOf(dllmAttributes.getPublic_remarks_lao())); //ARRAY

        if (dllmAttributes.getCategories_name_lao()!= null)
            dllmArrayList.add("categories_name_lao : " +String.valueOf(dllmAttributes.getCategories_name_lao())); //ARRAY

        if (dllmAttributes.getLanguages()!= null)
            dllmArrayList.add("languages : " +String.valueOf(dllmAttributes.getLanguages())); //ARRAY

        if (dllmAttributes.getLanguages_lao()!= null)
            dllmArrayList.add("languages_lao : " +String.valueOf(dllmAttributes.getLanguages_lao())); //ARRAY

        if (dllmAttributes.getScripts()!= null)
            dllmArrayList.add("scripts : " +String.valueOf(dllmAttributes.getScripts())); //ARRAY

        if (dllmAttributes.getScripts_lao()!= null)
            dllmArrayList.add("scripts_lao : " +String.valueOf(dllmAttributes.getScripts_lao())); //ARRAY

        if (dllmAttributes.getTitle_search_roman()!= null)
            dllmArrayList.add("title_search_roman : " +String.valueOf(dllmAttributes.getTitle_search_roman())); //ARRAY

        if (dllmAttributes.getTitle_search_lao()!= null)
            dllmArrayList.add("title_search_lao : " +String.valueOf(dllmAttributes.getTitle_search_lao())); //ARRAY

        if (dllmAttributes.getDllm_title_roman()!= null)
            dllmArrayList.add("dllm_title_roman : " +String.valueOf(dllmAttributes.getDllm_title_roman())); //ARRAY

        if (dllmAttributes.getDllm_title_lao()!= null)
            dllmArrayList.add("dllm_title_lao : " +String.valueOf(dllmAttributes.getDllm_title_lao())); //ARRAY

        if (dllmAttributes.getPlmp_title_lao()!= null)
            dllmArrayList.add("plmp_title_lao : " +String.valueOf(dllmAttributes.getPlmp_title_lao())); //ARRAY

        dllmArrayList.add("location_documents_count : " +String.valueOf(dllmAttributes.getLocation_documents_count()));
        dllmArrayList.add("legibilities_name : " +dllmAttributes.getLegibilities_name());
        dllmArrayList.add("legibilities_name_lao : " +dllmAttributes.getLegibilities_name_lao());
        dllmArrayList.add("conditions_name : " +dllmAttributes.getConditions_name());
        dllmArrayList.add("conditions_name_lao : " +dllmAttributes.getConditions_name_lao());
        dllmArrayList.add("documents_preferred_date_system : " +dllmAttributes.getDocuments_preferred_date_system());
        dllmArrayList.add("documents_preferred_date_system_lao : " +dllmAttributes.getDocuments_preferred_date_system_lao());

        if (dllmAttributes.getDocuments_date_written()!= null)
            dllmArrayList.add("documents_date_written : " +dllmAttributes.getDocuments_date_written());

        Iterator<String> iterDllm_original = dllmArrayList.iterator();

        while (iterDllm_original.hasNext()) {
            String md = iterDllm_original.next();
            if (md==null)
                iterDllm_original.remove();
        }

        I18n dllm_org = new I18n("en", dllmArrayList);

        return new Metadata(new Label(new I18n("en", "dllm_original")),
                new Value(new I18n []{ dllm_org }));
    }
}
