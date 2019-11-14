import entity.Kategoria;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class Start_KategoriaTikalk {
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
