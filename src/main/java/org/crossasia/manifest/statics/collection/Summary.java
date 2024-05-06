package org.crossasia.manifest.statics.collection;

public enum Summary {

    TURFAN("Die hier präsentierten Turfan Akten versammeln die im Museum für Asiatische Kunst (AKu) verwahrten 21 Aktenbände. Die Aktenbände I bis XV sowie der Aktenband XVII enthalten im Museum für Völkerkunde (erst Königliches Museum für Völkerkunde, später dann Staatliches Museum für Völkerkunde) archivierten Unterlagen zu den Hintergründen für die Aussendung, Vorbereitung, Planung, Ausführung und Abrechnung der Expeditionen sowie die Korrespondenz mit Wissenschaftlern bzw. Berichte und Anträge im Hinblick auf die Erforschung, Konservierung und Präsentation der aus Chinesisch Zentralasien mitgebrachten Objekte im damaligen Museum für Völkerkunde. Die Aktenbände XVI sowie XVIII bis XXI enthalten den Schriftwechsel, der ursprünglich beim sogenannten Turfan-Komitee (Lokalkomitee zur Erforschung Zentral-Asiens) verwahrt wurde, und dann, nach Auflösung des Komitees, in die Obhut des Museums für Völkerkunde überging."),
    SUGAWARA("The collection contains roughly eight hundred contractual documents from the Kashgar Region from the beginning of the 19th to the mid 20th century."),
    DTAB("The database Digital Tibetan Archives Bonn (DTAB) is a collection of more than 4400 handwritten Tibetan legal texts, which were digitized and described within two research projects led by Prof. Dr. Peter Schwieger 1999-2005.");
    private String value;
    Summary(String value) {
        this.value = value;
    }

    public String getVal() {
        return value;
    }
}
