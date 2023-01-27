package bookstore;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book(2016, "I Wish I Was Egyptian", "Fiction", "Alaa al-Aswani");
        Book book2 = new Book(2013, "Juden auf Wanderschaft", "Essays", "Joseph Roth");
        Book book3 = new Book(2020, "Pestera", "Fiction", "Jose Saramago");
        Book book4 = new Book(2012, "Originile limbilor neolatine - Introducere în filologia romanică ", "Analysis", "Carlo Tagliavini");
        Book book5 = new Book(2009, "The Castle", "Fiction", "Franz Kafka");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        System.out.println(bookSet);

        System.out.println(" ");

        //ADD METHOD
        BookStore bookStore = new BookStore(bookSet);

        System.out.println("before added");
        System.out.println(bookSet);
        bookStore.addBook(book5);
        System.out.println("after added");
        System.out.println(bookSet);

        System.out.println(" ");

        //DELETE METHOD
        System.out.println("before removal");
        System.out.println(bookSet);
        System.out.println("after removal");
        bookStore.deleteBook(book4);
        System.out.println(bookSet);

        System.out.println(" ");

        // RETURN VALUE OF ATRIBUTES BOOK
        System.out.println(">> Get all books by Year");
        System.out.println(bookStore.getAllBooksOrderedByYear());

        System.out.println(">> Get all Genres");
        System.out.println(bookStore.getAllGenres());

        System.out.println(">> Get all Books by Genre");
        System.out.println(bookStore.getAllBooksByGenre());

        System.out.println(">> Get all books by Author");
        System.out.println(bookStore.getAllBooksOrderedByAuthor());

        System.out.println(">> All books with the same Genre");
        System.out.println(bookStore.getBooksByGenre("Essays"));
    }
}
