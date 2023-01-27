package stream;

import stream.helperClasses.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOp {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(12);
        list1.add(23);
        list1.add(45);
        list1.add(6);
        //1. returneaza numerele din lista care sunt mai mari decat x
        System.out.println(findNoBiggerThan(list1, 15));



        List<String> programmingLanguages = Arrays.asList("Java", "", "scala", "Kotlin", "", "clojure");
        //2. printeaza cate string-uri din lista care incep cu litera mare si care nu sunt goale
        //VAR 1
        long count = programmingLanguages.stream()
//                .filter(language -> {
//                    if(!language.isEmpty()) {
//                        if(Character.isUpperCase(language.charAt(0))){
//                            return true;
//                        }
//                    }
//                    return false;
//                })
                .filter(language -> !language.isEmpty() && Character.isUpperCase(language.charAt(0)))
                .count();
        System.out.println(count);
        //VAR 2
        long count2 = programmingLanguages.stream()
                .filter(language ->!language.isEmpty())
               //.peek(x-> System.out.println("1" + x))
                .filter(language -> Character.isUpperCase(language.charAt(0)))
                //.peek(x-> System.out.println("2" + x))
                .count();
        System.out.println(count2);


        //***
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23, "USA"));
        list.add(new Person("Joe", 18, "USA"));
        list.add(new Person("Ryan", 54, "USA"));
        list.add(new Person("Iyan", 5, "USA"));
        list.add(new Person("Ray", 63, "USA"));
        //3. printeaza care sunt persoanele active (cu varsta mai mare decat 18 si mai mica decat 60 de ani)
         list.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 60)
                .forEach(person -> System.out.println(person));
    }

    //1
    public static List<Integer> findNoBiggerThan(List<Integer> list, int x) {
        return list.stream()
                .filter(number -> number > x)
                .collect(Collectors.toList());
    }

}