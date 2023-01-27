package Algorithms.collections.twistedWord;

public class Word {
    public static void main(String[] args) {
        //6
        //Verifica daca un String poate fi derivat din alt String rotindu-l circular.
        //Exemplu: Input: s1 = abcd
        //                s2 = dabc
        //Output: true, pentru ca s2 poate fi derivat din s1, rotind-se cu o unitate

        //1.rotesc
        //2.verific
        String word = "abcd";
        //String twistedWord = "";

        //var1
        /*for (int i = 1; i < word.length(); i++) {
            twistedWord += word.charAt(i); //bcd
        }
        twistedWord += word.charAt(0);*/

        //var2
        /*twistedWord = word.substring(1) + word.charAt(0);
        System.out.println(twistedWord);*/

        //var3
        word = word.substring(1) + word.charAt(0);
        System.out.println(word);

        System.out.println(areCircularTwisted("abcd", "cdab"));

       /* String s1 = "abcd";
        String s2 = "cdab";
        String concatenated =s1+s1;
        if (concatenated.contains(s2)){
            System.out.println("rotated");
        }*/
    }

    public static boolean areCircularTwisted(String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            word1 = word1.substring(1) + word1.charAt(0);
            if (word1.equals(word2));
            return true;
        }
        return false;
    }
}
