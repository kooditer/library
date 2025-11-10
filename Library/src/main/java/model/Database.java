package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private List<Raamat> raamatud;
    private Connection con;

    public Database() {
        raamatud = new LinkedList<Raamat>();
    }

    public void connect() throws Exception {
        if (con!=null) return;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver found");
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }
        String url = "jdbc:mysql://localhost:3306/raamatud";

        con = DriverManager.getConnection(url, "root", "Veiko123");
        System.out.println("Connected: " + con);
    }

    public void save() throws SQLException {
        String checkSql = "select count(*) as count from books where id=?";
        PreparedStatement checkStmt = con.prepareStatement(checkSql);

        String insertSql = "insert into books (id, pealkiri, autor, aasta, zhanr, " +
                "laenutatud, laenutaja)" +
                " values (?, ?, ?, ?, ?, ?, ?)";

        String updateSql = "update books set pealkiri=?, autor=?, aasta=?, zhanr=?, " +
                "laenutatud=?, laenutaja=? where id=?";

        PreparedStatement insertStmt = con.prepareStatement(insertSql);
        PreparedStatement updateStmt = con.prepareStatement(updateSql);

        for (Raamat raamat:raamatud) {
            int id = raamat.getRaamatID();
            String pealkiri = raamat.getPealkiri();
            String autor = raamat.getAutor();
            String aasta = raamat.getAasta();
            Zhanr zhanr = raamat.getZhanrCombo();
            boolean isLaenatud = raamat.isLaenutatud();
            String laenutaja = raamat.getLaenutaja();


            checkStmt.setInt(1, id);
            ResultSet checkResult = checkStmt.executeQuery();
            checkResult.next();

            int count = checkResult.getInt(1);

            if (count==0) {
                System.out.println("Inserting raamat with id " + id);
                int col = 1;
                insertStmt.setInt(col++, id);
                insertStmt.setString(col++, pealkiri);
                insertStmt.setString(col++, autor);
                insertStmt.setString(col++, aasta);
                insertStmt.setString(col++, zhanr.name());
                insertStmt.setBoolean(col++, isLaenatud);
                insertStmt.setString(col++, laenutaja);

                insertStmt.executeUpdate();
            } else {
                System.out.println("Updating raamat with id " + id);
                int col = 1;
                updateStmt.setString(col++, pealkiri);
                updateStmt.setString(col++, autor);
                updateStmt.setString(col++, aasta);
                updateStmt.setString(col++, zhanr.name());
                updateStmt.setBoolean(col++, isLaenatud);
                updateStmt.setString(col++, laenutaja);
                updateStmt.setInt(col++, id);

                updateStmt.executeUpdate();

            }
//            System.out.println("ID => " + id + " Count: " + count);
        }
        updateStmt.close();
        insertStmt.close();
        checkStmt.close();

    }

    public void disconnect(){
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Ei saa ühendust sulgeda");
//                throw new RuntimeException(e);
            }
        }
    }

    public void addRaamat(Raamat raamat) {
        raamatud.add(raamat);
    }

    public List<Raamat> getRaamatud() {
        return raamatud;
    }

    public void eemaldaRaamat(int index) {
        raamatud.remove(index);
    }
}
