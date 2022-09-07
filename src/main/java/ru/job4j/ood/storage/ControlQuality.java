package ru.job4j.ood.storage;

import java.util.*;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void resort() {
        List<Food> food = new ArrayList<>();
        for (Store s : stores) {
            food.addAll(s.getFoodList());
            s.clear();
        }
        doDistribute(food);
    }

    private boolean sort(Food food, Store store) {
        return store.sort(food);
    }

    public void doDistribute(List<Food> food) {
        for (Store s : stores) {
            for (Food f : food) {
                boolean isCondition = s.accept(f);
                if (isCondition) {
                    sort(f, s);
                }
            }
        }
    }
}
