package ru.job4j.ood.storage;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface Store {

    float EXPIRATION_DATA = 100F;

    boolean clear();

    boolean sort(Food food);

    boolean accept(Food food);

    default float checkFreshness(Food food) {
        Date now = Calendar.getInstance().getTime();
        Date beginning = food.getCreateDate().getTime();
        Date end = food.getExpiryDate().getTime();
        float condition = (
                end.getTime() - now.getTime()
        ) * EXPIRATION_DATA / (
                end.getTime() - beginning.getTime()
        );
        return condition;
    }

    List<Food> getFoodList();
}
