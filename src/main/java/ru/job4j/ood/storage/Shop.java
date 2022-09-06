package ru.job4j.ood.storage;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private List<Food> shopList = new ArrayList<>();

    @Override
    public void sort(Food food) {
        shopList.add(food);
    }

    public List<Food> getShopList() {
        return shopList;
    }
}
