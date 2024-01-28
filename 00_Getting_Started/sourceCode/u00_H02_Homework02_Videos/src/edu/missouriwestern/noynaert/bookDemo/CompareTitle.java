package edu.missouriwestern.noynaert.bookDemo;

import java.util.Comparator;

/**
 * Compares titles of two books, ignoring case.
 */
public class CompareTitle implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        int result = book1.title.compareToIgnoreCase(book2.getTitle());
        return result;
    }
}
