package org.crossasia.manifest.canvas;

import info.freelibrary.iiif.presentation.v3.AnnotationPage;
import info.freelibrary.iiif.presentation.v3.ImageContent;
import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.PaintingAnnotation;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import info.freelibrary.iiif.presentation.v3.services.ImageService3;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.crossasia.manifest.statics.manifest.ManifestData.*;

public class Canvas {
    public  void createCanvas(File file, CollectionAttributes turfanAttributes, JSONObject jsonObj, Manifest manifest) {
        String MANIFEST_THUMBNAIL_URI;
        ImageService3 manifestThumbService;
        String MANIFEST_THUMBNAIL_URI2;
        String MANIFEST_URI;
        ImageService3 manifestThumbService2;
        //start adding images
        JSONArray pages = null;
        if (jsonObj.has("pages")) {
            pages = (jsonObj.getJSONArray("pages"));
        }

        int page_int = pages.length();
        //int pages_int = 1;
        String manifestID ="";
        String canvasID ="";
        String annoID ="";
        String imageID ="";
        String annoPageID ="";

        info.freelibrary.iiif.presentation.v3.Canvas canvas = new info.freelibrary.iiif.presentation.v3.Canvas("");

        ArrayList<info.freelibrary.iiif.presentation.v3.Canvas> canvases = new ArrayList<info.freelibrary.iiif.presentation.v3.Canvas>();
        AnnotationPage<PaintingAnnotation> annoPage = new AnnotationPage<>("");
        PaintingAnnotation anno = new PaintingAnnotation("",canvas);
        ImageContent imageContent = new ImageContent("");
        for (int j = 0; j < pages.length(); j++) {
            JSONObject pagesObj = (JSONObject) pages.get(j);
            JSONObject pagesObj_first = (JSONObject) pages.get(0);

            String pages_position = "";
            String id = "";
            String pages_image_file = "";
            String pages_id = "";
            String first_pages_id = "";
            String first_page = "1";
            String pages_document_id = "";
            String description ="";
            String title3 = "";
            String place ="";
            String collection = "";
            String date = "";
            String year = "";
            String keyword = "";
            String source = "";
            String comment = "";
            String noteDate = "";
            String placeDetail ="";
            String id_identifier="";
            String dcIdentifier="";
            String akten= "";
            String image ="";
            String schemaIdentifier="";
            String position ="";
            String turfanNumberPage = "";
            String sender = "";
            String recipient = "";
            String person = "";
            JSONArray personArray=null;

            String spatial ="";
            JSONArray spatialArray=null;

            String index ="";
            JSONArray indexArray=null;

            String medium ="";
            JSONArray mediumArray=null;

            String subject ="";
            JSONArray subjectArray=null;

            String dcndlNumber ="";

            int number_of_pages = pages.length();

            if (pagesObj_first.has("pages_id")) {
                first_page = "1";
            }

            if (pagesObj.has("dcndl:number")) {
                dcndlNumber = (String) pagesObj.get("dcndl:number").toString();
            }

            if (pagesObj.has("id")) {
                id = (String) pagesObj.get("id").toString();
            }

            String [] aktenArr = id.split("_");

            akten = "akten"+aktenArr[0];


            if (pagesObj.has("dc:identifier")) {
                dcIdentifier = (String) pagesObj.get("dc:identifier").toString().trim();
                first_pages_id = (String) pagesObj_first.get("dc:identifier").toString().trim()
                        .replace(" ","").replace("/","");;                }

            String id_short = dcIdentifier.replace(" ","").replace("/","");

            if (pagesObj.has("pages_position"))
                pages_position = (String) pagesObj.get("pages_position").toString();

            if (pagesObj.has("pages_image_file"))
                pages_image_file = (String) pagesObj.get("pages_image_file").toString();

            if (pagesObj.has("position")) {
                pages_id = (String) pagesObj.get("position").toString();
                first_pages_id = turfanAttributes.getId();
            }

            if (pagesObj.has("schema:collection")) {
                collection = (String) pagesObj.get("schema:collection").toString().trim();
            }

            if (pagesObj.has("schema:person")) {
                if (pagesObj.get("schema:person") instanceof String)
                    person = (String) pagesObj.get("schema:person").toString().trim();
                else
                    personArray =pagesObj.getJSONArray("schema:person");
            }

            if (pagesObj.has("schema:index")) {
                if (pagesObj.get("schema:index") instanceof String)
                    index = (String) pagesObj.get("schema:index").toString().trim();
                else
                    indexArray =pagesObj.getJSONArray("schema:index");
            }

            if (pagesObj.has("dc:subject")) {
                if (pagesObj.get("dc:subject") instanceof String)
                    subject = (String) pagesObj.get("dc:subject").toString().trim();
                else
                    subjectArray =pagesObj.getJSONArray("dc:subject");
            }

            if (pagesObj.has("dcterms:spatial")) {
                if (pagesObj.get("dcterms:spatial") instanceof String)
                    spatial = (String) pagesObj.get("dcterms:spatial").toString().trim();
                else
                    spatialArray =pagesObj.getJSONArray("dcterms:spatial");
            }

            if (pagesObj.has("dcterms:medium")) {
                if (pagesObj.get("dcterms:medium") instanceof String)
                    medium = (String) pagesObj.get("dcterms:medium").toString().trim();
                else
                    mediumArray =pagesObj.getJSONArray("dcterms:medium");
            }


            if (pagesObj.has("schema:year")) {
                year = (String) pagesObj.get("schema:year").toString().trim();
                if (year.equals("O.Dat.")) {
                    year="o.Dat.";
                } else if (year.equals("o.Dat")) {
                    year="o.Dat.";
                }   else if (year.equals("o.Da")) {
                    year="o.Dat.";
                }
            }

            if (pagesObj.has("turfan:number_page")) {
                turfanNumberPage = (String) pagesObj.get("turfan:number_page").toString().trim();
            }

            if (pagesObj.has("turfan:sender")) {
                sender = (String) pagesObj.get("turfan:sender").toString().trim();
            }

            if (pagesObj.has("turfan:recipient")) {
                recipient = (String) pagesObj.get("turfan:recipient").toString().trim();
            }

            if (pagesObj.has("schema:comment")) {
                comment = (String) pagesObj.get("schema:comment").toString().trim();
            }

            if (pagesObj.has("schema:position")) {
                position = (String) pagesObj.get("schema:position").toString().trim();
            }

            if (pagesObj.has("dc:title")) {
                title3 = (String) pagesObj.get("dc:title").toString().trim();
            }

            if (pagesObj.has("dc:date")) {
                date = (String) pagesObj.get("dc:date").toString().trim();
                if (date.equals("O.Dat.")) {
                    date="o.Dat.";
                } else if (date.equals("o.Dat")) {
                    date="o.Dat.";
                }   else if (date.equals("o.Da")) {
                    date="o.Dat.";
                }
            }

            if (pagesObj.has("dc:description")) {
                description = (String) pagesObj.get("dc:description").toString().trim();
            }

            if (pagesObj.has("schema:image")) {
                image = (String) pagesObj.get("schema:image").toString().trim();
            }

            if (pagesObj.has("id")) {
                id_identifier = (String) pagesObj.get("id").toString().trim();
            }


            if (pagesObj.has("schema:identifier")) {
                schemaIdentifier = (String) pagesObj.get("schema:identifier").toString().trim();
            }


            MANIFEST_URI = SERVER + MANIFEST_COLLECTION + "+"+akten+"+"+ id_short + "/manifest";
            MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + "+"+akten+"+"+ id_short+   THUMBNAIL_PATH;

            try {
                URL url = new URL("https://iiif-content.crossasia.org/xasia/turfan" + "+" + akten + "+" + id_short + "/info.json");
                JSONParser jsonParser = new JSONParser();
                URLConnection urlConnection = url.openConnection();
                BufferedReader in  = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                long weight = 0;
                long height =0;
                String inputLine;
                while ((inputLine = in.readLine())!=null) {
                    org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) jsonParser.parse(inputLine);
                    weight = (Long) jsonObject.get("width");
                    height = (Long) jsonObject.get("height");
                }
                in.close();

                manifestID = SERVER + MANIFEST_COLLECTION + "" + akten + "+" + id_short;
                canvasID = manifestID + "/canvas";
                imageID = manifestID + "/full/full/0/default.jpg";
                annoID = manifestID + "/annotation";
                annoPageID = manifestID;

                canvas = new info.freelibrary.iiif.presentation.v3.Canvas(canvasID).setWidthHeight((int) weight, (int) height);

                List<Metadata> list = new ArrayList<>();


                if(!position.isEmpty()) {
                    Metadata meta = new Metadata(new Label("none", "schema:position"),
                            new Value(position));
                    list.add(meta);
                }

                if(!year.isEmpty()) {
                    Metadata meta = new Metadata(new Label("none", "schema:year"),
                            new Value(year));
                    list.add(meta);
                }

                if(!noteDate.isEmpty()) {
                    Metadata meta = new Metadata(new Label("none", "turfan:noteDate"),
                            new Value(noteDate));
                    list.add(meta);
                }

                if(!turfanNumberPage.isEmpty()) {
                    Metadata meta = new Metadata(new Label("none", "turfan:number_page"),
                            new Value(turfanNumberPage));
                    list.add(meta);
                }

                if(!dcndlNumber.isEmpty()) {
                    Metadata meta = new Metadata(new Label("none", "dcndl:number"),
                            new Value(dcndlNumber));
                    list.add(meta);
                }

                if(!title3.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "dc:title"),
                            new Value( new I18n("de", title3)));
                    list.add(meta);
                }

