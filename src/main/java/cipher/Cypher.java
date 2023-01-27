package cipher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cypher {
    private List<Character> inputChars;
    private List<Character> outputChars;
    Map<Character, Character> cypher;


    public Cypher(List<Character> inputChars, List<Character> outputChars) {
        this.inputChars = inputChars;
        this.outputChars = outputChars;
        cypher = new HashMap<>();
        initializeCypher();
    }

    public List<Character> getInputChars() {
        return inputChars;
    }

    public void setInputChars(List<Character> inputChars) {
        this.inputChars = inputChars;
    }

    public List<Character> getOutputChars() {
        return outputChars;
    }

    public void setOutputChars(List<Character> outputChars) {
        this.outputChars = outputChars;
    }

    @Override
    public String toString() {
        return "Cypher{" +
                "inputChars=" + inputChars +
                ", outputChars=" + outputChars +
                '}';
    }

    //Construieste o mapa in care fiecare cheie este un caracter si fiecare valoare este codificarea caracterului
    //De exemplu, pentru exemplu de mai sus, mapa va arata asa: {a=s, b=x, c=h, d=k, e=t, i=n, l=z, m=q, n=j, o=f, s=y, u=g}
    public Map<Character, Character> initializeCypher() {
        for (int i = 0; i < inputChars.size(); i++) {
            cypher.put(inputChars.get(i), outputChars.get(i));
        }
        return cypher;
    }

    //Primeste ca parametru un cuvant si returneaza cuvantul codificat
    public String encrypt(String word) {
        String encryptedWord = "";
        for (Character character : word.toCharArray()) {
            encryptedWord += cypher.get(character);
        }
        return encryptedWord;
    }

    //Primeste ca parametru un cuvant si returneaza cuvantul decodificat
    public String decrypt(String word) {
        String decryptedWord = "";
        for (Character character : word.toCharArray()) {
            for (Character key : cypher.keySet()) {
                if (cypher.get(key).equals(character)) {
                    decryptedWord += key;
                }
            }
        }
        return decryptedWord;
    }
}