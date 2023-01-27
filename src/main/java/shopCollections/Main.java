package shopCollections;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.addProduct(new Product("milk", 7, Category.LACTATE));
        store.addProduct(new Product("yogurt", 7, Category.LACTATE));
        store.addProduct(new Product("apples", 7, Category.LEGUMEFRUCTE));
        Product productToBeDeleted = new Product("orange", 10, Category.LEGUMEFRUCTE);

        System.out.println(store.getProductsByCategory());

        System.out.println(store.getProductByCategory(Category.LEGUMEFRUCTE));

        System.out.println("****");

        System.out.println(store.getAllCategories());

        store.addProduct(productToBeDeleted);
        System.out.println(store);
        store.deleteProduct(productToBeDeleted);
        System.out.println(store);

    }
}

