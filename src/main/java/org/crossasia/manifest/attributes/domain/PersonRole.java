package org.crossasia.manifest.attributes.domain;

import java.util.List;

public class PersonRole {
    private String personId;
    private String personName;
    private List<String> personNames;
    private String role;
    private String roleComment;

    public PersonRole() {}

    public PersonRole(String personId, String personName, String role) {
        this.personId = personId;
        this.personName = personName;
        this.role = role;
    }

    // Getters and setters
    public String getPersonId() { return personId; }
    public void setPersonId(String personId) { this.personId = personId; }

    public String getPersonName() { return personName; }
    public void setPersonName(String personName) { this.personName = personName; }

    public List<String> getPersonNames() { return personNames; }
    public void setPersonNames(List<String> personNames) { this.personNames = personNames; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getRoleComment() { return roleComment; }
    public void setRoleComment(String roleComment) { this.roleComment = roleComment; }
}
