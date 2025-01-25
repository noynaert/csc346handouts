package edu.missouriwestern.noynaert.publications;

import java.io.Serializable;
import java.util.Objects;

/**
 * The book class contains two fields.  The fields are title:String and pages:int
 *
 * @author J.Evan Noynaert
 * @since January, 2025
 */

public class Book implements Comparable<Book> {
    private String title;
    private int pages;

    public Book() {
        this("Unknown", -99);
    }

    public Book(String title, int pages) {
        setTitle(title);
        setPages(pages);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    /**
     * If the number of pages is over 1500, the data field is set to 1500
     * If the number of pages is less than 0, the data field is set to 0
     *
     * @param pages
     */

    public void setPages(int pages) {
        this.pages = pages;

        if (pages < 0) {
            this.pages = 0;
        }
        if (pages > 1500) {
            this.pages = 1500;
        }

//        this.pages = (pages < 0) ? 0 : pages;
//        this.pages = (pages > 1500) ? 1500 : pages;

    }

    public String toString() {
        String s = String.format("Title: \"%s\", Pages: %,d", title, pages);

        return s;
    }

    @Override
    public int compareTo(Book other) {
        int result = 0;
        result = this.title.compareTo(other.title);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pages);
    }
}



