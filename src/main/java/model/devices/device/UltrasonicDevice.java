package model.devices.device;

import model.devices.accessory.Accessory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ultrasonik_devices")
public class UltrasonicDevice extends Device {
    @Column(name = "device_name")
    private String name;
    @Column(name = "device_model")
    private String model;

    public UltrasonicDevice(Integer id, String brand, Accessory accessory, String name, String model) {
        super(id, brand, accessory);
        this.name = name;
        this.model = model;
    }

    public UltrasonicDevice() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "UltrasonicDevice{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public static class Builder {
        private Integer id;
        private String brand;
        private Accessory accessory;
        private String name;
        private String model;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setAccessory(Accessory accessory) {
            this.accessory = accessory;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public UltrasonicDevice build() {
            return new UltrasonicDevice(id, brand, accessory, name, model);
        }
    }
}
