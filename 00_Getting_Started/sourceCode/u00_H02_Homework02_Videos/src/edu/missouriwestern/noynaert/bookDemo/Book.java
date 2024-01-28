package edu.missouriwestern.noynaert.bookDemo;

import java.util.Objects;

/**
 * POJO that represents a book.
 *
 * @author J. Evan Noynaert
 * @since January 2024
 */
public class Book implements Comparable<Book>{
    private String isbn;  //10-digit ISBN
    private String author;
    String title;
    private int year;  //original publicat year

    public Book(String isbn, String author, String title, int year) {
        setIsbn(isbn);
        setAuthor(author);
        setTitle(title);
        setYear(year);
    }

    /**
     *  Accepts the year as a double.  It truncates it to the year.
     *  This was done because the database was representing the year and month with decimals.
     *
     * @param isbn
     * @param author
     * @param title
     * @param year as a double.  It is converted to an int
     */
    public Book(String isbn, String author, String title, double year) {
        this(isbn,author,title,(int)year);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Accepts the year as a double.  It truncates it to the year.
     * This was done because the database was representing the year and month with decimals.
     *
     * The year is converted by truncation rather than rounding.
     * @param year
     */
    public void setYear(double year){
        setYear((int)year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }

    /**
     * compares based on author first, then title, then year, and finally on isbn.
     * It should produce unique results.
     *
     * @param other the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Book other) {
        int result = author.compareToIgnoreCase(other.author);
        if (result==0){
            result = title.compareToIgnoreCase(other.title);
        }
        if(result==0){
            if(year < other.year)
                result = -1;
            else
                result = 1;
        }
        if(result==0) {
            result = isbn.compareTo(other.isbn);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
