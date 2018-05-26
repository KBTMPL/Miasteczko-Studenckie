package MS.glowny;

// foreign packages

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// my packages

import MS.obsluga.WeWy;
import MS.wyjatki.WyjatekAB;
import MS.wyjatki.WyjatekMS;

public class MiasteczkoStudenckie extends Thread implements Serializable {

    // konstruktor

    public MiasteczkoStudenckie(String nazwa, String panstwo, String miasto, String sciezka, int czas) {
        this.nazwa = nazwa;
        this.panstwo = panstwo;
        this.miasto = miasto;
        this.sciezka = sciezka;
        this.czas = czas * 1000 * 60; // podajemy w minutach
        this.zapis = new WeWy(sciezka, nazwa);
        this.watekPracuje = false;
        this.akademiki = new HashMap<>();
        this.budynkiUslugowe = new HashMap<>();
        this.stat_mieszkancy = new HashMap<>();
        this.stat_pracownicyAkademikow = new HashMap<>();
        this.stat_pracownicyUslugowych = new HashMap<>();
        this.listaPracownikowUslugowych = new HashMap<>();
        this.listaPracownikowAkademikow = new HashMap<>();
        this.listaMieszkancow = new HashMap<>();
    }

    // metody

        // dodawanie elementów

    public void dodajAkademik(Akademik akademik) throws WyjatekMS {
        if (akademiki.containsKey(akademik.getNazwaid()))
            throw new WyjatekMS("Taki akademik już istnieje");
        else if (akademik.getNazwaid().equals(""))
            throw new WyjatekMS("Identyfikator nie może być pusty");
        else
            akademiki.put(akademik.getNazwaid(), akademik);

    }

    public void dodajBudynekUslugowy(BudynekUslugowy budynekuslugowy) throws WyjatekMS {
        if (budynkiUslugowe.containsKey(budynekuslugowy.getNazwaid()))
            throw new WyjatekMS("Taki budynek usługowy już istnieje");
        else if (budynekuslugowy.getNazwaid().equals(""))
            throw new WyjatekMS("Identyfikator nie może być pusty");
        else
            budynkiUslugowe.put(budynekuslugowy.getNazwaid(), budynekuslugowy);
    }

    public void usunBudynekUslugowy(String nazwaid) throws WyjatekMS {

        if (budynkiUslugowe.containsKey(nazwaid))
            budynkiUslugowe.remove(nazwaid);
        else
            throw new WyjatekMS("Nie możesz usunąć nieistniejącego budynku usługowego");
    }

    public void usunAkademik(String nazwaid) throws WyjatekMS {

        if (akademiki.containsKey(nazwaid))
            akademiki.remove(nazwaid);
        else
            throw new WyjatekMS("Nie możesz usunąć nieistniejącego akademika");
    }

    public void kwaterujMieszkanca(Mieszkaniec mieszkaniec) throws WyjatekMS {
        if (akademiki.containsKey(mieszkaniec.getNazwaidAkademika()))
            try {
                akademiki.get(mieszkaniec.getNazwaidAkademika()).kwaterujMieszkanca(mieszkaniec);
            } catch (WyjatekAB wyjatekAB) {
                if (wyjatekAB.isPusty())
                    throw new WyjatekMS("Identyfikator (pesel) nie może być pusty");
                else
                    throw new WyjatekMS("Nie możesz dwukrotnie kwaterować tego samego mieszkańca");
            }
        else
            throw new WyjatekMS("Nie możesz kwaterować mieszkańca do nieistniejącego akademika");
    }

    public void wykwaterujMieszkanca(String pesel, String nazwaidAkademika) throws WyjatekMS {
        if (akademiki.containsKey(nazwaidAkademika))
            try {
                akademiki.get(nazwaidAkademika).wykwaterujMieszkanca(pesel);
            } catch (WyjatekAB wyjatekAB) {
                throw new WyjatekMS("Nie możesz wykwaterować niezakwaterowanego mieszkańca");
            }
        else
            throw new WyjatekMS("Nie możesz wykwaterować mieszkańca z nieistniejącego akademika");
    }

