package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory buildSessionFactory(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        return factory;
    }

    private static final SessionFactory sessionFacotory = buildSessionFactory();

    public static SessionFactory getSessionFacotory(){
        return sessionFacotory;
    }
}
