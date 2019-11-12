import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory buildSessionFactory(){
        return new Configuration().configure().buildSessionFactory();
    }

    private static final SessionFactory sessionFacotory = buildSessionFactory();

    public static SessionFactory getSessionFacotory(){
        return sessionFacotory;
    }
}
