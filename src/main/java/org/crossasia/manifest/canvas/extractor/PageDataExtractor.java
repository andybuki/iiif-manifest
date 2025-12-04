package org.crossasia.manifest.canvas.extractor;

import org.crossasia.manifest.canvas.model.PageData;
import org.json.JSONArray;
import org.json.JSONObject;

public class PageDataExtractor {

    /**
     * Extracts page data from a JSON object
     */
    public static PageData extract(JSONObject pagesObj) {
        PageData data = new PageData();

        // Simple string fields
        extractStringField(pagesObj, "id", data::setId);
        extractStringField(pagesObj, "name", data::setName);
        extractStringField(pagesObj, "position", data::setPosition);
        extractStringField(pagesObj, "dc:identifier", value -> data.setDcIdentifier(value.trim()));
        extractStringField(pagesObj, "dc:title", value -> data.setTitle(value.trim()));
        extractStringField(pagesObj, "dc:description", value -> data.setDescription(value.trim()));
        extractStringField(pagesObj, "dc:place", value -> data.setPlace(value.trim()));
        extractStringField(pagesObj, "schema:collection", value -> data.setCollection(value.trim()));
        extractStringField(pagesObj, "schema:comment", value -> data.setComment(value.trim()));
        extractStringField(pagesObj, "schema:image", value -> data.setImage(value.trim()));
        extractStringField(pagesObj, "schema:identifier", value -> data.setSchemaIdentifier(value.trim()));
        extractStringField(pagesObj, "dcterms:source", value -> data.setSource(value.trim()));
        extractStringField(pagesObj, "turfan:placeDetail", value -> data.setPlaceDetail(value.trim()));
        extractStringField(pagesObj, "turfan:noteDate", value -> data.setNoteDate(value.trim()));
        extractStringField(pagesObj, "turfan:number_page", value -> data.setTurfanNumberPage(value.trim()));
        extractStringField(pagesObj, "turfan:sender", value -> data.setSender(value.trim()));
        extractStringField(pagesObj, "turfan:recipient", value -> data.setRecipient(value.trim()));
        extractStringField(pagesObj, "dcndl:number", value -> data.setDcndlNumber(value.trim()));
        extractStringField(pagesObj, "alben", value -> data.setAlben(value.trim()));
        extractStringField(pagesObj, "schema:keyword", value -> data.setKeyword(value.trim()));

        // Date with normalization
        if (pagesObj.has("dc:date")) {
            String date = pagesObj.get("dc:date").toString().trim();
            data.setDate(normalizeDateString(date));
        }

        // Year with normalization
        if (pagesObj.has("schema:year")) {
            String year = pagesObj.get("schema:year").toString().trim();
            data.setYear(normalizeDateString(year));
        }

        // Fields that can be String or JSONArray
        extractStringOrArray(pagesObj, "schema:person", data::setPerson, data::setPersonArray);
        extractStringOrArray(pagesObj, "schema:index", data::setIndex, data::setIndexArray);
        extractStringOrArray(pagesObj, "dc:subject", data::setSubject, data::setSubjectArray);
        extractStringOrArray(pagesObj, "dcterms:spatial", data::setSpatial, data::setSpatialArray);
        extractStringOrArray(pagesObj, "dcterms:medium", data::setMedium, data::setMediumArray);

        return data;
    }

    /**
     * Helper to extract string fields safely
     */
    private static void extractStringField(JSONObject obj, String key, java.util.function.Consumer<String> setter) {
        if (obj.has(key)) {
            setter.accept(obj.get(key).toString());
        }
    }

    /**
     * Helper to extract fields that can be either String or JSONArray
     */
    private static void extractStringOrArray(
            JSONObject obj,
            String key,
            java.util.function.Consumer<String> stringSetter,
            java.util.function.Consumer<JSONArray> arraySetter) {

        if (obj.has(key)) {
            Object value = obj.get(key);
            if (value instanceof String) {
                stringSetter.accept(value.toString().trim());
            } else if (value instanceof JSONArray) {
                arraySetter.accept((JSONArray) value);
            }
        }
    }

    /**
     * Normalizes date strings (O.Dat., o.Dat, o.Da -> o.Dat.)
     */
    private static String normalizeDateString(String date) {
        if (date.equals("O.Dat.") || date.equals("o.Dat") || date.equals("o.Da")) {
            return "o.Dat.";
        }
        return date;
    }
}