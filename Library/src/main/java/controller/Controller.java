package controller;

import gui.FormEvent;
import model.Database;
import model.Raamat;
import model.Zhanr;

import java.util.List;

public class Controller {
    Database db = new Database();

    public List<Raamat> getRaamatud() {
        return db.getRaamatud();
    }

    public void addRaamat(FormEvent ev) {
        String pealkiri = ev.getPealkiri();
        String autor = ev.getAutor();
        String aasta = ev.getAasta();
        String zhanr = ev.getZhanr();
        String laenutaja = ev.getLaenutaja();
        boolean laenutatud = ev.isLaenutatud();

        Zhanr comboZhanr;
        if (zhanr.equals("Õpik")) {
            comboZhanr = Zhanr.õpik;
        } else if (zhanr.equals("Elulugu")) {
            comboZhanr = Zhanr.elulugu;
        }
        else {
            comboZhanr = Zhanr.krimka;
        }

        Raamat raamat = new Raamat(pealkiri, autor, aasta, comboZhanr, laenutatud, laenutaja);
        db.addRaamat(raamat);
    }

    public void removeRaamat(int index) {
        db.removeRaamat(index);
    }
}
