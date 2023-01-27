package methodReferences.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Schoolbag {

    private List<Item> itemList;
    private static final Integer maxCapacityOfSchoolBag = 10;


    public Schoolbag() {
        this.itemList = new ArrayList<>();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Schoolbag{" +
                "itemList=" + itemList +
                '}';
    }

    public void addItem(Item newItem) throws OperationNotSupported {
        Integer sum = getSumOfItemCapacities();
        if (sum + newItem.getCapacity() <= maxCapacityOfSchoolBag) {
            itemList.add(newItem);
        } else {
            throw new OperationNotSupported("Item exceeds capacity");
        }
    }

    public void deleteItem(Item item) {
        itemList.remove(item);
    }

    public Integer getSumOfItemCapacities() {
//        Integer sum =0;
//        for(Item item : items) {
//            sum += item.getCapacity();
//        }
//        return sum;

        // var 2
        Optional<Integer> optionalSum = itemList.stream()
                .map(item -> item.getCapacity())
                .reduce((sum, capacity) -> sum + capacity);
        return optionalSum.orElse(0);
    }


    public Integer getRestCapacityOfSchoolbag() {
        return maxCapacityOfSchoolBag - getSumOfItemCapacities();
    }


    public Item getItemByName(String name) {
        Optional<Item> foundItemByName = itemList.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst();
        return foundItemByName.orElse(null);
    }

}
