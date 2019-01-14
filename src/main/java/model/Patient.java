package model;

import model.tests.Test;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Integer id;
    @Column(name = "patient_name")
    private String name;
    @Column(name = "patient_last_name")
    private String lastName;
    @Column(name = "patient_date_of_birth")
    private LocalDate dateOfBirth;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Test> tests = new HashSet<>();

    public Patient(Integer id, String name, String lastName, LocalDate dateOfBirth, Set<Test> tests) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tests = tests;
    }

    public Patient() {
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public void addTest(Test test) {
        tests.add(test);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", tests=" + tests +
                '}';
    }

    public static class PatientBuilder {
        private String name;
        private String lastName;
        private LocalDate dateOfBirth;
        private Integer id;
        private Set<Test> tests = new HashSet<>();

        public PatientBuilder() {
        }

        public PatientBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PatientBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PatientBuilder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PatientBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public PatientBuilder setTests(Set<Test> tests) {
            this.tests = tests;
            return this;
        }

        public Patient build() {
            return new Patient(id, name, lastName, dateOfBirth, tests);
        }
    }
}
