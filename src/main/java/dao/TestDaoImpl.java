package dao;

import model.tests.Test;
import org.hibernate.SessionFactory;

public class TestDaoImpl extends AbstractDao<Test, Integer> implements TestDao{
    public TestDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Test.class);
    }
}
