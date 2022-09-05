package ru.job4j.ood.ocp;

public class Delivery {

    public void deliver(String deliveryType) {
        if (deliveryType.equals("courier")) {
            System.out.println("Delivery by courier...");
        } else if (deliveryType.equals("mail")) {
            System.out.println("Delivery mail...");
        }
    }

    public void deliver(SendingParcel sendingParcel) {
        sendingParcel.send();
    }
}
