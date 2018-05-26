package MS.glowny;

// foreign packages

import java.io.Serializable;
import java.util.ArrayList;

// my packages

public class Mieszkaniec extends Osoba implements Serializable {

    // konstruktor

    public Mieszkaniec(String imie, String nazwisko, String dataUrodzenia, String adresZamieszkania, String pesel, String nrDowodu, boolean statusStudenta, boolean statusDoktoranta, boolean statusPracownika, String nrPokoju, String nazwaidAkademika) {
        super(imie, nazwisko, dataUrodzenia, adresZamieszkania, pesel, nrDowodu, statusStudenta, statusDoktoranta, statusPracownika);
        this.nrPokoju = nrPokoju;
        this.nazwaidAkademika = nazwaidAkademika;
    }

    // metody

    // atrybuty

    private String nrPokoju;
    private String nazwaidAkademika;

    // gettery

    public String getNrPokoju() {
        return nrPokoju;
    }

    public String getNazwaidAkademika() {
        return nazwaidAkademika;
    }

    public ArrayList<String> getMetryka() {
        ArrayList<String> metryka = new ArrayList<>();
        metryka.add("Imię: " + getImie());
        metryka.add("Nazwisko: " + getNazwisko());
        metryka.add("Data urodzenia: " + getDataUrodzenia());
        metryka.add("Adres zamieszkania: " + getAdresZamieszkania());
        metryka.add("Pesel: " + getPesel());
        metryka.add("Numer dowodu: " + getNrDowodu());
        metryka.add("Identyfikator akademika: " + getNazwaidAkademika());
        metryka.add("Numer pokoju: " + getNrPokoju());
        metryka.add("Status studenta: " + (isStatusStudenta() ? "tak" : "nie"));
        metryka.add("Status doktoranta: " + (isStatusDoktoranta() ? "tak" : "nie"));
        metryka.add("Status pracownika: " + (isStatusPracownika() ? "tak" : "nie"));
        return metryka;
    }
}
