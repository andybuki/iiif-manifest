package org.crossasia.manifest.curlscript;

import org.json.simple.parser.JSONParser;

import java.io.*;

public class ManifestCurlSchript {
    public static void main(String[] args) throws IOException {
        BufferedWriter out = null;
        try {
            String manifests = "/data/dlmnt/fedora/manifests";
            File dirManifests = new File(manifests);
            File[] filesInManifests = dirManifests.listFiles();

            String quote = "\u005c\u0022";
            out = new BufferedWriter(new FileWriter("/data/dlmnt/fedora/manifests/files.sh"));
            String cURLink = "";

            for (File file : filesInManifests) {
                String fileName = file.toString().replace(manifests+"/", "").replace(".json", "");
                if (fileName.equals(manifests + "/files.sh")) {
                    System.out.println("text file");
                } else {
                    try {
                            cURLink = "curl -u fedoraAdmin:fedoraAdmin -i -X PUT" + " --data-binary @" + fileName + ".json " + " -H " +quote+ "Content-Type: application/json" + quote + " -H "+ quote+"Content-Disposition: attachment; filename=" +fileName+".json"+ quote + " "  + "http://b-lx0005.sbb.spk-berlin.de/fcrepo/rest/dlntm/" + fileName +"/manifest";

                        //curl -u fedoraAdmin:fedoraAdmin -i -X PUT --data-binary @manifest.json -H "Content-Type: application/json" -H "Content-Disposition: attachment; filename=manifest.json" http://b-lx0005.sbb.spk-berlin.de/fcrepo/rest/japonica/1/manifest
                        out.write(cURLink + "\r\n");
                        }catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                    System.out.println(fileName );
                }
            }

            System.out.println("conversion is done");
        } catch (IOException e) {
            System.out.println("Exception ");
        } finally {
            out.close();
        }
    }
}
