package dao;

import model.devices.accessory.Accessory;
import org.hibernate.SessionFactory;

public class AccessoryDaoImpl extends AbstractDao<Accessory, Integer> implements AccessoryDao {
    public AccessoryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Accessory.class);
    }
}
