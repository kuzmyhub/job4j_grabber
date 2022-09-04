package ru.job4j.ood.srp;

public class LadaCarDealership implements CarDealership {

    @Override
    public String carInformation(Car car) {
        return car.getEngineCapacity() + " : "
                + car.getConditioner() + " : "
                + car.getCastWheels() + " : "
                + car.getAutorun() + " : ";
    }

    @Override
    public Car selectEquipment(String engineCapacity, String conditioner,
                                  String castWheels, String autorun) {
        return new Car(engineCapacity, conditioner,
                castWheels, autorun);
    }

    @Override
    public int calculateValue(int engine, int conditioner,
                               int wheels, int autorun) {
        return engine + conditioner + wheels + autorun;
    }
}
