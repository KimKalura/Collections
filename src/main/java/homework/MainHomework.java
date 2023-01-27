package homework;

import java.util.*;

public class MainHomework {

    public static void main(String[] args) {
        //1
        System.out.println("EXERCISE 1");
        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(4);
        numbersList.add(5);
        System.out.println(numbersList);
        System.out.println(calculatePower(numbersList));

        //2
        System.out.println("EXERCISE 2");
        List<String> wordsList = new ArrayList<>();
        wordsList.add("ana");
        wordsList.add("are");
        wordsList.add("mere");
        System.out.println(wordsList);
        System.out.println(findTheLongestWord(wordsList));

        //3
        System.out.println("EXERCISE 3");
        List<Integer> numbersList1 = new ArrayList<>();
        numbersList1.add(1);
        numbersList1.add(-2);
        numbersList1.add(3);
        numbersList1.add(4);
        numbersList1.add(4);
        numbersList1.add(-5);
        System.out.println(numbersList1);

        List<Integer> numbersList2 = new ArrayList<>();
        numbersList2.add(1);
        numbersList2.add(-7);
        numbersList2.add(2);
        System.out.println(numbersList2);

        System.out.println(findPositiveNumbers(numbersList1, numbersList2));

        //4
        System.out.println("EXERCISE 4");
        List<String> listOfWords = new ArrayList<>();
        listOfWords.add("ana");
        listOfWords.add("nu");
        listOfWords.add("are");
        listOfWords.add("mere");
        System.out.println(listOfWords);
        System.out.println(findReversedWordsList(listOfWords));

        //5
        System.out.println("EXERCISE 5");
        Set<String> firstSet = new HashSet<>();
        firstSet.add("ana");
        firstSet.add("are");
        firstSet.add("mere");

        Set<String> secondSet = new HashSet<>();
        secondSet.add("ana");
        secondSet.add("are");
        //secondSet.add("mere");

        System.out.println(firstSet);
        System.out.println(secondSet);
        System.out.println(superMethod(firstSet, secondSet));


        //6
        System.out.println("EXERCISE 6");
        List<String> wordsNo = new ArrayList<>();
        wordsNo.add("ana");
        wordsNo.add("are");
        wordsNo.add("mere");
        wordsNo.add("are");

        System.out.println(getDuplicates(wordsNo));

        //7
        System.out.println("EXERCISE 7");
        /*List<Integer> numbers = new ArrayList<>();
        numbers.add(35);
        numbers.add(120);
        numbers.add(7);
        numbers.add(35);
        numbers.add(86);*/
        List<Integer> numbers = Arrays.asList(35, 120, 7, 120);
        System.out.println(findDuplicateElement(numbers));

        //8
        System.out.println("EXERCISE 8");
        Set<Integer> nooList = new HashSet<>();
        nooList.add(458);
        nooList.add(56);
        nooList.add(9647);
        nooList.add(321);
        nooList.add(86);
        System.out.println(nooList);
        System.out.println("Number: " + findMaxMin(nooList));

        //with List
        List<Integer> noList = Arrays.asList(458, 56, 9647, 321, 86);
        System.out.println(noList);
        System.out.println("Min: " + findMinNo(noList));
        System.out.println("Max: " + findMaxNo(noList));

        //9
        System.out.println("EX 9");
        List<String> wordsArray = Arrays.asList("race", "care");
        System.out.println(wordsArray);
        System.out.println(areAnagrams("race", "care")); //carec
    }


    //1
//    primeste ca si parametru o lista de numere si returneaza o alta lista de numere formata din numerele din lista primita ca parametru, ridicate la patrat (puteti folosi Math.pow(2) pentru a ridica la patrat)
//    Exemplu:
//    Input: {2,3,4,5}
//    Output: {4,9,16,25}
    public static List<Integer> calculatePower(List<Integer> numbersList) {
        List<Integer> newNumbersList = new ArrayList<>();
        for (Integer number : numbersList) {
            double power = Math.pow(number, 2);
            newNumbersList.add((int) power);
        }
        return newNumbersList;
    }

