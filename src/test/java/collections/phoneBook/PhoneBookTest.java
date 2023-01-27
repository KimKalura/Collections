package collections.phoneBook;

import collections.PhoneBook;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {

    @Test
    void testFilterContacts_ShouldReturnValidContacts() {
        //given
        List<String> validContacts = new ArrayList<>();
        validContacts.add("+80 256 3256 652");
        validContacts.add("+40 666 2158 234");
        validContacts.add("+31 225 4785 652");
        List<String> blackContacts = new ArrayList<>();
        blackContacts.add("+80 256 3256 652");
        blackContacts.add("+31 225 4785 652");

        //when
        List<String> result = PhoneBook.filterContact(validContacts, blackContacts);

        //then
        assertEquals(1, result.size());
    }

}
