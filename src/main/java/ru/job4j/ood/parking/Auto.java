package ru.job4j.ood.parking;

public class Auto implements Car {

    private static final int SIZE = 1;

    private String number;

    public Auto(String number) {
        this.number = number;
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public String getNumber() {
        return this.number;
    }
}