                if(!subject.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "dc:subject"),
                            new Value( new I18n("de", subject)));
                    list.add(meta);
                }

                if(!source.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "dcterms:source"),
                            new Value( new I18n("de", source)));
                    list.add(meta);
                }

                if(!medium.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "dcterms:medium"),
                            new Value( new I18n("de", medium)));
                    list.add(meta);
                }

                if(!comment.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "schema:comment"),
                            new Value( new I18n("de", comment)));
                    list.add(meta);
                }
                if(!collection.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "schema:collection"),
                            new Value( new I18n("de", collection)));
                    list.add(meta);
                }


                if(!description.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "dc:description"),
                            new Value( new I18n("de", description)));
                    list.add(meta);
                }

                if(!place.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "dc:place"),
                            new Value( new I18n("de", place)));
                    list.add(meta);
                }

                if(!placeDetail.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "turfan:placeDetail"),
                            new Value( new I18n("de", placeDetail)));
                    list.add(meta);
                }

                if (!dcIdentifier.isEmpty()) {
                    Metadata meta = new Metadata(new Label("none", "dc:identifier"),
                            new Value(dcIdentifier));
                    list.add(meta);
                }

                if (!person.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "schema:person"),
                            new Value(person));
                    list.add(meta);
                }

                if (!index.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "schema:index"),
                            new Value(index));
                    list.add(meta);
                }

                if (!spatial.isEmpty()) {
                    Metadata meta = new Metadata(new Label("de", "dcterms:spatial"),
                            new Value(spatial));
                    list.add(meta);
                }

                if (personArray!=null) {
                    List<String> l = new ArrayList<>();
                    for (int i = 0; i< personArray.length(); i++) {
                        l.add((String) personArray.get(i));
                    }
                    I18n i18n = new I18n("de", l);
                    Metadata meta = new Metadata(new Label("de", "schema:person"),
                            new Value(new I18n[]{i18n}));
                    list.add(meta);
                }

                if (indexArray!=null) {
                    List<String> l = new ArrayList<>();
                    for (int i = 0; i< indexArray.length(); i++) {
                        l.add((String) indexArray.get(i));
                    }
                    I18n i18n = new I18n("de", l);
                    Metadata meta = new Metadata(new Label("de", "schema:index"),
                            new Value(new I18n[]{i18n}));
                    list.add(meta);
                }

                if (subjectArray!=null) {
                    List<String> l = new ArrayList<>();
                    for (int i = 0; i< subjectArray.length(); i++) {
                        l.add((String) subjectArray.get(i));
                    }
                    I18n i18n = new I18n("de", l);
                    Metadata meta = new Metadata(new Label("de", "dc:subject"),
                            new Value(new I18n[]{i18n}));
                    list.add(meta);
                }

                if (spatialArray!=null) {
                    List<String> l = new ArrayList<>();
                    for (int i = 0; i< spatialArray.length(); i++) {
                        l.add((String) spatialArray.get(i));
                    }
                    I18n i18n = new I18n("de", l);
                    Metadata meta = new Metadata(new Label("de", "dcterms:spatial"),
                            new Value(new I18n[]{i18n}));
                    list.add(meta);
                }

                if (mediumArray!=null) {
                    List<String> l = new ArrayList<>();
                    for (int i = 0; i< mediumArray.length(); i++) {
                        l.add((String) mediumArray.get(i));
                    }
                    I18n i18n = new I18n("de", l);
                    Metadata meta = new Metadata(new Label("de", "dcterms:medium"),
                            new Value(new I18n[]{i18n}));
                    list.add(meta);
                }

                if(!keyword.isEmpty()) {
                    ArrayList<String> l = new ArrayList<>();
                    if (keyword.contains(";")) {
                        String [] keywords = keyword.split(";");
                        Collections.addAll(l, keywords);
                    } else {
                        l.add(keyword);
                    }
                    I18n i18n = new I18n("de", l);
                    Metadata meta = new Metadata(new Label("de", "schema:keyword"),
                            new Value(new I18n[]{i18n}));
                    list.add(meta);
                }

                if(!schemaIdentifier.isEmpty()) {
                    ArrayList<String> l = new ArrayList<>();
                    if (schemaIdentifier.contains(";")) {
                        String [] keywords = schemaIdentifier.split(";");
                        Collections.addAll(l, keywords);
                    } else {
                        l.add(schemaIdentifier);
                    }
                    I18n i18n = new I18n("none", l);
                    Metadata meta = new Metadata(new Label("none", "schema:identifier"),
                            new Value(new I18n[]{i18n}));
                    list.add(meta);
                }

                if(!sender.isEmpty()) {
                    ArrayList<String> l = new ArrayList<>();
                    if (sender.contains(";")) {
                        String [] keywords = sender.split(";");
                        Collections.addAll(l, keywords);
                    } else {
                        l.add(sender);
                    }
                    I18n i18n = new I18n("de", l);
                    Metadata meta = new Metadata(new Label("de", "turfan:sender"),
                            new Value(new I18n[]{i18n}));
                    list.add(meta);
                }

                if(!recipient.isEmpty()) {
                    ArrayList<String> l = new ArrayList<>();
                    if (recipient.contains(";")) {
                        String [] keywords = recipient.split(";");
                        Collections.addAll(l, keywords);
                    } else {
                        l.add(recipient);
                    }
                    I18n i18n = new I18n("de", l);
                    Metadata meta = new Metadata(new Label("de", "turfan:recipient"),
                            new Value(new I18n[]{i18n}));
                    list.add(meta);
                }

                if(!date.isEmpty()) {
                    Metadata meta = new Metadata(new Label("none", "dc:date"),
                            new Value(date));
                    list.add(meta);
                }

                canvas.setMetadata(list);
                //canvas.setMetadata(metadataMembers(turfanAttributes, manifest));

                imageContent = new ImageContent(imageID).setWidthHeight((int) weight, (int) height);
                ImageService3 manifestThumbService3 = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ akten+"+"+ id_short);
                imageContent.setServices(manifestThumbService3);

                //canvas.setServices(manifestThumbService3);

            }catch (NullPointerException e) {
                e.printStackTrace();
                System.out.println(e +" - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
            }catch (ParseException e) {
                e.printStackTrace();
                System.out.println(e +" - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
            }catch (Exception e) {
                e.printStackTrace();
                System.out.println(e +" - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
            }
            MANIFEST_URI = SERVER + MANIFEST_COLLECTION + akten +"+"+id_short  + "/manifest";
            MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + akten+"+"+ id_short+   THUMBNAIL_PATH;
            MANIFEST_THUMBNAIL_URI2 = SERVER + MANIFEST_COLLECTION + akten+"+"+ first_pages_id+   THUMBNAIL_PATH;
            manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ akten+"+"+ id_short);
            annoPage = new AnnotationPage<>(annoPageID);

            //canvas.setLabel(pages_document_id+ ": "+ jsonObj.get("dc:title") + " ("+pagesObj.get("name")+ ")");
            canvas.setLabel(pagesObj.get("schema:collection") + " | ("+pagesObj.get("dc:identifier")+ ")");

            //canvas.setServices(manifest.set,SERVER + MANIFEST_COLLECTION + pages_document_id +"+"+pages_id );
            canvas.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI));
            anno = new PaintingAnnotation(annoID, canvas);
            //annoPage.setServices(manifestThumbService);
            annoPage.addAnnotations(anno.setBodies(imageContent).setTarget(canvasID));

            canvases.add(canvas.setPaintingPages(annoPage));

            //canvases.add(canvas.setLabel(pages_document_id+ ":"+ jsonObj.get("dc:title") + " ("+pagesObj.get("old_name")+ ")"));
            manifest.setCanvases(canvases);


            manifestThumbService2 = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ akten+"+"+ first_pages_id);
            //manifest.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService2));
            manifest.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI2));

        }
        //end adding images
    }
}
