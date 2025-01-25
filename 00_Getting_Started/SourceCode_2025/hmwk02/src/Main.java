import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import edu.missouriwestern.noynaert.publications.Book;
import edu.missouriwestern.noynaert.publications.PageComparator;
import edu.missouriwestern.noynaert.utility.Toolkit;

public class Main {
    public static void main(String[] args) {
        final String ADDRESS = "https://raw.githubusercontent.com/noynaert/csc346handouts/refs/heads/main/dataFiles/sanderson.md";
        ArrayList<String> lines = new ArrayList<>();
        Toolkit.readURL(ADDRESS,lines);
        Toolkit.printList(lines,"Input lines");

        ArrayList<Book> books = makeBooks(lines);
        Collections.sort(books, new PageComparator().reversed());
        Collections.sort(books, new BookTitleLengthComparator().reversed());
        Toolkit.printList(books,"Stormlight Archive Books");

        System.out.println("Done");
    }

    private static ArrayList<Book> makeBooks(ArrayList<String> lines) {
        ArrayList<Book> books = new ArrayList<>();

        for(var line :lines){
            String[] parts = line.split("\\|");
            if(parts.length == 2){
                String title = parts[0];
                int pages = -99;
                //System.out.println(parts[1]);
                try{
                    pages = Integer.parseInt(parts[1]);
                }catch(NumberFormatException e){
                    System.out.printf("I caught %s\n", parts[1]);
                    //continue;  //aborts the rest of the loop if the line is Not a Number
                }
                if (pages != -99) {
                    // Book book = new Book(title, pages);
                    // books.add(book);
                    books.add(new Book(title, pages));
                }
            }
        }

        return books;
    }
}
class BookTitleLengthComparator implements Comparator<Book> {

    @Override
    public int compare(Book a, Book b) {
        int result = 0;
        result = a.getTitle().length() - b.getTitle().length();
        if (result == 0) {
            a.getTitle().compareTo(b.getTitle());
        }
        return result;
    }

    @Override
    public Comparator<Book> reversed() {
        return Comparator.super.reversed();
    }
}
