package org.crossasia.manifest.old;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

@SpringBootApplication
public class ManifestApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(ManifestApplication.class, args);
		String quote = "\u005c\u0022";
		String books = "/data1/solr/ajax-dfz/book.json";
		String pages = "/data1/solr/ajax-dfz/books_pages_test.json";

		PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-dfz/books5.json"));
		JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
		JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < booksObject.length(); i++) {

			String id = "";
			String book_id = "";
			JSONArray title = null;
			String bibliographicCitation = "";
			JSONArray responsibility = null;
			JSONArray author = null;
			String date = "";
			JSONArray edition = null;
			JSONArray subject = null;
			String language = "";
			JSONArray temporal = null;
			JSONArray spatial = null;
			JSONArray series_title = null;
			String extent = "";
			String format = "";
			String url = "";
			String erflink = "";
			String url2 = "";
			JSONArray identifier = null;
			String description = "";


			JSONObject booksObj = (JSONObject) booksObject.get(i);
			id = (String) booksObj.get("id").toString();
			book_id = (String) booksObj.get("book_id").toString();

			if (booksObj.has("title"))
				title = (JSONArray) booksObj.get("title");

			if (booksObj.has("identifier"))
				identifier = (JSONArray) booksObj.get("identifier");

			if (booksObj.has("series_title"))
				series_title = (JSONArray) booksObj.get("series_title");

			if (booksObj.has("bibliographicCitation"))
				bibliographicCitation = (String) booksObj.get("bibliographicCitation").toString();

			if (booksObj.has("responsibility")) {
				responsibility = (JSONArray) booksObj.get("responsibility");
			}

			if (booksObj.has("author"))
				author = (JSONArray) booksObj.get("author");

			if (booksObj.has("date"))
				date = (String) booksObj.get("date").toString();

			if (booksObj.has("edition"))
				edition = (JSONArray) booksObj.get("edition");

			if (booksObj.has("subject"))
				subject = (JSONArray) booksObj.get("subject");

			if (booksObj.has("language")) {
				language = (String) booksObj.get("language");
			}

			if (booksObj.has("temporal"))
				temporal = (JSONArray) booksObj.get("temporal");

			if (booksObj.has("spatial")) {
				spatial = (JSONArray) booksObj.get("spatial");
			}

			if (booksObj.has("extent")) {
				extent = (String) booksObj.get("extent");
			}

			if (booksObj.has("format")) {
				format = (String) booksObj.get("format");
			}

			if (booksObj.has("url"))
				url = (String) booksObj.get("url");




					sb.append('\t' + "{" + '\n');

					sb.append("\t\t" + quote + "@context" + quote + ":" + quote + "http://iiif.io/api/presentation/2/context.json" + quote + "," + '\n');
					sb.append("\t\t" + quote + "@id" + quote + ":" + quote + "https://purl.stanford.edu/" + id + "iiif/manifest" + quote + "," + '\n');
					sb.append("\t\t" + quote + "@type" + quote + ":" + quote + "sc:Manifest" + quote + "," + '\n');

					sb.append("\t\t" + quote + "label" + quote + ":" + title + "," + '\n');

					if (description != null) {
						sb.append("\t\t" + quote + "description" + quote + ":" + quote + description + quote + "," + '\n');
					}

					sb.append("\t\t" + quote + "logo" + quote + ":" + "{" + '\n');
					sb.append("\t\t\t" + quote + "@id" + quote + ":" + quote + "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png" + quote + "," + '\n');
					sb.append("\t\t\t" + quote + "service" + quote + ":" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "@context" + quote + ":" + quote + "http://iiif.io/api/image/2/context.json" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "@id" + quote + ":" + quote + "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "profile" + quote + ":" + quote + "http://iiif.io/api/image/2/level2.json" + quote + '\n');
					sb.append("\t\t\t" + "}" + '\n');
					sb.append("\t\t" + "}," + '\n');
					sb.append("\t\t" + quote + "metadata" + quote + ":" + "[" + '\n');
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Date" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + date + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');

					for (int auto = 0; auto < author.length(); auto++) {
						String authorString = (String) author.get(auto);
						sb.append("\t\t\t" + "{" + '\n');
						sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Author" + quote + "," + '\n');
						sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + authorString + quote + '\n');
						sb.append("\t\t\t" + "}," + '\n');
					}

					for (int iden = 0; iden < identifier.length(); iden++) {
						String idenString = (String) identifier.get(iden);
						sb.append("\t\t\t" + "{" + '\n');
						sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Identifier" + quote + "," + '\n');
						sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + idenString + quote + '\n');
						sb.append("\t\t\t" + "}," + '\n');
					}

					for (int edit = 0; edit < edition.length(); edit++) {
						String editString = (String) edition.get(edit);
						sb.append("\t\t\t" + "{" + '\n');
						sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Edition" + quote + "," + '\n');
						sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + editString + quote + '\n');
						sb.append("\t\t\t" + "}," + '\n');
					}

					for (int spat = 0; spat < spatial.length(); spat++) {
						String spatString = (String) spatial.get(spat);
						sb.append("\t\t\t" + "{" + '\n');
						sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Spatial" + quote + "," + '\n');
						sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + spatString + quote + '\n');
						sb.append("\t\t\t" + "}," + '\n');
					}

					for (int seri = 0; seri < series_title.length(); seri++) {
						String seriString = (String) series_title.get(seri);
						sb.append("\t\t\t" + "{" + '\n');
						sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Series Title" + quote + "," + '\n');
						sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + seriString + quote + '\n');
						sb.append("\t\t\t" + "}," + '\n');
					}

					for (int titl = 0; titl < title.length(); titl++) {
						String titlString = (String) title.get(titl);
						sb.append("\t\t\t" + "{" + '\n');
						sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Title" + quote + "," + '\n');
						sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + titlString + quote + '\n');
						sb.append("\t\t\t" + "}," + '\n');
					}

					if (booksObj.has("responsibility")) {
						for (int resp = 0; resp < responsibility.length(); resp++) {
							String respString = (String) title.get(resp);
							sb.append("\t\t\t" + "{" + '\n');
							sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Responsibility" + quote + "," + '\n');
							sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + respString + quote + '\n');
							sb.append("\t\t\t" + "}," + '\n');
						}
					}

					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Url" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + url + quote + '\n');
					sb.append("\t\t\t" + "}," + '\n');

					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "label" + quote + ":" + quote + "Language" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "value" + quote + ":" + quote + language + quote + '\n');
					sb.append("\t\t\t" + "}" + '\n');

					sb.append("\t\t" + "]," + '\n');
					sb.append("\t\t" + quote + "thumbnail" + quote + ":" + "{" + '\n');
					sb.append("\t\t\t" + quote + "@id" + quote + ":" + quote + "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png" + quote + "," + '\n');
					sb.append("\t\t\t" + quote + "@type" + quote + ":" + quote + "dctypes:Image" + quote + "," + '\n');
					sb.append("\t\t\t" + quote + "format" + quote + ":" + quote + "image/jpeg" + quote + "," + '\n');
					sb.append("\t\t\t" + quote + "service" + quote + ":" + "{" + '\n');
					sb.append("\t\t\t\t" + quote + "@context" + quote + ":" + quote + "http://iiif.io/api/image/2/context.json" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "@id" + quote + ":" + quote + "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png" + quote + "," + '\n');
					sb.append("\t\t\t\t" + quote + "profile" + quote + ":" + quote + "http://iiif.io/api/image/2/level2.json" + quote + '\n');
					sb.append("\t\t\t" + "}" + '\n');
					sb.append("\t\t" + "}," + '\n');
					sb.append("\t\t" + quote + "sequences" + quote + ":" + "[" + '\n');
					sb.append("\t\t\t" + "{" + '\n');
					sb.append("\t\t\t" + quote + "@id" + quote + ":" + quote + "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png" + quote + "," + '\n');
					sb.append("\t\t\t" + quote + "@type" + quote + ":" + quote + "sc:Sequence" + quote + "," + '\n');
					sb.append("\t\t\t" + quote + "label" + quote + ":" + quote + "Current order" + quote + "," + '\n');
					sb.append("\t\t\t" + quote + "viewingDirection" + quote + ":" + quote + "left-to-right" + quote + "," + '\n');
					sb.append("\t\t\t" + quote + "rendering" + quote + ":" + "[" + '\n');
					sb.append("\t\t\t\t" + "{" + '\n');
					sb.append("\t\t\t\t\t" + quote + "@id" + quote + ":" + quote + "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png" + quote + "," + '\n');
					sb.append("\t\t\t\t\t" + quote + "label" + quote + ":" + quote + "Download Metadata" + quote + "," + '\n');
					sb.append("\t\t\t\t\t" + quote + "format" + quote + ":" + quote + "application/pdf" + quote + '\n');
					sb.append("\t\t\t\t" + "}" + '\n');
					sb.append("\t\t\t" + "]," + '\n');
					sb.append("\t\t\t" + quote + "canvases" + quote + ":" + "[" + '\n');
					for (int j = 0; j < pagesObject.length(); j++) {
						JSONObject pagesObj = (JSONObject) pagesObject.get(j);
						String books_id_pages = (String) pagesObj.get("book_id");
						String id_pages = (String) pagesObj.get("id");

						if (book_id.equals(books_id_pages)) {

					int number_of_pages = pagesObject.length();
					for (int pageNum = 0; pageNum < number_of_pages; pageNum++) {
						sb.append("\t\t\t\t" + "{" + '\n');
						sb.append("\t\t\t\t\t" + quote + "@id" + quote + ":" + quote + "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png" + quote + "," + '\n');
						sb.append("\t\t\t\t\t" + quote + "@type" + quote + ":" + quote + "sc:Canvas" + quote + "," + '\n');
						sb.append("\t\t\t\t\t" + quote + "label" + quote + ":" + quote + "Title TEXT" + quote + "," + '\n');
						sb.append("\t\t\t\t\t" + quote + "height" + quote + ":" + quote + 2424 + quote + "," + '\n');
						sb.append("\t\t\t\t\t" + quote + "width" + quote + ":" + quote + 2424 + quote + "," + '\n');
						sb.append("\t\t\t\t\t" + quote + "images" + quote + ":" + "[" + '\n');
						sb.append("\t\t\t\t\t\t" + "{" + '\n');
						sb.append("\t\t\t\t\t\t\t" + quote + "@id" + quote + ":" + quote + "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t" + quote + "@type" + quote + ":" + quote + "oa:Annotation" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t" + quote + "motivation" + quote + ":" + quote + "sc:painting" + quote + "," + '\n');

						sb.append("\t\t\t\t\t\t\t" + quote + "resource" + quote + ":" + "{" + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "@id" + quote + ":" + quote + "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "@type" + quote + ":" + quote + "dctypes:Image" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "format" + quote + ":" + quote + "image/jpeg" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "height" + quote + ":" + quote + 2424 + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "width" + quote + ":" + quote + 2424 + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + quote + "service" + quote + ":" + "{" + '\n');
						sb.append("\t\t\t\t\t\t\t\t\t" + quote + "@context" + quote + ":" + quote + "http://iiif.io/api/image/2/context.json" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t\t" + quote + "@id" + quote + ":" + quote + "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png" + quote + "," + '\n');
						sb.append("\t\t\t\t\t\t\t\t\t" + quote + "profile" + quote + ":" + quote + "http://iiif.io/api/image/2/level2.json" + quote + '\n');
						sb.append("\t\t\t\t\t\t\t\t" + "}" + '\n');

						sb.append("\t\t\t\t\t\t\t" + "}," + '\n');
						sb.append("\t\t\t\t\t\t\t" + quote + "on" + quote + ":" + quote + "LINK" + quote + '\n');

						sb.append("\t\t\t\t\t\t" + "}" + '\n');
						sb.append("\t\t\t\t\t" + "]" + '\n');
						if (pageNum == number_of_pages) {
							sb.append("\t\t\t\t" + "}" + '\n');
						} else {
							sb.append("\t\t\t\t" + "}," + '\n');
						}
					}
					sb.append("\t\t\t" + "]" + '\n');
					sb.append("\t\t\t" + "}" + '\n');
					sb.append("\t\t" + "]" + '\n');
					sb.append("\t" + "}" + '\n');

				}

			}

			sb.deleteCharAt(sb.length() - 1);
			out.println("[" + '\n' + sb.toString() + '\n' + "]");
		}


	}

}
