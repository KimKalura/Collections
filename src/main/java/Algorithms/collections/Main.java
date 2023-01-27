package Algorithms.collections;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //2
        // Inlocuieste fiecare element dintr-un array cu produsul tuturor celorlalte elemente
        //Exemplu:  Input: { 1, 2, 3, 4, 5 }
        //          Output: { 120, 60, 40, 30, 24 }
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Ex 2");
        System.out.println(nums);
        System.out.println(findNoOfProduct(nums));

        //3
        List<Integer> duplicateList = Arrays.asList(6, 5, 6, 2, 3, 1);
        System.out.println("Ex 3");
        System.out.println(duplicateList);
        System.out.println(getDuplicateNo(duplicateList));


        //4
        // Sunt afisate n-1 numere dintr-un interval de la 1 la n. Sa se gaseasca numarul care lipseste.
        //Exemplu:Input: n=7, a=[3,2,1,6,5,7]
        //        Output: 4 - lipseste doar 4 din array.
        //(hint: sorteaza array-ul si verifica daca gasesti o diferenta de 2 intre 2 elemente consecutive. Un gasesti diferenta, acolo va fi si numarul care lipseste.
        // Gandeste-te apoi si la alta metoda de rezolvare)
        List<Integer> noList = Arrays.asList(3, 2, 1, 6, 5, 7);
        System.out.println("Ex 4");
        System.out.println("The missing number from 1 to 7 is " + getMissingNo(noList));
        int n = 7;
        System.out.println("Option 2. The missing number from 1 to 7 is " + findTheMissingNo(noList, n));

        //5
        //Grupeaza elementele dintr-un array astfel incat elementele duplicate sa fie unul langa altul
        //Exemplu:  Input: { 1, 2, 3, 1, 2, 1 }
        //          Output: { 1, 1, 1, 2, 2, 3 }
        //(hint: construieste o mapa in care cheia este elementul, iar valoarea de cate ori apare. Apoi construieste rezultatul
        // parcurgand mapa si adaugand elementele unul dupa altul intr-un nou array, in functie de mumarul de aparitii al fiecarui element)
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 1, 2, 1);
        System.out.println("Ex 5");
        System.out.println(numbersList);
        System.out.println(duplicateNo(numbersList));

        //7
        //Gaseste diferenta maxima intre 2 numere dintr-o lista, astfel incat elementul mai mic sa apara inaintea elementului mai mare
        //Exemplu: Input: [2,7,9,5,1,3,5]
        //	       Output: 7 (perechea de numere care indeplineste conditia este (2,9)

        //1. scadem primul nr din fiecare nr
        //2. convertim fiecare diferenta in pozitiv
        //   comparam diferenta gasita cu diferenta maxima

        //3.trecem la urmatorul nr si il scadem din fiecare nr
        //2. convertim fiecare diferenta in pozotiv
        //   comparam diferenta gasita cu diferenta maxima

        //....

        //3.trecem la ULTIMUL nr si il scadem din fiecare nr
        //2. convertim fiecare diferenta in pozitiv
        //   comparam diferenta gasita cu diferenta maxima

        //--
        //scad fiecare nt din fiecare nr
        //convertesc fiecare diferenta in pozitiv
        //compar diferenta cu diferenta maxima

        List<Integer> numberList = Arrays.asList(2, 7, 9, 5, 1, 3, 5);
        System.out.println("Ex 7 ");
        System.out.println(getMaxDiference(numberList));

        //8
        //8. Gaseste cea mai apropiata valoare de un anumit numar dintr-o lista de numere
        //Exemplu: Input: [2,7,9,5,1,3,5], 8
        //         Output: 9 sau 7 sunt cele mai apropiate valori de 8
        List<Integer> integerNo = Arrays.asList(2, 7, 9, 5, 1, 3, 5);
        System.out.println("Ex 8");
        System.out.println(integerNo);
        System.out.println(findTheNearestNo(integerNo, 8));

        //9
        // Muta toate zero-urile dintr-un array la final
        // Exemplu: Input: [6,0,8,2,3,0,4,0,1]
        //          Output: [6,8,2,3,4,1,0,0,0]
        List<Integer> numsList = Arrays.asList(6, 0, 8, 2, 3, 0, 4, 0, 1);
        System.out.println("Ex 9");
        System.out.println(numsList);
        System.out.println(getAllZeroToTheEnd(numsList));

        //10
        //Gaseste un subarray dintr-un array,  care sa aiba o anumita suma
        //Un subarray are capatul din stanga inaintea capatului din dreapta in array-ul original.
        //Array-ul original poate avea doar numere pozitive
        //Exemplu: Input: [1,4,20,3,10,5], sum=33
        //         Ouput:suma a fost gasita intre indicii 2 si 4 (20+3+10=33)
        //         Input: [1,4], sum = 0
        //         Output: niciun subarray nu a fost gasit
        List<Integer> arrayList = Arrays.asList(1, 4, 20, 3, 10, 5);
        System.out.println("Ex 10");
        System.out.println(arrayList);
        findSubarraySum(arrayList, 33);


        //11
        // Roteste un array la stanga cu o pozitie
        // Exemplu: Input: [1,2,3,4,5]
        //         Output: [5,1,2,3,4]
        // Rezolva apoi problema in mod general, adica roteste un array la stanga cu n pozitii
        // Exemplu: Input: [1,2,3,4,5] , n=2
        //          Output: [3,4,5,1,2] - array-ul s-a rotit cu 2 pozitii
        List<Integer> integersList = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Ex 11");
        System.out.println(integersList);
        System.out.println(rotatedNo(integersList));

        //12
        //Gaseste al k-lea cel mai mic element dintr-un array
        //Exemplu: Input: {7, 10, 4, 3, 20, 15}, K = 3
        //                Output: 7
        System.out.println("Ex 12");
        List<Integer> kNums = Arrays.asList(7, 10, 4, 3, 20, 15);
        int k = 3;
        kNums.sort(Comparator.comparingInt(a -> a));
        System.out.println(kNums.get(k - 1));

        //13
        // Inverseaza un array fara sa folosesti un alt array

        List<Integer> arrList = Arrays.asList(8, 3, 2, 5, 9);
        System.out.println("Ex 13");
        System.out.println("INITIAL ARRAY " + arrList);
        System.out.println("ROTATED ARRAY " + getRotatedArray(arrList));


        //14
        // Implementeaza o masina de dat rest
        //Ai la dispozitie un nr infinit de monede de 25 centi, 10 centi, 5 centi si un cent.
        //Pentru o anumita suma, gaseste numarul minim de monede pentru a reprezenta acea suma
        //Exemplu: Input: amount = 17
        //                Output: [10, 5, 1, 1]

        //17/25
        //17/10 1 rest 7 - intra o data pentru ca restul e 1
        //2/5 1 rest 2
        // 2/1 = 2
        System.out.println("Ex 14");
        List<Integer> coins = Arrays.asList(25, 10, 5, 1);  //->10,5,5,1

        Integer amount = 17;
        List<Integer> generatedChange = new ArrayList<>();
        for (int i = 0; i < coins.size(); i++) {
            int cat = amount / coins.get(i);
            for (int j = 0; j < cat; j++) {
                generatedChange.add(coins.get(i));
            }
            amount = amount % coins.get(i);
        }
        System.out.println(generatedChange);

        amount = 17;
        generatedChange.clear();
        for (int i = 0; i < coins.size(); i++) {
            while (amount >= coins.get(i)) {
                amount -= coins.get(i);
                generatedChange.add(coins.get(i));
            }
        }

    }

    //2
    //1.aflam produsul tuturor nr
    // parcurgem lista de numere
    //2.impartim produsul la fiecare numar din lista
    //3.inlocuim elementele si afisam lista
    public static List<Integer> findNoOfProduct(List<Integer> nums) {
        List<Integer> listNoOfProduct = new ArrayList<>();
        int prod = 1;
        for (int i = 0; i < nums.size(); i++) {
            prod *= nums.get(i);
        }

        for (int i = 0; i < nums.size(); i++) {
            nums.set(i, (prod / nums.get(i)));
            //listNoOfProduct.add(prod / nums.get(i));
        }
        System.out.println("v2 " + nums);
        return listNoOfProduct;
    }

    //3
    public static Map<Integer, Integer> getDuplicateNo(List<Integer> duplicateList) {
        Map<Integer, Integer> duplicateNo = new HashMap<>();
        for (Integer number : duplicateList) {
            if (duplicateNo.containsKey(number)) {
                duplicateNo.put(number, duplicateNo.get(number) + 1);
            } else {
                duplicateNo.put(number, 1);
            }
        }
        return duplicateNo;
    }

    //4
    public static Integer getMissingNo(List<Integer> noList) {
        Collections.sort(noList);
        for (int i = 0; i < noList.size(); i++) {
            if (noList.get(i + 1) - noList.get(i) == 2) {
                return noList.get(i) + 1;
            }
        }
        return 0;
    }

    //VAR 2 PT 4
    public static Integer findTheMissingNo(List<Integer> noList, int n) {
        Map<Integer, Boolean> numberByApparition = new HashMap<>();
        for (Integer number : noList) {
            numberByApparition.put(number, true);
        }
        for (int number = 1; number <= n; number++) {
            if (!numberByApparition.containsKey(number)) {
                return number;
            }
        }
        return 0;
    }

    //5
    public static List<Integer> duplicateNo(List<Integer> numbersList) {
        Map<Integer, Integer> newMap = new TreeMap<>();
        for (Integer number : numbersList) {
            if (newMap.containsKey(number)) {
                newMap.put(number, newMap.get(number) + 1);
            } else {
                newMap.put(number, 1);
            }
        }

        List<Integer> newList = new ArrayList<>();
        for (Integer number : newMap.keySet()) {
            for (int i = 1; i <= newMap.get(number); i++) {
                newList.add(number);
            }
        }
        return newList;
    }

    //7
    public static int getMaxDiference(List<Integer> numbers) {
        int maxDifference = 0;
        int firstNoPosition = 0;
        int secondNoPosition = 0;

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) < numbers.get(j)) {
                    /*int currentDifference = Math.abs(numbers.get(i) - numbers.get(j));
                    if (currentDifference > maxDifference) {
                        maxDifference = currentDifference;
                    }*/

                    //var 2
                    if (numbers.get(j) - numbers.get(i) > maxDifference) {
                        maxDifference = numbers.get(j) - numbers.get(i);
                        firstNoPosition = i; //retin pozitia
                        secondNoPosition = j;
                    }

                    //var 3
                    /*maxDifference = Integer.max(maxDifference, Math.abs(numbers.get(i) - numbers.get(j)));
                    maxDifference = Integer.max(maxDifference, numbers.get(j) - numbers.get(i));*/
                }
            }
        }
        System.out.println(numbers.get(firstNoPosition) + " " + numbers.get(secondNoPosition));
        return maxDifference;
    }

    //8
    //1. parcurgem lista
    //2. comparam fiecare nr din lista cu n(adica 8)
    //3. il gasim, il retinm in variabila si il afisam
    public static Integer findTheNearestNo(List<Integer> integerList, int n) {
        int foundedNearestNo = Integer.MAX_VALUE;
        int positionOfMin = 0;
        for (int i = 0; i < integerList.size(); i++) {
            if (Math.abs(n - integerList.get(i)) < foundedNearestNo) {
                foundedNearestNo = Math.abs(n - integerList.get(i));
                positionOfMin = i;
            }
        }
        return integerList.get(positionOfMin);
    }

    //9
    public static List<Integer> getAllZeroToTheEnd(List<Integer> numsList) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < numsList.size(); i++) {
            if (numsList.get(i) != 0) {
                newList.add(numsList.get(i));
            }
        }
        for (int i = 0; i < numsList.size(); i++) {
            if (numsList.get(i) == 0) {
                newList.add(numsList.get(i));
            }
        }
        return newList;
    }

    //10
    public static void findSubarraySum(List<Integer> arrayList, int sum) {
        for (int i = 0; i < arrayList.size(); i++) {
            int currentSum = arrayList.get(i);
            for (int j = i + 1; j < arrayList.size() && currentSum <= sum; j++) {
                if (currentSum == sum) {
                    System.out.println("suma a fost gasita intre intervalele " + i + " " + (j - 1));
                    break;
                }
                currentSum += arrayList.get(j);
            }
        }
    }

    //11
    public static List<Integer> rotatedNo(List<Integer> integersList) {
        int first = integersList.get(integersList.size() - 1);
        for (int i = integersList.size()-1; i >= 1; i--) {
            integersList.set(i, integersList.get(i - 1));
        }
        integersList.set(0, first);

        return integersList;
    }

    //13
    // ! a=b; b=c; c=a
    //1. ne luam o variabila temporara care va reprezenta fiecare element din lista ->  arrList.get(i)
    //2. gasim jumatatea array-ului -> arrList.size() / 2
    //  *** 2.1 avem acelasi rezultat daca punem arrList.size() - 2
    //3. ne folosim de metoda set() din List<> unde ->la pozitia (i) punem ultimul element i-1
    //  3.1 si in final, pozitia ultimului element i-1  va fi schimbata cu temp
    public static List<Integer> getRotatedArray(List<Integer> arrList) {
        int temp;

        for (int i = 0; i < arrList.size() / 2; i++) {
            temp = arrList.get(i);
            arrList.set(i, arrList.get(arrList.size() - i-1));
            arrList.set(arrList.size() - i-1, temp);
            //Collections.sort(arrList);
        }
        return arrList;
    }
}

