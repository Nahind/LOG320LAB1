package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created by nandane on 10/01/17.
 */
public class Anagramme {


    public List<ArrayList<Character>> fileToWordsList(File file)
    {
        // Store the list of all words contained in the file
        List<ArrayList<Character>> wordsList = new Vector<>();

        try
        {
            BufferedReader wordsReader = new BufferedReader(new FileReader(file));
            String word;
            // Transform the word string into an array of char & remove spaces
            while ((word = wordsReader.readLine()) != null)
            {
                word = word.toLowerCase().replaceAll("[^A-Za-z0-9]","");
                ArrayList<Character> charList = new ArrayList<>();
                for( char c : word.toCharArray())
                {
                    if (c != ' ') charList.add(c);
                }
                wordsList.add(charList);
            }
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.");
            e.printStackTrace();
        }

        return wordsList;
    }

    public void findAnagrammsBasic(List<ArrayList<Character>> testWords, List<ArrayList<Character>> dictWords) {
        int anagrammeCount;

        for (ArrayList<Character> testWord : testWords)
        {
            anagrammeCount = 0;
            for (ArrayList<Character> dictWord : dictWords)
            {
                boolean result = isAnagrammBasic(testWord, dictWord);
                if (result) anagrammeCount++;
            }

            System.out.println("Il y a " + anagrammeCount + " anagrammes du mot " +
                    testWord.toString().replaceAll("[\\[\\], ]", ""));
        }
    }


    public boolean isAnagrammBasic(ArrayList<Character> chaine1, ArrayList<Character> chaine2) {
        boolean found = false;
        chaine1 = (ArrayList<Character>) chaine1.clone();
        chaine2 = (ArrayList<Character>) chaine2.clone();

        for (int i = 0; i < chaine1.size(); i++) {
            char c1 = chaine1.get(i);
            found = false;

            int j = 0;
            while (!found && j < chaine2.size()) {
                char c2 = chaine2.get(j);

                if(c1 == c2) {
                    chaine2.remove(j);
                    found = true;
                }

                j++;
            }

            if (!found) return false;
        }

        if (!chaine2.isEmpty()) return false;

        return found;
    }


    private static boolean isAnagrammSmart(ArrayList<Character> a, ArrayList<Character> b, Map<Character, Integer> map) {
        // Assign a prime number to each

        int productA = map.get(a.get(0));
        int productB = map.get(b.get(0));

        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 1; i < a.size(); i++) {
            try {
                productA *= map.get(a.get(i));
                productB *= map.get(b.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return productA == productB;
    }

    public void findAnagrammsSmart(List<ArrayList<Character>> testWords, List<ArrayList<Character>> dictWords) {

        Map<Character, Integer> map = loadPrimeMap();
        int anagrammeCount;

        for (ArrayList<Character> testWord : testWords) {
            anagrammeCount = 0;

            for (ArrayList<Character> dictWord : dictWords) {

                boolean result = isAnagrammSmart(testWord, dictWord, map);
                if (result) anagrammeCount++;
            }

            System.out.println("Il y a " + anagrammeCount + " anagrammes du mot " +
                    testWord.toString().replaceAll("[\\[\\], ]", ""));
        }
    }

    private Map<Character, Integer> loadPrimeMap() {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('a', 2);
        map.put('b', 3);
        map.put('c', 5);
        map.put('d', 7);
        map.put('e', 11);
        map.put('f', 13);
        map.put('g', 17);
        map.put('h', 19);
        map.put('i', 23);
        map.put('j', 29);
        map.put('k', 31);
        map.put('l', 37);
        map.put('m', 41);
        map.put('n', 43);
        map.put('o', 47);
        map.put('p', 53);
        map.put('q', 59);
        map.put('r', 61);
        map.put('s', 67);
        map.put('t', 71);
        map.put('u', 73);
        map.put('v', 79);
        map.put('w', 83);
        map.put('x', 89);
        map.put('y', 97);
        map.put('z', 101);
        map.put('0', 103);
        map.put('1', 107);
        map.put('2', 109);
        map.put('3', 113);
        map.put('4', 127);
        map.put('5', 131);
        map.put('6', 137);
        map.put('7', 139);
        map.put('8', 149);
        map.put('9', 151);

        return map;
    }



}
