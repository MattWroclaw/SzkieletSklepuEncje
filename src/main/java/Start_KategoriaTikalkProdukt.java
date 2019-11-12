import entity.KategoriaTikalk;
import entity.Produkt;
import entity.TypProduktu;
import org.hibernate.Session;

import java.util.List;

public class Start_KategoriaTikalkProdukt {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFacotory().openSession();
        session.beginTransaction();

//        główne
        KategoriaTikalk root = new KategoriaTikalk();
        root.setOpis("root");

//  1 stopień
        KategoriaTikalk motoryzajca = new KategoriaTikalk();
        motoryzajca.setOpis("motoryzacja");

//        2.1 stopień
        KategoriaTikalk osobowe = new KategoriaTikalk();
        osobowe.setOpis("osobowe");

        //        2.2 stopień
        KategoriaTikalk ciezarowe = new KategoriaTikalk();
        ciezarowe.setOpis("ciezarowe");


        //  3.1 stopień -sobowe
        KategoriaTikalk mercedes = new KategoriaTikalk();
        mercedes.setOpis("mercedes");

        //  3.2 stopień -sobowe
        KategoriaTikalk bmw = new KategoriaTikalk();
        bmw.setOpis("bmw");
//      3.3 stopień - ciężarowe

        KategoriaTikalk man = new KategoriaTikalk();
        man.setOpis("Ciezarowy MAN");

//        ustawiamy zależności drzewa
        List<KategoriaTikalk> rootChildren = root.getChildren();
        rootChildren.add(motoryzajca);

        List<KategoriaTikalk> motoryzacjaChildren = motoryzajca.getChildren();
        motoryzacjaChildren.add(osobowe);
        motoryzacjaChildren.add(ciezarowe);
        motoryzajca.setParent(root);

        List<KategoriaTikalk> osoboweChildren = osobowe.getChildren();
        osoboweChildren.add(mercedes);
        osoboweChildren.add(bmw);
        osobowe.setParent(motoryzajca);

        mercedes.setParent(osobowe);
        bmw.setParent(osobowe);

        List<KategoriaTikalk> ciezaroweChildren = ciezarowe.getChildren();
        ciezaroweChildren.add(man);
        ciezarowe.setParent(motoryzajca);

        man.setParent(ciezarowe);

        // utrwalamy drzewo zależności


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

        cKlasa.setKategoriaTikalk(mercedes);
        cKlasa.setTypProduktu(TypProduktu.MOTO);
        cKlasa.setTytul("Mercedes C-klass");
        cKlasa.setOpis("Piękny, nowy, nie śmigany");

        eKlasa.setKategoriaTikalk(mercedes);
        eKlasa.setTypProduktu(TypProduktu.MOTO);
        eKlasa.setTytul("Mercedes E-klass");
        eKlasa.setOpis("Nowoczesna limuzyna dla każdego boagacza");

        sKlasa.setKategoriaTikalk(mercedes);
        sKlasa.setTypProduktu(TypProduktu.MOTO);
        sKlasa.setTytul("Mercedes S-klass");
        sKlasa.setOpis("Zadbany, nie śmigany, wcześniejszy kierowca często go mył");

        glaKlasa.setKategoriaTikalk(mercedes);
        glaKlasa.setTypProduktu(TypProduktu.MOTO);
        glaKlasa.setTytul("Mercedes G-klass");
        glaKlasa.setOpis("Miejska terenówka.");

        x1.setKategoriaTikalk(bmw);
        x1.setTypProduktu(TypProduktu.MOTO);
        x1.setTytul("BMW x1");
        x1.setOpis("Jako 3 auto w rodzinie.");

        x3.setKategoriaTikalk(bmw);
        x3.setTypProduktu(TypProduktu.MOTO);
        x3.setTytul("BMW x3");
        x3.setOpis("Doskonały do jazdy po kiełbasę na grilla do Biedronki");

        x3.setKategoriaTikalk(bmw);
        x3.setTypProduktu(TypProduktu.MOTO);
        x3.setTytul("BMW x5");
        x3.setOpis("Ladny, przestronny, drogi. Wszystko czego pragniesz!");

        g90.setKategoriaTikalk(man);
        g90.setTypProduktu(TypProduktu.MOTO);
        g90.setTytul("MAN G90");
        g90.setOpis("Mały przebieg");

        tgl.setKategoriaTikalk(man);
        tgl.setTypProduktu(TypProduktu.MOTO);
        tgl.setTytul("MAN TGL");
        tgl.setOpis("Piękny lakier");

        tgm.setKategoriaTikalk(man);
        tgm.setTypProduktu(TypProduktu.MOTO);
        tgm.setTytul("MAN TGM");
        tgm.setOpis("Wygodne fotele");

        session.persist(root);

        session.persist(motoryzajca);

        session.persist(osobowe);
        session.persist(ciezarowe);

        session.persist(mercedes);
        session.persist(bmw);

        session.persist(man);

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
