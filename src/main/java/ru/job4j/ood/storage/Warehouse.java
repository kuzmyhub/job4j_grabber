package ru.job4j.ood.storage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private List<Food> warehouseList = new ArrayList<>();

    @Override
    public void sort(Food food) {
        warehouseList.add(food);
    }

    public List<Food> getWarehouseList() {
        return warehouseList;
    }
}
