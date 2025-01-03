package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class LessonsCards {
    private String name;
    private String dateString;
    private LocalDate date;
    private String url;

    public LessonsCards(String text, String dateString, String url) {
        this.name = text;
        this.dateString = dateString;
        this.date = LocalDate.parse(dateString.substring(0, dateString.indexOf(" ·")), DateTimeFormatter.ofPattern("d MMMM, yyyy", new Locale("ru")));
        this.url = url;
    }

    public LessonsCards(String text, String dateString, LocalDate date) {
        this.name = text;
        this.dateString = dateString;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDateString() {
        return dateString;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LessonsCards that = (LessonsCards) o;
        return Objects.equals(name, that.name) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date);
    }
}