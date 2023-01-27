package methodReferences.school;

public class Main {
    public static void main(String[] args) {

        Schoolbag schoolbag = new Schoolbag();
        try {
            schoolbag.addItem(new Item("book", 4));
        }catch (OperationNotSupported e){
            System.out.println(e.getMessage());
        }


        try {
            schoolbag.addItem(new Item("notebook", 3));
        } catch (OperationNotSupported e) {
            System.out.println(e.getMessage());
        }


        try {
            schoolbag.addItem(new Item("watercolors", 3));
        } catch (OperationNotSupported e) {
            System.out.println(e.getMessage());
        }


        try {
            schoolbag.addItem(new Item("eraser", 2));
        } catch (OperationNotSupported e) {
            System.out.println(e.getMessage());
        }

        System.out.println(schoolbag);


        System.out.println("Delete Item:");
        schoolbag.deleteItem(schoolbag.getItemList().get(1));
        System.out.println(schoolbag);

        System.out.println("Get sumCapacities:");
        System.out.println(schoolbag.getSumOfItemCapacities());

        System.out.println("Get restCapacity:");
        System.out.println(schoolbag.getRestCapacityOfSchoolbag());

        System.out.println("Get Item by name:");
        System.out.println(schoolbag.getItemByName("book"));
    }

}
