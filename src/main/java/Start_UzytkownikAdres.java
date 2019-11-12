import entity.Adres;
import entity.Uzytkownik;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Start_UzytkownikAdres {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFacotory().openSession();
        session.beginTransaction();

        Uzytkownik u1 = new Uzytkownik();

        u1.setHaslo("hasloU1");
        u1.setMiasto("Ciechakow");
        u1.setLoginMail("drugi uzytkownik1");
        u1.setRole("USER");
        session.persist(u1);

        Adres a1u1 = new Adres();
        a1u1.setPanstwo("Polska");
        a1u1.setMiasto("Wronki");
        a1u1.setKodPocztowy("81-456");
        a1u1.setUlica("Storczykowa");
        a1u1.setUzytkownik(u1);
        session.persist(a1u1);

        Adres a2u1 = new Adres();
        a2u1.setPanstwo("Czechy");
        a2u1.setMiasto("Ciechankow");
        a2u1.setKodPocztowy("*21-789");
        a2u1.setUlica("Rozana");
        a2u1.setUzytkownik(u1);
        session.persist(a2u1);

        session.flush();
        session.close();

    }
}
