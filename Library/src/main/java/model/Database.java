package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        String url = "jdbc:mysql://localhost:3306/sakila";

        con = DriverManager.getConnection(url, "root", "Veiko123");
//        System.out.println("Connected: " + con);
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
