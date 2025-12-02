package org.crossasia.manifest.attributes.domain;

import java.util.List;

/**
 * Represents date information for historical documents.
 *
 * <p>This class supports multiple calendar systems and date formats commonly found
 * in historical documents, including Gregorian, Hijri (Islamic), and original
 * calendar notations used in the source documents.</p>
 *
 * <h3>Supported Calendar Systems</h3>
 * <ul>
 *   <li><strong>Gregorian:</strong> Standard date and year fields</li>
 *   <li><strong>Hijri:</strong> Islamic calendar with year and month</li>
 *   <li><strong>Original:</strong> Date as written in the original document</li>
 * </ul>
 *
 * <h3>Example Usage with Builder</h3>
 * <pre>{@code
 * DateInfo dateInfo = new DateInfo.Builder()
 *     .date("1850-03-15")
 *     .dateOriginal("15th day of the 3rd month, Year of the Iron Dog")
 *     .hijriYear("1266")
 *     .hijriMonth("Rajab")
 *     .build();
 * }</pre>
 *
 * @see org.crossasia.manifest.attributes.DtabAttributes
 */
public class DateInfo {
    /** Standard date representation (typically Gregorian) */
    private String date;

    /** Multiple date values or date ranges */
    private List<String> dates;

    /** Date as written in the original document */
    private String dateOriginal;

    /** Year as written in the original document */
    private String yearOriginal;

    /** Complete date expression combining all components */
    private String wholeDate;

    /** Additional notes about the date */
    private String noteDate;

    /** Description or explanation of the date */
    private String descriptionDate;

    /** Reference ID for date description */
    private String dateDescriptionId;

    /** Unique identifier for this date entry */
    private String dateId;

    // Hijri calendar specific

    /** Year in the Hijri (Islamic) calendar */
    private String hijriYear;

    /** Month in the Hijri calendar (e.g., "Ramadan", "Muharram") */
    private String hijriMonth;

    /** Day of the week */
    private String dayOfWeek;

    /**
     * Default constructor.
     */
    public DateInfo() {}

    /**
     * Builder for constructing DateInfo instances with a fluent API.
     *
     * <p>Example:</p>
     * <pre>{@code
     * DateInfo info = new DateInfo.Builder()
     *     .date("1850")
     *     .dateOriginal("Year of the Iron Dog")
     *     .build();
     * }</pre>
     */
    public static class Builder {
        private DateInfo dateInfo = new DateInfo();

        public Builder date(String date) {
            dateInfo.date = date;
            return this;
        }

        public Builder dates(List<String> dates) {
            dateInfo.dates = dates;
            return this;
        }

        public Builder dateOriginal(String dateOriginal) {
            dateInfo.dateOriginal = dateOriginal;
            return this;
        }

        public Builder yearOriginal(String yearOriginal) {
            dateInfo.yearOriginal = yearOriginal;
            return this;
        }

        public Builder wholeDate(String wholeDate) {
            dateInfo.wholeDate = wholeDate;
            return this;
        }

        public Builder hijriYear(String hijriYear) {
            dateInfo.hijriYear = hijriYear;
            return this;
        }

        public Builder hijriMonth(String hijriMonth) {
            dateInfo.hijriMonth = hijriMonth;
            return this;
        }

        public DateInfo build() {
            return dateInfo;
        }
    }

    // Getters and setters
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public List<String> getDates() { return dates; }
    public void setDates(List<String> dates) { this.dates = dates; }

    public String getDateOriginal() { return dateOriginal; }
    public void setDateOriginal(String dateOriginal) { this.dateOriginal = dateOriginal; }

    public String getYearOriginal() { return yearOriginal; }
    public void setYearOriginal(String yearOriginal) { this.yearOriginal = yearOriginal; }

    public String getWholeDate() { return wholeDate; }
    public void setWholeDate(String wholeDate) { this.wholeDate = wholeDate; }

    public String getNoteDate() { return noteDate; }
    public void setNoteDate(String noteDate) { this.noteDate = noteDate; }

    public String getDescriptionDate() { return descriptionDate; }
    public void setDescriptionDate(String descriptionDate) { this.descriptionDate = descriptionDate; }

    public String getDateDescriptionId() { return dateDescriptionId; }
    public void setDateDescriptionId(String dateDescriptionId) { this.dateDescriptionId = dateDescriptionId; }

    public String getHijriYear() { return hijriYear; }
    public void setHijriYear(String hijriYear) { this.hijriYear = hijriYear; }

    public String getHijriMonth() { return hijriMonth; }
    public void setHijriMonth(String hijriMonth) { this.hijriMonth = hijriMonth; }

    public String getDayOfWeek() { return dayOfWeek; }
    public void setDayOfWeek(String dayOfWeek) { this.dayOfWeek = dayOfWeek; }

    public String getDateId() { return dateId; }
    public void setDateId(String dateId) { this.dateId = dateId; }
}