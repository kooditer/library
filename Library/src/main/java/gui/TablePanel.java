package gui;

import model.Raamat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private RaamatTableModel tableModel;
    private BookTableListener listener;
    private JPopupMenu popup;

    public TablePanel() {
        tableModel = new RaamatTableModel();
        table = new JTable(tableModel);

        popup = new JPopupMenu();
        JMenuItem removeRow = new JMenuItem("Kustuta raamat");
        popup.add(removeRow);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row, row);
                if (e.getButton()==MouseEvent.BUTTON3) {
                    popup.show(table, e.getX(), e.getY());
                }
            }
        });

        removeRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (listener!=null) {
                    listener.removeRow(row);
                    tableModel.fireTableRowsDeleted(row, row);
                }
            }
        });



        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }


    public void setData(List<Raamat> db) {
        tableModel.setData(db);
    }
    public void refresh() {
        tableModel.fireTableDataChanged();
    }
    public void SetTableListener(BookTableListener listener) {
        this.listener = listener;
    }
}
