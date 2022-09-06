package ru.job4j.ood.storage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    public static final float EXPIRATION_DATA_WAREHOUSE =  75F;

    private List<Food> warehouseList = new ArrayList<>();

    @Override
    public boolean sort(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            rsl = warehouseList.add(food);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        float condition = checkFreshness(food);
        if (condition > EXPIRATION_DATA_WAREHOUSE) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public float checkFreshness(Food food) {
        return Store.super.checkFreshness(food);
    }

    @Override
    public List<Food> getFoodList() {
        return List.copyOf(warehouseList);
    }
}
