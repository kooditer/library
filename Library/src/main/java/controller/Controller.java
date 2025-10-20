package controller;

import gui.FormEvent;
import model.Book;
import model.Database;
import model.Genre;
import model.Rating;

public class Controller {
    Database db =new Database();

    public void addBook(FormEvent ev) {
        String pealkiri = ev.getPealkiri();
        String autor = ev.getAutor();
        String aasta = ev.getAasta();
        String zhanr = ev.getZhanr();
        String hinnang = ev.getHinnang();
        boolean laenutatud = ev.isCheckBox();
        String laenutaja = ev.getLaenutaja();

        Genre genre;
        if (zhanr.equals("Lasteraamat")) {
            genre = Genre.laste;
        } else if (zhanr.equals("Õpik")) {
            genre = Genre.õpik;
        } else if (zhanr.equals("Eneseabi")) {
            genre = Genre.eneseabi;
        } else if (zhanr.equals("Kriminull")) {
            genre = Genre.kriminull;
        } else if (zhanr.equals("Põnevik")) {
            genre = Genre.põnevik;
        } else if (zhanr.equals("Luuleraamat")) {
        genre = Genre.luule;
        } else {
            genre = Genre.muu;
        }

        Rating rating;
        if (hinnang.equals("Väga hea")) {
            rating = Rating.väga_hea;
        } else if (hinnang.equals("Hea")) {
            rating = Rating.hea;
        } else if (hinnang.equals("Keskmine")) {
            rating = Rating.keskmine;
        } else if (hinnang.equals("Halb")) {
            rating = Rating.halb;
        } else {
            rating = Rating.väga_halb;
        }

        Book book = new Book(pealkiri, autor, aasta, genre, rating, laenutatud, laenutaja);

        db.addBook(book);

        }//addBook end
}//Controller class end
