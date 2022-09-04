package ru.job4j.ood.srp;

public interface ShopOrderCreator {
    String notification();

    Order createOrder(String order, String name, String address);
}
