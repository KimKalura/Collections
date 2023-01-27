package cipher;

import generics.SimpleClass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Character> inputChars = new ArrayList<>();
        inputChars.add('a');
        inputChars.add('e');
        inputChars.add('i');
        inputChars.add('o');
        inputChars.add('u');
        inputChars.add('c');
        inputChars.add('n');
        inputChars.add('d');
        inputChars.add('b');
        inputChars.add('s');
        inputChars.add('l');
        inputChars.add('m');
        System.out.println(inputChars);

        /*Cypher cypher = new Cypher();
        Character[] characters = {'a', 'e', 'i', 'o', 'u', 'c', 'n', 'd', 'b', 's', 'l', 'm'};
        //cypher.printArray(characters);
        System.out.println(characters);*/


        List<Character> outputChars = new ArrayList<>();
        outputChars.add('s');
        outputChars.add('t');
        outputChars.add('n');
        outputChars.add('f');
        outputChars.add('g');
        outputChars.add('h');
        outputChars.add('j');
        outputChars.add('k');
        outputChars.add('x');
        outputChars.add('y');
        outputChars.add('z');
        outputChars.add('q');
        System.out.println(outputChars);

        Cypher cypher = new Cypher(inputChars, outputChars);
        System.out.println(cypher.initializeCypher());
        System.out.println(cypher.encrypt("sababa"));
        System.out.println(cypher.decrypt("njyfzgxnz"));
    }
}
