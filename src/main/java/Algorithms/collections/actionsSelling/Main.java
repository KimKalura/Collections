package Algorithms.collections.actionsSelling;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1. Afla profitul maxim pe care il poti face cumparand si vanzand actiuni.
        //Ca si input ai un array cu preturile unei actiuni in fiecare zi. Va trebui sa determini in ce zi trebuie sa cumperi si in ce zi trebuie sa vinzi
        // ca sa obtii profitul maxim
        //Exemplu:Input: [100, 180, 260, 310, 40, 535, 695]  //
        //        Output: Cumpara in ziua 5 (la pretul de 40) si vinde in ziua 7 (la pretul de 695), adica profit maxim 695-40=655
        //        Input2: [2, 3, 10, 6, 4, 8, 1]
        //        Output: Cumpara in ziua 0 (la pretul de 2) si vinde in ziua 2 (la pretul de 10), adica profit maxim 10-2=8

        List<Integer> prices = Arrays.asList(100, 180, 260, 310, 40, 535, 695);
        System.out.println(prices);

        System.out.println(getMaxProfit(prices));
    }

    public static int getMaxProfit(List<Integer> prices) {
        //1.parcurg lista pt a gasi ziua cu pretul Maxim
        //2.parcurg lista (pana la ziua cu pretul Maxim)pt a gasi ziua cu pretul Minim
        //3.calculez profitul
        int maxPrice = 0;
        int dayWithMaxPrice = 0;
        int minPrice = Integer.MAX_VALUE;
        //int dayWithMinPrice = 0;
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) > maxPrice) {
                maxPrice = prices.get(i);
                dayWithMaxPrice = i;
            }
        }
        for (int i = 0; i < dayWithMaxPrice; i++) {
            if (prices.get(i) < minPrice) {
                minPrice = prices.get(i);
                //dayWithMinPrice = i;
            }
        }
        return maxPrice - minPrice;
    }
}
