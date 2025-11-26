package org.crossasia.manifest.attributes.base;

public abstract  class BaseCollectionAttributes {
    private String id;
    private String identifier;
    private String title;
    private String description;

    protected BaseCollectionAttributes() {}

    protected BaseCollectionAttributes(String id, String identifier, String title, String description) {
        this.id = id;
        this.identifier = identifier;
        this.title = title;
        this.description = description;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getIdentifier() { return identifier; }
    public void setIdentifier(String identifier) { this.identifier = identifier; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
