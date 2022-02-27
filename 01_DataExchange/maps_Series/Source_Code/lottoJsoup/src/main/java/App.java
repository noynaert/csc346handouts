import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;
import java.util.TreeMap;

/**
 * Counts lotto numbers
 *
 * Sample output:
 * [ 1] occurred 350 times
 * [ 2] occurred 325 times
 * [ 3] occurred 330 times
 * ...
 * [44] occurred 325 times
  */

public class App {
    public static void main(String[] args){
        Map<Integer, Integer> frequencies = new TreeMap<>();
        String address = "https://www.molottery.com/gameHistory2.do?method=loDisplay&order=asc";

        try{
            Document doc = Jsoup.connect(address).get();
            Elements rows = doc.select("tbody > tr");
            for(Element row : rows){
                Elements columns = row.select("td");
                String picks = columns.get(1).text();
                String[] numbers = picks.split("-");
                for(int i = 0; i<numbers.length;i++){
                    int number = Integer.parseInt(numbers[i]);
                    if(frequencies.containsKey(number)){
                        int count = frequencies.get(number);
                        count++;
                        frequencies.put(number, count);
                    }else{
                        frequencies.put(number, 1);
                    }
                }
            }
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }

        printMap(frequencies,"Frequencies of Lotto Numbers");
        System.out.println("\nDone!");
    }
    private static void printMap(Map m, String heading){
        System.out.printf("======= %s =======\n", heading);
        var keys = m.keySet();
        for(var key : keys){
            var value = m.get(key);
            System.out.printf("[%2s]\t%s\n", key, value);
        }
        System.out.printf("======= %d entries\n", m.size());
    }
}
