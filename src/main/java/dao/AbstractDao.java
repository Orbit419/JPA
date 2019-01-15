package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, Id extends Serializable> implements Dao<T, Id> {
    private final SessionFactory sessionFactory;
    private final Class<T> tClass;

    public AbstractDao(SessionFactory sessionFactory, Class<T> tClass) {
        this.sessionFactory = sessionFactory;
        this.tClass = tClass;
    }

    public Id save(T entity) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Id id = (Id) session.save(entity);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public T findById(Id id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        T t = session.load(tClass, id);
        session.getTransaction().commit();
        session.disconnect();
        return t;
    }

    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(tClass);
        Root<T> root = query.from(tClass);
        query.select(root);
        Query<T> q = session.createQuery(query);
        List<T> list = q.getResultList();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    public T update(T entity) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public void deleteById(Id id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        T t = session.load(tClass, id);
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }
}
