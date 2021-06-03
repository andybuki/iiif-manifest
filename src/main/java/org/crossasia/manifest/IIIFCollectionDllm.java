package org.crossasia.manifest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

@SpringBootApplication
public class IIIFCollectionDllm {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(IIIFCollectionDllm.class, args);
		String quote = "\u005c\u0022";
		File absolutePath = new File("/data1/dllm/manifest/splitted/");

		File dir = new File(String.valueOf(absolutePath));
		File[] filesInDir = dir.listFiles();
		StringBuilder sb = new StringBuilder();

		sb.append('\t' + "{" + '\n');

		sb.append("\t\t" + quote + "@context" + quote + ":" + quote + "http://iiif.io/api/presentation/2/context.json" + quote + "," + '\n');
		sb.append("\t\t" + quote + "@id" + quote + ":" + quote + "http://b-lx0005.sbb.spk-berlin.de:8080/fcrepo/rest/dllm/collection" + quote + "," + '\n');
		sb.append("\t\t" + quote + "@type" + quote + ":" + quote + "sc:Collection" + quote + "," + '\n');
		sb.append("\t\t" + quote + "label" + quote + ":" + quote +"Digital Library of Lao Manuscripts"+ quote  + "," + '\n');
		sb.append("\t\t" + quote + "description" + quote + ":" + quote + "" + quote +"," + '\n');
		sb.append("\t\t" + quote + "attribution" + quote + ":" + quote + "State Library of Berlin" + quote +"," + '\n');
		sb.append("\t\t" + quote + "logo" + quote + ":" + quote+"https://ngcs-beta.staatsbibliothek-berlin.de/dc/logo-small" +quote+"," + '\n');
		sb.append("\t\t" + quote + "manifests" + quote + ":" + "[" + '\n');

		for (File file : filesInDir) {

			JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));
			long k = dir.length();
			String id = "";
			JSONArray title_roman = null;
			JSONArray title_lao = null;



			if (jsonObj.has("id")) {
				id = (String) jsonObj.get("id").toString();
			}

			if (jsonObj.has("titles_lao")) {
				title_lao = (JSONArray) jsonObj.get("titles_lao");
			}

			if (jsonObj.has("titles")) {
				title_roman = (JSONArray) jsonObj.get("titles");
			}


			sb.append("\t\t\t" + "{" + '\n');
			sb.append("\t\t\t" + quote + "@id" + quote + ":" + quote + "http://b-lx0005.sbb.spk-berlin.de:8080/fcrepo/rest/dllm/dllm_000"+id+"/manifest" + quote + "," + '\n');
			sb.append("\t\t\t" + quote + "@type" + quote + ":" + quote + "sc:Manifest" + quote + "," + '\n');
			if (jsonObj.has("titles") || jsonObj.has("titles_lao")  ) {
				sb.append("\t\t\t" + quote + "label" + quote + ":" + quote + title_roman.get(0).toString().replace("[\"", "").replace("\"]", "") +
						" (" + title_lao.get(0).toString().replace("[\"", "").replace("\"]", "") + ")" + quote + "" + '\n');

			} else {
				sb.append("\t\t\t" + quote + "label" + quote + ":" + quote +"NO Title"+ quote  + "" + '\n');
			}
			sb.append("\t\t\t" + "}," + '\n');
			/*if (j == page_int-1) {
				sb.append("\t\t\t\t" + "}" + '\n');
			} else {
				sb.append("\t\t\t\t" + "}," + '\n');
			}*/

		}
		sb.append("\t\t" + "]" + '\n');
		sb.append("\t" + "}" + '\n');
		sb.deleteCharAt(sb.length() - 1);
		PrintStream out = new PrintStream(new FileOutputStream("/data1/dllm/manifest/collection.json"));
		out.println("" + '\n' + sb.toString() + '\n' + "");

	}

}
