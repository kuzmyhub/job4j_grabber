package ru.job4j.ood.parking;

import java.util.Objects;

public class Auto implements Car {

    public static final int SIZE = 1;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Auto auto = (Auto) o;
        return Objects.equals(number, auto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
