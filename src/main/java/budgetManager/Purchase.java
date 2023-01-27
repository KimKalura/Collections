package budgetManager;


public class Purchase implements Comparable<Purchase> {

    private String name;
    private int price;
    private Category category;

    public Purchase(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    @Override
    public int compareTo(Purchase anotherPurchase) {
        return Integer.compare(price, anotherPurchase.getPrice());
    }
}
