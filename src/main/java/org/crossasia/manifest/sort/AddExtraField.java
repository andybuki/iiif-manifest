package org.crossasia.manifest.sort;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddExtraField {
    public static void main(String[] args) throws FileNotFoundException {
        File in = new File("C:\\Colllections\\dtab\\manifests\\split\\files_original_plus_OLD_seals\\");
        File directory = new File(String.valueOf(in));
        File[] filesDir = directory.listFiles();
        PrintStream out = null;
        File seal = new File("C:\\Colllections\\dtab\\manifests\\sealDataGroupedNew2_AGAIN.json");

        JSONArray jsonArraySeal = new JSONArray(new JSONTokener(new FileInputStream(seal)));

            for (File file : filesDir) {
                File f = new File("C:\\Colllections\\dtab\\manifests\\split\\final_with_seals2\\");
                JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));
                String document_id = "";

                if (jsonObj.has("id")) {
                    document_id = jsonObj.getString("id");
                }

                for (int i = 0; i < jsonArraySeal.length(); i++) {
                    JSONObject jsonObjectSeal = jsonArraySeal.getJSONObject(i);
                    Integer sealId = jsonObjectSeal.getInt("document_id");

                    //String sealData = "";
                    //List<String> sealArray = new ArrayList<>();
                    JSONArray sealdocIDArray = null;
                    JSONArray sealImageFilesArray = null;
                    JSONArray sealInfoArray = null;
                    JSONArray sealFormArray = null;
                    JSONArray sealColorArray = null;
                    JSONArray sealScriptArray = null;
                    JSONArray sealCompareArray = null;


                    if (jsonObjectSeal.has("seal_docID")) {
                        sealdocIDArray = jsonObjectSeal.getJSONArray("seal_docID");
                    }

                    if (jsonObjectSeal.has("seal_image_files")) {
                        sealImageFilesArray = jsonObjectSeal.getJSONArray("seal_image_files");
                    }

                    if (jsonObjectSeal.has("seal_info")) {
                        sealInfoArray = jsonObjectSeal.getJSONArray("seal_info");
                    }

                    if (jsonObjectSeal.has("seal_form")) {
                        sealFormArray = jsonObjectSeal.getJSONArray("seal_form");
                    }

                    if (jsonObjectSeal.has("seal_color")) {
                        sealColorArray = jsonObjectSeal.getJSONArray("seal_color");
                    }

                    if (jsonObjectSeal.has("seal_script")) {
                        sealScriptArray = jsonObjectSeal.getJSONArray("seal_script");
                    }

                    if (jsonObjectSeal.has("seal_compare")) {
                        sealCompareArray = jsonObjectSeal.getJSONArray("seal_compare");
                    }

                    /*if (jsonObjectSeal.has("multiSiegel")) {
                        sealData = jsonObjectSeal.getString("multiSiegel");
                        if (sealData.contains("##")) {
                          String []  arr =  sealData.split("##");
                          for (String str: arr)
                              sealArray.add(str);
                        } else
                            sealArray.add(sealData);
                    }*/

                    if (document_id.equals(""+sealId)) {
                        jsonObj.put("dtab:seal_docID", sealdocIDArray);
                        jsonObj.put("dtab:seal_image_files", sealImageFilesArray);
                        jsonObj.put("dtab:seal_info", sealInfoArray);

                        jsonObj.put("dtab:seal_compare", sealCompareArray);
                        jsonObj.put("dtab:seal_script", sealScriptArray);
                        jsonObj.put("dtab:seal_color", sealColorArray);
                        jsonObj.put("dtab:seal_form", sealFormArray);
                        System.out.println(sealdocIDArray);
                    }
                }
                out = new PrintStream(new FileOutputStream(f + "\\" + file.getName()));
                out.println(jsonObj);
        }
    }
}
