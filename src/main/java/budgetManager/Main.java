package budgetManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Purchase> readList = ReadFromFile.readFromFile();
        System.out.println("from file" + readList);


        List<Purchase> purchases1 = new ArrayList<>();
        Purchase purchase1 = new Purchase("House", 90000000, Category.OTHERS);
        Purchase purchase2 = new Purchase("Christmas Party", 2500, Category.FUN);
        Purchase purchase3 = new Purchase("Cookies", 60, Category.FOOD);
        Purchase purchase15 = new Purchase("Ice cream", 80, Category.FOOD);
        purchases1.add(purchase1);
        purchases1.add(purchase2);
        purchases1.add(purchase3);
        purchases1.add(purchase15);


        List<Purchase> purchases2 = new ArrayList<>();
        Purchase purchase4 = new Purchase("Furniture", 7500, Category.OTHERS);
        Purchase purchase5 = new Purchase("Coats", 350, Category.CLOTHES);
        Purchase purchase6 = new Purchase("ChineseFood", 30, Category.FOOD);
        purchases2.add(purchase4);
        purchases2.add(purchase5);
        purchases2.add(purchase6);

        List<Purchase> purchases3 = new ArrayList<>();
        Purchase purchase7 = new Purchase("Jewlery", 650, Category.OTHERS);
        Purchase purchase8 = new Purchase("Theater", 80, Category.FUN);
        Purchase purchase9 = new Purchase("Skating Rink", 25, Category.FUN);
        purchases3.add(purchase7);
        purchases3.add(purchase8);
        purchases3.add(purchase9);

        List<Purchase> purchases4 = new ArrayList<>();
        Purchase purchase10 = new Purchase("Utilities", 700, Category.OTHERS);
        Purchase purchase11 = new Purchase("Jewlery", 450, Category.OTHERS);
        purchases4.add(purchase10);
        purchases4.add(purchase11);

        List<Purchase> purchases5 = new ArrayList<>();
        Purchase purchase12 = new Purchase("FastFood", 50, Category.FOOD);
        Purchase purchase13 = new Purchase("Coat", 900, Category.CLOTHES);
        Purchase purchase14 = new Purchase("Electronics", 730, Category.OTHERS);
        purchases5.add(purchase12);
        purchases5.add(purchase13);
        purchases5.add(purchase14);


        List<User> users = new ArrayList<>();
        User user1 = new User(purchases1, 2000000000);
        User user2 = new User(purchases2, 200000);
        User user3 = new User(purchases3, 90500);
        User user4 = new User(purchases4, 8000);
        User user5 = new User(purchases5, 1050);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);


        System.out.println(">> All purchases: " + user1.getAllPurchases());
        System.out.println(">> All purchases by one Category - V1: " + user1.getAllPurchasesByOneCategoryV1(Category.OTHERS));
        System.out.println(">> All purchases by one Category - V2: " + user3.getAllPurchasesByOneCategoryV2());
        System.out.println(">> Purchases by Category: " + user1.getPurchasesByCategory());
        System.out.println(">> max category: " + user5.getMaxCategory());
        System.out.println(">> min category: " + user2.getMinCategory());
        System.out.println(">> All purchases in the range: " + user5.findAllPurchasesFrom(60, 1000));
        System.out.println(">> Sorting purchases by Price: " + user1.getAllPurchasesOrderedByPrice());
        System.out.println(">> Sorting purchases from a certain Category by Price: " + user4.getPurchasesFromACertainCategoryByPrice(purchases4, Category.OTHERS));

        user5.setMaxBudget(5000);
        System.out.println(">> Setting maxBudget: " + user5.getMaxBudget());

        System.out.println(">> Available Budget: " + user4.getAvailableBudget());

        user4.addPurchase(new Purchase("Vacation", 7500, Category.OTHERS));
        System.out.println(">> After adding a new purchase: " + user4.getAllPurchases());

        user2.deletePurchase(purchase6);
        System.out.println(">> After deleting a purchase: " + user2.getAllPurchases());


        user1.write(purchases1.toString());
    }
}
