package org.crossasia.manifest;

import info.freelibrary.iiif.presentation.v3.Collection;
import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Summary;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.crossasia.manifest.json.StaticJsonCaller;
import org.crossasia.manifest.metadata.LabelMetadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.crossasia.manifest.IIIFPresentationDlmnt.ORIGINAL_LANGUAGE;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;

@SpringBootApplication
public class IIIFCollectionDllm {

	public static void main(String[] args) throws IOException {

		String quote = "\u005c\u0022";
		File absolutePath = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/presentation/splitter/");
		//PrintStream out = new PrintStream(new FileOutputStream("src/main/resources/output.txt"));
		File dir = new File(String.valueOf(absolutePath));
		File[] filesInDir = dir.listFiles();
		int counter = 1;
		File created = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/presentation/result3/");
		Collection collection = new Collection("Collection", "Digital Library of Lao Manuscripts 0-1000");
		List<Collection.Item> items = new ArrayList<>();


		for (File file : filesInDir) {
			DllmAttributes dllmAttributes = new DllmAttributes();
			int lentgthFiles =  filesInDir.length;
			JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));
			StaticJsonCaller.staticJsonCaller(dllmAttributes, jsonObj);
			I18n i18n_title_Roman = LabelMetadata.getStringsLabel(dllmAttributes);
			I18n i18n_title = LabelMetadata.getStringsLabelBoth(dllmAttributes);
			I18n i18n_title_no_title_both = LabelMetadata.getStringsLabelNoTitleBoth(dllmAttributes);
			Label label = new Label(i18n_title);
			Label label_no_title_both = new Label(i18n_title_no_title_both);

			Summary summary = new Summary(new I18n("en", "The Digital Library of Lao Manuscripts makes images of over 12,000 texts from throughout Laos easily accessible for study. Collaborating institutions are the National Library of Laos, the University of Passau, and the Staatsbibliothek zu Berlin Preußischer Kulturbesitz. The project is funded by the German Research Foundation (DFG) and the German Federal Ministry of Economic Cooperation and Development (BMZ)."),
					new I18n(ORIGINAL_LANGUAGE, "ຫໍສະໝຸດດິຈິຕອລໜັງສືໃບລານລາວ ມີຮູບດິຈິຕອລ ຫຼາຍກວ່າ 12,000 ຕົ້ນສະບັບຕົວຂຽນ ຈາກທົ່ວປະເທດ ເພື່ອໃຫ້ຜູ້ສົນໃຈເຂົ້າຄົ້ນຄວ້າຢ່າງສະດວກສະບາຍ. ສະຖາບັນຮ່ວມມື ມີ ຫໍສະໝຸດແຫ່ງຊາດລາວ, ມະຫາວິທະຍາໄລ ປັສເຊົາ ແລະ ຫໍສະໝຸດແຫ່ງລັດ ປະຈຳກຸງແບັກແລັງ ໂຄງການນີ້ໄດ້ຮັບທຶນອຸປະຖຳຈາກມູນນິທິ ເພື່ອການຄົ້ນຄວ້າ ເຢຍຣະມັນ (DFG) ແລະ ກະຊວງການຮ່ວມມືທາງເສດຖະກິດ ແລະ ການພັດທະນາແຫ່ງ ສ.ສ. ເຢຍຣະມັນ (BMZ)."));

			collection.setSummary(summary);
			collection.setID("https://itr02.crossasia.org/fcrepo/rest/dllm/collection0-1000");

			int id = parseInt(dllmAttributes.getDocuments_id().replace("dllm_",""));
			String manifestID = "https://itr02.crossasia.org/fcrepo/rest/dllm/dllm_000"+id+"/manifest";
			Collection.Item manifest = new Collection.Item(Collection.Item.Type.MANIFEST, manifestID);
			if (i18n_title_Roman!=null) {
				manifest.setLabel(label);
			} else {
				manifest.setLabel(label_no_title_both);
			}

			items.add(manifest);
			collection.setItems(items);

			DllmAttributes finalDllmAttributes = dllmAttributes;

			/*Collections.sort(collection, new Comparator<Collection>() {


				@Override
				public int compare(JSONObject jsonObjectA, JSONObject jsonObjectB) {
					int compare = 0;
					try
					{
						int keyA = jsonObjectA.getInt("key");
						int keyB = jsonObjectB.getInt("key");
						compare = Integer.compare(keyA, keyB);
					}
					catch(JSONException e)
					{
						e.printStackTrace();
					}
					return compare;
				}
			});*/


		}




		PrintStream out = new PrintStream(new FileOutputStream("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/presentation/result3/collection2.json"));
		out.println(collection.toString());
	}

}
