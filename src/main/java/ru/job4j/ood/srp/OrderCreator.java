package ru.job4j.ood.srp;

public class OrderCreator implements ShopOrderCreator {
    public String notification() {
        return "A new order has been received";
    }

    public Order createOrder(String order, String name, String address) {
        return new Order(order, name, address);
    }
}
