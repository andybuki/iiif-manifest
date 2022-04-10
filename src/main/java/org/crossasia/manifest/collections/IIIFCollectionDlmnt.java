package org.crossasia.manifest.collections;

import info.freelibrary.iiif.presentation.v3.Collection;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Summary;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.json.StaticJsonCaller;
import org.crossasia.manifest.metadata.LabelMetadata;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@SpringBootApplication
public class IIIFCollectionDlmnt {

	public static void main(String[] args) throws IOException {

		String quote = "\u005c\u0022";
		File absolutePath = new File("/data/dlmnt/fedora/manifests/");
		//PrintStream out = new PrintStream(new FileOutputStream("src/main/resources/output.txt"));
		File dir = new File(String.valueOf(absolutePath));
		File[] filesInDir = dir.listFiles();
		int counter = 1;
		File created = new File("/data/dlmnt/fedora/results/");
		Collection collection = new Collection("Collection", "Digital Library of Lanna Manuscripts 0-1000");
		List<Collection.Item> items = new ArrayList<>();


		for (File file : filesInDir) {
			if (file.toString().contains(".json")) {
				CollectionAttributes dllmAttributes = new CollectionAttributes();
				int lentgthFiles = filesInDir.length;
				JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));
				StaticJsonCaller.staticJsonCaller(dllmAttributes, jsonObj);
				JSONObject labelTitle = (JSONObject) jsonObj.get("label");
				JSONArray arrayTitle = (JSONArray) labelTitle.get("none");
				String title = (String) arrayTitle.get(0);
				I18n i18n_title_Roman = LabelMetadata.getStringsLabel(dllmAttributes);
				I18n i18n_title = LabelMetadata.getStringsLabelBoth(dllmAttributes);
				I18n i18n_title_no_title_both = LabelMetadata.getStringsLabelNoTitleBothLanna(dllmAttributes);
				Label label = new Label(title);
				Label label_no_title_both = new Label(i18n_title_no_title_both);

				Summary summary = new Summary(new I18n("en", "The Digital Library of Northern Thai Manuscripts (DLNTM) is designed as a resource for the study of traditional literature from this region. At present, the digital library contains images of over 4,200 manuscripts which can be searched and viewed online or freely downloaded, and to which more manuscripts will be added. Collaborating institutions are the University of Pennsylvania, Chiang Mai University, the National Library of Laos, and Staatsbibliothek zu Berlin. The project was funded by the Henry Luce Foundation and the German Federal Foreign Office.")
				);

				collection.setSummary(summary);
				collection.setID("https://itr02.crossasia.org/fcrepo/rest/dlntm/collection0-2000");

				int id = parseInt(dllmAttributes.getDocuments_id().
						replace("https://itr02.crossasia.org/fcrepo/rest/dlntm/", "").
						replace("/manifest", ""));
				String manifestID = "https://itr02.crossasia.org/fcrepo/rest/dlntm/" + id + "/manifest";
				Collection.Item manifest = new Collection.Item(Collection.Item.Type.MANIFEST, manifestID);
				if (label != null) {
					manifest.setLabel(label);
				} else {
					manifest.setLabel(label_no_title_both);
				}

				items.add(manifest);
				collection.setItems(items);

				CollectionAttributes finalDllmAttributes = dllmAttributes;
			}

			PrintStream out = new PrintStream(new FileOutputStream("/data/dlmnt/fedora/results/collection.json"));
			out.println(collection.toString());
		}
	}

}
