package edu.missouriwestern.edu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Demonstrates Maven with Jsoup
 *
 */
public class App {
    public static void main(String[] args) {
        Document doc;
        String address = "https://gogriffons.com/sports/womens-volleyball/roster";
        try {
            doc = Jsoup.connect(address).get();

            Elements images = doc.select("img");
            for(Element image : images){
                System.out.println(image.attr("data-src"));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());


            e.printStackTrace();
        }

        System.out.println("\nDone!");
    }
}
