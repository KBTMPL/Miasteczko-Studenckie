package MS.glowny;

// foreign packages

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

// my packages

import MS.wyjatki.WyjatekAB;

public class Akademik extends Budynek implements Serializable {

    // konstruktor

    public Akademik(String nazwaid, String nazwaWlasna, String adresBudynku, String[] godzinyOtwarcia, String nrKontaktowy, int numerAkademika, double oplataMiesieczna, String standardWyposazenia) {
        super(nazwaid, nazwaWlasna, adresBudynku, godzinyOtwarcia, nrKontaktowy);
        this.numerAkademika = numerAkademika;
        this.oplataMiesieczna = oplataMiesieczna;
        this.standardWyposazenia = standardWyposazenia;
        this.mieszkancy = new HashMap<>();
    }

    // metody

    public void kwaterujMieszkanca(Mieszkaniec mieszkaniec) throws WyjatekAB {
        if (mieszkancy.containsKey(mieszkaniec.getPesel()))
            throw new WyjatekAB();
        else if (mieszkaniec.getPesel().equals(""))
            throw new WyjatekAB(true);
        else
            mieszkancy.put(mieszkaniec.getPesel(), mieszkaniec);
    }

    public void wykwaterujMieszkanca(String pesel) throws WyjatekAB {
        if (mieszkancy.containsKey(pesel))
            mieszkancy.remove(pesel);
        else
            throw new WyjatekAB();

    }

    public Mieszkaniec getMieszkaniec(String pesel) throws WyjatekAB {
        if (mieszkancy.containsKey(pesel))
            return mieszkancy.get(pesel);
        else
            throw new WyjatekAB();
    }

    public void zmienOplateMiesieczna(double oplataMiesieczna) {
        this.oplataMiesieczna = oplataMiesieczna;
    }

    public int ileMieszkancow() {
        return mieszkancy.size();
    }

    // atrybuty

    private int numerAkademika;
    private double oplataMiesieczna;
    private String standardWyposazenia; // jak reprezentować standard wyposażenia

    private HashMap<String, Mieszkaniec> mieszkancy; // pesel jako klucz

    // gettery

    public int getNumerAkademika() {
        return numerAkademika;
    }

    public double getOplataMiesieczna() {
        return oplataMiesieczna;
    }

    public String getStandardWyposazenia() {
        return standardWyposazenia;
    }

    public HashMap<String, Mieszkaniec> getMieszkancy() {
        return mieszkancy;
    }

    public ArrayList<String> getMetryka() {
        int i = 0;
        ArrayList<String> metryka = new ArrayList<>();
        metryka.add("Identyfikator akademika: " + getNazwaid());
        metryka.add("Nazwa akademika: " + getNazwaWlasna());
        metryka.add("Adres akademika: " + getAdresBudynku());
        metryka.add("Telefon kontaktowy: " + getNrKontaktowy());
        metryka.add("Numer akademika: " + getNumerAkademika());
        metryka.add("Opłata miesięczna: " + getOplataMiesieczna());
        metryka.add("Standard wyposażenia: " + getStandardWyposazenia());
        metryka.add("Godziny otwarcia:");
        for (String dzien : getGodzinyOtwarcia()) {
            metryka.add(getDniTygodnia(i) + ": " + dzien);
            i++;
        }
        return metryka;
    }
}
