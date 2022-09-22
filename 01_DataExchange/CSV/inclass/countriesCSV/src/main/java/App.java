import com.opencsv.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args){
        String fileName = "countries.csv";
        parseLines(fileName);

        System.out.println("\nDone!");
    }
    public static void parseLines(String fileName){
        try {
            CSVReader reader = new CSVReader(new FileReader(fileName));
            PrintWriter output = new PrintWriter("output.csv");

            List<String[]> list = (List<String[]>) reader.readAll();
            for(String[] fields: list){

                if(fields.length == 7) {
                    output.printf("%s,%s,%s,%s,%s,%s,%s\n", fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
                }else if(fields.length==6) {
                    output.printf("%s,%s,%s,%s,%s,%s,%s\n", fields[0], "/the-world-factbook",fields[1], fields[2], fields[3], fields[4], fields[5]);

                }else{
                    System.out.print("\t");
                    for(int i = 0; i< fields.length;i++){
                        System.out.printf("(%d %-6s) ", i, fields[i]);
                    }
                    System.out.println();
                }

            }

            output.close();
            System.out.println("File was read");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Done with parseLines");
    }
}
