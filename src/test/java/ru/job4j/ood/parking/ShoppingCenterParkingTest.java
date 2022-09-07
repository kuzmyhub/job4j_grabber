package ru.job4j.ood.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ShoppingCenterParkingTest {

    @Test
    public void when2AutoAnd1TruckThenTrue() {
        ShoppingCenterParking scp = new ShoppingCenterParking(2, 1);
        Car autoOne = new Auto("E253TT32");
        Car autoTwo = new Auto("B253MM24");
        Car truckOne = new Truck(2, "Y467AP98");
        assertThat(scp.park(autoOne)).isEqualTo(true);
        assertThat(scp.park(autoTwo)).isEqualTo(true);
        assertThat(scp.park(truckOne)).isEqualTo(true);
    }

    @Test
    public void when2TruckThenTrue() {
        ShoppingCenterParking scp = new ShoppingCenterParking(2, 1);
        Car truckOne = new Truck(2, "Y467AP98");
        Car truckTwo = new Truck(2, "P467AC65");
        assertThat(scp.park(truckOne)).isEqualTo(true);
        assertThat(scp.park(truckTwo)).isEqualTo(true);
    }

    @Test
    public void when2AutoAndOneAutoPlaceThenFalse() {
        ShoppingCenterParking scp = new ShoppingCenterParking(1, 0);
        Car autoOne = new Auto("E253TT32");
        Car autoTwo = new Auto("B253MM24");
        assertThat(scp.park(autoOne)).isEqualTo(true);
        assertThat(scp.park(autoTwo)).isEqualTo(false);
    }

    @Test
    public void when2TruckAndOneTruckPlaceThenFalse() {
        ShoppingCenterParking scp = new ShoppingCenterParking(0, 1);
        Car truckOne = new Truck(2, "Y467AP98");
        Car truckTwo = new Truck(2, "P467AC65");
        assertThat(scp.park(truckOne)).isEqualTo(true);
        assertThat(scp.park(truckTwo)).isEqualTo(false);
    }

    @Test
    public void when1AutoAndOneTruckPlaceThenFalse() {
        ShoppingCenterParking scp = new ShoppingCenterParking(0, 1);
        Car autoOne = new Auto("E253TT32");
        assertThat(scp.park(autoOne)).isEqualTo(false);
    }

    @Test
    public void when1TruckAndOneAutoPlaceThenFalse() {
        ShoppingCenterParking scp = new ShoppingCenterParking(1, 0);
        Car truckOne = new Truck(2, "Y467AP98");
        assertThat(scp.park(truckOne)).isEqualTo(false);
    }
}