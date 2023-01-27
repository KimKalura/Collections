package stockCompany;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*Map<String, Integer> map = new HashMap<>();
        map.put("google", 200);
        map.put("tesla", 300);
        map.put("microsoft", 450);
        map.put("yahoo", 700);
        Stock stock = new Stock(map);*/

        //vezi M addStockEntry
        Stock stock = new Stock();
        stock.addStockEntry("Google", 300);
        stock.addStockEntry("Tesla", 400);
        stock.addStockEntry("Microsoft", 200);


        System.out.println(stock.getMostExpensiveCompany());

        System.out.println(stock.getAverageSharePrice());
    }
}
