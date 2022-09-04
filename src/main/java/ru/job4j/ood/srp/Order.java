package ru.job4j.ood.srp;

public class Order {
    private String orderNumber;
    private String name;
    private String address;

    public Order(String orderNumber, String name, String address) {
        this.orderNumber = orderNumber;
        this.name = name;
        this.address = address;
    }
}
