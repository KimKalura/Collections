package lambda.collections_exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //1.  Suma numerelor pare.-Calculeaza suma numerelor pare dintr-o lista de Integer-uri.
        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(325);
        numbersList.add(8);
        numbersList.add(37);
        numbersList.add(88);
        numbersList.add(29);
        numbersList.add(12);
        System.out.println(numbersList);

        Integer sumOfEvenNo = numbersList.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .sum();
        System.out.println(sumOfEvenNo);

        System.out.println(getSumOfEvenNo(numbersList));

        //2.  Suma numerelor divizibile cu x sau cu y. -Scrie o metoda care sa calculeze suma numerelor divizibile cu x sau y (unde x si y sunt primiti ca parametri),
        // dintr-o lista de Integer-uri.
        List<Integer> divisibleNo = new ArrayList<>();
        divisibleNo.add(6);
        divisibleNo.add(2);
        divisibleNo.add(88);
        divisibleNo.add(18);
        divisibleNo.add(32);
        System.out.println(divisibleNo);

        System.out.println(getSumOfDivisibleNo(divisibleNo, 2, 4));

        //3.Sorteaza numerele dintr-un array.-Scrie o metoda care sa sorteze numerele dintr-o lista de Integer-uri, dar inainte de asta sa le transforme in valori pozitive
        //Ex: Input: [-1,2,-3,4,-5]
        //    Output:[1,2,3,4,5]
        //(HINT: map pentru a transforma fiecare numar din negativ in pozitiv, apoi sorted() ca si operatie finala. Foloseste Math.abs() pentru a transforma un numar din
        // negativ in pozitiv)
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-1);
        numbers.add(2);
        numbers.add(-3);
        numbers.add(4);
        numbers.add(-5);
        System.out.println(numbers);

        List<Integer> sortedPositiveNo = numbers.stream()
                .map(number -> Math.abs(number))
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedPositiveNo);
        System.out.println(getPositiveNo(numbers));

        //4.  Filtreaza persoanele care pot vota.-O persoana este caracterizata de nume si varsta.
        //Scrie o metoda statica numita isPersonEligibleForVoting(), care accepta ca parametru o lista de persoane si returneaza o lista cu persoanele care pot vota
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Menuhim", 18));
        personList.add(new Person("Debora", 28));
        personList.add(new Person("Sameskin", 12));
        personList.add(new Person("Carolina", 5));
        personList.add(new Person("Beth", 22));
        personList.add(new Person("Rahela", 14));
        System.out.println(personList);

        List<Person> isPersonEligibleForVoting = personList.stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toList());
        System.out.println(isPersonEligibleForVoting);

        System.out.println(isPersonEligibleForVoting(personList, 18));
        System.out.println("Clasic method: " + personWhoCanVotes(personList));

        //5.   Spell checker 2. -Avand intr-un main un String, in care se stocheaza un text si o lista de cuvinte gresite, scrie o functie care accepta acesti 2 parametrii
        // si returneaza lista cu cuvintele gresite care se regasesc in text
        //Ex: Input: String text = “acesta etse nu text”
        //           List<String> badWords = [“etse”, “nu”, “acetsa”, “extt”]
        //    Output: [“etse”, “nu”], pentru ca acestea sunt cuvintele din badWords care se regasesc in text
        //(HINT: stream pe lista badWords, apoi filtram doar cuvintele care sunt continute in text (folosind metoda contains()) )
        String text = "acesta etse nu text";
        List<String> badWords = new ArrayList<>();
        badWords.add("etse");
        badWords.add("nu");
        badWords.add("acetsa");
        badWords.add("extt");
        System.out.println(text);
        System.out.println(badWords);

        List<String> badWordsList = badWords.stream()
                .filter(word -> text.contains(word))
                .collect(Collectors.toList());
        System.out.println(badWordsList);

        System.out.println(findWordsFromText(text, badWords));
    }

    //1
    public static Integer getSumOfEvenNo(List<Integer> numbersList) {
        int sum = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) % 2 == 0) {
                sum += numbersList.get(i);
            }
        }
        return sum;
    }

    //2
    public static Integer getSumOfDivisibleNo(List<Integer> divisibleNo, int x, int y) {
        Optional<Integer> sumOfDivisibleNo = divisibleNo.stream()
                .filter(number -> number % x == 0)
                .filter(number -> number % y == 0)
                .reduce((sum, number) -> sum + number);
//                .mapToInt(number -> number)
//                .sum();
        return sumOfDivisibleNo.orElse(0);
    }

    //3
    public static List<Integer> getPositiveNo(List<Integer> numbers) {
        List<Integer> positiveNo = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            positiveNo.add(Math.abs(numbers.get(i)));
        }
        return positiveNo;
    }

    //4
    public static List<Person> isPersonEligibleForVoting(List<Person> personList, int age) {
        return personList.stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toList());
        //.forEach(person -> System.out.println(person));
    }

    public static List<Person> personWhoCanVotes(List<Person> personList) {
        List<Person> foundPerson = new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getAge() > 18) {
                foundPerson.add(personList.get(i));
            }
        }
        return foundPerson;
    }

    //5
    public static List<String> findWordsFromText(String text, List<String> badWords) {
        List<String> foundedWord = new ArrayList<>();
        for (int i = 0; i < badWords.size(); i++) {
            if (text.contains(badWords.get(i))) {
                foundedWord.add(badWords.get(i));
            }
        }
        return foundedWord;
    }

}
