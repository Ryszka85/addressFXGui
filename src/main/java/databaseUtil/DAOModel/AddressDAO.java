package databaseUtil.DAOModel;

import databaseUtil.session.DbSession;
import datamodel.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import validation.Validator;

import java.util.List;

public class AddressDAO implements DbDAO<Address> {
    @Override
    public void save(Address obj) {
        try (Session session = DbSession.getSessionFactory()) {
            Validator.objectNotNull(obj);
            Transaction transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(Address obj) {

    }

    @Override
    public Address selectOneByID(int id) {
        try (Session session = DbSession.getSessionFactory()) {
            return getAddress(id, session);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Address getAddress(int id, Session session) {
        final Query query;
        final String queryString = "from Address where id_address = :id";
        query = session.createQuery(queryString)
                .setParameter("id", id);
        return (Address) query.getSingleResult();
    }

    @Override
    public Address selectOneByString(String searchParam) {
        return null;
    }

    public List<Address> addressesByUserID(final int userId) {
        try (Session session = DbSession.getSessionFactory()) {
            return getAddresses(userId, session);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Address> getAddresses(int userId, Session session) {
        final String queryString = "from Address where id_person = :id";
        final Query query = session.createQuery(queryString)
                .setParameter("id", userId);
        return (List<Address>) query.list();
    }

    @Override
    public List<Address> selectAll() {
        try (Session session = DbSession.getSessionFactory()) {
            final String queryString = "from Address";
            final Query query = session.createQuery(queryString);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
