import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Using Gson to read JSON without using POJOs
 *
 * This is replacing the 02.020 video that did not have the right screen showing.
 *      The 02.020 video used JsonObject and JsonElement classes.
 *      This video will be more brute force methods
 *
 *      First video will use a simple mapping from
 *         https://api.agify.io/?name=Phoebie
 *      Second video will use a complicated nested mapping from
 *         https://api.coindesk.com/v1/bpi/currentprice.json
 */

public class App {
    static Gson gson = new Gson();
    public static void main(String[] args){

        try{
            //simple(" https://api.agify.io/?name=Phoebie");
            complicated(" https://api.coindesk.com/v1/bpi/currentprice.json");
        }catch(Exception e){
            System.err.println("ERROR: "+ e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("\nDone!");
    }

    private static void simple(String address) throws Exception {
        URL url = new URL(address);
        String s; //Hold our json string
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
         s = "";
         String line;
         while((line = br.readLine()) != null){
             s+=line;
         }
        HashMap<String, Object> m = gson.fromJson(s,HashMap.class);
        Object o = m.get("name");
        String name = (String)o;
        o = m.get("age");
        int age = (int)((double)o);
        int count = (int)(double)m.get("count");
        System.out.printf("The estimated age of %s is %d with a count of %d\n", name, age,count);
    }
    public static void complicated(String address) throws Exception{
        URL url = new URL(address);
        String s; //Hold our json string
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        s = "";
        String line;
        while((line = br.readLine()) != null){
            s+=line;
        }
        ///////////////
        HashMap<String, Map> m = gson.fromJson(s,HashMap.class);
        Map<String, String> time = m.get("time");
        String utc = time.get("updated");

        //get the bpi field
        Map<String, Map> bpi = m.get("bpi");

        Map<String, String> usd = bpi.get("USD");
       // String usdRate = (String)usd.get("rate");
        String usdRate = usd.get("rate");

        Map<String, String> gbp = bpi.get("GBP");
        String gbpRate = gbp.get("rate");

        System.out.printf("At time %s, USDollars had a bitcoin exchange rate of %s and British Pould Sterling had an exchange rate of %s\n",
                utc, usdRate, gbpRate);
    }
}
