package databaseUtil.DAOModel;

import databaseUtil.session.DbSession;
import datamodel.Country;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CountryDAO implements DbDAO<Country> {
    @Override
    public void save(Country obj) {

    }

    @Override
    public void deleteById(Country obj) {

    }

    @Override
    public Country selectOneByID(int id) {
        return null;
    }

    @Override
    public Country selectOneByString(final String searchParam) {
        try (Session session = DbSession.getSessionFactory()) {
            final String queryString = "from Country where country_name = :param";
            final Query query = session.createQuery(queryString)
                    .setParameter("param", searchParam);
            return (Country) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error!Query went wrong.");
        }
        return null;
    }

    public Country selectOneByCountryName(final String countryName) {
        return selectOneByString(countryName);
    }

    @Override
    public List<Country> selectAll() {
        return null;
    }
}
