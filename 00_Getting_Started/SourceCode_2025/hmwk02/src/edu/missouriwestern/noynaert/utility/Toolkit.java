package edu.missouriwestern.noynaert.utility;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * This class is a collection of general purpose methods
 * for working with ArrayLists.
 *
 * @author J. Evan Noynaert
 * @since January, 2025
 */
public class Toolkit {
    /**
     * This method reads lines of text from the url specified by address.  The lines of text are
     * stored in the lines ArrayList.
     *
     * @param address:String  The URL of the text file
     * @param lines:ArrayList<String> This is the list of lines that have been read.
     */
    public static void readURL(String address, ArrayList<String> lines) {

        try {
            URL url = new URL(address);

            InputStreamReader inStream = new InputStreamReader(url.openStream());
            BufferedReader input = new BufferedReader(inStream);

            //read the lines
            String line;
            while ( (line=input.readLine()) != null){
                line = line.trim();
                lines.add(line);
            }
            input.close();
            inStream.close();
        } catch (Exception e) {
            System.out.printf("Error reading URL (%s): %s\n", e.getMessage(),address);
            System.exit(1);
        }
    }
    public static <T>void printList(ArrayList<T> lines, String title) {
        //Print the title
        System.out.printf("\n%s\n\n",title);

        //Print the lines, if any
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
        /*
        for (line:lines){
           System.out.println(line);
         */

        //Print the total
        System.out.printf("\n There were %d lines in the list\n", lines.size());


    }
}

