package ru.job4j.ood.parking;

import java.util.HashSet;
import java.util.Set;

public class ShoppingCenterParking implements ParkingSpace {

    private int autoPlaces;

    private int truckPlaces;

    private Set<Car> autos = new HashSet<>();

    private Set<Car> trucks = new HashSet<>();

    private int remainingAutoPlaces;

    private int remainingTruckPlaces;

    public ShoppingCenterParking(int autoPlaces, int truckPlaces) {
        this.autoPlaces = autoPlaces;
        this.truckPlaces = truckPlaces;
        remainingAutoPlaces = autoPlaces;
        remainingTruckPlaces = truckPlaces;
    }

    @Override
    public boolean park(Car car) {
        boolean rsl = false;
        if ((car.getSize() == Auto.SIZE && !autos.contains(car))
                || (car.getSize() > Auto.SIZE && !autos.contains(car)
                && !trucks.contains(car))) {
            if (car.getSize() == Auto.SIZE) {
                if (remainingAutoPlaces >= Auto.SIZE) {
                    autos.add(car);
                    remainingAutoPlaces -= Auto.SIZE;
                    rsl = true;
                }
            } else if (car.getSize() > Auto.SIZE) {
                if (remainingTruckPlaces >= Auto.SIZE) {
                    trucks.add(car);
                    remainingTruckPlaces -= Auto.SIZE;
                    rsl = true;
                } else if (remainingAutoPlaces >= car.getSize()) {
                    autos.add(car);
                    remainingAutoPlaces -= car.getSize();
                    rsl = true;
                }
            }
        }
        return rsl;
    }
}
