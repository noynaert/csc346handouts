package com.noynaert;

import java.io.File;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String fileName = "Moby.txt";
        Map<String,Integer> wordCount = new TreeMap<>();
        int totalWords = 0;

        totalWords = new App().countWords(fileName, wordCount);

        for(String word : wordCount.keySet()){
            System.out.printf("%6d %s\n", wordCount.get(word), word);
        }

        System.out.printf("Found %,d words\n", totalWords);
        System.out.println( "Done!" );
    }

    public int countWords(String fileName, Map<String, Integer> wordCount){
        int totalWords = 0;
        Scanner textFile = null;
        try{
            textFile = new Scanner(new File(fileName));
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

        while(textFile.hasNextLine()){
            String line = textFile.nextLine().trim().toLowerCase();
            if(line.length() > 0){
                String[] words = line.split("[^a-z']+");
                for(String word : words){
                    if(wordCount.containsKey(word)){
                        wordCount.put(word, wordCount.get(word) + 1);
                    }else{
                        wordCount.put(word, 1);
                    }
                }
            }
            totalWords++;

        }

        return totalWords;
    }
}
