package databaseUtil.DAOModel;

import java.util.List;

public interface DbDAO<T> {
    void save(T obj);
    void deleteById(T obj);
    T selectOneByID(final int id);
    T selectOneByString(final String searchParam);
    List<T> selectAll();
}
