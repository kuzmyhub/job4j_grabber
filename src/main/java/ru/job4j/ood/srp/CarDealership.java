package ru.job4j.ood.srp;

public interface CarDealership {
    String carInformation(Car car);

    Car selectEquipment(String engineCapacity,
                           String conditioner,
                           String castWheels,
                           String autorun);

    int calculateValue(int engine, int conditioner,
                       int wheels, int autorun);
}
