package testDatabase;

import model.Database;
import model.Raamat;
import model.Zhanr;

import java.sql.SQLException;

public class TestDatabase {
    public static void main(String[] args) {
        System.out.println("Ühendame database-ga...");

        Database db = new Database();
        try {
            db.connect();
            System.out.println("ühendus database-ga loodud");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        db.addRaamat(new Raamat("Mõmmi aabits", "Heljo Mänd", "2009", Zhanr.õpik, true, "Elle Mäesalu"));
        db.addRaamat(new Raamat("Mõmmi aabits", "Heljo Mänd", "2009", Zhanr.õpik, true, "Elle Mäesalu"));
        db.addRaamat(new Raamat("Kolm lugu", "Olimar Kallas", "2111", Zhanr.krimka, false, "Enn Mäesalu"));
        db.addRaamat(new Raamat("Mingi raamat", "Mats Traat", "1999", Zhanr.elulugu, true, "Maile Mäesalu"));
        db.addRaamat(new Raamat("Parim raamat", "Veiko Mäesalu", "2007", Zhanr.õpik, true, "Veiko Mäesalu"));

        try {
            db.save();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        db.close();

    }
}
