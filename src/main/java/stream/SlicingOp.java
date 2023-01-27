package stream;

import java.util.*;
import java.util.stream.Collectors;

public class SlicingOp {
    public static void main(String[] args) {
        List<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("USA");
        countries.add("China");
        countries.add("India");
        countries.add("UK");
        countries.add("China");

        //1. printeaza tarile din lista, fara sa se repete
        List<String> setWithoutDuplicates = countries.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(setWithoutDuplicates);
        System.out.println("ex 1" + getUniqueElements(countries));
        System.out.println("ex 1-clasic: " + getCountriesWithoutDuplicates(countries));

        System.out.println(" ");

        //2. printeaza 3 tari din lista, fara sa se repete
        Set<String> firstThreeCountry = countries.stream()
                .limit(3)
                .collect(Collectors.toSet());
        System.out.println("ex 2:" + firstThreeCountry);
        System.out.println("ex 2-clasic: " + getTreeCountries(countries));

    }

    //var 1
    public static List<String> getUniqueElements(List<String> countriesList) {
        LinkedHashSet<String> uniqueElements = new LinkedHashSet<>(countriesList);
        ArrayList<String> uniqueList = new ArrayList<>(uniqueElements);
        return uniqueList;
    }
    //var 2
    public static Set<String> getCountriesWithoutDuplicates(List<String> countries) {
        Set<String> uniqueElemets = new HashSet<>();
        for(String country :countries) {
            uniqueElemets.add(country);
        }
        return uniqueElemets;
    }

    //2
    public static Set<String> getTreeCountries(List<String> countries) {
        Set<String> countriesSet = new HashSet<>();
        int i = 0;
        for (String country : countries) {
            if (!countriesSet.contains(country) && i < 3){
                countriesSet.add(country);
                i++;
            }
        }
        return countriesSet;
    }

}