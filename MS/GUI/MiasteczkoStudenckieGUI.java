package MS.GUI;

import MS.glowny.*;
import MS.obsluga.WeWy;
import MS.wyjatki.WyjatekMS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;
import java.util.Set;

public class MiasteczkoStudenckieGUI {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField anazwaid;
    private JTextField anazwa;
    private JTextField aadres;
    private JTextField akontaktowy;
    private JTextField anumer;
    private JTextField aoplata;
    private JTextField astandard;
    private JTextField apon;
    private JTextField awt;
    private JTextField asr;
    private JTextField aczw;
    private JTextField apt;
    private JTextField asb;
    private JTextField and;
    private JButton adoms;
    private JTextField bnazwaid;
    private JTextField bnazwa;
    private JTextField badres;
    private JTextField bkontaktowy;
    private JTextField bnumer;
    private JTextField btyp;
    private JTextField bpon;
    private JTextField bwt;
    private JTextField bsr;
    private JTextField bczw;
    private JTextField bpt;
    private JTextField bsb;
    private JTextField bnd;
    private JButton bdoms;
    private JComboBox mstatusstudenta;
    private JComboBox mstatusdoktoranta;
    private JComboBox mstatuspracownika;
    private JTextField mimie;
    private JTextField mnazwisko;
    private JTextField mdataurodzenia;
    private JTextField madres;
    private JTextField mpesel;
    private JTextField mnrdowodu;
    private JTextField mnazwaid;
    private JTextField mnrpokoju;
    private JButton pdoms;
    private JButton mdoms;
    private JTextField petat;
    private JTextField pwynagrodzenie;
    private JComboBox ppremia;
    private JTextField pwartoscpremii;
    private JTextField pstanowisko;
    private JTextField pnazwaid;
    private JTextField pnumerdowodu;
    private JTextField ppesel;
    private JTextField padres;
    private JTextField pdataurodzenia;
    private JTextField pnazwisko;
    private JTextField pimie;
    private JTabbedPane tabbedPane2;
    private JTextField msnazwawrite;
    private JTextField mspanstwo;
    private JTextField msmiasto;
    private JTextField msczas;
    private JButton mswrite;
    private JTextField mssciezkaread;
    private JTextField mssciezkawrite;
    private JButton msread;
    private JTextField msnazwaread;
    private JTextField statLA;
    private JTextField statLMA;
    private JTextField statLPA;
    private JTextField statLBU;
    private JTextField statLPBU;
    private JComboBox statmAkaList;
    private JButton bstatmAkaList;
    private JTextField statLMAzL;
    private JComboBox statpAkaList;
    private JButton bstatpAkaList;
    private JTextField statLPAzL;
    private JComboBox statpUslList;
    private JButton pstatpUslList;
    private JTextField statLPBUzL;
    private JComboBox pstatusstudenta;
    private JComboBox pstatusdoktoranta;
    private JButton wyczyscp;
    private JButton wyczyscm;
    private JButton wyczyscb;
    private JButton wyczysca;
    private JTextField Apesel;
    private JButton wykwateruj;
    private JButton zwolnij;
    private JButton usun;
    private JTextField Aid;
    private JTextField Pid;
    private JTextField Ppesel;
    private JComboBox Brodzaj;
    private JTextField Bid;
    private JPanel start;
    private JPanel statystyki;
    private JPanel podgladbazy;
    private JPanel dodaka;
    private JPanel dodbud;
    private JPanel kwamiesz;
    private JPanel zatrprac;
    private JPanel zarz;
    private JComboBox akalist;
    private JButton wybierzAka;
    private JButton wybierzBud;
    private JButton mwybierzAka;
    private JButton mwybierzMiesz;
    private JComboBox budlist;
    private JComboBox makalist;
    private JComboBox mlist;
    private JButton pwybierzAka;
    private JButton pwybierzPrac;
    private JButton bwybierzBud;
    private JButton bwybierzPrac;
    private JComboBox pakalist;
    private JComboBox palist;
    private JComboBox bbudlist;
    private JComboBox bpraclist;

    private MiasteczkoStudenckie ms;
    private WeWy odczyt;
    private boolean dostep = false;

