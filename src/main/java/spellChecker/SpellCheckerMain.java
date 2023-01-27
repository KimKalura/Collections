package spellChecker;

import org.w3c.dom.*;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class SpellCheckerMain {

    public static void main(String[] args) {
        //string splituit dupa spatiu si pus intr-un array de cuv
        //parcurgem arrayul de cuv din text si vedem daca se reg fiecare cuv in lista de cuv valide

       /* Set<String> dictionary = Set.of("aa", "bb", "cc");
       //Arrays.asList metoda de la lista:
        List<String> wordsFromText = Arrays.asList("aa", "dd", "ee", "cc");
        System.out.println(findBadWords(dictionary,wordsFromText)); // [dd,ee]*/

        Set<String> dictionary = new HashSet<>();
        List<String> wordsFromText = new ArrayList<>();

        //citirea dictionarului
        Scanner console = new Scanner(System.in);

        System.out.println("Enter number of words from dictionary");
        int number = Integer.parseInt(console.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Enter the next word");
            String word = console.nextLine();
            dictionary.add(word);
        }
        System.out.println(dictionary);

        //citirea textului
        System.out.println("Enter number of lines");
        int numberOfLines = Integer.parseInt(console.nextLine());
        for (int i = 0; i < numberOfLines; i++) {
            System.out.println("Enter the next line  ");
            String line = console.nextLine();
            String[] words = line.split(" ");
            for (int j = 0; j < words.length; j++) {
                wordsFromText.add(words[j]);
            }
        }
        System.out.println(wordsFromText);

        //verificarea textului pt cuvinte eronate
        System.out.println(findBadWords(dictionary, wordsFromText));
    }

    public static Set<String> findBadWords(Set<String> dictionary, List<String> wordsFromText) {
        Set<String> badWords = new HashSet<>();
        for (String word : wordsFromText) {
            if (!dictionary.contains(word)) {
                badWords.add(word);
            }
        }
        return badWords;
    }
}
