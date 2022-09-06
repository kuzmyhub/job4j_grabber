package ru.job4j.ood.storage;

import java.util.*;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public boolean sort(Food food, Store store) {
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

    public List<Store> getStores() {
        return List.copyOf(stores);
    }
}
