package gui;

import model.Book;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BookTableModel extends AbstractTableModel {
    private List<Book> db;
    private String[] colNames = {"ID", "Pealkiri", "Autor", "Väljaandmise aasta", "Zhanr", "Hinnang", "Välja laenutatud", "Laenutaja"};

    public BookTableModel() {

    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public void setData(List<Book> db) {
        this.db = db;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = db.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return book.getId();
            case 1:
                return book.getTitle();
            case 2:
                return book.getAuthor();
            case 3:
                return book.getPublished();
            case 4:
                return book.getGenre();
            case 5:
                return book.getRating();
            case 6:
                return book.isOut();
            case 7:
                return book.getClient();
        }
        return null;
    }
}
