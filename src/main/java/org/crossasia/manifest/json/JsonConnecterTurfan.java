package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.domain.DateInfo;
import org.crossasia.manifest.attributes.domain.PlaceInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConnecterTurfan {



    public static void title (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:title")) {
            turfanAttributes.setTitle((String) jsonObj.get("dc:title"));
        }
    }

    public static void date (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:date")) {
            DateInfo dateInfo = turfanAttributes.getDateInfo();
            turfanAttributes.getDateInfo().setDates(JsonConverter.getStringList(jsonObj, "dc:date")
            );
        }
    }

    public static void keyword (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:keyword")) {
            turfanAttributes.setKeywords(JsonConverter.getStringList(jsonObj, "schema:keyword"));
        }
    }

    public static void collection (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:collection")) {
            turfanAttributes.setCollections(JsonConverter.getStringList(jsonObj, "schema:collection"));
        }
    }

    public static void identifier (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:identifier")) {
            turfanAttributes.setIdentifier((String) jsonObj.get("dc:identifier"));
        }
    }

    public static void type (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("turfan:type")) {
            turfanAttributes.setTypes(JsonConverter.getStringList(jsonObj, "turfan:type"));
        }
    }

    public static void placeDetail2 (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("turfan:placeDetail2")) {
            PlaceInfo placeInfo = turfanAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                turfanAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlaceDetail2(JsonConverter.getString(jsonObj, "turfan:placeDetail2"));
        }
    }

    public static void siteID (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("turfan:siteID")) {
            turfanAttributes.setSiteIds(JsonConverter.getStringList(jsonObj, "turfan:siteID"));
        }
    }

    public static void siteNameGer (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("turfan:siteNameGer")) {
            turfanAttributes.setSiteNamesGerman(JsonConverter.getStringList(jsonObj, "turfan:siteNamesGer"));
        }
    }

    public static void dsrLink (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("turfan:dsrLink")) {
            turfanAttributes.setDsrLinks(JsonConverter.getStringList(jsonObj, "turfan:dsrLink"));
        }
    }

    public static void placeDetail (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("turfan:placeDetail")) {
            PlaceInfo placeInfo = turfanAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                turfanAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlaceDetail(JsonConverter.getString(jsonObj, "turfan:placeDetail"));
        }
    }

    public static void place (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:place")) {
            PlaceInfo placeInfo = turfanAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                turfanAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlace(JsonConverter.getString(jsonObj, "dc:place"));
        }
    }

    public static void invnumber (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("turfan:invNumber")) {
            turfanAttributes.setInventoryNumbers(JsonConverter.getStringList(jsonObj, "turfan:invNumber"));
        }
    }

    public static void seeAlso (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("rdfs:seeAlso")) {
            turfanAttributes.setSeeAlso(JsonConverter.getStringList(jsonObj, "rdfs:seeAlso"));
        }
    }

    public static void objId (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("smb:objId")) {
            turfanAttributes.setObjectIds(JsonConverter.getStringList(jsonObj, "smb:objId"));
        }
    }

    public static void langeBeschreibung (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("smb:langeBeschreibung")) {
            turfanAttributes.setLongDescription(JsonConverter.getString(jsonObj, "smb:langeBeschreibung"));
        }
    }

    public static void georgBezug (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("smb:GeogrBezug")) {
            PlaceInfo placeInfo = turfanAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                turfanAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setGeographicReferences(JsonConverter.getStringList(jsonObj, "smb:GeogrBezug"));
        }
    }

    public static void description (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:description")) {
            if (jsonObj.get("dcterms:description") instanceof String)
                turfanAttributes.setDescription((String) jsonObj.get("dcterms:description"));
            else
                turfanAttributes.setDescriptions(JsonConverter.getStringList(jsonObj, "dcterms:description"));
        }
    }

    public static void rechercheLink (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("turfan:smbLink")) {
            turfanAttributes.setRechercheLink((String) jsonObj.get("turfan:smbLink"));
        }
    }

    public static void noteDate (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("turfan:noteDate")) {
            DateInfo dateInfo = turfanAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                turfanAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setNoteDate(JsonConverter.getString(jsonObj, "turfan:noteDate"));
        }
    }

    public static void noteIdentifier (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("turfan:noteIdentifier")) {
            turfanAttributes.setNoteIdentifier((String) jsonObj.get("turfan:noteIdentifier"));
        }
    }

    public static void comment (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:comment")) {
            turfanAttributes.setComment((String) jsonObj.get("schema:comment"));
        }
    }

    public static void creator (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:creator")) {
            turfanAttributes.setCreator((String) jsonObj.get("dc:creator"));
        }
    }

    public static void noteCreator (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("turfan:noteCreator")) {
            turfanAttributes.setNoteCreator((String) jsonObj.get("turfan:noteCreator"));
        }
    }

    public static void format (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:format")) {
            turfanAttributes.setFormat((String) jsonObj.get("dcterms:format"));
        }
    }

    public static void source (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:source")) {
            turfanAttributes.setSource((String) jsonObj.get("dcterms:source"));
        }
    }

    public static void creditText (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:creditText")) {
            turfanAttributes.setCreditText((String) jsonObj.get("schema:creditText"));
        }
    }

    public static void schemaIdentifier (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:identifier")) {
            turfanAttributes.setSchemaIdentifiers(JsonConverter.getStringList(jsonObj, "schema:identifier"));
        }
    }

    public static void requirements (CollectionAttributes turfanAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:requirements")) {
            turfanAttributes.setRequirements((String) jsonObj.get("schema:requirements"));
        }
    }

}
