package ru.job4j.ood.storage;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    public static final float EXPIRATION_DATA_TRASH = 0F;

    public static final float EXPIRATION_DATA_DISCOUNT = 25F;

    public static final float EXPIRATION_DATA_WAREHOUSE =  75F;

    private List<Food> shopList = new ArrayList<>();

    @Override
    public boolean clear() {
        shopList.clear();
        return shopList.isEmpty();
    }

    @Override
    public boolean sort(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            float condition = checkFreshness(food);
            if (condition < EXPIRATION_DATA_DISCOUNT
                    && condition > EXPIRATION_DATA_TRASH) {
                food.setDiscount(20);
            }
            rsl = shopList.add(food);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        float condition = checkFreshness(food);
        if (condition <= EXPIRATION_DATA_WAREHOUSE
                && condition >= EXPIRATION_DATA_TRASH) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getFoodList() {
        return List.copyOf(shopList);
    }
}
