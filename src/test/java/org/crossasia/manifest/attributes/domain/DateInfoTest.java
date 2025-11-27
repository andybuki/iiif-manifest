package org.crossasia.manifest.attributes.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@DisplayName("DateInfo Tests")
public class DateInfoTest {

    private DateInfo dateInfo;

    @BeforeEach
    public void setUp() {
        dateInfo = new DateInfo();
    }

    @Test
    @DisplayName("Should set and get date")
    public void testSetGetDate() {
        dateInfo.setDate("2024-01-01");
        assertEquals("2024-01-01", dateInfo.getDate());
    }

    @Test
    @DisplayName("Should set and get dates list")
    public void testSetGetDates() {
        List<String> dates = Arrays.asList("2024-01-01", "2024-12-31");
        dateInfo.setDates(dates);

        assertEquals(2, dateInfo.getDates().size());
        assertEquals("2024-01-01", dateInfo.getDates().get(0));
    }

    @Test
    @DisplayName("Should set and get dateOriginal")
    public void testSetGetDateOriginal() {
        dateInfo.setDateOriginal("1900-05-15");
        assertEquals("1900-05-15", dateInfo.getDateOriginal());
    }

    @Test
    @DisplayName("Should set and get hijri year and month")
    public void testSetGetHijriDate() {
        dateInfo.setHijriYear("1445");
        dateInfo.setHijriMonth("Ramadan");

        assertEquals("1445", dateInfo.getHijriYear());
        assertEquals("Ramadan", dateInfo.getHijriMonth());
    }

    @Test
    @DisplayName("Should set and get dateId")
    public void testSetGetDateId() {
        dateInfo.setDateId("date-123");
        assertEquals("date-123", dateInfo.getDateId());
    }

    @Test
    @DisplayName("Builder should construct DateInfo correctly")
    public void testBuilder() {
        DateInfo result = new DateInfo.Builder()
                .date("2024-01-01")
                .dateOriginal("1900-01-01")
                .hijriYear("1445")
                .build();

        assertEquals("2024-01-01", result.getDate());
        assertEquals("1900-01-01", result.getDateOriginal());
        assertEquals("1445", result.getHijriYear());
    }
}
