package ru.job4j.ood.storage;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    public static final float EXPIRATION_DATA_TRASH = 0F;

    private List<Food> trashList = new ArrayList<>();

    @Override
    public boolean clear() {
        trashList.clear();
        return trashList.isEmpty();
    }

    @Override
    public boolean sort(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            rsl = trashList.add(food);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        float condition = checkFreshness(food);
        if (condition <= EXPIRATION_DATA_TRASH) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getFoodList() {
        return List.copyOf(trashList);
    }
}
