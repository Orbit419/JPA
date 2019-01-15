package model.devices.accessory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ultrasonic_accessory")
public class UltrasonicAccessory extends Accessory {
    @Column(name = "ultrasonic_accessory_model")
    private String model;
    @Column(name = "ultrasonic_accessory_class")
    private String accessoryClass;

    public UltrasonicAccessory(Integer id, String brand, String model, String accessoryClass) {
        super(id, brand);
        this.model = model;
        this.accessoryClass = accessoryClass;
    }

    public UltrasonicAccessory() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAccessoryClass() {
        return accessoryClass;
    }

    public void setAccessoryClass(String accessoryClass) {
        this.accessoryClass = accessoryClass;
    }

    @Override
    public String toString() {
        return "UltrasonicAccessory{" +
                "model='" + model + '\'' +
                ", accessoryClass='" + accessoryClass + '\'' +
                '}';
    }

    public static class Builder {
        private Integer id;
        private String brand;
        private String model;
        private String accessoryClass;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setAccessoryClass(String accessoryClass) {
            this.accessoryClass = accessoryClass;
            return this;
        }

        public UltrasonicAccessory build() {
            return new UltrasonicAccessory(id, brand, model, accessoryClass);
        }
    }
}
