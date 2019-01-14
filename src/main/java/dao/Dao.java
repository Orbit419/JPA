package dao;

import java.io.Serializable;
import java.util.List;

public interface Dao <T, Id extends Serializable> {
    Id save(T entity);

    T findById(Id id);

    List<T> findAll();

    T update(T entity);

    void deleteById(Id id);

    void delete(T entity);
}
