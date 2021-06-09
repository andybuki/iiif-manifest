package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.DllmAttributes;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JsonChecker {

    public static void jsonObjects() throws FileNotFoundException {
        DllmAttributes dllmAttributes = new DllmAttributes();
        File absolutePath = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/presentation/raw/");

        File dir = new File(String.valueOf(absolutePath));
        File[] filesInDir = dir.listFiles();


        for (File file : filesInDir) {
            StringBuilder sb = new StringBuilder();
            JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

            if (jsonObj.has("titles")) {
                //dllmAttributes.getDllm_title_roman( jsonObj.get("titles"));
            }
        }
    }
}