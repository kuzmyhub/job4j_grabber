package ru.job4j.ood.storage;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private List<Food> trash = new ArrayList<>();

    @Override
    public void sort(Food food) {
        trash.add(food);
    }

    public List<Food> getTrash() {
        return trash;
    }
}
