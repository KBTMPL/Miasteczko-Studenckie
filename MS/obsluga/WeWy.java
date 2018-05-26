package MS.obsluga;

// foreign packages

import java.io.*;

// my packages

import MS.glowny.MiasteczkoStudenckie;
import MS.wyjatki.WyjatekAB;


public class WeWy implements Serializable { // obsluga ciaglego zapisu do pliku

    // konstruktor

    public WeWy(String path, String nazwa) {
        this.path = path;
        this.nazwa = nazwa;
    }

    // metody

    public String polacz(String a) {

        StringBuilder c = new StringBuilder();
        c.append(path);
        c.append(a);
        return c.toString();
    }

    public MiasteczkoStudenckie readmiasteczkostudenckie() /*throws WyjatekAB*/ {

        MiasteczkoStudenckie e = null;
        try {
            FileInputStream fileIn = new FileInputStream(polacz(nazwa));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (MiasteczkoStudenckie) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println(i.toString()); //
        } catch (ClassNotFoundException c) {
            System.out.println(c.toString());
        }
        return e;

    }

    public void writemiasteczkostudenckie(MiasteczkoStudenckie x) /*throws WyjatekAB*/ {

        try {
            FileOutputStream fileOut = new FileOutputStream(polacz(x.getNazwa()));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(x);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            System.out.println(i.toString()); //
        }

    }

    // atrybuty

    private String path;
    private String nazwa;

    // gettery


    public String getPath() {
        return path;
    }

    public String getNazwa() {
        return nazwa;
    }
}
