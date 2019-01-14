package dao;

import model.devices.device.Device;
import org.hibernate.SessionFactory;

public class DeviceDaoImpl extends AbstractDao<Device, Integer> implements DeviceDao{
    public DeviceDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Device.class);
    }
}
