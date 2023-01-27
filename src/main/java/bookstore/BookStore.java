package bookstore;

import java.util.*;
import java.util.stream.Collectors;


public class BookStore {
    Set<Book> bookSet;

    public BookStore(Set<Book> books) {
        this.bookSet = books;
    }

    public Set<Book> getBooks() {
        return bookSet;
    }

    public void setBooks(Set<Book> books) {
        this.bookSet = books;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "booksSet=" + bookSet +
                '}';
    }

    //Adauga o carte primita ca parametru in set-ul books
    public void addBook(Book book) {
        bookSet.add(book);
    }

    //Sterge cartea primita ca parametru din set-ul books
    public void deleteBook(Book book) {
        bookSet.remove(book);
    }


    //Va returna valoarea atributului books
    public List<Book> getAllBooksOrderedByYear() {
        List<Book> bookByYear = new ArrayList<>();
        bookByYear.addAll(bookSet);
        Collections.sort(bookByYear);
        return bookByYear;
    }

    //Va returna un set cu toate genurile existente in colectia de carti
    public Set<String> getAllGenres() {
        return bookSet.stream()
                .map(book -> book.getGenre())
                .collect(Collectors.toSet());
    }

    //Va returna un TreeSet care va folosi AuthorComparator pentru a sorta cartile dupa autor
    public Set<Book> getAllBooksOrderedByAuthor() {
        Set<Book> booksByAuthor = new TreeSet<>();
        booksByAuthor.addAll(bookSet);
        return booksByAuthor;
        //book1.getAuthor().compareTo(book2.getAuthor());
    }

    //Va construi o mapa, in care cheia este un gen, iar valoarea este set-ul de carti care au acel gen
    //Va returna aceasta mapa (toate genurile, cu toate cartile din fiecare gen)
    //(HINT: mapa cu cheia gen, iar valoarea lista de carti cu acel gen)
    public Map<String, Set<Book>> getAllBooksByGenre() {
        Map<String, Set<Book>> booksByGenre = new HashMap<>();
        for (Book book : bookSet) {
            if (!booksByGenre.containsKey(book.getGenre())) {
                Set<Book> set = new HashSet<>();
                set.add(book);
                booksByGenre.put(book.getGenre(), set);
            } else {
                booksByGenre.get(book.getGenre()).add(book);
            }
        }
        return booksByGenre;
    }

    //Va construi o mapa, in care cheia este un gen, iar valoarea este set-ul de carti care au acel gen
    //Va primi ca parametru un gen
    //Va returna toate cartile care au acel gen
    public Set<Book> getBooksByGenre(String genre) {
        Map<String, Set<Book>> booksByGenre = getAllBooksByGenre();
        Set<Book> set = new HashSet<>();
        if (booksByGenre.containsKey(genre)) {
            set = booksByGenre.get(genre);
        }
        return set;
    }
}