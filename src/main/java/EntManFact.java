import entity.Uzytkownik;
import utils.PersistanceUtilMoje;

import javax.persistence.EntityManager;

public class EntManFact {
    public static void main(String[] args) {
        EntityManager entityManager = PersistanceUtilMoje.getEntityManager();
        entityManager.getTransaction().begin();

//        działanie na encjach
        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setRole("Admin");
        uzytkownik.setMiasto("Krakow");
        uzytkownik.setLoginMail("login@main.com");
        uzytkownik.setHaslo("haslo123");

        entityManager.persist(uzytkownik);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
