package ru.job4j.ood.storage;

import java.util.*;

public class ControlQuality {

    public static final float EXPIRATION_DATA_TRASH = 25F;

    public static final float EXPIRATION_DATA_WAREHOUSE =  75F;

    public static final float EXPIRATION_DATA = 100F;

    private Trash trash;

    private Shop shop;

    private Warehouse warehouse;

    public ControlQuality() {
        this.trash = new Trash();
        this.shop = new Shop();
        this.warehouse = new Warehouse();
    }

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

    public void conveyor(List<Food> food) {
        for (Food f : food) {
            float condition = freshness(f);
            if (condition > EXPIRATION_DATA_WAREHOUSE) {
                sort(f, warehouse);
            } else if (condition <= EXPIRATION_DATA_WAREHOUSE
                    && condition >= EXPIRATION_DATA_TRASH) {
                sort(f, shop);
            } else if (condition < EXPIRATION_DATA_TRASH) {
                sort(f, trash);
            }
        }
    }

    public Trash getTrash() {
        return trash;
    }

    public Shop getShop() {
        return shop;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
}
