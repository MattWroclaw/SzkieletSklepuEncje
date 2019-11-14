import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Start_TestZamowienia {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFacotory()
                .openSession();
        session.beginTransaction();

//        Tworzymy uzytkownika z adresem
        Uzytkownik uzytkownik = new Uzytkownik("mail", "password", "user", "wolow");
        Adres adres = new Adres("Polska", "Wolow", "Czysta", "74-147", uzytkownik);

//        Toworzymy kategorie
        Kategoria kategoriaRoot = new Kategoria();
        Kategoria kategoriaMoto = new Kategoria();
        Kategoria kategoriaBMW = new Kategoria();

        kategoriaRoot.setOpis("root");
        List<Kategoria>childrenRoot = kategoriaRoot.getChildren();
        childrenRoot.add(kategoriaMoto);

        kategoriaMoto.setOpis("motoryzacja");
        kategoriaMoto.setParent(kategoriaRoot);
        List<Kategoria> childrenMoto = kategoriaMoto.getChildren();
        childrenMoto.add(kategoriaBMW);

        kategoriaBMW.setParent(kategoriaMoto);
        kategoriaBMW.setOpis("BMW");

//        tworzymy produkt
        Produkt produktBMW = new Produkt("BMW x1", "Zgrabny samochod...", "url:",
                kategoriaBMW, 22000d, TypProduktu.MOTO );

//        tworzymy linie zamowienia
        LiniaZamowienia liniaZamowienia = new LiniaZamowienia(produktBMW, 4, 22000d);

//        tworzymy koszyk
        Koszyk koszykBmw = new Koszyk(uzytkownik, Arrays.asList(liniaZamowienia));

//        tworzymy zamowienie
        Zamowienie zamowienieBmw = new Zamowienie(uzytkownik, 88000d,
                adres, LocalDate.now(), koszykBmw, StatusZamowienia.PRZYGOTOWANE_DO_WYSYLKI);

        session.persist(adres);
        session.persist(kategoriaRoot);
        session.persist(kategoriaMoto);
        session.persist(kategoriaBMW);
        session.persist(uzytkownik);

        session.persist(produktBMW);
        session.persist(liniaZamowienia);
        session.persist(koszykBmw);
        session.persist(zamowienieBmw);

        session.flush();
        session.close();
    }
}
