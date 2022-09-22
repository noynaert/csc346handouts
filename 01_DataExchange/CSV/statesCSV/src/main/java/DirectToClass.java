import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;
import java.util.function.Consumer;

/**
 * This program reads from a .csv file and processes each line as a string.
 * <p>
 * based loosely on https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
 *
 * @author J. Evan Noynaert
 * @since October 2022
 */

public class DirectToClass {
    public static void direct(String fileName) {

        try {

            List<Country> countries = (List<Country>) new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(Country.class)
                    .build()
                    .parse();
//            for (Country country : countries) {
//                System.out.println(country);
//            }

            //countries.forEach(System.out::println);
            countries.forEach(country->System.out.println(country));

//            countries.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Done With Direct");
    }




}