    //2
//    Gaseste cuvantul cel mai lung dintr-o lista de cuvinte (primita ca parametru), si il returneaza
//    Exemplu:
//    Input: {“ana”, “are”, “mere”}
//    Output: “mere”
    public static String findTheLongestWord(List<String> wordsList) {
        String longestWord = "";
        for (String word : wordsList) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    //3
//    Primeste ca parametru 2 liste de numere si returneaza un set format din numerele pozitive din ambele liste
//    primite ca parametru
//    Exemplu:
//    Input: {1, -2, 3, 4, 4, -5}, {1, -7, 2}
//    Output: {1, 3, 4, 2}
    public static Set<Integer> findPositiveNumbers(List<Integer> numbersList1, List<Integer> numbersList2) {
        Set<Integer> positiveNumbers = new HashSet<>();
        for (Integer number1 : numbersList1) {
            if (number1 > 0) {
                positiveNumbers.add(number1);
            }
        }
        for (Integer number2 : numbersList2) {
            if (number2 > 0) {
                positiveNumbers.add(number2);
            }
        }
        return positiveNumbers;
    }

    //4
//    Primeste ca parametru o lista de cuvinte si returneaza lista de cuvinte inversata, cu mentiunea ca lista inversata nu va include cuvintele care au lungimea mai mica decat 3
//    Exemplu:
//    Input: {“ana”, “nu”, “are”, “mere”}
//    Output: {“mere”, “are”, “ana”}
    public static List<String> findReversedWordsList(List<String> listOfWords) {
        List<String> reversedListOfWords = new ArrayList<>();
        for (int i = listOfWords.size() - 1; i >= 0; i--) {
            if (listOfWords.get(i).length() >= 3) {
                reversedListOfWords.add(listOfWords.get(i));
            }
        }
        return reversedListOfWords;
    }

    //5
//    Primeste ca parametru doua set-uri si returneaza true daca primul set primit ca parametru este superset al celui de-al doilea set
//    Un set “set1” este superset al altui set “set2”, daca “set1” contine toate elementele din “set2”, dar seturile nu sunt egale   - containsAll()
//    Exemple:
//    Input1: {“ana”, “are”, “mere”}, {“ana”, “are”}
//    Output1: true
//    Input2: {“ana”, “are”, “mere”}, {“ana”, “are”, “mere”}
//    Output2: false
    public static boolean superMethod(Set<String> firstSet, Set<String> secondSet) {
        return firstSet.containsAll(secondSet) && (!firstSet.equals(secondSet));
    }


    //6
//    Primeste ca parametru o lista de cuvinte si returneaza de cate ori apare fiecare cuvant in lista
//    Exemplu:
//    Input: {“ana”, “are”, “mere”, “are”}
//    Output: {ana=1, are=2, mere=1}
    public static Map<String, Integer> getDuplicates(List<String> wordsNo) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < wordsNo.size(); i++) {
            String currentWord = wordsNo.get(i);
            if (hashMap.containsKey(currentWord)) {
                hashMap.put(currentWord, hashMap.get(currentWord) + 1);
            } else {
                hashMap.put(currentWord, 1);
            }
        }
        return hashMap;
    }

    //7
//    Primeste ca parametru o lista de numere, care are un element duplicat
//    Returneaza elementul duplicat
//    HINT (alt mod de rezolvare decat cel clasic): metoda add din interfata Set returneaza false, daca nu poate
//    adauga elementul primit ca parametru in set
    public static Integer findDuplicateElement(List<Integer> numbers) {
        Set<Integer> uniqueElements = new HashSet<>();
       /* for (Integer element : numbers) {
            if (uniqueElements.add(element) == false) {
                return element;
            }
        }
        return -1;*/

        for (int i = 0; i < numbers.size(); i++) {
            //Integer element = numbers.get(i);
            if (uniqueElements.add(numbers.get(i)) == false) {//simplificat -> !uniqueElements.add(numbers.get(i))
                return numbers.get(i);
            }
        }
        return -1;
    }

    //8
//    Primeste ca parametru o lista de numere
//    Afiseaza cel mai mic si cel mai mare element din lista
//    HINT (alt mod de rezolvare decat cel clasic): adauga toate elementele din lista intr-un treeset, apoi apeleaza metodele
//    first() si last() pe acel treeset
    public static Optional<Integer> findMaxMin(Set<Integer> nooList) {
        //var1
        /*Optional<Integer> smallestNo = nooList.stream()
                .max(Comparator.comparing(n -> n));
                //.min(Comparator.comparing(n -> n));
        return smallestNo;*/

        //var2
        return nooList.stream()
                .max(Comparator.comparing(n -> n));
        //.min(Comparator.comparing(n -> n));

        //var3; with TreeSet //Integer
        /*TreeSet<Integer> nrs = new TreeSet<>();
        nrs.addAll(nooList);
        return nrs.last();*/

    }

    //var2 (ex 8)
    public static Integer findMinNo(List<Integer> noList) {
        int min = Integer.MAX_VALUE;
        for (Integer n : noList) {
            if (min > n) {
                min = n;
            }
        }
        return min;
        /*for (int i = 0; i < noList.size(); i++) {
            int currentNo = noList.get(i);
            if (currentNo < min) {
                min = currentNo;
            }
        }
        return min;*/
    }

    public static Integer findMaxNo(List<Integer> noList) {
        int max = Integer.MIN_VALUE;
        for (Integer n : noList) {
            if (max < n) {
                max = n;
            }
        }
        return max;
        /*for (int i = 0; i < noList.size(); i++) {
            int currentNo = noList.get(i);
            if (currentNo > max) {
                max = currentNo;
            }
        }
        return max;*/
    }

    //9
//    Scrie o metoda care:
//    Primeste ca parametrii doua cuvinte si returneaza true, daca cuvintele sunt anagrame.
//    Exemple:
//    Input1: “race”, “care”
//    Output1: true, pentru ca care contine aceleasi litere ca si race, si literele apar de acelasi numar de ori
//    Input2:”race”, “carec”
//    Output2: false, pentru ca nu contin acelasi litere, de acelasi numar de ori
    public static boolean areAnagrams(String word1, String word2) {
        //1. generam mapa din primul cuvant
        //2. generam mape din alt doilea cuvant
        //3. comporama mapele, daca sunt egale cuvintele sunt anagrame
        Map<Character, Integer> firstMap = new HashMap<>();
        Map<Character, Integer> secondMap = new HashMap<>();
        generateMap(firstMap, generateListOfCharacter(word1));
        generateMap(secondMap, generateListOfCharacter(word2));

        if (firstMap.equals(secondMap)) {
            return true;
        } else {
            return false;
        }
    }

    private static List<Character>  generateListOfCharacter(String word) {
        List<Character> wordList = new ArrayList<>();
        for (Character ch : word.toCharArray()) {
            wordList.add(ch);
        }
        return wordList;
    }

    private static void generateMap(Map<Character, Integer> map, List<Character> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            if (map.containsKey(wordList.get(i))) {
                map.put(wordList.get(i), map.get(wordList.get(i) + 1));
            } else {
                map.put(wordList.get(i), 1);
            }
        }
    }
}

