import com.opencsv.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class App {

    public static void main(String[] args){
        String fileName = "countries.csv";
        parseLines(fileName);

        System.out.println("\nDone!");
    }
    public static void parseLines(String fileName){
        try {
//            CSVReader reader = new CSVReader(new FileReader(fileName));
//            List<String[]> reader2 = (List<String[]>)reader;

            var reader = (List<String[]>) new CSVReader(new FileReader(fileName));
            System.out.println("File was read");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Done with parseLines");
    }
}
