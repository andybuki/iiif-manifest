package org.crossasia.manifest.attributes.domain;

import java.util.List;

/**
 * Represents a person and their role in a document.
 *
 * <p>This class is used to capture information about individuals involved in documents,
 * such as senders, receivers, signatories, or witnesses. It supports both single names
 * and multiple name variants (e.g., different language representations).</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * PersonRole sender = new PersonRole("P001", "Dalai Lama", "Sender");
 * sender.setRoleComment("Religious and political leader");
 * }</pre>
 *
 * @see org.crossasia.manifest.attributes.DtabAttributes
 */
public class PersonRole {
    /** Unique identifier for the person */
    private String personId;

    /** Primary name of the person */
    private String personName;

    /** List of alternative names or name variants (e.g., different languages) */
    private List<String> personNames;

    /** Role of the person in the document (e.g., "Sender", "Receiver", "Witness") */
    private String role;

    /** Additional comments or context about the person's role */
    private String roleComment;

    /**
     * Default constructor.
     */
    public PersonRole() {}

    /**
     * Constructs a PersonRole with basic information.
     *
     * @param personId unique identifier for the person
     * @param personName primary name of the person
     * @param role role of the person in the document
     */
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