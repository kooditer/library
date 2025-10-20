package gui;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private BookTableModel tableModel;

    public TablePanel() {
        tableModel = new BookTableModel();
        table = new JTable(tableModel);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Book> db) {
        tableModel.setData(db);
    }
    public void refresh() {
        tableModel.fireTableDataChanged();
    }

}
