package org.crossasia.manifest.attributes.domain;

import java.util.List;

public class SealInfo {
    private String sealId;
    private List<String> sealIds;
    private String seal;
    private List<String> seals;

    // Physical characteristics
    private List<String> colors;
    private List<String> forms;
    private List<String> sizes;
    private List<String> inscriptions;

    // Metadata
    private List<String> nameOfScripts;
    private List<String> commentUsedScripts;
    private List<String> references;
    private List<String> comments;
    private List<String> links;
    private List<String> imageFiles;
    private List<String> compare;

    // Document associations
    private List<String> documentIds;
    private List<String> multiSeal;

    public SealInfo() {}

    // Getters and setters
    public String getSealId() { return sealId; }
    public void setSealId(String sealId) { this.sealId = sealId; }

    public List<String> getSealIds() { return sealIds; }
    public void setSealIds(List<String> sealIds) { this.sealIds = sealIds; }

    public String getSeal() { return seal; }
    public void setSeal(String seal) { this.seal = seal; }

    public List<String> getSeals() { return seals; }
    public void setSeals(List<String> seals) { this.seals = seals; }

    public List<String> getColors() { return colors; }
    public void setColors(List<String> colors) { this.colors = colors; }

    public List<String> getForms() { return forms; }
    public void setForms(List<String> forms) { this.forms = forms; }

    public List<String> getSizes() { return sizes; }
    public void setSizes(List<String> sizes) { this.sizes = sizes; }

    public List<String> getInscriptions() { return inscriptions; }
    public void setInscriptions(List<String> inscriptions) { this.inscriptions = inscriptions; }

    public List<String> getNameOfScripts() { return nameOfScripts; }
    public void setNameOfScripts(List<String> nameOfScripts) { this.nameOfScripts = nameOfScripts; }

    public List<String> getCommentUsedScripts() { return commentUsedScripts; }
    public void setCommentUsedScripts(List<String> commentUsedScripts) {
        this.commentUsedScripts = commentUsedScripts;
    }

    public List<String> getReferences() { return references; }
    public void setReferences(List<String> references) { this.references = references; }

    public List<String> getComments() { return comments; }
    public void setComments(List<String> comments) { this.comments = comments; }

    public List<String> getLinks() { return links; }
    public void setLinks(List<String> links) { this.links = links; }

    public List<String> getImageFiles() { return imageFiles; }
    public void setImageFiles(List<String> imageFiles) { this.imageFiles = imageFiles; }

    public List<String> getCompare() { return compare; }
    public void setCompare(List<String> compare) { this.compare = compare; }

    public List<String> getDocumentIds() { return documentIds; }
    public void setDocumentIds(List<String> documentIds) { this.documentIds = documentIds; }

    public List<String> getMultiSeal() { return multiSeal; }
    public void setMultiSeal(List<String> multiSeal) { this.multiSeal = multiSeal; }
}