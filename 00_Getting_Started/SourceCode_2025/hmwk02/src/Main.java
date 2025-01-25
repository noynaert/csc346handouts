import java.util.ArrayList;

import edu.missouriwestern.noynaert.utility.Toolkit;

public class Main {
    public static void main(String[] args) {
        final String ADDRESS = "https://raw.githubusercontent.com/noynaert/csc346handouts/refs/heads/main/dataFiles/sanderson.md";
        ArrayList<String> lines = new ArrayList<>();
        Toolkit.readURL(ADDRESS,lines);
        Toolkit.printList(lines,"Books by Sanderson");

        System.out.println("Done");
    }
}