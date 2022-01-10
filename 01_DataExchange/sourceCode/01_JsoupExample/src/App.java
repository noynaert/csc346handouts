import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Illustrates the use of a .jar file using jsoup as the example.
 * 
 * < a
 * href="https://jsoup.org/packages/jsoup-1.14.3.jar">https://jsoup.org/packages/jsoup-1.14.3.jar</a>
 */

public class App {
    public static void main(String[] args) {
        String url = "https://missouriwestern.edu";
        try {
            Document doc = Jsoup.connect(url).get();

            Elements elements = doc.select("a");
            for (Element element : elements) {
                System.out.println(element);
                String address = element.attr("href");
                String text = element.text();
                System.out.printf("Address: %s\nText: %s\n\n", address, text);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Aborting");
            System.exit(1);
            // e.printStackTrace();
        }

        System.out.println("Done!");
    }
}
