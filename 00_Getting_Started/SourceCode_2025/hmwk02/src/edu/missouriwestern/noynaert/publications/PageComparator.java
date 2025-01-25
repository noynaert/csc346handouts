package edu.missouriwestern.noynaert.publications;

import java.util.Comparator;

public class PageComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
        int result = 0;
        result = first.getPages() - second.getPages();
        if (result == 0) {
            first.getTitle().compareTo(second.getTitle());
        }
        return result;
    }

    @Override
    public Comparator<Book> reversed() {
        return Comparator.super.reversed();
    }
}
