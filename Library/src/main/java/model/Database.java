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
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }
        String url = "jdbc:mysql://localhost:3306/raamatud";
        con = DriverManager.getConnection(url, "root", "Veiko123");
        System.out.println("Ühendus " + con + " on avatud");
    }

    public void save() throws SQLException {
        String checkSql = "select count(*) as count from books where id=?";
        PreparedStatement checkStatement = con.prepareStatement(checkSql);
        for (Raamat raamat:raamatud) {
            int id = raamat.getRaamatID();
            checkStatement.setInt(1,id);
            ResultSet checkResult = checkStatement.executeQuery();
            checkResult.next();

            int count = checkResult.getInt(1);
            System.out.println("ID = " + id + " => " + count);

        }
        checkStatement.close();
    }
    public void close() {
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addRaamat(Raamat raamat) {
        raamatud.add(raamat);
    }

    public List<Raamat> getRaamatud() {
        return raamatud;
    }

    public void removeRaamat(int index) {
        raamatud.remove(index);
    }
}
