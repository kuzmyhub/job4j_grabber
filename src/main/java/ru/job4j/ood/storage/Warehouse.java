package ru.job4j.ood.storage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private List<Food> warehouse = new ArrayList<>();

    @Override
    public void sort(Food food) {
        warehouse.add(food);
    }

    public List<Food> getWarehouse() {
        return warehouse;
    }
}
