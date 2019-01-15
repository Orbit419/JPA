import model.Patient;
import model.devices.accessory.UltrasonicAccessory;
import model.devices.device.Device;
import model.devices.device.UltrasonicDevice;
import model.tests.SkinTest;
import model.tests.Test;
import service.PatientService;
import util.DependencyContainerFactory;
import util.HibernateUtil;

import java.time.LocalDate;

public class HWMain {
    public static void main(String[] args) {
        PatientService patientService = DependencyContainerFactory.getPatientService();

        Patient patient = new Patient.PatientBuilder()
                .setName("Vasya")
                .setLastName("Korovkin")
                .setDateOfBirth(LocalDate.parse("1995-02-10"))
                .build();

        Device ultrasonicDevice = new UltrasonicDevice.Builder()
                .setBrand("Brend")
                .setName("Ultra-1")
                .setModel("T-34")
                .build();

        UltrasonicAccessory ultrasonicAccessory = new UltrasonicAccessory.Builder()
                .setBrand("Brand")
                .setModel("Gepard")
                .setAccessoryClass("SuperClass")
                .build();

        Test skinTest = new SkinTest.Builder()
                .setDate(LocalDate.parse("2019-01-13"))
                .setResult(true)
                .build();

        skinTest.setPatient(patient);
        patient.addTest(skinTest);
        skinTest.setDevice(ultrasonicDevice);
        ultrasonicDevice.setAccessory(ultrasonicAccessory);

//        Integer id = patientService.save(patient);

        Patient updatePatient = new Patient.PatientBuilder()
                .setId(1)
                .setName("Vasya")
                .setLastName("Beda")
                .setDateOfBirth(LocalDate.parse("1990-04-25"))
                .build();

//        patientService.update(updatePatient);

//        System.out.println(patientService.findById(1));

//        patientService.deleteById(12);

        HibernateUtil.getSessionFactory().close();
    }
}
