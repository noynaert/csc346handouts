import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String address = "https://aps4.missouriwestern.edu/schedule/?tck=202220";
        try {
            Document doc = Jsoup.connect(address).get();
            org.jsoup.select.Elements options = doc.select("#department option");
            System.out.printf("There are %d items that were selected\n", options.size());
            for(Element option: options){
                String departmentName = option.text();
                String code = option.attr("value");
                System.out.printf("%-4s %s\n",code, departmentName);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());

            e.printStackTrace();
        }
        System.out.println("\nDone!");
    }
}
