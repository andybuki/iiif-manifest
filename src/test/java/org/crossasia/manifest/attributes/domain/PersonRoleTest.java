package org.crossasia.manifest.attributes.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@DisplayName("PersonRole Tests")
public class PersonRoleTest {

    private PersonRole personRole;

    @BeforeEach
    public void setUp() {
        personRole = new PersonRole();
    }

    @Test
    @DisplayName("Should construct with parameters")
    public void testConstructorWithParameters() {
        PersonRole role = new PersonRole("person-123", "John Doe", "Author");

        assertEquals("person-123", role.getPersonId());
        assertEquals("John Doe", role.getPersonName());
        assertEquals("Author", role.getRole());
    }

    @Test
    @DisplayName("Should set and get person names list")
    public void testSetGetPersonNames() {
        List<String> names = Arrays.asList("John Doe", "Jane Smith");
        personRole.setPersonNames(names);

        assertEquals(2, personRole.getPersonNames().size());
        assertEquals("John Doe", personRole.getPersonNames().get(0));
    }

    @Test
    @DisplayName("Should set and get role comment")
    public void testSetGetRoleComment() {
        personRole.setRoleComment("Primary author");
        assertEquals("Primary author", personRole.getRoleComment());
    }
}
