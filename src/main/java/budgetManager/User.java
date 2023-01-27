package budgetManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class User {
    private List<Purchase> purchases;
    private int maxBudget;


    public User(List<Purchase> purchases, int maxBudget) {
        this.purchases = purchases;
        this.maxBudget = maxBudget;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public int getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(int maxBudget) {
        this.maxBudget = maxBudget;
    }

    @Override
    public String toString() {
        return "User{" +
                "purchases=" + purchases +
                ", maxBudget=" + maxBudget +
                '}';
    }


    //Vizualizarea tututor cheltuielilor
    public List<Purchase> getAllPurchases() {
        return purchases;
    }

    //Vizualizarea cheltuielilor dintr-o anumita categorie
    public List<Purchase> getAllPurchasesByOneCategoryV1(Category category) {
        List<Purchase> allPurchasesByCategory = new ArrayList<>();
        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).getCategory().equals(category)) {
                allPurchasesByCategory.add(purchases.get(i));
            }
        }
        return allPurchasesByCategory;
       //return getPurchasesByCategory().get(category); //Var2
    }
    public Map<Category, Integer> getAllPurchasesByOneCategoryV2() {
        Map<Category, Integer> allPurchasesByCategory = new HashMap<>();
        for (int i = 0; i < purchases.size(); i++) {
            Category category = purchases.get(i).getCategory();
            if (!allPurchasesByCategory.containsKey(category)) {
                allPurchasesByCategory.put(category, purchases.get(i).getPrice());
            } else {
                allPurchasesByCategory.put(category, allPurchasesByCategory.get(category) + purchases.get(i).getPrice());
            }
        }
        return allPurchasesByCategory;
    }

    //Vizualizarea cheltuielilor grupate pe categorii
    public Map<Category, List<Purchase>> getPurchasesByCategory() {
        Map<Category, List<Purchase>> purchasesByCategory = new HashMap<>();
        for (int i = 0; i < purchases.size(); i++) {
            Category category = purchases.get(i).getCategory();
            if (!purchasesByCategory.containsKey(category)) {

                List<Purchase> purchases1 = new ArrayList<>();
                purchases1.add(purchases.get(i));
                purchasesByCategory.put(category, purchases1);
            } else {
                purchasesByCategory.get(category).add(purchases.get(i));
            }
        }
        return purchasesByCategory;
    }

    //Vizualizarea categoriei in care a cheltuit cel mai mult/mai putin
    public Category getMaxCategory() {
        Map<Category, Integer> sumOfPurchasesByCategory = getAllPurchasesByOneCategoryV2();
        Integer max = 0;
        Category maxCategory = null;
        for (Category category: sumOfPurchasesByCategory.keySet()){
            Integer currentSumOfPurchases = sumOfPurchasesByCategory.get(category);
            if (currentSumOfPurchases > max){
                max = currentSumOfPurchases;
                maxCategory = category;
            }
        }
//        for (Map.Entry<Category,Integer> pair: sumOfPurchasesByCategory.entrySet()){
//            Integer currentSumOfPurchases = pair.getValue();
//            if (currentSumOfPurchases>max){
//                max = currentSumOfPurchases;
//                maxCategory = pair.getKey();
//            }
//        }
        return maxCategory;
    }

    public Category getMinCategory() {
        Map<Category, Integer> sumOfPurchasesByCategory = getAllPurchasesByOneCategoryV2();
        Integer min = Integer.MAX_VALUE;
        Category minCategory = null;
        for (Category category : sumOfPurchasesByCategory.keySet()) {
            Integer currentSumOfPurchases = sumOfPurchasesByCategory.get(category);
            if (currentSumOfPurchases < min) {
                min = currentSumOfPurchases;
                minCategory = category;
            }
        }
        return minCategory;
    }

    //Vizualizarea tuturor cheltuielilor dintr-un interval de pret
    public List<Purchase> findAllPurchasesFrom(int price1, int price2) {
        List<Purchase> foundedPurchases = new ArrayList();
        purchases.stream().filter(p -> p.getPrice() > price1 && p.getPrice() < price2).forEach(foundedPurchases::add);
        return foundedPurchases;

        //return purchases.stream().filter(p -> p.getPrice() > price1 && p.getPrice() < price2).collect(Collectors.toList());

        /*for (Purchase p : purchases){
            if(p.getPrice() > price1 && p.getPrice() < price2){
                foundedPurchases.add(p);
            }
        }
        return foundedPurchases;*/
    }

    //Sortarea tuturor cheltuielilor dupa pret
    public List<Purchase> getAllPurchasesOrderedByPrice() {
        List<Purchase> allPurchaseByPrice = new ArrayList<>();
        allPurchaseByPrice.addAll(purchases);
        Collections.sort(allPurchaseByPrice);
        return allPurchaseByPrice;
        //return purchases.stream().sorted().collect(Collectors.toList());
    }

    //Sortarea cheltuielilor dintr-o anumita categorie dupa pret
    public List<Purchase> getPurchasesFromACertainCategoryByPrice(List<Purchase> purchases, Category category) {
        List<Purchase> purchasesFromACertainCategory = getAllPurchasesByOneCategoryV1(category);
        return purchasesFromACertainCategory.stream().sorted().collect(Collectors.toList());
        //return getPurchasesByCategory().get(category).stream().sorted().collect(Collectors.toList());
    }

    //Salvarea tuturor cheltuielilor intr-un fisier  +metoda read +write
    public void write(String purchases) throws IOException {
        BufferedWriter writer = null;
        writer = new BufferedWriter(
                new FileWriter("src/main/java/budgetManager/PurchasesFile.txt"));
        writer.write(purchases);
        writer.close();
    }

    //Setarea unui buget
    public void setBudget(Integer maxBudget) {
        setMaxBudget(maxBudget);
    }

    //Vizualizarea bugetului disponibil
    public Integer getAvailableBudget() {
        int sum = 0;
        for (int i = 0; i < purchases.size(); i++) {
            sum += purchases.get(i).getPrice();
        }
        return maxBudget - sum;
    }

    //Adaugarea unei cheltuieli
    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    //Stergerea unei cheltuieli
    public void deletePurchase(Purchase purchase) {
        purchases.remove(purchase);
    }
}
