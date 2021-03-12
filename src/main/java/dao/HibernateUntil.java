package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUntil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().
                    addAnnotatedClass(entity.Actor.class).
                    addAnnotatedClass(entity.Country.class).
                    addAnnotatedClass(entity.Film.class).
                    addAnnotatedClass(entity.Genre.class).
                    configure().buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("Initial SessionFactory creating failed " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
