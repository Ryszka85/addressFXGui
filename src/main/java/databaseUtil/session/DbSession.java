package databaseUtil.session;

import datamodel.Address;
import datamodel.Country;
import datamodel.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public abstract class DbSession<T> {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure()
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Country.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /*public abstract void save(T obj);
    public abstract void deleteById(T obj);
    public abstract T selectOneByID(final int id);
    public abstract T selectOneByString(final String searchParam);
    public abstract List<T> selectAll();*/

    public static Session getSessionFactory() {
        return sessionFactory.openSession();
    }
}
