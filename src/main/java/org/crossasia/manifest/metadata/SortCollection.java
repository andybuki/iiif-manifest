package org.crossasia.manifest.metadata;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCollection {

    private static final Logger logger = LoggerFactory.getLogger(SortCollection.class);
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/presentation/result3/collection2.json");
        //JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));
        JSONArray jsonArr = new JSONArray(file);
        JSONArray sortedJsonArray = new JSONArray();

        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < jsonArr.length(); i++) {
            jsonValues.add(jsonArr.getJSONObject(i));
        }
        Collections.sort( jsonValues, new Comparator<JSONObject>() {
            //You can change "Name" with "ID" if you want to sort by ID
            private static final String KEY_NAME = "Name";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                //int id = parseInt(dllmAttributes.getDocuments_id().replace("dllm_",""));
                String valA = new String();
                String valB = new String();

                try {
                    valA = (String) a.get(KEY_NAME);
                    valB = (String) b.get(KEY_NAME);
                }
                catch (JSONException e) {
                    logger.warn("Failed to extract '{}' field for comparison. Using empty string.", KEY_NAME, e);
                    valA = "";
                    valB = "";
                }

                return valA.compareTo(valB);
                //if you want to change the sort order, simply use the following:
                //return -valA.compareTo(valB);
            }
        });

        for (int i = 0; i < jsonArr.length(); i++) {
            sortedJsonArray.put(jsonValues.get(i));
        }
    }
}
