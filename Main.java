import MS.glowny.*;
import MS.obsluga.*;
import MS.wyjatki.WyjatekMS;

public class Main {

    public static void main(String[] args) {

        if (true) {
            String godzinyOtwarcia[] = {"7-15", "8-15", "7-16", "7-14", "7-12", "7-18", "7-20"}; // metoda zbierająca te godziny z pól
            MiasteczkoStudenckie ms = new MiasteczkoStudenckie("MSAGH", "Polska", "Kraków", "C:\\Users\\Krzysztof\\Desktop\\Laby\\JPO\\JAVA\\studenci\\gr2\\kbulanda\\Miasteczko Studenckie\\BINARY\\", 1);
            Akademik hajduczek = new Akademik("DS10", "Hajduczek", "budryka 7", godzinyOtwarcia, "664906661", 10, 350, "podstawowy");
            Akademik strasznydwor = new Akademik("DS13", "strasznydwor", "budryka 7", godzinyOtwarcia, "664906661", 10, 350, "podstawowy");


            Mieszkaniec kbulanda = new Mieszkaniec("Krzysztof", "Bulanda", "15/03/1996", "Gajowa 56G", "96031511219", "nacocitopotrzebne", true, false, false, "404A", "DS10");
            Mieszkaniec keklol = new Mieszkaniec("kek", "lol", "15/03/1990", "hehe 76", "96151511219", "nacocitopotrzebne", true, false, false, "404A", "DS10");
            Mieszkaniec keklol2 = new Mieszkaniec("kek", "lol", "15/03/1990", "hehe 76", "964151511219", "nacocitopotrzebne", true, false, false, "404A", "DS13");


            try {
                ms.dodajAkademik(hajduczek);
                ms.dodajAkademik(strasznydwor);
                ms.kwaterujMieszkanca(kbulanda);
                ms.kwaterujMieszkanca(keklol);
                ms.kwaterujMieszkanca(keklol2);
                //ms.wykwaterujMieszkanca("96031511219", "DS10");
            } catch (WyjatekMS kek) {

            }

            System.out.println(ms.ileMieszkancow());
            try {
                System.out.println(ms.getAkademik("DS10").ileMieszkancow());
                System.out.println(ms.getAkademik("DS13").ileMieszkancow());
            } catch (WyjatekMS e) {
            }

            ms.start();
            //WeWy zapis = new WeWy("C:\\Users\\Krzysztof\\Desktop\\Laby\\JPO\\JAVA\\studenci\\gr2\\kbulanda\\Miasteczko Studenckie\\BINARY\\", ms.getNazwa());
            //zapis.writemiasteczkostudenckie(ms);
        } else {
            WeWy odczyt = new WeWy("C:\\Users\\Krzysztof\\Desktop\\Laby\\JPO\\JAVA\\studenci\\gr2\\kbulanda\\Miasteczko Studenckie\\BINARY\\", "MSAGH");
            MiasteczkoStudenckie mskek = odczyt.readmiasteczkostudenckie();
            int kek = 10;
        }


    }
}