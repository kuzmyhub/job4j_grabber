package ru.job4j.ood.parking;

public class Truck implements Car {

    private int size;

    private String number;

    public Truck(int size, String number) {
        if (size <= Auto.SIZE) {
            throw new IllegalArgumentException(String.format(
                    "Truck size must be more than %s", Auto.SIZE)
            );
        }
        this.size = size;
        this.number = number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getNumber() {
        return this.number;
    }
}
