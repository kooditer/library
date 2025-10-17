import java.util.EventObject;

public class FormEvent extends EventObject {
    private String pealkiri;
    private String autor;
    private String aasta;
    private String zhanr;
    private String hinnang;
    private boolean checkBox;
    private String laenutaja;

//    public FormEvent(Object source) {
//        super(source);
//    }

    public FormEvent(Object source, String pealkiri, String autor, String aasta, String zhanr, String hinnang, boolean checkBox, String laenutaja) {
        super(source);
        this.pealkiri = pealkiri;
        this.autor = autor;
        this.aasta = aasta;
        this.zhanr = zhanr;
        this.hinnang = hinnang;
        this.checkBox = checkBox;
        this.laenutaja = laenutaja;
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

    public String getZhanr() {
        return zhanr;
    }

    public void setZhanr(String zhanr) {
        this.zhanr = zhanr;
    }

    public String getHinnang() {
        return hinnang;
    }

    public void setHinnang(String hinnang) {
        this.hinnang = hinnang;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

    public String getLaenutaja() {
        return laenutaja;
    }

    public void setLaenutaja(String laenutaja) {
        this.laenutaja = laenutaja;
    }
}
