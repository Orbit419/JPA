package model.tests;

import model.Patient;
import model.devices.device.Device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "blood_tests")
public class BloodTest extends Test {
    @Column(name = "blood_test_date")
    private LocalDateTime date;
    @Column(name = "blood_test_result")
    private boolean result;

    public BloodTest(Integer id, Patient patient, Device device, LocalDateTime date, boolean result) {
        super(id, patient, device);
        this.date = date;
        this.result = result;
    }

    public BloodTest() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
        return "BloodTest{" +
                "date=" + date +
                ", result=" + result +
                '}';
    }

    public class Builder {
        private Integer id;
        private Patient patient;
        private Device device;
        private LocalDateTime date;
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

        public Builder setDate(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public Builder setResult(boolean result) {
            this.result = result;
            return this;
        }

        public BloodTest build() {
            return new BloodTest(id, patient, device, date, result);
        }
    }
}
