package stream;

import stream.helperClasses.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingOp {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23, "India"));
        list.add(new Person("Joe", 18, "USA"));
        list.add(new Person("Ryan", 54, "Canada"));
        list.add(new Person("Iyan", 5, "India"));
        list.add(new Person("Ray", 63, "China"));

        //1. verifica daca lista de persoana contine cel putin o persoana din Canada
        boolean isAnyPersonFrom = list.stream()
                .anyMatch(person -> person.getCountry().equals("Canada"));
        System.out.println(isAnyPersonFrom);

        System.out.println(isAnyPersonFrom("Canada", list)); //pt varianta 2 cu metoda

        System.out.println("Person from Canada: " + getPersonFrom(list, "Canada"));

        //***
        //2. verifica daca toate persoanele din lista sunt din Canada
        boolean areAllPeopleFromCanada = list.stream()
                //.filter(person-> person.getCountry().equals("Canada"))
                .allMatch(person -> person.getCountry().equals("Canada"));
        System.out.println(areAllPeopleFromCanada);

        System.out.println("There are all people from Canada: " + getAllPersonFrom(list, "Canada"));

        //***
        //3. verifica daca nu exista nicio persoana din Rusia
        boolean isAnyPersonFromRusia = list.stream()
                .allMatch(person -> !person.getCountry().equals("Rusia"));
        System.out.println("Person from Russia:" + isAnyPersonFromRusia);
        System.out.println("Person from Russia" + isNoPersonFrom("Russia", list));
    }

    //1 var2 cu metoda
    public static boolean isAnyPersonFrom(String countryName, List<Person> personList) {
        return personList.stream()
                .anyMatch(person -> person.getCountry().equals(countryName));
    }

    //1 ***
    public static boolean getPersonFrom(List<Person> list, String country) {
        boolean personFromCanada = true;
        for (int i = 0; i < list.size(); i++) {
            if (personFromCanada == list.equals(country)) {
                return true;
            }
        }
        return personFromCanada;
    }

    //2 ***
    public static boolean getAllPersonFrom(List<Person> list, String country) {
        boolean thereAreAllPeopleFromCanada = false;
        for (int i = 0; i < list.size(); i++) {
            if (thereAreAllPeopleFromCanada == country.equals("Canada")) {
                return true;
            } else {
                return false;
            }
        }
        return thereAreAllPeopleFromCanada;
    }

    //3
    public static boolean isNoPersonFrom(String countryName, List<Person> personList){
        for (Person person : personList) {
            if (person.getCountry().equals(countryName)){
                return false;
            }
        }
        return true;
    }

}
