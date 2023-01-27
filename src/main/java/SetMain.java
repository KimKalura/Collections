import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {
        Set<String> countries = new HashSet<>();

        countries.add("India");
        countries.add("Japonia");
        countries.add("India");

        System.out.println(countries);
        System.out.println(countries.contains("Japonia"));
        countries.clear();
        System.out.println(countries);

        for (String country : countries) {
            System.out.println(country);
        }
    }
}
