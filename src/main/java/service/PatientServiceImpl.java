package service;

import dao.PatientDao;
import model.Patient;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public Integer save(Patient entity) {
        return patientDao.save(entity);
    }

    @Override
    public Patient findById(Integer id) {
        return patientDao.findById(id);
    }

    @Override
    public List<Patient> findAll() {
        return patientDao.findAll();
    }

    @Override
    public Patient update(Patient entity) {
        return patientDao.update(entity);
    }

    @Override
    public void deleteById(Integer id) {
        patientDao.deleteById(id);
    }

    @Override
    public void delete(Patient entity) {
        patientDao.delete(entity);
    }
}
