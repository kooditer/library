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
    private TableListener listener;
    private JPopupMenu popupMenu;

    public TablePanel() {
        tableModel = new RaamatTableModel();
        table = new JTable(tableModel);
        popupMenu = new JPopupMenu();
        JMenuItem eemaldaRida = new JMenuItem("Eemalda raamat");
        popupMenu.add(eemaldaRida);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row, row);
                if (e.getButton()==MouseEvent.BUTTON3) {
                    popupMenu.show(table, e.getX(), e.getY());
                }
            }
        });

        eemaldaRida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rida = table.getSelectedRow();
                if (listener!=null) {
                    listener.removeRow(rida);
                    tableModel.fireTableRowsDeleted(rida, rida);
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

    public void setTableListener(TableListener listener) {
        this.listener = listener;
    }
}
