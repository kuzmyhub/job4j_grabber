package ru.job4j.ood.ocp;

public class MailDelivery implements SendingParcel {
    @Override
    public void send() {
        System.out.println("Доставка почтой");
    }
}
