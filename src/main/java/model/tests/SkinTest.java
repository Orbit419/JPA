package model.tests;

import model.Patient;
import model.devices.device.Device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "skin_tests")
public class SkinTest extends Test {
    @Column(name = "skin_test_date")
    private LocalDate date;
    @Column(name = "skin_test_result")
    private boolean result;

    public SkinTest(Integer id, Patient patient, Device device, LocalDate date, boolean result) {
        super(id, patient, device);
        this.date = date;
        this.result = result;
    }

    public SkinTest() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SkinTest{" +
                "date=" + date +
                ", result=" + result +
                '}';
    }

    public static class Builder {
        private Integer id;
        private Patient patient;
        private Device device;
        private LocalDate date;
        private boolean result;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setPatient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public Builder setDevice(Device device) {
            this.device = device;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setResult(boolean result) {
            this.result = result;
            return this;
        }

        public SkinTest build() {
            return new SkinTest(id, patient, device, date, result);
        }
    }
}
