package gui;

import model.Raamat;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RaamatTableModel extends AbstractTableModel {
    private List<Raamat> db;
    private String[] colNames = {"ID", "Pealkiri", "Autor", "Aasta",
            "Zhanr", "Laenutatud", "Laenutaja"};

    public RaamatTableModel() {}

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public void setData(List<Raamat> db) {
        this.db = db;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Raamat raamat = db.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return raamat.getRaamatID();
            case 1:
                return raamat.getPealkiri();
            case 2:
                return raamat.getAutor();
            case 3:
                return raamat.getAasta();
            case 4:
                return raamat.getZhanrCombo();
            case 5:
                return raamat.isLaenutatud();
            case 6:
                return raamat.getLaenutaja();
        }
        return null;
    }

}
