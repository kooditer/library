package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private List<Book> books;

    public Database() {
        books = new LinkedList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void removeBook(int index) {
        books.remove(index);
    }


}
