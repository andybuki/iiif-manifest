package org.crossasia.manifest.attributes.domain;

public class ArchiveInfo {
    private String archiveId;
    private String archiveName;
    private String archiveSignatory;
    private String idInArchive;
    private String physicalLocation;

    public ArchiveInfo() {}

    // Getters and setters
    public String getArchiveId() { return archiveId; }
    public void setArchiveId(String archiveId) { this.archiveId = archiveId; }

    public String getArchiveName() { return archiveName; }
    public void setArchiveName(String archiveName) { this.archiveName = archiveName; }

    public String getArchiveSignatory() { return archiveSignatory; }
    public void setArchiveSignatory(String archiveSignatory) { this.archiveSignatory = archiveSignatory; }

    public String getIdInArchive() { return idInArchive; }
    public void setIdInArchive(String idInArchive) { this.idInArchive = idInArchive; }

    public String getPhysicalLocation() { return physicalLocation; }
    public void setPhysicalLocation(String physicalLocation) { this.physicalLocation = physicalLocation; }
}
