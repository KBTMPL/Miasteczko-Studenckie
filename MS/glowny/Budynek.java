package MS.glowny;

// foreign packages

import java.io.Serializable;
import java.util.HashMap;

// my packages

import MS.wyjatki.WyjatekAB;

public class Budynek implements Serializable {

    // konstruktor

    public Budynek(String nazwaid, String nazwaWlasna, String adresBudynku, String[] godzinyOtwarcia, String nrKontaktowy) {
        this.nazwaid = nazwaid;
        this.nazwaWlasna = nazwaWlasna;
        this.adresBudynku = adresBudynku;
        this.godzinyOtwarcia = godzinyOtwarcia;
        this.nrKontaktowy = nrKontaktowy;
        this.pracownicy = new HashMap<>();
    }

    // metody

    public void rekrutujPracownika(Pracownik pracownik) throws WyjatekAB {
        if (pracownicy.containsKey(pracownik.getPesel()))
            throw new WyjatekAB();
        else if (pracownik.getPesel().equals(""))
            throw new WyjatekAB(true);
        else
            pracownicy.put(pracownik.getPesel(), pracownik);
    }

    public void zwolnijPracownika(String pesel) throws WyjatekAB {
        if (pracownicy.containsKey(pesel))
            pracownicy.remove(pesel);
        else
            throw new WyjatekAB();
    }

    public Pracownik getPracownik(String pesel) throws WyjatekAB {
        if (pracownicy.containsKey(pesel))
            return pracownicy.get(pesel);
        else
            throw new WyjatekAB();
    }

    public void setGodzinyOtwarcia(String[] godzinyOtwarcia) {
        this.godzinyOtwarcia = godzinyOtwarcia;
    }

    public int ilePracownikow() {
        return pracownicy.size();
    }

    // atrybuty

    private String nazwaid;
    private String nazwaWlasna;
    private String adresBudynku;
    private String[] godzinyOtwarcia;
    private String nrKontaktowy;
    private String[] dniTygodnia = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"};

    private HashMap<String, Pracownik> pracownicy; // pesel jako klucz

    // gettery

    public String getNazwaid() {
        return nazwaid;
    }

    public String getNazwaWlasna() {
        return nazwaWlasna;
    }

    public String getAdresBudynku() {
        return adresBudynku;
    }

    public String[] getGodzinyOtwarcia() {
        return godzinyOtwarcia;
    }

    public String getNrKontaktowy() {
        return nrKontaktowy;
    }

    public HashMap<String, Pracownik> getPracownicy() {
        return pracownicy;
    }

    public String getDniTygodnia(int i) {
        return dniTygodnia[i];
    }
}
