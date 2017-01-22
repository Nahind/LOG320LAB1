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
        String dictFileName = "N=1000.txt";
        String wordsFileName = "words.txt";
        String path = "src/assets/";

        List<ArrayList<Character>> testWords = a.fileToWordsList(new File(path + wordsFileName));
        List<ArrayList<Character>> dictWords = a.fileToWordsList(new File(path + dictFileName));

        // Initial algorithme for finding anagramm
        System.out.println("Initial algorithme for finding anagramm");
        a.findAnagrammsBasic(testWords, dictWords);

        // Modified algorithme for finding anagramm
        System.out.println("Modified algorithme for finding anagramm");
        a.findAnagrammsSmart(testWords, dictWords);
    }
}