    public void rekrutujPracownika(Pracownik pracownik) throws WyjatekMS {
        try {
            if (akademiki.containsKey(pracownik.getNazwaidPracy()))
                akademiki.get(pracownik.getNazwaidPracy()).rekrutujPracownika(pracownik);
            else if (budynkiUslugowe.containsKey(pracownik.getNazwaidPracy()))
                budynkiUslugowe.get(pracownik.getNazwaidPracy()).rekrutujPracownika(pracownik);
            else
                throw new WyjatekMS("Nie możesz zatrudniać pracownika do nieistniejącego budynku");
        } catch (WyjatekAB wyjatekB) {
            if (wyjatekB.isPusty())
                throw new WyjatekMS("Identyfikator (pesel) nie może być pusty");
            else
                throw new WyjatekMS("Nie możesz zatrudnić po raz kolejny tego samego pracownika");
        }
    }

    public void zwolnijPracownika(String pesel, String nazwaidPracy) throws WyjatekMS {
        try {
            if (akademiki.containsKey(nazwaidPracy))
                akademiki.get(nazwaidPracy).zwolnijPracownika(pesel);
            else if (budynkiUslugowe.containsKey(nazwaidPracy))
                budynkiUslugowe.get(nazwaidPracy).zwolnijPracownika(pesel);
            else
                throw new WyjatekMS("Nie możesz zwalniać pracownika z nieistniejącego budynku");
        } catch (WyjatekAB wyjatekB) {
            throw new WyjatekMS("Nie możesz zwolnić niezatrudnionego pracownika");
        }
    }

    // gettery "w głąb"

    public Pracownik getPracownik(String pesel, String nazwaidPracy) throws WyjatekMS {
        try {
            if (akademiki.containsKey(nazwaidPracy))
                return akademiki.get(nazwaidPracy).getPracownik(pesel);
            else if (budynkiUslugowe.containsKey(nazwaidPracy))
                return budynkiUslugowe.get(nazwaidPracy).getPracownik(pesel);
            else
                throw new WyjatekMS("Nie istnieje takie miejsce pracy");
        } catch (WyjatekAB wyjatekB) {
            throw new WyjatekMS("Taki pracownik nie istnieje");
        }
    }

    public Mieszkaniec getMieszkaniec(String pesel, String nazwaidAkademika) throws WyjatekMS {
        try {
            if (akademiki.containsKey(nazwaidAkademika))
                return akademiki.get(nazwaidAkademika).getMieszkaniec(pesel);
            else
                throw new WyjatekMS("Nie istnieje taki akademik");
        } catch (WyjatekAB wyjatekB) {
            throw new WyjatekMS("Taki mieszkaniec nie istnieje");
        }
    }

    public Akademik getAkademik(String nazwaidAkademika) throws WyjatekMS {
        if (akademiki.containsKey(nazwaidAkademika))
            return akademiki.get(nazwaidAkademika);
        else
            throw new WyjatekMS("Taki akademik nie istnieje");
    }

    public BudynekUslugowy getBudynekUslugowy(String nazwaidBudynku) throws WyjatekMS {
        if (budynkiUslugowe.containsKey(nazwaidBudynku))
            return budynkiUslugowe.get(nazwaidBudynku);
        else
            throw new WyjatekMS("Taki budynek usługowy nie istnieje");
    }

    // statystyka

    public int ileAkademikow() {
        return akademiki.size();
    }

    public int ileMieszkancow() {

        int i = 0;
        int bufor = 0;
        stat_mieszkancy.clear();

        Iterator it = akademiki.values().iterator();

        while (it.hasNext()) {
            Akademik para = (Akademik) it.next();
            bufor = para.ileMieszkancow();
            i = i + bufor;
            stat_mieszkancy.put(para.getNazwaid(), bufor);
        }

        return i;
    }

    public int ilePracownikowAkademikow() {

        int i = 0;
        int bufor = 0;
        stat_pracownicyAkademikow.clear();

        Iterator it = akademiki.values().iterator();

        while (it.hasNext()) {
            Akademik para = (Akademik) it.next();
            bufor = para.ilePracownikow();
            i = i + bufor;
            stat_pracownicyAkademikow.put(para.getNazwaid(), bufor);
        }

        return i;
    }

