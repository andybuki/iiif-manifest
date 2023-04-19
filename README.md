# IIIFManifestBuilder

This app is for creating IIIF Manifests, based on IIIF 3.0 Presentation Standart, from already existing Json files.

I use predifined names in metadata block.
You need to adapt your json file before creating a IIIF Manifest.

As result you'll get a IIIF Manifest. If you add a folger of Json files you'll get a list of IIIF Manifests back.


Hier i'll publish some examples:

First of all how should your json file look like.

I'll give you a list of possible metadata fileds, that i allready use in my IIIF Manifests.
Before starting you need to give a URL with your IIIF Image Server.

I store Image files in Fedora repository and use https://ngcs-beta.staatsbibliothek-berlin.de/docs  NGCS-Chula as IIIF Image Server
The actual version based on IIIF standard 2.1, but IIIF Presentation 3.0 works correctly with the previous version.


Each json file will converts in one IIIF Manifest. 
Json file should have pages array where all the pages are. 

Hier i give a list of all obligatorily fields in metadata and in pages level