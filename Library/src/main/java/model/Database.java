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

    public void connect() throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }
        String url = "jdbc:mysql://localhost:3306/raamatud";
        con = DriverManager.getConnection(url, "root", "Veiko123");
    }

    public void save() throws SQLException {
        String checkSql = "select count(*) as count from books where pealkiri=?";
        PreparedStatement checkStatement = con.prepareStatement(checkSql);

        String insertSql = "insert into books (id, pealkiri, autor, aasta, zhanr, laenutatud, laenutaja) values (?, ?, ?, ?, ?, ?, ?)";


        String updateSql = "update books set autor=?, aasta=?, zhanr=?, laenutatud=?, laenutaja=? where pealkiri=?";

        PreparedStatement insertStatement = con.prepareStatement(insertSql);
        PreparedStatement updateStatement = con.prepareStatement(updateSql);


        for (Raamat raamat:raamatud) {
            int id = raamat.getRaamatID();
            String pealkiri = raamat.getPealkiri();
            String autor = raamat.getAutor();
            String aasta = raamat.getAasta();
            Zhanr zhanr = raamat.getZhanrCombo();
            boolean isLaenutatud = raamat.isLaenutatud();
            String laenutaja = raamat.getLaenutaja();

            checkStatement.setString(1, pealkiri);
            ResultSet checkResult = checkStatement.executeQuery();
            checkResult.next();
            int count = checkResult.getInt(1);
            System.out.println("Raamatut " + "\"" + pealkiri + "\"" + " on " + count + "tükki");

            if (count==0) {
                System.out.println("Sisestan database-i raamatu  " + pealkiri);
                int col = 1;
                insertStatement.setInt(col++, id);
                insertStatement.setString(col++, pealkiri);
                insertStatement.setString(col++, autor);
                insertStatement.setString(col++, aasta);
                insertStatement.setString(col++, zhanr.name());
                insertStatement.setBoolean(col++, isLaenutatud);
                insertStatement.setString(col++, laenutaja);

                insertStatement.executeUpdate();
            } else {
                System.out.println("Uuendan raamatut " + "\"" + pealkiri + "\"");
                int col = 1;
                //updateStatement.setInt(col++, id);
                updateStatement.setString(col++, autor);
                updateStatement.setString(col++, aasta);
                updateStatement.setString(col++, zhanr.name());
                updateStatement.setBoolean(col++, isLaenutatud);
                updateStatement.setString(col++, laenutaja);
                updateStatement.setString(col++, pealkiri);

                updateStatement.executeUpdate();
            }

        }
        checkStatement.close();
        insertStatement.close();
        updateStatement.close();
    }


    public void load() throws SQLException {
        raamatud.clear();
        String sql = "select id, pealkiri, autor, aasta, zhanr, laenutatud, laenutaja from books order by pealkiri";
        Statement selectStatement = con.createStatement();
        ResultSet results = selectStatement.executeQuery(sql);
        while (results.next()) {
            int id = results.getInt("id");
            String pealkiri = results.getString("pealkiri");
            String autor = results.getString("autor");
            String aasta = results.getString("aasta");
            String zhanr = results.getString("zhanr");
            boolean laenutatud = results.getBoolean("laenutatud");
            String laenutaja = results.getString("laenutaja");

            Raamat raamat = new Raamat(id, pealkiri, autor, aasta, Zhanr.valueOf(zhanr), laenutatud, laenutaja);
            raamatud.add(raamat);
        }
        results.close();
        selectStatement.close();

    }



    public void disconnect(){
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
//                throw new RuntimeException(e);
                System.out.println("Cant close connection");
            }
        }

    }

    public void addRaamat(Raamat raamat) {
        raamatud.add(raamat);
    }

    public List<Raamat> getRaamatud() {
        return raamatud;
    }

    public void kustutaRaamat(int index) {
        raamatud.remove(index);
    }
}
