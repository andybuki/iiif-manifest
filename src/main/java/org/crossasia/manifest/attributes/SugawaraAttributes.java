package org.crossasia.manifest.attributes;

import org.crossasia.manifest.attributes.domain.PersonRole;
import org.crossasia.manifest.attributes.domain.ScriptInfo;
import org.crossasia.manifest.attributes.domain.SealInfo;
import org.json.JSONArray;

import java.util.List;

public class SugawaraAttributes extends CollectionAttributes {

    private String folder;
    private String category;

    // Subject/classification
    private List<String> subjects;

    // Physical characteristics
    private String physicalData;
    private String physicalType;
    private String extent;

    // Tax stamps
    private List<String> taxStamps;

    // Document info
    private String document;

    // Person roles
    private PersonRole roleA;
    private PersonRole roleB;

    // Seals
    private SealInfo sealInfo;

    // Language
    private ScriptInfo scriptInfo;

    // Citations and grants
    private String citation;
    private String grant;
    private String abstractText;

    public SugawaraAttributes() {
        super();
    }

    // Getters and setters
    public String getFolder() { return folder; }
    public void setFolder(String folder) { this.folder = folder; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public List<String> getSubjects() { return subjects; }
    public void setSubjects(List<String> subjects) { this.subjects = subjects; }

    public String getPhysicalData() { return physicalData; }
    public void setPhysicalData(String physicalData) { this.physicalData = physicalData; }

    public String getPhysicalType() { return physicalType; }
    public void setPhysicalType(String physicalType) { this.physicalType = physicalType; }

    public String getExtent() { return extent; }
    public void setExtent(String extent) { this.extent = extent; }

    public List<String> getTaxStamps() { return taxStamps; }
    public void setTaxStamps(List<String> taxStamps) { this.taxStamps = taxStamps; }

    public String getDocument() { return document; }
    public void setDocument(String document) { this.document = document; }

    public PersonRole getRoleA() { return roleA; }
    public void setRoleA(PersonRole roleA) { this.roleA = roleA; }

    public PersonRole getRoleB() { return roleB; }
    public void setRoleB(PersonRole roleB) { this.roleB = roleB; }

    public SealInfo getSealInfo() { return sealInfo; }
    public void setSealInfo(SealInfo sealInfo) { this.sealInfo = sealInfo; }

    public ScriptInfo getScriptInfo() { return scriptInfo; }
    public void setScriptInfo(ScriptInfo scriptInfo) { this.scriptInfo = scriptInfo; }

    public String getCitation() { return citation; }
    public void setCitation(String citation) { this.citation = citation; }

    public String getGrant() { return grant; }
    public void setGrant(String grant) { this.grant = grant; }

    public String getAbstractText() { return abstractText; }
    public void setAbstractText(String abstractText) { this.abstractText = abstractText; }
}
