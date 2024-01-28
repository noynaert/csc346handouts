package edu.missouriwestern.noynaert.bookDemo;

import java.util.Comparator;
/**
 * compares by year.  If the year is a tie, then compare by the standard Book compareTo.
 */
public class CompareYear implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        int result = book1.getYear() - book2.getYear();
        if(result==0)
            result = book1.compareTo(book2);
        return result;
    }
}
