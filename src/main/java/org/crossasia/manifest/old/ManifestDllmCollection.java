package org.crossasia.manifest.old;

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
public class ManifestDllmCollection {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		if (is.available()!=0) {
			try {
				BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				String jsonText = readAll(rd);
				JSONObject json = new JSONObject(jsonText);
				return json;
			} finally {
				is.close();
			}

		}else {
			System.out.println("Something wrong with IIIF Image Server");
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ManifestDllmCollection.class, args);
		String quote = "\u005c\u0022";
		File absolutePath = new File("/data1/dllm/manifest/splitted5/");

		File dir = new File(String.valueOf(absolutePath));
		File[] filesInDir = dir.listFiles();

		for (File file : filesInDir) {
			StringBuilder sb = new StringBuilder();
			JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));


			String id = "";
			String code_number ="";
			String roll = "";
			String date_written ="";
			int date_written_right =0;
			String temporal_date ="";
			String temporal_date_lao ="";

			int number_of_fascicles=0;
			int number_of_folios=0;
			int has_colophon=0;
			String has_colophon_str ="";
			int is_illustrated=0;
			String is_illustrated_str ="";

			String bundle_id="";

			int position_in_bundle=0;
			int pages_count=0;
			int locations_id=0;
			int locations_parent_id=0;

			String public_remarks_en = "";
			String public_remarks_lo ="";

			String private_remarks_en="";
			String private_remarks_lo ="";

			int is_color=0;
			String is_color_str ="";
			int is_complete=0;
			String is_complete_str="";

			String materials ="";
			String materials_lao="";

			String name_location="";
			String name_location_lao="";

			String location ="";
			String location_place ="";
			String location_place_lao="";

			int location_lft=0;
			int location_rgt=0;
			int location_code=0;
			double location_lat=0.0;
			double location_lon=0.0;
			int location_documents_count=0;

			String legibilities = "";
			String legibilities_lao = "";
			String additional_date_infos_roman = "";
			String additional_date_infos_lao = "";
			String conditions = "";
			String conditions_lao ="";
			String preferred_date_systems = "";
			String preferred_date_systems_lao = "";

			JSONArray languages = null;
			JSONArray languages_lao = null;

			JSONArray remark_lao = null;
			JSONArray remark_english = null;

			JSONArray term_roman = null;
			JSONArray term_leo = null;

			JSONArray categories = null;
			JSONArray categories_lao = null;

			JSONArray scripts = null;
			JSONArray scripts_lao = null;

			JSONArray title_roman = null;
			JSONArray title_lao = null;

			JSONArray title_search_roman = null;
			JSONArray title_search_lao = null;

			JSONArray plmp_title_lao = null;

			JSONArray pages = null;


			if (jsonObj.has("id")) {
				id = (String) jsonObj.get("id").toString();
			}
			if (jsonObj.has("code_number"))
				code_number = (String) jsonObj.get("code_number").toString();

			if (jsonObj.has("roll"))
				roll = (String) jsonObj.get("roll").toString();

			if (jsonObj.has("date_written")) {
				date_written = (String) jsonObj.get("date_written").toString();
				String[] spl = date_written.split("-");
				date_written_right = Integer.parseInt(spl[0]);
			}

			if (jsonObj.has("name_location"))
				name_location = (String) jsonObj.get("name_location").toString();

			if (jsonObj.has("name_location_lao"))
				name_location_lao = (String) jsonObj.get("name_location_lao").toString();

			if (jsonObj.has("number_of_fascicles"))
				number_of_fascicles = (int) jsonObj.get("number_of_fascicles");

			if (jsonObj.has("number_of_folios"))
				number_of_folios = (int) jsonObj.get("number_of_folios");

			if (jsonObj.has("has_colophon")) {
				has_colophon = (int) jsonObj.get("has_colophon");
				if (has_colophon==0) {
					has_colophon_str="No";
				}else {
					has_colophon_str="Yes";
				}
			}

			if (jsonObj.has("is_illustrated")) {
				is_illustrated = (int) jsonObj.get("is_illustrated");
				if (is_illustrated==0) {
					is_illustrated_str="No";
				}else {
					is_illustrated_str="Yes";
				}
			}

			if (jsonObj.has("locations_id"))
				locations_id = (int) jsonObj.get("locations_id");

			if (jsonObj.has("locations_parent_id"))
				locations_parent_id = (int) jsonObj.get("locations_parent_id");

			if (jsonObj.has("is_complete")) {
				is_complete = (int) jsonObj.get("is_complete");
				if (is_complete==0){
					is_complete_str="No";
				}else{
					is_complete_str="Yes";
				}
			}

			if (jsonObj.has("bundle_id"))
				bundle_id = (String) jsonObj.get("bundle_id").toString();

			if (jsonObj.has("position_in_bundle"))
				position_in_bundle = (int) jsonObj.get("position_in_bundle");

			if (jsonObj.has("pages_count"))
				pages_count = (int) jsonObj.get("pages_count");

			if (jsonObj.has("public_remarks_en"))
				public_remarks_en = (String) jsonObj.get("public_remarks_en").toString();

			if (jsonObj.has("public_remarks_lo"))
				public_remarks_lo = (String) jsonObj.get("public_remarks_lo").toString();

			if (jsonObj.has("private_remarks_en"))
				private_remarks_en = (String) jsonObj.get("private_remarks_en").toString();

			if (jsonObj.has("private_remarks_lo"))
				private_remarks_lo = (String) jsonObj.get("private_remarks_lo").toString();

			if (jsonObj.has("is_color")) {
				is_color = (int) jsonObj.get("is_color");
				if (is_color==0) {
					is_color_str="From Microfilm";
				} else {
					is_color_str="From Original";
				}
			}

			if (jsonObj.has("materials"))
				materials = (String) jsonObj.get("materials").toString();

			if (jsonObj.has("materials_lao"))
				materials_lao = (String) jsonObj.get("materials_lao").toString();

			if (jsonObj.has("location"))
				location = (String) jsonObj.get("location").toString();

			if (jsonObj.has("location_place"))
				location_place = (String) jsonObj.get("location_place").toString();

			if (jsonObj.has("location_place_lao"))
				location_place_lao = (String) jsonObj.get("location_place_lao").toString();

			if (jsonObj.has("location_lft"))
				location_lft = (int) jsonObj.get("location_lft");

			if (jsonObj.has("location_rgt"))
				location_rgt = (int) jsonObj.get("location_rgt");

			if (jsonObj.has("location_code"))
				location_code = (int) jsonObj.get("location_code");

			if (jsonObj.has("location_lat"))
				location_lat = (double) jsonObj.get("location_lat");

			if (jsonObj.has("location_lon"))
				location_lon = (double) jsonObj.get("location_lon");

			if (jsonObj.has("location_documents_count"))
				location_documents_count = (int) jsonObj.get("location_documents_count");

			if (jsonObj.has("legibilities"))
				legibilities = (String) jsonObj.get("legibilities").toString();

			if (jsonObj.has("legibilities_lao"))
				legibilities_lao = (String) jsonObj.get("legibilities_lao").toString();

			if (jsonObj.has("additional_date_infos_roman"))
				additional_date_infos_roman = (String) jsonObj.get("additional_date_infos_roman").toString();

			if (jsonObj.has("additional_date_infos_lao"))
				additional_date_infos_lao = (String) jsonObj.get("additional_date_infos_lao").toString();

			if (jsonObj.has("conditions"))
				conditions = (String) jsonObj.get("conditions").toString();

			if (jsonObj.has("conditions_lao"))
				conditions_lao = (String) jsonObj.get("conditions_lao").toString();

			if (jsonObj.has("preferred_date_systems")) {
				preferred_date_systems = (String) jsonObj.get("preferred_date_systems").toString();

				if (preferred_date_systems.equals("Buddhist Era (BE)")) {
					date_written_right = date_written_right+ 543;
					temporal_date = date_written_right+" (Buddhist Era)";
					temporal_date_lao = date_written_right+" (ພຸດທະສັກກະລາດ (ພສ))";

				} else if (preferred_date_systems.equals("Cunlasakkalat (CS)")) {
					date_written_right = date_written_right- 638;
					temporal_date = date_written_right+" (Cunlasakkalat)";
					temporal_date_lao = date_written_right+" (ບໍ່ປາກົດປີລິດຈະນາ)";

				} else if (preferred_date_systems.equals("Undated")) {
					temporal_date = "(Undated)";
					temporal_date_lao = "(ບໍ່ປາກົດປີລິດຈະນາ)";
				} else {
					temporal_date = date_written_right+" (Christian Era)";
					temporal_date_lao = date_written_right+" (ຄິດຕະສັກກະລາດ (ຄສ))";
				}
			}


			if (jsonObj.has("preferred_date_systems_lao"))
				preferred_date_systems_lao = (String) jsonObj.get("preferred_date_systems_lao").toString();

			if (jsonObj.has("languages")) {
				languages = (JSONArray) jsonObj.get("languages");
			}

			if (jsonObj.has("languages_lao")) {
				languages_lao = (JSONArray) jsonObj.get("languages_lao");
			}

			if (jsonObj.has("categories")) {
				categories = (JSONArray) jsonObj.get("categories");
			}

			if (jsonObj.has("categories_lao")) {
				categories_lao = (JSONArray) jsonObj.get("categories_lao");
			}

			if (jsonObj.has("scripts")) {
				scripts = (JSONArray) jsonObj.get("scripts");
			}

			if (jsonObj.has("scripts_lao")) {
				scripts_lao = (JSONArray) jsonObj.get("scripts_lao");
			}

			if (jsonObj.has("titles_lao")) {
				title_lao = (JSONArray) jsonObj.get("titles_lao");
			}

			if (jsonObj.has("titles")) {
				title_roman = (JSONArray) jsonObj.get("titles");
			}

			if (jsonObj.has("title_search_lao")) {
				title_search_lao = (JSONArray) jsonObj.get("title_search_lao");
			}

			if (jsonObj.has("title_search_roman")) {
				title_search_roman = (JSONArray) jsonObj.get("title_search_roman");
			}

			if (jsonObj.has("plmp_title_lao")) {
				plmp_title_lao = (JSONArray) jsonObj.get("plmp_title_lao");
			}

			if (jsonObj.has("remark_english")) {
				remark_english = (JSONArray) jsonObj.get("remark_english");
			}

			if (jsonObj.has("remark_lao")) {
				remark_lao = (JSONArray) jsonObj.get("remark_lao");
			}

			if (jsonObj.has("term_roman")) {
				term_roman = (JSONArray) jsonObj.get("term_roman");
			}

			if (jsonObj.has("term_leo")) {
				term_leo = (JSONArray) jsonObj.get("term_leo");
			}


			if (jsonObj.has("pages")) {
				pages = (jsonObj.getJSONArray("pages"));
			}


			
			/*

			if (jsonObj.has("url"))
				url = (String) jsonObj.get("url");
		  */


			sb.append('\t' + "{" + '\n');

			sb.append("\t\t" + quote + "@context" + quote + ":" + quote + "http://iiif.io/api/presentation/2/context.json" + quote + "," + '\n');
			sb.append("\t\t" + quote + "@id" + quote + ":" + quote + "http://b-lx0005.sbb.spk-berlin.de:8080/fcrepo/rest/dllm/dllm_000"+id+"/dllm_000"+id+"_manifest" + quote + "," + '\n');
			sb.append("\t\t" + quote + "@type" + quote + ":" + quote + "sc:Manifest" + quote + "," + '\n');
			if (jsonObj.has("titles") || jsonObj.has("titles_lao")  ) {
				sb.append("\t\t" + quote + "label" + quote + ":" + quote + title_roman.get(0).toString().replace("[\"", "").replace("\"]", "") +
						" (" + title_lao.get(0).toString().replace("[\"", "").replace("\"]", "") + ")" + quote + "," + '\n');

			} else {
				sb.append("\t\t" + quote + "label" + quote + ":" + quote +"NO Title"+ quote  + "," + '\n');
			}


			sb.append("\t\t" + quote + "description" + quote + ":" + quote + "Digital Library of Lao Manuscripts" + quote +"," + '\n');


			sb.append("\t\t" + quote + "logo" + quote + ":" + quote+"https://ngcs-beta.staatsbibliothek-berlin.de/dc/logo-small" +quote+"," + '\n');

			sb.append("\t\t" + quote + "metadata" + quote + ":" + "[" + '\n');
			if (jsonObj.has("code_number")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Code_Number" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + code_number + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("code_number")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "schema:keywords" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + code_number + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("roll")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Roll" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + roll + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("date_written")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Date Written" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + date_written + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("date_written_right")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Date Written Right" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + date_written_right + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("temporal_date")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Temporal Date" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + temporal_date + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("temporal_date_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Temporal Date Lao" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + temporal_date_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("number_of_fascicles")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Number of Fascicles" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + number_of_fascicles + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("number_of_folios")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Number of Folios" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + number_of_folios + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("has_colophon")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Has Colophon" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + has_colophon + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("has_colophon")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:description" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + "Colophone: "+has_colophon_str + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("is_illustrated")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Is Illustrated" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + is_illustrated + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("is_illustrated")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:description" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + "Illustrated: "+is_illustrated_str + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("bundle_id")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Bundle Id" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + bundle_id + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("position_in_bundle")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Position in Bundle" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + position_in_bundle + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("pages_count")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Pages Count" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + pages_count + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("locations_id")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Locations Id" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + locations_id + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("locations_parent_id")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Locations Parent Id" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + locations_parent_id + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("public_remarks_en")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Public Remarks En" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + public_remarks_en + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("public_remarks_lo")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Public Remarks Lo" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + public_remarks_lo + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			/*if (jsonObj.has("private_remarks_en")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Private Remarks En" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + private_remarks_en + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("private_remarks_lo")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Private Remarks Lo" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + private_remarks_lo + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}*/

			if (jsonObj.has("is_color")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Is Color" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + is_color + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("is_color")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:description" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + "Scan: "+is_color_str + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("is_complete")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Is Complete" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + is_complete + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("is_complete")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:description" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + "Complete: "+is_complete_str + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}


				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:source" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + "Digital Library of Lao Manuscripts" + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');


			if (jsonObj.has("materials")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Materials" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + materials + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("materials_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Materials Lao" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + materials_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("name_location")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Name Location" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + name_location + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("name_location_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Name Location Lao" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + name_location_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("name_location")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcterms:spatial" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + name_location + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("name_location_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcterms:spatial" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + name_location_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("name_location_lao") || jsonObj.has("name_location")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcndl:publicationPlace" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + name_location  + " (" + name_location_lao +  ") " + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}


			if (number_of_fascicles!=0 || number_of_folios!=0) {
				if (jsonObj.has("number_of_fascicles") || jsonObj.has("number_of_folios")) {
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcterms:extent" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + number_of_fascicles + " fascicle(s), " + number_of_folios+" folio(s)" + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}


			if (jsonObj.has("location_place")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Location Place" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + location_place + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("location_place_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Location Place Lao" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + location_place_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("location_lft")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Location Lft" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + location_lft + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("location_rgt")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Location Rgt" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + location_rgt + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("location_code")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Location Code" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + location_code + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("location_lat")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "schema:latitude" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + location_lat + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("location_lon")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "schema:longitude" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + location_lon + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("location_lat")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Location Lat" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + location_lat + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("location_lon")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Location Lon" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + location_lon + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("location_documents_count")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Location Documents Count" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + location_documents_count + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("legibilities")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Legibilities" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + legibilities + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("legibilities_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Legibilities Lao" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + legibilities_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("legibilities")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:description" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + "Legibility: "+legibilities + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("legibilities_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:description" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + "Legibility: " +legibilities_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("additional_date_infos_roman")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Additional Date Infos Roman" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + additional_date_infos_roman + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("additional_date_infos_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Additional Date Infos Lao" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + additional_date_infos_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("conditions")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Conditions" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + conditions + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("conditions_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Conditions Lao" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + conditions_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("conditions")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:description" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + "Conditions: "+conditions + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("conditions_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:description" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + "Conditions: " +conditions_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}


			if (jsonObj.has("preferred_date_systems")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Preferred Date Systems" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + preferred_date_systems + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("preferred_date_systems_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Preferred Date Systems Lao" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + preferred_date_systems_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("languages")) {
				for (int lang = 0; lang < languages.length(); lang++) {
					String languagesString = (String) languages.get(lang);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Language" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + languagesString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("languages_lao")) {
				for (int lang = 0; lang < languages_lao.length(); lang++) {
					String languagesLaoString = (String) languages_lao.get(lang);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Language Lao" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + languagesLaoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("languages")) {
				for (int lang = 0; lang < languages.length(); lang++) {
					String languagesString = (String) languages.get(lang);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:language" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + languagesString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("languages_lao")) {
				for (int lang = 0; lang < languages_lao.length(); lang++) {
					String languagesLaoString = (String) languages_lao.get(lang);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:language" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + languagesLaoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}


			if (jsonObj.has("remark_english")) {
				for (int rema = 0; rema < remark_english.length(); rema++) {
					String remarkEnglishString = (String) remark_english.get(rema);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Remark English" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + remarkEnglishString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("remark_lao")) {
				for (int rema = 0; rema < remark_lao.length(); rema++) {
					String remarkLaoString = (String) remark_lao.get(rema);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Remark Lao" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + remarkLaoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("term_roman")) {
				for (int term = 0; term < term_roman.length(); term++) {
					String termRomanString = (String) term_roman.get(term);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Term Roman" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + termRomanString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("term_leo")) {
				for (int term = 0; term < term_leo.length(); term++) {
					String termLeoString = (String) term_leo.get(term);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Term Leo" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + termLeoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("term_leo")) {
				for (int term = 0; term < term_leo.length(); term++) {
					String termLeoString = (String) term_leo.get(term);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "schema:keywords" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + termLeoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("term_roman")) {
				for (int term = 0; term < term_roman.length(); term++) {
					String termRomanString = (String) term_roman.get(term);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "schema:keywords" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + termRomanString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("categories")) {
				for (int cat = 0; cat < categories.length(); cat++) {
					String categoriesString = (String) categories.get(cat);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Categories" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + categoriesString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("categories_lao")) {
				for (int cat = 0; cat < categories_lao.length(); cat++) {
					String categoriesLaoString = (String) categories_lao.get(cat);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Categories Lao" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + categoriesLaoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("categories")) {
				for (int cat = 0; cat < categories.length(); cat++) {
					String categoriesString = (String) categories.get(cat);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:subject" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + categoriesString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("categories_lao")) {
				for (int cat = 0; cat < categories_lao.length(); cat++) {
					String categoriesLaoString = (String) categories_lao.get(cat);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:subject" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + categoriesLaoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("scripts")) {
				for (int scr = 0; scr < scripts.length(); scr++) {
					String scriptsString = (String) scripts.get(scr);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "crossasia:script" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + scriptsString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}


			if (jsonObj.has("scripts")) {
				for (int scr = 0; scr < scripts.length(); scr++) {
					String scriptsString = (String) scripts.get(scr);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Scripts" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + scriptsString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("scripts_lao")) {
				for (int scr = 0; scr < scripts_lao.length(); scr++) {
					String scriptsLaoString = (String) scripts_lao.get(scr);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Scripts Lao" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + scriptsLaoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("titles")) {
				for (int tit = 0; tit < title_roman.length(); tit++) {
					String titleRomanString = (String) title_roman.get(tit);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcndl:titleTranscription" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + titleRomanString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("titles_lao")) {
				for (int tit = 0; tit < title_lao.length(); tit++) {
					String titleLaoString = (String) title_lao.get(tit);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dc:title" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + titleLaoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("titles")) {
				for (int tit = 0; tit < title_roman.length(); tit++) {
					String titleRomanString = (String) title_roman.get(tit);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Title Roman" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + titleRomanString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("titles_lao")) {
				for (int tit = 0; tit < title_lao.length(); tit++) {
					String titleLaoString = (String) title_lao.get(tit);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Title Lao" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + titleLaoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("title_search_roman")) {
				for (int sea = 0; sea < title_search_roman.length(); sea++) {
					String titleSearchRomanString = (String) title_search_roman.get(sea);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Title Search Roman" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + titleSearchRomanString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("title_search_lao")) {
				for (int sea = 0; sea < title_search_lao.length(); sea++) {
					String titleSearchLaoString = (String) title_search_lao.get(sea);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Title Search Lao" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + titleSearchLaoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			if (jsonObj.has("plmp_title_lao")) {
				for (int plmp = 0; plmp < plmp_title_lao.length(); plmp++) {
					String plmpTitleLaoString = (String) plmp_title_lao.get(plmp);
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Plmp Title Lao" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + plmpTitleLaoString + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');
				}
			}

			/*if (date_written_right != 0 || additional_date_infos_roman != "" ||  additional_date_infos_lao!="" ||  preferred_date_systems !="" || preferred_date_systems_lao!="") {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcterms:temporal" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + "[" + quote + temporal_date + quote +
						"," + quote + temporal_date_lao + quote +
						"," + quote + additional_date_infos_roman + quote +
						"," + quote + additional_date_infos_lao + quote +
						"," + quote + preferred_date_systems + quote +
						"," + quote + preferred_date_systems_lao + quote +
						"]" + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}*/

			if (jsonObj.has("temporal_date")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcterms:temporal" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + temporal_date + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("temporal_date_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcterms:temporal" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + temporal_date_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("additional_date_infos_roman")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcterms:temporal" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + additional_date_infos_roman + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("additional_date_infos_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcterms:temporal" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + additional_date_infos_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("preferred_date_systems")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcterms:temporal" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + preferred_date_systems + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}

			if (jsonObj.has("preferred_date_systems_lao")) {
				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "dcterms:temporal" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + preferred_date_systems_lao + quote + '\n');
				sb.append("\t\t\t" + "}," + '\n');
			}


				sb.append("\t\t\t" + "{" + '\n');
				sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "crossasia:hasModel" + quote + "," + '\n');
				sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + "Book" + quote + '\n');
				sb.append("\t\t\t" + "}" + '\n');


			sb.append("\t\t" + "]," + '\n');

			sb.append("\t\t" + quote + "thumbnail" + quote + ":" + "{" + '\n');
			sb.append("\t\t\t" + quote + "@id" + quote + ":" + quote + "http://b-dev998.pk.de/xasia/dllm+dllm_0001+484497/full/150,/0/default.jpg" + quote + "," + '\n');
			sb.append("\t\t\t" + quote + "@type" + quote + ":" + quote + "dctypes:Image" + quote + "," + '\n');
			sb.append("\t\t\t" + quote + "format" + quote + ":" + quote + "image/jpeg" + quote + "," + '\n');
			sb.append("\t\t\t" + quote + "service" + quote + ":" + "{" + '\n');
			sb.append("\t\t\t\t" + quote + "@context" + quote + ":" + quote + "http://iiif.io/api/image/2/context.json" + quote + "," + '\n');
			sb.append("\t\t\t\t" + quote + "@id" + quote + ":" + quote + "http://b-dev998.pk.de/xasia/dllm+dllm_0001+484497" + quote + "," + '\n');
			sb.append("\t\t\t\t" + quote + "profile" + quote + ":" + quote + "http://iiif.io/api/image/2/level2.json" + quote + '\n');
			sb.append("\t\t\t" + "}" + '\n');
			sb.append("\t\t" + "}," + '\n');

			sb.append("\t\t" + quote + "sequences" + quote + ":" + "[{" + '\n');
			sb.append("\t\t\t" + "" + '\n');
			sb.append("\t\t\t" + quote + "@id" + quote + ":" + quote + "http://www.laomanuscripts.net/en/index" + quote + "," + '\n');
			sb.append("\t\t\t" + quote + "@type" + quote + ":" + quote + "sc:Sequence" + quote + "," + '\n');
			sb.append("\t\t\t" + quote + "label" + quote + ":" + quote + "Current order" + quote + "," + '\n');
			sb.append("\t\t\t" + quote + "viewingDirection" + quote + ":" + quote + "left-to-right" + quote + "," + '\n');
			/*sb.append("\t\t\t" + quote + "rendering" + quote + ":" + "[" + '\n');
			sb.append("\t\t\t\t" + "{" + '\n');
			sb.append("\t\t\t\t\t" + quote + "@id" + quote + ":" + quote + "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png" + quote + "," + '\n');
			sb.append("\t\t\t\t\t" + quote + "label" + quote + ":" + quote + "Download Metadata" + quote + "," + '\n');
			sb.append("\t\t\t\t\t" + quote + "format" + quote + ":" + quote + "application/pdf" + quote + '\n');
			sb.append("\t\t\t\t" + "}" + '\n');
			sb.append("\t\t\t" + "]," + '\n');*/

			sb.append("\t\t\t" + quote + "canvases" + quote + ":" + "[" + '\n');
			int page_int = pages.length();
			for (int j = 0; j < pages.length(); j++) {
				JSONObject pagesObj = (JSONObject) pages.get(j);

				String pages_position="";
				String pages_image_file="";
				String pages_id="";
				String pages_document_id="";
				int number_of_pages = pages.length();

				if (pagesObj.has("pages_position"))
					pages_position = (String) pagesObj.get("pages_position").toString();

				if (pagesObj.has("pages_image_file"))
					pages_image_file = (String) pagesObj.get("pages_image_file").toString();

				if (pagesObj.has("pages_id"))
					pages_id = (String) pagesObj.get("pages_id").toString();

				if (pagesObj.has("pages_document_id"))
					pages_document_id = (String) pagesObj.get("pages_document_id").toString();


				JSONObject json = readJsonFromUrl("http://b-dev998.pk.de/xasia/dllm"+"+dllm_000"+pages_document_id+"+"+pages_id+"/info.json");

				//if (json!=null) {
					String manifest_id = "http://b-dev998.pk.de/xasia/dllm"+"+dllm_000"+pages_document_id+"+"+pages_id;
						sb.append("\t\t\t\t" + "{" + '\n');
						sb.append("\t\t\t\t\t" + quote + "@id" + quote + ":" + quote + manifest_id+"/canvas" + quote + "," + '\n');
						sb.append("\t\t\t\t\t" + quote + "@type" + quote + ":" + quote + "sc:Canvas" + quote + "," + '\n');
						sb.append("\t\t\t\t\t" + quote + "label" + quote + ":" + quote + "dllm_000"+ pages_document_id+"_"+pages_position + quote + "," + '\n');
						sb.append("\t\t\t\t\t" + quote + "height" + quote + ":" + quote + json.get("height") + quote + "," + '\n');
						sb.append("\t\t\t\t\t" + quote + "width" + quote + ":" + quote + json.get("width") + quote + "," + '\n');
						sb.append("\t\t\t\t\t" + quote + "images" + quote + ":" + "[" + '\n');
						sb.append("\t\t\t\t\t\t" + "{" + '\n');
						sb.append("\t\t\t\t\t\t\t" + quote + "@id" + quote + ":" + quote + manifest_id+"/annotation" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t" + quote + "@type" + quote + ":" + quote + "oa:Annotation" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t" + quote + "motivation" + quote + ":" + quote + "sc:painting" + quote + "," + '\n');

						sb.append("\t\t\t\t\t\t\t" + quote + "resource" + quote + ":" + "{" + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "@id" + quote + ":" + quote + manifest_id +"/full/full/0/default.jpg"+ quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "@type" + quote + ":" + quote + "dctypes:Image" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "format" + quote + ":" + quote + "image/jpeg" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "height" + quote + ":" + quote + json.get("height") + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "width" + quote + ":" + quote + json.get("width") + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "service" + quote + ":" + "{" + '\n');
						sb.append("\t\t\t\t\t\t\t\t\t" + quote + "@context" + quote + ":" + quote + "http://iiif.io/api/image/2/context.json" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t\t" + quote + "@id" + quote + ":" + quote + manifest_id + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t\t" + quote + "profile" + quote + ":" + quote + "http://iiif.io/api/image/2/level2.json" + quote + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + "}" + '\n');

						sb.append("\t\t\t\t\t\t\t" + "}," + '\n');
						sb.append("\t\t\t\t\t\t\t" + quote + "on" + quote + ":" + quote + manifest_id+"/canvas" + quote + '\n');

						sb.append("\t\t\t\t\t\t" + "}" + '\n');
						sb.append("\t\t\t\t\t" + "]" + '\n');
						if (j == page_int-1) {
							sb.append("\t\t\t\t" + "}" + '\n');
						} else {
							sb.append("\t\t\t\t" + "}," + '\n');
						}
					//}

					//sb.append("\t\t\t" + "]" + '\n');

			}

			sb.append("\t\t\t" + "]" + '\n');
			sb.append("\t\t\t" + "}" + '\n');
			sb.append("\t\t" + "]" + '\n');
			sb.append("\t" + "}" + '\n');
			sb.deleteCharAt(sb.length() - 1);
			PrintStream out = new PrintStream(new FileOutputStream("/data1/dllm/manifest/manifests3/dllm_000"+id+"_manifest.json"));
			out.println("" + '\n' + sb.toString() + '\n' + "");
		}


	}

}
