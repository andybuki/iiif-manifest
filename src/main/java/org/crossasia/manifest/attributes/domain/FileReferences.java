package org.crossasia.manifest.attributes.domain;

import java.util.List;

public class FileReferences {
    private List<String> previewImageFiles;
    private String transcriptionFiles;
    private String htmlFiles;
    private String otherFiles;

    public FileReferences() {}

    // Getters and setters
    public List<String> getPreviewImageFiles() { return previewImageFiles; }
    public void setPreviewImageFiles(List<String> previewImageFiles) {
        this.previewImageFiles = previewImageFiles;
    }

    public String getTranscriptionFiles() { return transcriptionFiles; }
    public void setTranscriptionFiles(String transcriptionFiles) {
        this.transcriptionFiles = transcriptionFiles;
    }

    public String getHtmlFiles() { return htmlFiles; }
    public void setHtmlFiles(String htmlFiles) { this.htmlFiles = htmlFiles; }

    public String getOtherFiles() { return otherFiles; }
    public void setOtherFiles(String otherFiles) { this.otherFiles = otherFiles; }
}
