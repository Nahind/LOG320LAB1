package app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by nandane on 10/01/17.
 */
public class AnagrammeApp {

    public static void main(String[] args) {

        // List dict files availible for testing
        File folder = new File("src/assets");
        ArrayList<File> dictFiles = new ArrayList<>();
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().startsWith("N=")) {
                dictFiles.add(listOfFiles[i]);
            }
        }

        for (File f : dictFiles) {

            System.out.println("dict file name = " + f.getName());
            for (int i = 1; i <= 10; i++) {

                Anagramme a = new Anagramme();
                String dictFileName = f.getName();
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
                durationBasic = ((endTime - startTime) / 1000000);

                // Modified algorithm for finding anagramm
                System.out.println("\nModified algorithme for finding anagramm");
                // Start the timer to check method speed
                startTime = System.nanoTime();
                a.findAnagrammsSmart(testWords, dictWords);
                endTime = System.nanoTime();
                durationSmart = ((endTime - startTime) / 1000000);


                System.out.printf("\nThe basic method has taken %dms" + "\nThe smart method has taken %dms\n",
                        durationBasic, durationSmart);
                FileWriter out;
                try {
                    out = new FileWriter(path + "logfile.txt", true);
                    out.write(dictFileName.substring(2, dictFileName.length() - 4) + ","
                            + durationBasic + "," + durationSmart + "\n");
                    out.close();
                } catch (IOException e) {
                    System.out.println("Error appending to file " + args[0]);
                }


            }
        }
    }
}
