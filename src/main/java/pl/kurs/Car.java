package pl.kurs;

import java.util.Objects;

public class Car {
    private String producer;
    private String model;

    public Car(String producer, String model) {
        this.producer = producer;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(producer, car.producer) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model);
    }
}
