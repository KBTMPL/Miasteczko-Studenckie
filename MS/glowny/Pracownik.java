package MS.glowny;

// foreign packages

import java.io.Serializable;
import java.util.ArrayList;

// my packages

public class Pracownik extends Osoba implements Serializable {

    // konstruktor

    public Pracownik(String imie, String nazwisko, String dataUrodzenia, String adresZamieszkania, String pesel, String nrDowodu, boolean statusStudenta, boolean statusDoktoranta, boolean statusPracownika, String stanowisko, double wynagrodzenieMiesieczne, float etat, boolean premia, double wartoscPremii, String nazwaidPracy) {
        super(imie, nazwisko, dataUrodzenia, adresZamieszkania, pesel, nrDowodu, statusStudenta, statusDoktoranta, statusPracownika);
        this.stanowisko = stanowisko;
        this.wynagrodzenieMiesieczne = wynagrodzenieMiesieczne;
        this.etat = etat;
        this.premia = premia;
        this.wartoscPremii = wartoscPremii;
        this.nazwaidPracy = nazwaidPracy;
    }

    // atrybuty

    private String stanowisko;
    private double wynagrodzenieMiesieczne;
    private float etat;
    private boolean premia;
    private double wartoscPremii;
    private String nazwaidPracy;

    private double wyplata = wynagrodzenieMiesieczne + (premia ? wartoscPremii : 0);

    // gettery

    public String getStanowisko() {
        return stanowisko;
    }

    public double getWynagrodzenieMiesieczne() {
        return wynagrodzenieMiesieczne;
    }

    public float getEtat() {
        return etat;
    }

    public boolean isPremia() {
        return premia;
    }

    public double getWartoscPremii() {
        return wartoscPremii;
    }

    public String getNazwaidPracy() {
        return nazwaidPracy;
    }

    public double getWyplata() {
        return wyplata;
    }

    public ArrayList<String> getMetryka() {
        ArrayList<String> metryka = new ArrayList<>();
        metryka.add("Imię: " + getImie());
        metryka.add("Nazwisko: " + getNazwisko());
        metryka.add("Data urodzenia: " + getDataUrodzenia());
        metryka.add("Adres zamieszkania: " + getAdresZamieszkania());
        metryka.add("Pesel: " + getPesel());
        metryka.add("Numer dowodu: " + getNrDowodu());
        metryka.add("Identyfikator pracy: " + getNazwaidPracy());
        metryka.add("Stanowisko: " + getStanowisko());
        metryka.add("Etat: " + getEtat());
        metryka.add("Wynagrodzenie miesięczne: " + getWynagrodzenieMiesieczne());
        metryka.add("Premia: " + (isPremia() ? "tak" : "nie"));
        metryka.add("Wartość premii: " + getWartoscPremii());
        metryka.add("Status studenta: " + (isStatusStudenta() ? "tak" : "nie"));
        metryka.add("Status doktoranta: " + (isStatusDoktoranta() ? "tak" : "nie"));
        metryka.add("Status pracownika: " + (isStatusPracownika() ? "tak" : "nie"));
        return metryka;
    }
}
