package ru.job4j.ood.storage;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ControlQuality {

    public static final float EXPIRATION_DATA_TRASH = 25F;

    public static final float EXPIRATION_DATA_WAREHOUSE =  75F;

    public static final float EXPIRATION_DATA = 100F;

    public void sort(Food food, Store store) {
        store.sort(food);
    }

    public float freshness(Food food) {
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

    public static void main(String[] args) {
        ControlQuality controlQuality = new ControlQuality();
        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        List<Food> food = List.of(
                new Food("Cheese", new GregorianCalendar(2022, 8, 20),
                        new GregorianCalendar(2022, 0, 25), 450, 20),
                new Food("Chicken", new GregorianCalendar(2022, 8, 10),
                        new GregorianCalendar(2022, 8, 2), 220, 5),
                new Food("Juice", new GregorianCalendar(2023, 8, 5),
                        new GregorianCalendar(2022, 8, 5), 150, 0)
        );
        for (Food f : food) {
            float condition = controlQuality.freshness(f);
            if (condition > EXPIRATION_DATA_WAREHOUSE) {
                controlQuality.sort(f, warehouse);
            } else if (condition <= EXPIRATION_DATA_WAREHOUSE
                    && condition >= EXPIRATION_DATA_TRASH) {
                controlQuality.sort(f, shop);
            } else if (condition < EXPIRATION_DATA_TRASH) {
                controlQuality.sort(f, trash);
            }
        }
    }
}
