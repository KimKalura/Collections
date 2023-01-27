package methodReferences;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Integer.max(3, 7);

        //Reference to a static method
        BiFunction<Integer, Integer, Integer> maxFunction = (a, b) -> Integer.max(a, b);
        BiFunction<Integer, Integer, Integer> maxFunction2 = Integer::max;
        System.out.println(maxFunction.apply(3, 7));

        //reference to an instance method to an object
        String word = "java";
        //System.out.println(word.indexOf('v'));
        word.indexOf('v');
        Function<Character, Integer> indexOfCharacterFunction = character -> word.indexOf(character);
        Function<Character, Integer> indexOfCharacterFunction2 = word::indexOf;
        System.out.println(indexOfCharacterFunction.apply('v'));

        //reference to an instance method of a class
        Function<Long, Double> converter = x -> x.doubleValue(); //convertim de la long la double;
        Function<Long, Double> converter2 = Long::doubleValue;
        System.out.println(converter2.apply(200L));

        //reference to a constructor
        Function<String, Person> personGenerator = name -> new Person(name);
        Function<String, Person> personGenerator2 = Person::new;
        System.out.println(personGenerator2.apply("John"));

        //Consumer<String> printer = x -> System.out.println(x);
        Consumer<String> printer = System.out::println;

    }
}
