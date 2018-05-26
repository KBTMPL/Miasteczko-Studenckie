package MS.glowny;

// foreign packages

import java.io.Serializable;
import java.util.ArrayList;

// my pacakges


public class BudynekUslugowy extends Budynek implements Serializable {

    // konstruktor

    public BudynekUslugowy(String nazwaid, String nazwaWlasna, String adresBudynku, String godzinyOtwarcia[], String nrKontaktowy, String typBudynku, int numerBudynku) {
        super(nazwaid, nazwaWlasna, adresBudynku, godzinyOtwarcia, nrKontaktowy);
        this.typBudynku = typBudynku;
        this.numerBudynku = numerBudynku;
    }

    // metody

    // atrybuty

    private String typBudynku;
    private int numerBudynku;

    // gettery

    public String getTypBudynku() {
        return typBudynku;
    }

    public int getNumerBudynku() {
        return numerBudynku;
    }

    public ArrayList<String> getMetryka() {
        int i = 0;
        ArrayList<String> metryka = new ArrayList<>();
        metryka.add("Identyfikator budynku usługowego: " + getNazwaid());
        metryka.add("Nazwa budynku usługowego: " + getNazwaWlasna());
        metryka.add("Adres budynku usługowego: " + getAdresBudynku());
        metryka.add("Telefon kontaktowy: " + getNrKontaktowy());
        metryka.add("Numer budynku usługowego: " + getNumerBudynku());
        metryka.add("Typ budynku usługowego: " + getTypBudynku());
        metryka.add("Godziny otwarcia:");
        for (String dzien : getGodzinyOtwarcia()) {
            metryka.add(getDniTygodnia(i) + ": " + dzien);
            i++;
        }
        return metryka;
    }
}
