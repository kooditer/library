package Default;

import model.Database;
import model.Raamat;
import model.Zhanr;

import java.sql.SQLException;

import static model.Zhanr.*;

public class TestDatabase {
    public static void main(String[] args) {
        System.out.println("Running database test");

        Database db = new Database();
        try {
            db.connect();
        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

        db.addRaamat(new Raamat("Karu aabits", "Heljo Mänd", "2009", õpik, true, "Elle Mäesalu"));
        db.addRaamat(new Raamat("Mõmmi aabits", "Heljo Mänd", "2009", õpik, true, "Elle Mäesalu"));
        db.addRaamat(new Raamat("Kolm lugu", "Olimar Kallas", "2111", krimka, false, "Enn Mäesalu"));
        db.addRaamat(new Raamat("Mingi raamat", "Mats Traat", "1999", elulugu, true, "Maile Mäesalu"));
        db.addRaamat(new Raamat("Parim raamat", "Veiko Mäesalu", "2007", õpik, true, "Veiko Mäesalu"));


        try {
            db.save();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            db.load();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        db.disconnect();
    }
}
