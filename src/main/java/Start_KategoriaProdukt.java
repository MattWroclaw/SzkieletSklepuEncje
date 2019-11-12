import entity.Kategoria;
import entity.Produkt;
import entity.TypProduktu;
import org.hibernate.Session;


public class Start_KategoriaProdukt {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFacotory().openSession();
        session.beginTransaction();

        Kategoria dzieciece = new Kategoria();
        dzieciece.setNazwa("Zabawki dla dzieci");

        Produkt p1 = new Produkt();
        p1.setOpis("klocki dla dzieci w wieku 0+");
//       p1.setKategoria(dzieciece);
        p1.setTytul("Lego");
        p1.setTypProduktu(TypProduktu.DZIECKO);

        Produkt p2 =new Produkt();
        p2.setTytul("Matchbox");
        p2.setOpis("Resorak - cysterna paliwowa");
//        p2.setKategoria(dzieciece);
        p2.setTypProduktu(TypProduktu.DZIECKO);

//        inny typ produktu

        Kategoria ksiazki = new Kategoria();
        ksiazki.setNazwa("ksiazkiKucharskie");

        Produkt p3 = new Produkt();
        p3.setTypProduktu(TypProduktu.KSIAZKI);
//        p3.setKategoria(ksiazki);
        p3.setOpis("Kuchnia polska w wielu wykonaniach");
        p3.setTytul("Pyszne bo polskie");

        session.persist(p1);
        session.persist(dzieciece);
        session.persist(p2);

        session.persist(p3);
        session.flush();
        session.close();
    }
}
