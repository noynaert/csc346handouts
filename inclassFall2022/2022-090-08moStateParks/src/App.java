import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/* Scrapes the web page at https://en.wikipedia.org/wiki/List_of_Missouri_state_parks to get a list of state parks.
*/
public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Park> parks= new ArrayList(150);
        String address = "https://en.wikipedia.org/wiki/List_of_Missouri_state_parks";
        Document doc = getDocument(address);
        System.out.println("Title: "+doc.title());

        Element rawTable = getTbody(doc,0);
        getParks(rawTable, parks);
        //Elements historic = getTbody(doc, 1);
        System.out.println("Done");
    }

    /**
     * Expects a tbody from a table and returns an arraylist of the parks.
     * @param rawTable  Just the tbody from the table
     * @param parks  The list of parks.
     */
    private static void getParks(Element rawTable, ArrayList<Park> parks) {
        System.out.println("in getParks");
        Elements rows = rawTable.getElementsByTag("tr");
        for(Element row : rows){
            Elements cells = row.getElementsByTag("td");
            if(cells.size() == 5){
                String name = cells.get(0).text();
                String county = cells.get(1).text();
                String acreString = cells.get(2).text();
                String yearString = cells.get(4).text();
               // System.out.println(name + county + acreString + yearString);
                Park p = new Park(name, county, getAcres(acreString), Integer.parseInt(yearString));
                //System.out.println(p + " ... "+acreString);
                parks.add(p);
            }
        }
    }
    public static double getAcres(String s){
        double result = 0.0;
        s = s.replace(",","");
        String[] parts = s.split(" ");
        result = (parts.length == 2) ? Double.parseDouble(parts[0]) : 0.0;
        /*
        if(parts.length == 2)
            result = Double.parseDouble(parts[0]);
        else
            result = 0.0;
        */
        System.out.println(s);
        return result;
    }
    public static Element getTbody(Document doc, int index){
        Element result = doc.getElementsByTag("tbody").get(index);
        return result;
    }
    private static Document getDocument(String address) throws Exception {
        Document doc = null;

            doc = Jsoup.connect(address).get();

        return doc;
    }


}
