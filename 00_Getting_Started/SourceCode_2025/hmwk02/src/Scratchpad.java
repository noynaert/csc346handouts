import edu.missouriwestern.noynaert.publications.Book;
import edu.missouriwestern.noynaert.utility.Toolkit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static edu.missouriwestern.noynaert.utility.Toolkit.printList;

public class Scratchpad {
    public static void main(String[] args) {
        final String ADDRESS = "https://raw.githubusercontent.com/noynaert/csc346handouts/refs/heads/main/dataFiles/sanderson.md";
        ArrayList<String> lines = new ArrayList<>();
        Toolkit.readURL(ADDRESS, lines);
       // Toolkit.readURL("https://raw.githubusercontent.com/noynaert/csc346handouts/refs/heads/main/dataFiles/mistborn.md", lines);

        ArrayList<Book> books = Main.makeBooks(lines);
       // printList(books, "Page title");

        String fileName = "books.md";
        String[] columnHeaders = { "Book<br>Title","Pages"};
        String pageTitle = "Some Books";

        try {
            writeMarkdown(books, pageTitle, columnHeaders, fileName);
        }catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }

        System.out.println("Scratchpad is done!");
    }

    public static<T> void writeMarkdown(ArrayList<T> items, String pageTitle, String[] columnHeaders, String fileName) throws InvocationTargetException, IllegalAccessException {
        Class theClass = items.get(0).getClass();
        PrintWriter writer = null;
        Method[] getters = getGetters(theClass);
        try {
            writer = new PrintWriter(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        //Write the title page
        writer.printf("# %s\n\n", pageTitle);

        //Make the header
        writer.print("|");
        for (String header : columnHeaders) {
            writer.printf(" %s |", header);
        }
        writer.println();
        writer.print("|");
        for (var header : columnHeaders) {
            writer.printf(" :---: |", header);
        }
        writer.println();

        //write the body of the table
        for (var item : items) {
            writer.print("|");
            for(int i=0; i<getters.length; i++){
                writer.printf(" %s |", getters[i].invoke(item));
            }
//            for (Method getter : getters) {
//                writer.printf(" %s |", getter.invoke(book));
//            }
//            writer.printf(" %s |", getters[0].invoke(book));
//            writer.printf(" %d |", getters[1].);
            writer.println();
        }



        writer.close();
    }

    private static Method[] getGetters(Class theClass) {
        Method[] methods = theClass.getMethods();
        ArrayList<Method> getters = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().startsWith("get")
                    && method.getParameterCount() == 0
                    && !void.class.equals(method.getReturnType())
                    && !method.getName().equals("getClass")
            ) {
                getters.add(method);
            }
        }
        //printList(getters, "Getters");
        Method[] gettersArray = new Method[getters.size()];
        getters.toArray(gettersArray);
        return gettersArray;
    }
}
