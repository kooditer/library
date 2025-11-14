package model;

public class Raamat {
    private static int count = 1;
    private int raamatID;
    private String pealkiri;
    private String autor;
    private String aasta;
    private Zhanr zhanrCombo;
    private boolean laenutatud;
    private String laenutaja;

    public Raamat(String pealkiri, String autor, String aasta,
                  Zhanr zhanrCombo, boolean laenutatud, String laenutaja) {
        this.pealkiri = pealkiri;
        this.autor = autor;
        this.aasta = aasta;
        this.zhanrCombo = zhanrCombo;
        this.laenutatud = laenutatud;
        this.laenutaja = laenutaja;
        this.raamatID = count;
        count++;
    }

    public Raamat(int id, String pealkiri, String autor, String aasta,
                  Zhanr zhanrCombo, boolean laenutatud, String laenutaja) {
        this(pealkiri, autor, aasta, zhanrCombo, laenutatud, laenutaja);
        this.raamatID = id;
    }

    public int getRaamatID() {
        return raamatID;
    }

    public void setRaamatID(int raamatID) {
        this.raamatID = raamatID;
    }

    public String getPealkiri() {
        return pealkiri;
    }

    public void setPealkiri(String pealkiri) {
        this.pealkiri = pealkiri;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAasta() {
        return aasta;
    }

    public void setAasta(String aasta) {
        this.aasta = aasta;
    }

    public Zhanr getZhanrCombo() {
        return zhanrCombo;
    }

    public void setZhanrCombo(Zhanr zhanrCombo) {
        this.zhanrCombo = zhanrCombo;
    }

    public boolean isLaenutatud() {
        return laenutatud;
    }

    public void setLaenutatud(boolean laenutatud) {
        this.laenutatud = laenutatud;
    }

    public String getLaenutaja() {
        return laenutaja;
    }

    public void setLaenutaja(String laenutaja) {
        this.laenutaja = laenutaja;
    }

    @Override
    public String toString() {
        return raamatID + ": " +  pealkiri;
    }
}
