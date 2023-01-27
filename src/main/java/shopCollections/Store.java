package shopCollections;

import java.util.*;


public class Store {

    private Map<Category, List<Product>> productsByCategory;


    public Store() {
        this.productsByCategory = new HashMap<>();
    }

    public Map<Category, List<Product>> getProductsByCategory() {
        return productsByCategory;
    }

    public void setProductsByCategory(Map<Category, List<Product>> productsByCategory) {
        this.productsByCategory = productsByCategory;
    }


    public void addProduct(Product product) {
        if (!productsByCategory.containsKey(product.getCategory())) {
            List<Product> products = new ArrayList<>();
            products.add(product);
            productsByCategory.put(product.getCategory(), products);
        } else {
            productsByCategory.get(product.getCategory()).add(product);
        }
    }

    // toate produsele dintr-o anumita categorie
    public List<Product> getProductByCategory(Category category) {
        return productsByCategory.get(category);
    }

    public Set<Category> getAllCategories() {
//        Set<Category> allCategories = new HashSet<>();
//        for(Map.Entry<Category, List<Product>> entry : productsByCategory.entrySet()){
//            allCategories.add(entry.getKey());
//        }
//        return allCategories;

        return productsByCategory.keySet();
    }


    public void deleteProduct(Product product) {
         productsByCategory.get(product.getCategory()).remove(product);
    }


    @Override
    public String toString() {
        return "Store{" +
                "productsByCategory=" + productsByCategory +
                '}';
    }
}