import entity.KategoriaTikalk;
import org.hibernate.Session;

import java.util.List;

public class Start_KategoriaTikalk {
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

        // utrwalamy
        session.persist(root);

        session.persist(motoryzajca);

        session.persist(osobowe);
        session.persist(ciezarowe);

        session.persist(mercedes);
        session.persist(bmw);

        session.persist(man);

        session.flush();
        session.close();
    }


}
