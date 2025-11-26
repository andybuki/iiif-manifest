package org.crossasia.manifest.sort;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

 class Document {
    @JsonProperty("document_id")
    private int documentId;

    @JsonProperty("multiSiegel")
    private String multiSiegel;

    // Default constructor (required for Jackson)
    public Document() {}

    // Parameterized constructor
    public Document(int documentId, String multiSiegel) {
        this.documentId = documentId;
        this.multiSiegel = multiSiegel;
    }

    // Getters and Setters
    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getMultiSiegel() {
        return multiSiegel;
    }

    public void setMultiSiegel(String multiSiegel) {
        this.multiSiegel = multiSiegel;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", multiSiegel='" + multiSiegel + '\'' +
                '}';
    }
}


public class JoinData {


    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File seal = new File("C:\\Colllections\\dtab\\manifests\\split\\sealData.json");
        PrintStream out = new PrintStream(new FileOutputStream("C:\\Colllections\\dtab\\manifests\\split\\sealDataJoin2.json"));

        String quote = "\u005c\u0022";
        String filePath = "C:\\Colllections\\dtab\\manifests\\split\\sealData.json"; // Ensure the path is correct

        // Create ObjectMapper instance

        try {
            // Read JSON file and convert to List<Document>
            List<Document> documents = objectMapper.readValue(
                    new File(filePath),
                    new TypeReference<List<Document>>() {
                    }
            );

           StringBuilder sb = new StringBuilder();
            // Grouping by documentId and concatenating multiSiegel strings
            Map<Integer, String> groupedDocuments = documents.stream()
                    .collect(Collectors.groupingBy(
                            Document::getDocumentId,
                            Collectors.mapping(
                                    Document::getMultiSiegel,
                                    Collectors.joining("##")
                            )
                    ));

            // Printing the grouped documents
            System.out.println("Grouped Documents:");
            groupedDocuments.forEach((docId, multiSiegel) ->

            //sb.append(  quote + "document_id" + quote + ":" + quote+ documentId2 + quote + "," + '\n' );
            //sb.append(  quote + "multiSiegel" + quote + ":" + quote+ map + quote + "," + '\n' );
                    //System.out.println("{"+ "document_id: " + docId + "\n, multiSiegel: " + multiSiegel+"},"+ '\n')
                    out.println("{"+ quote +"document_id"+quote+":" + docId + "\n,"+quote+ "multiSiegel"+quote+":" + quote+ multiSiegel+quote+"},"+ '\n')
            );





        } catch (IOException e) {
            System.err.println("Error reading or parsing the JSON file:");
            e.printStackTrace();
        }




        /*
        JSONArray jsonArraySeal = new JSONArray(new JSONTokener(new FileInputStream(seal)));
        StringBuilder sb = new StringBuilder();
        String quote = "\u005c\u0022";
        Map<Integer, StringBuilder> map = new HashMap<>();
        //ArrayList<String> listSeal = new ArrayList<>();
        for (int i = 0; i < jsonArraySeal.length(); i++) {

            JSONObject jsonObjectSeal = jsonArraySeal.getJSONObject(i);
            //JSONObject jsonObjectSeal2 =jsonArraySeal.getJSONObject(i + 1);;
            //int documentId2 =jsonObjectSeal2.getInt("document_id");
            if (map.size()>1) {
                sb = new StringBuilder();
            }
            Integer documentId = jsonObjectSeal.getInt("document_id");
            String str = (String) jsonObjectSeal.get("multiSiegel");
            sb = sb.append(str);


            //StringBuilder sealData = new StringBuilder();
            //listSeal.add(jsonObjectSeal.getString("multiSiegel"));
            map.put(documentId, sb);
            System.out.println();



            /*if (documentId==documentId2) {
                listSeal.add(jsonObjectSeal.getString("multiSiegel"));
                System.out.println(listSeal);
            }*/

            //for (int j = i+1; j < jsonArraySeal.length(); j++) {

            //JSONObject jsonObjectSeal2 = jsonArraySeal.getJSONObject(j);
            //int sealId = jsonObjectSeal2.getInt("seal_id");

            //int documentId2 = jsonObjectSeal2.getInt("document_id");


           /* sb.append("{"+ '\n');
            //sb.append(  quote + "document_id" + quote + ":" + quote+ documentId2 + quote + "," + '\n' );
            //sb.append(  quote + "multiSiegel" + quote + ":" + quote+ map + quote + "," + '\n' );
            sb.append("},");
        }

        System.out.println(map);
        out.println("["+map.toString()+"]");*/
        }
    }



