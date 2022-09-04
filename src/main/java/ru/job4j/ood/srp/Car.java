package ru.job4j.ood.srp;

public class Car {
    String engineCapacity;
    String conditioner;
    String castWheels;
    String autorun;

    public Car(String engineCapacity, String conditioner, String castWheels, String autorun) {
        this.engineCapacity = engineCapacity;
        this.conditioner = conditioner;
        this.castWheels = castWheels;
        this.autorun = autorun;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public String getConditioner() {
        return conditioner;
    }

    public String getCastWheels() {
        return castWheels;
    }

    public String getAutorun() {
        return autorun;
    }
}
