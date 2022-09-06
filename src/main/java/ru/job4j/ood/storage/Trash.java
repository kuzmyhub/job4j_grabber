package ru.job4j.ood.storage;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private List<Food> trashList = new ArrayList<>();

    @Override
    public void sort(Food food) {
        trashList.add(food);
    }

    public List<Food> getTrashList() {
        return trashList;
    }
}
