package ru.job4j.ood.parking;

public class Truck implements Car {

    private static final int VALIDATE_TRACK_SIZE = 1;

    private int size;

    private String number;

    public Truck(int size, String number) {
        if (size <= VALIDATE_TRACK_SIZE) {
            throw new IllegalArgumentException(String.format(
                    "Truck size must be more than %s", VALIDATE_TRACK_SIZE)
            );
        } else {
            this.size = size;
        }
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
