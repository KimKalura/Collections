package collections;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> validContacts = new ArrayList<>();
        validContacts.add("+80 256 3256 652");
        validContacts.add("+12 325 4855 694");
        validContacts.add("+30 124 8888 641");
        System.out.println(validContacts);

        List<String> blackContacts = new ArrayList<>();
        PhoneBook phoneBook = new PhoneBook(validContacts, blackContacts);
        phoneBook.addToBlackList("+80 256 3256 652");
        System.out.println(phoneBook.getBlackList());
        System.out.println(phoneBook.getValidContacts());

        //PhoneBook.filterContact(validContacts, blackContacts);

        phoneBook.removeFromBlackList("+80 256 3256 652");
        System.out.println(blackContacts.contains("+80 256 3256 652"));
        System.out.println(phoneBook.getValidContacts());
    }
}
