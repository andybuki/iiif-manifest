package org.crossasia.manifest.sort;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JsonCompare {
    public static void main(String[] args) {
        // Create sample JSON data
        String jsonString = "[" +
                "{\"seal_id\": \"1458\", \"document_id\": \"2625\", \"multiSiegel\": \"Seal ID1458: square, black, script: 'phags pa ...\"}," +
                "{\"seal_id\": \"1459\", \"document_id\": \"2625\", \"multiSiegel\": \"Seal ID1459: square; round, black, script: Seal1: (none); ...\"}," +
                "{\"seal_id\": \"1460\", \"document_id\": \"2626\", \"multiSiegel\": \"Seal ID1460: round, black, script: Some other script ...\"}" +
                "]";

        // Parse the JSON array
        JSONArray jsonArray = new JSONArray(jsonString);

        // List to store matching multiSiegel strings for a given document_id
        List<String> multiSiegelList = new ArrayList<>();

        // Iterate through the array and compare document_id
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj1 = jsonArray.getJSONObject(i);
            String documentId1 = obj1.getString("document_id");

            // Compare with other objects in the array
            for (int j = i + 1; j < jsonArray.length(); j++) {
                JSONObject obj2 = jsonArray.getJSONObject(j);
                String documentId2 = obj2.getString("document_id");

                // If document_id is the same, add multiSiegel to the list
                if (documentId1.equals(documentId2)) {
                    multiSiegelList.add(obj1.getString("multiSiegel"));
                    multiSiegelList.add(obj2.getString("multiSiegel"));
                }
            }
        }

        // Remove duplicates from the list (optional)
        List<String> distinctMultiSiegelList = new ArrayList<>(new HashSet<>(multiSiegelList));

        // Output the list of matching multiSiegel strings
        System.out.println("List of multiSiegel strings for matching document_id:");
        for (String multiSiegel : distinctMultiSiegelList) {
            System.out.println(multiSiegel);
        }
    }
}
