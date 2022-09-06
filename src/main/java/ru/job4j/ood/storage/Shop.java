package ru.job4j.ood.storage;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private List<Food> shop = new ArrayList<>();

    @Override
    public void sort(Food food) {
        shop.add(food);
    }

    public List<Food> getShop() {
        return shop;
    }
}
