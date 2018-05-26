package MS.glowny;

// foreign packages

import java.io.Serializable;

// my packages

public class Osoba implements Serializable {

    // konstruktor

    public Osoba(String imie, String nazwisko, String dataUrodzenia, String adresZamieszkania, String pesel, String nrDowodu, boolean statusStudenta, boolean statusDoktoranta, boolean statusPracownika) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.adresZamieszkania = adresZamieszkania;
        this.pesel = pesel;
        this.nrDowodu = nrDowodu;
        this.statusStudenta = statusStudenta;
        this.statusDoktoranta = statusDoktoranta;
        this.statusPracownika = statusPracownika;
    }

    // atrybuty

    private String imie;
    private String nazwisko;
    private String dataUrodzenia;
    private String adresZamieszkania;
    private String pesel;
    private String nrDowodu;
    private boolean statusStudenta;
    private boolean statusDoktoranta;
    private boolean statusPracownika;

    // gettery

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getAdresZamieszkania() {
        return adresZamieszkania;
    }

    public String getPesel() {
        return pesel;
    }

    public String getNrDowodu() {
        return nrDowodu;
    }

    public boolean isStatusStudenta() {
        return statusStudenta;
    }

    public boolean isStatusDoktoranta() {
        return statusDoktoranta;
    }

    public boolean isStatusPracownika() {
        return statusPracownika;
    }
}
