import entity.Kategoria;
import entity.Produkt;
import entity.TypProduktu;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class Start_KategoriaTikalkProdukt {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFacotory().openSession();
        session.beginTransaction();

//        główne
        Kategoria root = new Kategoria();
        root.setOpis("root");

//  1 stopień
        Kategoria motoryzajca = new Kategoria();
        motoryzajca.setOpis("motoryzacja");

//        2.1 stopień
        Kategoria osobowe = new Kategoria();
        osobowe.setOpis("osobowe");

        //        2.2 stopień
        Kategoria ciezarowe = new Kategoria();
        ciezarowe.setOpis("ciezarowe");


        //  3.1 stopień -sobowe
        Kategoria mercedes = new Kategoria();
        mercedes.setOpis("mercedes");

        //  3.2 stopień -sobowe
        Kategoria bmw = new Kategoria();
        bmw.setOpis("bmw");
//      3.3 stopień - ciężarowe

        Kategoria man = new Kategoria();
        man.setOpis("Ciezarowy MAN");

//        ustawiamy zależności drzewa
        List<Kategoria> rootChildren = root.getChildren();
        rootChildren.add(motoryzajca);

        List<Kategoria> motoryzacjaChildren = motoryzajca.getChildren();
        motoryzacjaChildren.add(osobowe);
        motoryzacjaChildren.add(ciezarowe);
        motoryzajca.setParent(root);

        List<Kategoria> osoboweChildren = osobowe.getChildren();
        osoboweChildren.add(mercedes);
        osoboweChildren.add(bmw);
        osobowe.setParent(motoryzajca);

        mercedes.setParent(osobowe);
        bmw.setParent(osobowe);

        List<Kategoria> ciezaroweChildren = ciezarowe.getChildren();
        ciezaroweChildren.add(man);
        ciezarowe.setParent(motoryzajca);

        man.setParent(ciezarowe);

        // utrwalamy drzewo zależności
        session.persist(root);

        session.persist(motoryzajca);

        session.persist(osobowe);
        session.persist(ciezarowe);

        session.persist(mercedes);
        session.persist(bmw);

        session.persist(man);

//        tworzę klika produktów (merc-os, bmw-os, cieżarowy-MAN)
        Produkt cKlasa = new Produkt();
        Produkt sKlasa = new Produkt();
        Produkt glaKlasa = new Produkt();
        Produkt eKlasa = new Produkt();

        Produkt x1 = new Produkt();
        Produkt x3 = new Produkt();
        Produkt x5 = new Produkt();

        Produkt g90 = new Produkt();
        Produkt tgl = new Produkt();
        Produkt tgm = new Produkt();

        cKlasa.setKategoria(mercedes);
        cKlasa.setTypProduktu(TypProduktu.MOTO);
        cKlasa.setTytul("Mercedes C-klass");
        cKlasa.setOpis("Piękny, nowy, nie śmigany");

        eKlasa.setKategoria(mercedes);
        eKlasa.setTypProduktu(TypProduktu.MOTO);
        eKlasa.setTytul("Mercedes E-klass");
        eKlasa.setOpis("Nowoczesna limuzyna dla każdego boagacza");

        sKlasa.setKategoria(mercedes);
        sKlasa.setTypProduktu(TypProduktu.MOTO);
        sKlasa.setTytul("Mercedes S-klass");
        sKlasa.setOpis("Zadbany, nie śmigany, wcześniejszy kierowca często go mył");

        glaKlasa.setKategoria(mercedes);
        glaKlasa.setTypProduktu(TypProduktu.MOTO);
        glaKlasa.setTytul("Mercedes G-klass");
        glaKlasa.setOpis("Miejska terenówka.");

        x1.setKategoria(bmw);
        x1.setTypProduktu(TypProduktu.MOTO);
        x1.setTytul("BMW x1");
        x1.setOpis("Jako 3 auto w rodzinie.");

        x3.setKategoria(bmw);
        x3.setTypProduktu(TypProduktu.MOTO);
        x3.setTytul("BMW x3");
        x3.setOpis("Doskonały do jazdy po kiełbasę na grilla do Biedronki");

        x5.setKategoria(bmw);
        x5.setTypProduktu(TypProduktu.MOTO);
        x5.setTytul("BMW x5");
        x5.setOpis("Ladny, przestronny, drogi. Wszystko czego pragniesz!");

        g90.setKategoria(man);
        g90.setTypProduktu(TypProduktu.MOTO);
        g90.setTytul("MAN G90");
        g90.setOpis("Mały przebieg");

        tgl.setKategoria(man);
        tgl.setTypProduktu(TypProduktu.MOTO);
        tgl.setTytul("MAN TGL");
        tgl.setOpis("Piękny lakier");

        tgm.setKategoria(man);
        tgm.setTypProduktu(TypProduktu.MOTO);
        tgm.setTytul("MAN TGM");
        tgm.setOpis("Wygodne fotele");



        session.persist(cKlasa);
        session.persist(eKlasa);
        session.persist(sKlasa);
        session.persist(glaKlasa);

        session.persist(x1);
        session.persist(x3);
        session.persist(x5);

        session.persist(g90);
        session.persist(tgl);
        session.persist(tgm);

        session.flush();
        session.close();
    }
}
