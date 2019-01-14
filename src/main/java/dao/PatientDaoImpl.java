package dao;

import model.Patient;
import org.hibernate.SessionFactory;

public class PatientDaoImpl extends AbstractDao<Patient, Integer> implements PatientDao {
    public PatientDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Patient.class);
    }
}
