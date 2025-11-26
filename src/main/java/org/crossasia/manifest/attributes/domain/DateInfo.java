package org.crossasia.manifest.attributes.domain;

import java.util.List;

public class DateInfo {
    private String date;
    private List<String> dates;
    private String dateOriginal;
    private String yearOriginal;
    private String wholeDate;
    private String noteDate;
    private String descriptionDate;

    // Hijri calendar specific
    private String hijriYear;
    private String hijriMonth;
    private String dayOfWeek;

    public DateInfo() {}

    // Builder pattern
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

    public String getHijriYear() { return hijriYear; }
    public void setHijriYear(String hijriYear) { this.hijriYear = hijriYear; }

    public String getHijriMonth() { return hijriMonth; }
    public void setHijriMonth(String hijriMonth) { this.hijriMonth = hijriMonth; }

    public String getDayOfWeek() { return dayOfWeek; }
    public void setDayOfWeek(String dayOfWeek) { this.dayOfWeek = dayOfWeek; }
}
