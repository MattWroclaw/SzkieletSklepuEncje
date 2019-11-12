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

//        2 stopień
        KategoriaTikalk osobowe = new KategoriaTikalk();
        osobowe.setOpis("osobowe");


        //  3 stopień
        KategoriaTikalk mercedes = new KategoriaTikalk();
        mercedes.setOpis("mercedes");

//        ustawiamy zależności drzewa
        List<KategoriaTikalk> rootChildren = root.getChildren();
        rootChildren.add(motoryzajca);

        List<KategoriaTikalk> motoryzacjaChildren = motoryzajca.getChildren();
        motoryzacjaChildren.add(osobowe);
        motoryzajca.setParent(root);

        List<KategoriaTikalk> osoboweChildren = osobowe.getChildren();
        osoboweChildren.add(mercedes);
        osobowe.setParent(motoryzajca);

        mercedes.setParent(osobowe);
// tworzę produkty
        Produkt mercedesAklasa = new Produkt();
        mercedesAklasa.setTytul("Mercedes W169");
        mercedesAklasa.setOpis("Piękny baby-Benz");
        mercedesAklasa.setTypProduktu(TypProduktu.SPORT);
        mercedesAklasa.setKategoriaTikalk(mercedes);

        Produkt mercedesSklasa = new Produkt();
        mercedesSklasa.setTytul("Mercedes W410");
        mercedesSklasa.setOpis("Dostojna limuzyna");
        mercedesSklasa.setTypProduktu(TypProduktu.MOTO);
        mercedesSklasa.setKategoriaTikalk(mercedes);

//        utrwalam

        session.persist(root);
        session.persist(motoryzajca);
        session.persist(osobowe);
        session.persist(mercedes);

        session.persist(mercedesAklasa);
        session.persist(mercedesSklasa);

        session.flush();
        session.close();
    }
}
