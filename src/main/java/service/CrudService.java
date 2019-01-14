package service;

import java.util.List;

public interface CrudService <T, Id>{
    Id save(T entity);

    T findById(Id id);

    List<T> findAll();

    T update(T entity);

    void deleteById(Id id);

    void delete(T entity);
}