    private MiasteczkoStudenckieGUI() {

        tabbedPane1.addComponentListener(new ComponentAdapter() {
        });

        tabbedPane1.remove(statystyki);
        tabbedPane1.remove(podgladbazy);
        tabbedPane1.remove(dodaka);
        tabbedPane1.remove(dodbud);
        tabbedPane1.remove(kwamiesz);
        tabbedPane1.remove(zatrprac);
        tabbedPane1.remove(zarz);

        mswrite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int czas = msczas.getText().equals("") ? 1 : Integer.valueOf(msczas.getText());
                if (msnazwawrite.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Wybierz identyfikator dla swojego miasteczka");
                else {
                    ms = new MiasteczkoStudenckie(msnazwawrite.getText(), mspanstwo.getText(), msmiasto.getText(), mssciezkawrite.getText(), czas);
                    if (ms == null)
                        JOptionPane.showMessageDialog(null, "Coś poszło nie tak! Miasteczko nie zostało utworzone");
                    else {
                        JOptionPane.showMessageDialog(null, "Miasteczko zostało poprawnie stworzone");
                        if (!ms.iswatekPracuje()) {
                            ms.start();
                            ms.setwatekPracuje(true);
                            statystyki.setName("Statystyki");
                            podgladbazy.setName("Podgląd bazy");
                            dodaka.setName("Dodawanie akademików");
                            dodbud.setName("Dodawanie budynków");
                            kwamiesz.setName("Kwaterowanie mieszkańców");
                            zatrprac.setName("Zatrudnianie pracowników");
                            zarz.setName("Zarządzanie");
                            tabbedPane1.add(statystyki);
                            tabbedPane1.add(podgladbazy);
                            tabbedPane1.add(dodaka);
                            tabbedPane1.add(dodbud);
                            tabbedPane1.add(kwamiesz);
                            tabbedPane1.add(zatrprac);
                            tabbedPane1.add(zarz);
                        }
                        odswiezStatystyki();
                    }
                }
            }
        });
        msread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                odczyt = new WeWy(mssciezkaread.getText(), msnazwaread.getText());
                ms = odczyt.readmiasteczkostudenckie();
                if (ms == null)
                    JOptionPane.showMessageDialog(null, "Coś poszło nie tak! Miasteczko nie zostało odczytane - upewnij się że używasz prawidłowej ścieżki");
                else {
                    JOptionPane.showMessageDialog(null, "Miasteczko zostało poprawnie wczytane");
                    if (!ms.iswatekPracuje()) {
                        ms.start();
                        ms.setwatekPracuje(true);
                        statystyki.setName("Statystyki");
                        podgladbazy.setName("Podgląd bazy");
                        dodaka.setName("Dodawanie akademików");
                        dodbud.setName("Dodawanie budynków");
                        kwamiesz.setName("Kwaterowanie mieszkańców");
                        zatrprac.setName("Zatrudnianie pracowników");
                        zarz.setName("Zarządzanie");
                        tabbedPane1.add(statystyki);
                        tabbedPane1.add(podgladbazy);
                        tabbedPane1.add(dodaka);
                        tabbedPane1.add(dodbud);
                        tabbedPane1.add(kwamiesz);
                        tabbedPane1.add(zatrprac);
                        tabbedPane1.add(zarz);
                    }
                    odswiezStatystyki();
                }
            }
        });
        bstatmAkaList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statLMAzL.setText(String.valueOf(ms.getStat_mieszkancy().get(statmAkaList.getSelectedItem())));
            }
        });
        bstatpAkaList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statLPAzL.setText((String.valueOf(ms.getStat_pracownicyAkademikow().get(statpAkaList.getSelectedItem()))));
            }
        });
        pstatpUslList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statLPBUzL.setText(String.valueOf(ms.getStat_pracownicyUslugowych().get(statpUslList.getSelectedItem())));
            }
        });
        adoms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] godzinyotwarcia = {apon.getText(), awt.getText(), asr.getText(), aczw.getText(), apt.getText(), asb.getText(), and.getText()};
                double oplata = aoplata.getText().equals("") ? 0 : Double.valueOf(aoplata.getText());
                int numer = anumer.getText().equals("") ? 0 : Integer.valueOf(anumer.getText());
                try {
                    ms.dodajAkademik(new Akademik(anazwaid.getText(), anazwa.getText(), aadres.getText(), godzinyotwarcia, akontaktowy.getText(), numer, oplata, astandard.getText()));
                    czyscA();
                    odswiezStatystyki();
                    JOptionPane.showMessageDialog(null, "Akademik dodany");
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        bdoms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] godzinyotwarcia = {apon.getText(), awt.getText(), asr.getText(), aczw.getText(), apt.getText(), asb.getText(), and.getText()};
                int numer = bnumer.getText().equals("") ? 0 : Integer.valueOf(bnumer.getText());
                try {
                    ms.dodajBudynekUslugowy(new BudynekUslugowy(bnazwaid.getText(), bnazwa.getText(), badres.getText(), godzinyotwarcia, bkontaktowy.getText(), btyp.getText(), numer));
                    czyscB();
                    odswiezStatystyki();
                    JOptionPane.showMessageDialog(null, "Budynek usługowy dodany");
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        mdoms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ss = mstatusstudenta.getSelectedItem().equals("tak");
                boolean sd = mstatusdoktoranta.getSelectedItem().equals("tak");
                boolean sp = mstatuspracownika.getSelectedItem().equals("tak");
                try {
                    ms.kwaterujMieszkanca(new Mieszkaniec(mimie.getText(), mnazwisko.getText(), mdataurodzenia.getText(), madres.getText(), mpesel.getText(), mnrdowodu.getText(), ss, sd, sp, mnrpokoju.getText(), mnazwaid.getText()));
                    czyscM();
                    odswiezStatystyki();
                    JOptionPane.showMessageDialog(null, "Mieszkaniec zakwaterowany");
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        pdoms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ss = pstatusstudenta.getSelectedItem().equals("tak");
                boolean sd = pstatusdoktoranta.getSelectedItem().equals("tak");
                boolean premia = ppremia.getSelectedItem().equals("tak");
                double wynagrodzenie = pwynagrodzenie.getText().equals("") ? 0 : Double.valueOf(pwynagrodzenie.getText());
                double wartoscpremii = pwartoscpremii.getText().equals("") ? 0 : Double.valueOf(pwartoscpremii.getText());
                try {
                    ms.rekrutujPracownika(new Pracownik(pimie.getText(), pnazwisko.getText(), pdataurodzenia.getText(), padres.getText(), ppesel.getText(), pnumerdowodu.getText(), ss, sd, true, pstanowisko.getText(), wynagrodzenie, Float.valueOf(petat.getText()), premia, wartoscpremii, pnazwaid.getText()));
                    czyscP();
                    odswiezStatystyki();
                    JOptionPane.showMessageDialog(null, "Pracownik zatrudniony");
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        wyczyscp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                czyscP();
            }
        });
        wyczyscm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                czyscM();
            }
        });
        wyczyscb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                czyscB();
            }
        });
        wyczysca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                czyscA();
            }
        });
        wykwateruj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ms.wykwaterujMieszkanca(Apesel.getText(), Aid.getText());
                    czyscWykwaterowanieMieszkanca();
                    odswiezStatystyki();
                    JOptionPane.showMessageDialog(null, "Wykwaterowano mieszkańca");
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        zwolnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ms.zwolnijPracownika(Ppesel.getText(), Pid.getText());
                    czyscZwalnianiePracownika();
                    odswiezStatystyki();
                    JOptionPane.showMessageDialog(null, "Zwolniono pracownika");
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        usun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Brodzaj.getSelectedItem().equals("akademik")) {
                        ms.usunAkademik(Bid.getText());
                        czyscUsuwanieBudynku();
                        odswiezStatystyki();
                        JOptionPane.showMessageDialog(null, "Usunięto budynek");
                    } else {
                        ms.usunBudynekUslugowy(Bid.getText());
                        czyscUsuwanieBudynku();
                        odswiezStatystyki();
                    }
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        wybierzAka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    wyswietlMetryke(ms.getAkademik((String) akalist.getSelectedItem()).getMetryka());
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        wybierzBud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    wyswietlMetryke(ms.getBudynekUslugowy((String) budlist.getSelectedItem()).getMetryka());
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        mwybierzAka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ms.getAkademik((String) makalist.getSelectedItem()); //
                    mlist.removeAllItems();
                    for (String key : ms.getListaMieszkancow().get(makalist.getSelectedItem()))
                        mlist.addItem(key);
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        mwybierzMiesz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    wyswietlMetryke(ms.getMieszkaniec((String) mlist.getSelectedItem(), (String) makalist.getSelectedItem()).getMetryka());
                    mlist.removeAllItems();
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        pwybierzAka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ms.getAkademik((String) pakalist.getSelectedItem()); //
                    palist.removeAllItems();
                    for (String key : ms.getListaPracownikowAkademikow().get(pakalist.getSelectedItem()))
                        palist.addItem(key);
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        pwybierzPrac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    wyswietlMetryke(ms.getPracownik((String) palist.getSelectedItem(), (String) pakalist.getSelectedItem()).getMetryka());
                    palist.removeAllItems();
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        bwybierzBud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ms.getBudynekUslugowy((String) bbudlist.getSelectedItem()); //
                    bpraclist.removeAllItems();
                    for (String key : ms.getListaPracownikowUslugowych().get(bbudlist.getSelectedItem()))
                        bpraclist.addItem(key);
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
        bwybierzPrac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    wyswietlMetryke(ms.getPracownik((String) bpraclist.getSelectedItem(), (String) bbudlist.getSelectedItem()).getMetryka());
                    bpraclist.removeAllItems();
                } catch (WyjatekMS wyjatek) {
                    JOptionPane.showMessageDialog(null, wyjatek.getMessage());
                }
            }
        });
    }


    private void odswiezStatystyki() {
        statLA.setText(String.valueOf(ms.ileAkademikow()));
        statLMA.setText(String.valueOf(ms.ileMieszkancow()));
        statLPA.setText(String.valueOf(ms.ilePracownikowAkademikow()));

        Set<String> a = ms.getStat_mieszkancy().keySet();
        Set<String> b = ms.getStat_pracownicyAkademikow().keySet();
        Set<String> c = ms.getStat_pracownicyUslugowych().keySet();

        statmAkaList.removeAllItems();
        statpAkaList.removeAllItems();
        statpUslList.removeAllItems();

        ms.stworzListeMieszkancow();
        ms.stworzListePracownikowAkademikow();
        ms.stworzListePracownikowUslugowych();

        akalist.removeAllItems();
        makalist.removeAllItems();
        pakalist.removeAllItems();
        budlist.removeAllItems();
        bbudlist.removeAllItems();

        for (String key : a) {
            statmAkaList.addItem(key);
            akalist.addItem(key);
            makalist.addItem(key);
            pakalist.addItem(key);
        }
        for (String key : b)
            statpAkaList.addItem(key);
        for (String key : c) {
            statpUslList.addItem(key);
            budlist.addItem(key);
            bbudlist.addItem(key);
        }

        statLBU.setText(String.valueOf(ms.ileBudynkowUslugowych()));
        statLPBU.setText(String.valueOf(ms.ilePracownikowBudynkowUslugowych()));


    }

    public void wyswietlMetryke(ArrayList<String> metryka) {
        StringBuilder sformatowanyTekst = new StringBuilder();
        sformatowanyTekst.append("<html>");
        for (String linia : metryka) {
            sformatowanyTekst.append(linia);
            sformatowanyTekst.append("<br>");
        }
        sformatowanyTekst.append("</html");
        JOptionPane.showMessageDialog(null, sformatowanyTekst.toString());
    }

    private void czyscM() {
        mimie.setText("");
        mnazwisko.setText("");
        mdataurodzenia.setText("");
        madres.setText("");
        mpesel.setText("");
        mnrdowodu.setText("");
        mnazwaid.setText("");
        mnrpokoju.setText("");
    }

    private void czyscP() {
        pimie.setText("");
        pnazwisko.setText("");
        padres.setText("");
        pdataurodzenia.setText("");
        ppesel.setText("");
        pnumerdowodu.setText("");
        pstanowisko.setText("");
        pwynagrodzenie.setText("");
        petat.setText("");
        pwartoscpremii.setText("");
        pnazwaid.setText("");
    }

    private void czyscB() {
        bnazwaid.setText("");
        bnazwa.setText("");
        badres.setText("");
        bkontaktowy.setText("");
        bnumer.setText("");
        btyp.setText("");
        bpon.setText("");
        bwt.setText("");
        bsr.setText("");
        bczw.setText("");
        bpt.setText("");
        bsb.setText("");
        bnd.setText("");
    }

    private void czyscA() {
        anazwaid.setText("");
        anazwa.setText("");
        aadres.setText("");
        akontaktowy.setText("");
        anumer.setText("");
        aoplata.setText("");
        astandard.setText("");
        apon.setText("");
        awt.setText("");
        asr.setText("");
        aczw.setText("");
        apt.setText("");
        asb.setText("");
        and.setText("");
    }

    private void czyscWykwaterowanieMieszkanca() {
        Aid.setText("");
        Apesel.setText("");
    }

    private void czyscZwalnianiePracownika() {
        Pid.setText("");
        Ppesel.setText("");
    }

    private void czyscUsuwanieBudynku() {
        Bid.setText("");
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Miasteczko Studenckie - baza danych");
        frame.setContentPane(new MiasteczkoStudenckieGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
