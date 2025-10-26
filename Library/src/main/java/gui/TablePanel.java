package gui;

import model.Raamat;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private RaamatTableModel tableModel;

    public TablePanel() {
        tableModel = new RaamatTableModel();
        table = new JTable(tableModel);


        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }


    public void setData(List<Raamat> db) {
        tableModel.setData(db);
    }
    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