    public int ileBudynkowUslugowych() {
        return budynkiUslugowe.size();
    }

    public int ilePracownikowBudynkowUslugowych() {

        int i = 0;
        int bufor = 0;
        stat_pracownicyUslugowych.clear();

        Iterator it = budynkiUslugowe.values().iterator();

        while (it.hasNext()) {
            BudynekUslugowy para = (BudynekUslugowy) it.next();
            bufor = para.ilePracownikow();
            i = i + bufor;
            stat_pracownicyUslugowych.put(para.getNazwaid(), bufor);
        }

        return i;
    }

    public void stworzListeMieszkancow() {
        listaMieszkancow.clear();
        Iterator it = akademiki.values().iterator();

        while (it.hasNext()) {
            Akademik para = (Akademik) it.next();
            listaMieszkancow.put(para.getNazwaid(), new ArrayList<String>(para.getMieszkancy().keySet()));
        }
    }

    public void stworzListePracownikowAkademikow() {
        listaPracownikowAkademikow.clear();
        Iterator it = akademiki.values().iterator();

        while (it.hasNext()) {
            Akademik para = (Akademik) it.next();
            listaPracownikowAkademikow.put(para.getNazwaid(), new ArrayList<String>(para.getPracownicy().keySet()));
        }
    }

    public void stworzListePracownikowUslugowych() {
        listaPracownikowUslugowych.clear();
        Iterator it = budynkiUslugowe.values().iterator();

        while (it.hasNext()) {
            BudynekUslugowy para = (BudynekUslugowy) it.next();
            listaPracownikowUslugowych.put(para.getNazwaid(), new ArrayList<String>(para.getPracownicy().keySet()));
        }
    }

    public void setwatekPracuje(boolean watekPracuje) {
        this.watekPracuje = watekPracuje;
    }

    // atrybuty

    private String nazwa;
    private String panstwo;
    private String miasto;

    private HashMap<String, Akademik> akademiki; // jak identyfikować budynki
    private HashMap<String, BudynekUslugowy> budynkiUslugowe;

    private HashMap<String, Integer> stat_mieszkancy;
    private HashMap<String, Integer> stat_pracownicyAkademikow;
    private HashMap<String, Integer> stat_pracownicyUslugowych;

    private HashMap<String, ArrayList<String>> listaMieszkancow;
    private HashMap<String, ArrayList<String>> listaPracownikowAkademikow;
    private HashMap<String, ArrayList<String>> listaPracownikowUslugowych;

    // WeWy

    private String sciezka;
    private int czas;
    private WeWy zapis;

    // obsługa wątków

    public void run() {
        while (true) {
            try {
                sleep(czas);
                //System.out.println("test");
                zapis.writemiasteczkostudenckie(this);
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean watekPracuje;

    // gettery

    public String getNazwa() {
        return nazwa;
    }

    public String getPanstwo() {
        return panstwo;
    }

    public String getMiasto() {
        return miasto;
    }

    public HashMap<String, Akademik> getAkademiki() {
        return akademiki;
    }

    public HashMap<String, BudynekUslugowy> getBudynkiUslugowe() {
        return budynkiUslugowe;
    }

    public HashMap<String, Integer> getStat_mieszkancy() {
        return stat_mieszkancy;
    }

    public HashMap<String, Integer> getStat_pracownicyAkademikow() {
        return stat_pracownicyAkademikow;
    }

    public HashMap<String, Integer> getStat_pracownicyUslugowych() {
        return stat_pracownicyUslugowych;
    }

    public String getSciezka() {
        return sciezka;
    }

    public int getCzas() {
        return czas;
    }

    public WeWy getZapis() {
        return zapis;
    }

    public boolean iswatekPracuje() {
        return watekPracuje;
    }

    public HashMap<String, ArrayList<String>> getListaMieszkancow() {
        return listaMieszkancow;
    }

    public HashMap<String, ArrayList<String>> getListaPracownikowAkademikow() {
        return listaPracownikowAkademikow;
    }

    public HashMap<String, ArrayList<String>> getListaPracownikowUslugowych() {
        return listaPracownikowUslugowych;
    }


}
