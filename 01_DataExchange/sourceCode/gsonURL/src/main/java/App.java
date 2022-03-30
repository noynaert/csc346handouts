import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * todo: PROGRAM DESCRIPTION
 *
 * @author: YOUR NAME
 * @since: MONTH YEAR program is started
 */

public class App {
    public static void main(String[] args){
        String address = "http://www.floatrates.com/daily/usd.json";
        try {
            URL floatrates = new URL(address);
            BufferedReader bigJson = new BufferedReader(
                    new InputStreamReader(floatrates.openStream())
            );
            String longLine ="";
            String line;
            while((line = bigJson.readLine()) != null){
                  longLine += line.trim();
            }
            System.out.println(longLine);

            //https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.5/com/google/gson/JsonObject.html
            Gson gson = new Gson();
            Map<String, JsonObject> things = gson.fromJson(longLine, Map.class);
            JsonObject thing = things.get("eur");
            String name = "";
            double exchangeRate=0.0;
            if(thing.has("name")){
                JsonElement el = thing.get("name");
                name = el.getAsString();
            }
//            if(thing.has("rate")){
//               exchangeRate = thing.get("rate").getAsDouble();
//            }
            System.out.printf("% s has an exchange rate of %f\n",name, exchangeRate);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nDone!");
    }
}
