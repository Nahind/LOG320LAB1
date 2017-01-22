package app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandane on 10/01/17.
 */
public class AnagrammeApp {

    public static void main(String[] args) {
        Anagramme a = new Anagramme();
        String dictFileName = "N=4000.txt";
        String wordsFileName = "words.txt";
        String path = "src/assets/";
        long startTime;
        long endTime;
        long durationBasic;
        long durationSmart;

        List<ArrayList<Character>> testWords = a.fileToWordsList(new File(path + wordsFileName));
        List<ArrayList<Character>> dictWords = a.fileToWordsList(new File(path + dictFileName));

        // Initial algorithm for finding anagramm
        System.out.println("Initial algorithme for finding anagramm");
        // Start the timer to check method speed
        startTime = System.nanoTime();
        a.findAnagrammsBasic(testWords, dictWords);
        endTime = System.nanoTime();
        durationBasic = ((endTime - startTime)/1000000);

        // Modified algorithm for finding anagramm
        System.out.println("\nModified algorithme for finding anagramm");
        // Start the timer to check method speed
        startTime = System.nanoTime();
        a.findAnagrammsSmart(testWords, dictWords);
        endTime = System.nanoTime();
        durationSmart = ((endTime - startTime)/1000000);


        System.out.printf(
                "\nThe basic method has taken %dms" +
                "\nThe smart method has taken %dms\n", durationBasic, durationSmart);
    }
}
