# 01.020 Using the Jsoup jar file

## Jsoup

[https://jsoup.org/](https://jsoup.org/)

* Jsoup is a package that makes it relatively easy to fetch and parse web pages.
* Web pages are parsed into DOM in the same way that modern browsers do.
* We can parse the page using the [CSS selectors](https://www.w3schools.com/cssref/css_selectors.asp)
  * ids start with the # symbol
  * classes start with periods.

## Using Jsoup

* Create a basic Java project in your ide.
* Download the "core" jar file from [https://jsoup.org/download](https://jsoup.org/download)
* Copy or move the file into the `lib` directory of your project

## API

The JSoup API is at [https://jsoup.org/apidocs/](https://jsoup.org/apidocs/)

## Sample code

```java
import CSC346Utility.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {

        String address="https://aps4.missouriwestern.edu/schedule/?tck=202220";
        try {
            Document doc = Jsoup.connect(address).get();
            Elements options = doc.select("#department option");
            System.out.printf("options size is %d\n", options.size());
            for(Element option: options){
                //System.out.println(option);
                String name = option.text();
                String abbreviation = option.attr("value");
                System.out.printf("%-4s %s\n",abbreviation, name);
            }

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
	   System.out.println("Done\n");

    }
}
```