package ru.job4j.ood.storage;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    public static final float EXPIRATION_DATA_TRASH = 0F;

    public static final float EXPIRATION_DATA_DISCOUNT = 25F;

    public static final float EXPIRATION_DATA_WAREHOUSE =  75F;

    private List<Food> shopList = new ArrayList<>();

    @Override
    public boolean sort(Food food) {
        shopList.add(food);
        return true;
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        float condition = checkFreshness(food);
        if (condition <= EXPIRATION_DATA_WAREHOUSE
                && condition >= EXPIRATION_DATA_DISCOUNT) {
            rsl = true;
        } else if (condition < EXPIRATION_DATA_DISCOUNT
                && condition > EXPIRATION_DATA_TRASH) {
            rsl = true;
            food.setDiscount(20);
        }
        return rsl;
    }

    @Override
    public float checkFreshness(Food food) {
        return Store.super.checkFreshness(food);
    }

    @Override
    public List<Food> getFoodList() {
        return List.copyOf(shopList);
    }
}
