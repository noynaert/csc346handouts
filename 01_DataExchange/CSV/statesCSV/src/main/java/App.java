import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;

public class App {
    public static void main(String[] args){
        String fileName = "countries.csv";
        DirectToClass.direct(fileName);
        System.out.println("Ending after direct read");
        System.exit(0);


        CSVReader reader;
        List<String[]> data;

        try {
            reader = new CSVReader(new FileReader(fileName));
            data = reader.readAll();
            for(String[] record: data){
//                System.out.println(record);
//                for(String field: record){
//                    String s = field.replace("\"", "");
//                    System.out.println("\t"+s);
//                }
                if(record.length == 7 && !record[0].equals("entity")){
                    Country country = new Country();

                    country.setName(record[0]);
                    country.setUrl(record[1]);
                    country.setGec(record[2]);
                    country.setIso(record[3]);
                    country.setStrang(record[4]);
                    country.setInternet(record[5]);
                    country.setComment(record[6]);

                    System.out.println("The country is "+ country);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        System.out.println("\nDone!");
    }

}
