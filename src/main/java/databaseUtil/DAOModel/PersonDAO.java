package databaseUtil.DAOModel;

import databaseUtil.session.DbSession;
import datamodel.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements DbDAO<Person> {
    @Override
    public void save(Person p) {
        try (Session session = DbSession.getSessionFactory()) {
            Validator.objectNotNull(p);
            Transaction transaction = session.beginTransaction();
            session.save(p);
            transaction.commit();
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(Person obj) {

    }

    @Override
    public Person selectOneByID(int id) {
        return null;
    }

    @Override
    public Person selectOneByString(String searchParam) {
        return null;
    }

    @Override
    public List<Person> selectAll() {
        List<Person> personList = new ArrayList<>();
        Session session = DbSession.getSessionFactory();
        final String from_person = "from Person";
        final Query query = session.createQuery(from_person);
        personList = query.list();
        return personList;
    }
}
