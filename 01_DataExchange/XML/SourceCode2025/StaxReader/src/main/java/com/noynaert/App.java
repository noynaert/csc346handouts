package com.noynaert;

import java.io.PrintWriter;

/**
 * Illustrates reading large XML files using StAX
 *
 * The program reads the people.xml file and outputs it to people.md
 *
 * @since March, 2025
 * @author J. Evan Noynaert
 *
 */
public class App 
{
    public static PrintWriter outputFile;
    public static void main( String[] args )
    {
        try{
            //Set up the output file
            outputFile = new PrintWriter("people.md");
            outputFile.println("ID|Name|Email|Phone Number<br>Count");
            outputFile.println(":---:|:----|:-----|:---------:");

            //Open the StAX parser



            outputFile.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


        System.out.println( "Done" );
    }
}
