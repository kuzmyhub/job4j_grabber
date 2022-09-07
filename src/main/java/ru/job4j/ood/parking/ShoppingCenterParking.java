package ru.job4j.ood.parking;

import java.util.HashSet;
import java.util.Set;

public class ShoppingCenterParking implements ParkingSpace {

    private int autoPlaces;

    private int truckPlaces;

    private Set<Car> auto = new HashSet<>();

    private Set<Car> truck = new HashSet<>();

    public ShoppingCenterParking(int autoPlaces, int truckPlaces) {
        this.autoPlaces = autoPlaces;
        this.truckPlaces = truckPlaces;
    }

    @Override
    public boolean park(Car car) {
        return false;
    }
}
