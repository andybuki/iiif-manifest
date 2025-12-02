package org.crossasia.manifest.sort;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

    private static final Logger logger = LoggerFactory.getLogger(Sort.class);
    public static void main(String[] args) throws FileNotFoundException {
        File in = new File("C:\\Colllections\\dtab\\manifests\\split\\test\\");
        File directory = new File(String.valueOf(in));
        File[] filesDir = directory.listFiles();
        PrintStream out = null;
        for (File file : filesDir) {

            File f = new File("C:\\Colllections\\dtab\\manifests\\split\\files_original3\\");

            JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));
            JSONArray jsonArrayPages = jsonObj.getJSONArray("pages");

            String jsonArrStr = "" +
                    "[{\"name\":\"/IMAGES/images_tibetan_documents/image46/0449e_KHD_S111_x-x_x-x_x.jpg\",\"alben\":\"0449e_KHD_S111_x-x_x-x_x.jpg\",\"id\":\"3070\",\"position\":1},{\"name\":\"/IMAGES/images_tibetan_documents/image46/0449b_KHD_S111_x-x_x-x_x.jpg\",\"alben\":\"0449b_KHD_S111_x-x_x-x_x.jpg\",\"id\":\"3070\",\"position\":2},{\"name\":\"/IMAGES/images_tibetan_documents/image46/0449c_KHD_S111_x-x_x-x_x.jpg\",\"alben\":\"0449c_KHD_S111_x-x_x-x_x.jpg\",\"id\":\"3070\",\"position\":3},{\"name\":\"/IMAGES/images_tibetan_documents/image46/0449a_KHD_S111_x-x_x-x_x.jpg\",\"alben\":\"0449a_KHD_S111_x-x_x-x_x.jpg\",\"id\":\"3070\",\"position\":4},{\"name\":\"/IMAGES/images_tibetan_documents/image46/0449d_KHD_S111_x-x_x-x_x.jpg\",\"alben\":\"0449d_KHD_S111_x-x_x-x_x.jpg\",\"id\":\"3070\",\"position\":5},{\"name\":\"IMAGES/images_tibetan_documents/image46/0449c_KHD_S111_x-x_x-x_x.jpg\",\"alben\":\"0449c_KHD_S111_x-x_x-x_x.jpg\",\"id\":\"3070\",\"position\":6},{\"name\":\"IMAGES/images_tibetan_documents/image46/0449d_KHD_S111_x-x_x-x_x.jpg\",\"alben\":\"0449d_KHD_S111_x-x_x-x_x.jpg\",\"id\":\"3070\",\"position\":7},{\"name\":\"Seals/all_seals/0449d_KHD_S111_x-x_x-x_x_Seal.jpg\",\"alben\":\"0449d_KHD_S111_x-x_x-x_x_Seal.jpg\",\"id\":\"3070\",\"position\":8}]";

            //JSONArray jsonArr = new JSONArray(jsonArrayPages);
            JSONArray sortedJsonArray = new JSONArray();
            String imageName = null;
            List<JSONObject> jsonValues = new ArrayList<JSONObject>();
            for (int i = 0; i < jsonArrayPages.length(); i++) {
                jsonValues.add(jsonArrayPages.getJSONObject(i));

            }

            Collections.sort( jsonValues, new Comparator<JSONObject>() {
                //You can change "Name" with "ID" if you want to sort by ID
                private static final String KEY_NAME = "name";
                private static final String KEY_NAME_ALBEN = "alben";

                @Override
                public int compare(JSONObject a, JSONObject b) {
                    String valA = new String();
                    String valB = new String();

                    String albenA = new String();
                    String albenB = new String();

                    try {
                        valA = (String) a.get(KEY_NAME);
                        valB = (String) b.get(KEY_NAME);

                        albenA = (String) a.get(KEY_NAME_ALBEN);
                        albenB = (String) b.get(KEY_NAME_ALBEN);

                    }
                    catch (JSONException e) {
                        logger.warn("Failed to extract sorting fields. Using empty strings for comparison.", e);
                        valA = "";
                        valB = "";
                        albenA = "";
                        albenB = "";
                    }
/*
                    if (valA.contains("IMAGES")  && (albenA.contains("a") || albenA.contains("b") || albenB.contains("a")|| albenB.contains("b"))) {
                        return valA.compareTo(valB);
                    } else if (valA.contains("IMAGES")  && (albenA.contains("a") )) {
                        return -valA.compareTo(valB);
                    } else if (valA.contains("IMAGES")  && valB.contains("IMAGES")) {
                        return -valA.compareTo(valB);
                    } else
                        return valA.compareTo(valB);
*/
                    //if you want to change the sort order, simply use the following:
                    return valA.compareTo(valB);
                   // return 0;
                }
            });

            for (int i = 0; i < jsonArrayPages.length(); i++) {
                sortedJsonArray.put(jsonValues.get(i));


                /*sortedJsonArray.put(jsonValues.get(1));
                sortedJsonArray.put(jsonValues.get(0));
                sortedJsonArray.put(jsonValues.get(2));
                sortedJsonArray.put(jsonValues.get(3));
                sortedJsonArray.put(jsonValues.get(4));*/

                if (jsonArrayPages.length()>=20) {
                    String image= (String) jsonValues.get(0).get("name");
                    String image2= (String) jsonValues.get(1).get("name");
                    String image3= (String) jsonValues.get(2).get("name");

                    String alben= (String) jsonValues.get(0).get("alben");
                    String alben2= (String) jsonValues.get(1).get("alben");
                    /*String alben3 = (String) jsonValues.get(2).get("alben");
                    String alben4 = (String) jsonValues.get(3).get("alben");
                    String alben5 = (String) jsonValues.get(4).get("alben");
                    String alben6 = (String) jsonValues.get(5).get("alben");*/
                    //String alben7 = (String) jsonValues.get(6).get("alben");

                if (image.contains("IMAGES") && image2.contains("IMAGES") && image3.contains("IMAGES") ) {
                    //if (!alben.contains("a") && !alben.contains("b") && alben2.contains("a") && !alben2.contains("b")) //&& !alben.contains("c") && !alben.contains("d") && alben2.contains("a"))// && alben3.contains("b") && alben4.contains("c")) //&& !alben5.contains("a") && !alben6.contains("a"))
                           /* && !alben7.contains("a")*/ //{
                        imageName="OK";
                   // }
                }
            }
        }
            jsonObj.put("pages",sortedJsonArray);
            int length = sortedJsonArray.length();
            if (length>=20 && imageName=="OK"){
                logger.info("{}-{}", jsonObj.get("id"), length);
            }
            out = new PrintStream(new FileOutputStream(f+"\\"+ file.getName()));
            out.println(jsonObj);
            //timer.sleep(100);
            //File  newFile = new File(out+"\\"+ file.getName());
            //System.out.println( jsonObj.get("id") +"-"+ length);
        }

    }
}
