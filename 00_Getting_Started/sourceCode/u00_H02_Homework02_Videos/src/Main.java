import edu.missouriwestern.noynaert.bookDemo.*;
import org.apache.commons.csv.*;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * This program illustrates reading a CSV file.
 *
 * <p>It is a model for homework 02</p>
 *
 * @author J. Evan Noyanert
 * @since  January 2024
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<Book> bookList;
        String fileName = "books.csv";

        try {
            bookList = readBooksCSV(fileName);
            writeBooksCSV(bookList, "original.csv");
            Collections.sort(bookList);  //sort by author and title
            writeBooksCSV(bookList,"byAuthor.csv");
            Collections.sort(bookList,new CompareTitle());
            writeBooksCSV(bookList,"byTitle.csv");
            Collections.sort(bookList, new CompareYear());
            writeBooksCSV(bookList,"byYear.csv");
            Collections.sort(bookList, new CompareISBN());
            writeBooksCSV(bookList,"byISBN.csv");
        }catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(46);
        }
        System.out.println("\nDone!");
    }

    /**
     * Writes a file in .csv format to the file indicated by the fileName parameter.  The file is written
     * with headers on all columns.  All records in the ArrayList are written to the file.
     *
     * @param bookList an ArrayList of Books
     * @param fileName
     * @throws IOException
     */
    private static void writeBooksCSV(ArrayList<Book> bookList, String fileName) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader("ISBN","Author","Title", "Year").build();
        CSVPrinter csvPrinter = new CSVPrinter(writer,csvFormat);
        for(Book book : bookList){
            csvPrinter.printRecord(book.getIsbn(), book.getAuthor(),book.getTitle(),
                    book.getYear());
        }
        csvPrinter.flush();
        csvPrinter.close();
    }


    /**
     * Read records from the specified CSV file and returns an ArrayList of records.
     * The header is recognized, but not really used.
     *
     * There is debugging information printed to the console.
     * @param fileName  The file to be read.  The first row should be the header.
     * @return  An ArrayList of Book records in the file
     * @throws Exception It may throw a FileNotFoundException.  It may also throw an error when it attempts to parse the double in the file.
     */
    public static ArrayList<Book> readBooksCSV(String fileName) throws Exception {
        ArrayList<Book> list = new ArrayList(100);

        Reader input = new FileReader(fileName);
        CSVParser records = new CSVParser(input,CSVFormat.DEFAULT.withFirstRecordAsHeader());
        List<String> headers = records.getHeaderNames();
        for(String header : headers){
            System.out.println("Header: " + header);
        }
        //retrieve the records and add them to the ArrayList
        for(CSVRecord record:records){
            String isbn = record.get("isbn");
            String author = record.get("authors");
            String title = record.get("title");
            String s = record.get("original_publication_year");
            double year = Double.parseDouble(s);
            Book book = new Book(isbn,author,title,year);
            //System.out.println(book);
            list.add(book);
        }

        return list;
    }

    /**
     * Compares the ISBN of two books
     */
    private static class CompareISBN implements Comparator<Book> {


        @Override
        public int compare(Book book1, Book book2) {
            int result = 0;
            result = book1.getIsbn().compareTo(book2.getIsbn());
            return result;
        }

    }
}
