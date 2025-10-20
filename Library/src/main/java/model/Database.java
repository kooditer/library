package model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private ArrayList<Book> books;

    public Database() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }


}
