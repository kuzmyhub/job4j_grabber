package ru.job4j.ood.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCenterParkingTest {

    @Test
    public void when2AutoAnd1TruckThenTrue() {
        ShoppingCenterParking scp = new ShoppingCenterParking(2, 1);
        Car autoOne = new Auto("E253TT32");
        Car autoTwo = new Auto("B253MM24");
        Car truckOne = new Truck(2, "Y467AP98");
        assertTrue(scp.park(autoOne));
        assertTrue(scp.park(autoTwo));
        assertTrue(scp.park(truckOne));
    }

    @Test
    public void when2TruckThenTrue() {
        ShoppingCenterParking scp = new ShoppingCenterParking(2, 1);
        Car truckOne = new Truck(2, "Y467AP98");
        Car truckTwo = new Truck(2, "P467AC65");
        assertTrue(scp.park(truckOne));
        assertTrue(scp.park(truckTwo));
    }
}