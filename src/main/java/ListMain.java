import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMain {

    public static void main(String[] args) {

        List<Integer> prices = new ArrayList<>();
        prices.add(2);
        prices.add(3);
        prices.add(5);
        System.out.println(prices);

        for (int i = 0; i < prices.size(); i++) {
            System.out.println(prices.get(i));
        }
        prices.set(0, 4); // la poz 0 inlocuiesc cu 4
        System.out.println(prices.get(0));

        for (Integer price : prices) {
            //System.out.println(price); // 4 3
            System.out.println(price * 2); //8 6
        }

        /*prices.remove(2); //sterge 5 de la poz 2;
        System.out.println(prices);*/

        prices.remove(new Integer(5));
        System.out.println(prices);


        System.out.println(prices.indexOf(3)); // 1

        System.out.println(prices.contains(3)); //true

        List<String> immutableList = Arrays.asList("asd", "bcd", "def");
        //immutableList.add("sfd");
    }
    
}
