package ru.job4j.ood.ocp;

public class CourierDelivery implements SendingParcel {
    @Override
    public void send() {
        System.out.println("Доставка курьером");
    }
}
