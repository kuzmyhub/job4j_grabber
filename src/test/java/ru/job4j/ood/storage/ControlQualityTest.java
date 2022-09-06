package ru.job4j.ood.storage;

import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    public void whenFoodIsRottenThenTrash() {
        ControlQuality controlQuality = new ControlQuality();
        Food cheese = new Food("Cheese", new GregorianCalendar(2022, 8, 20),
                new GregorianCalendar(2022, 0, 25), 450, 20);
        Food chicken = new Food("Chicken", new GregorianCalendar(2022, 8, 10),
                new GregorianCalendar(2022, 8, 2), 220, 5);
        Food juice = new Food("Juice", new GregorianCalendar(2023, 8, 5),
                new GregorianCalendar(2022, 8, 5), 150, 0);
        List<Food> food = List.of(cheese, chicken, juice);
        controlQuality.conveyor(food);
        assertThat(controlQuality.getTrash().getTrashList()).isEqualTo(List.of(cheese));
    }

    @Test
    public void whenFoodIsNotFreshAndNotRottenThenShop() {
        ControlQuality controlQuality = new ControlQuality();
        Food cheese = new Food("Cheese", new GregorianCalendar(2022, 8, 20),
                new GregorianCalendar(2022, 0, 25), 450, 20);
        Food chicken = new Food("Chicken", new GregorianCalendar(2022, 8, 10),
                new GregorianCalendar(2022, 8, 2), 220, 5);
        Food juice = new Food("Juice", new GregorianCalendar(2023, 8, 5),
                new GregorianCalendar(2022, 8, 5), 150, 0);
        List<Food> food = List.of(cheese, chicken, juice);
        controlQuality.conveyor(food);
        assertThat(controlQuality.getShop().getShopList()).isEqualTo(List.of(chicken));
    }

    @Test
    public void whenFoodIsFreshThenWarehouse() {
        ControlQuality controlQuality = new ControlQuality();
        Food cheese = new Food("Cheese", new GregorianCalendar(2022, 8, 20),
                new GregorianCalendar(2022, 0, 25), 450, 20);
        Food chicken = new Food("Chicken", new GregorianCalendar(2022, 8, 10),
                new GregorianCalendar(2022, 8, 2), 220, 5);
        Food juice = new Food("Juice", new GregorianCalendar(2023, 8, 5),
                new GregorianCalendar(2022, 8, 5), 150, 0);
        List<Food> food = List.of(cheese, chicken, juice);
        controlQuality.conveyor(food);
        assertThat(controlQuality.getWarehouse().getWarehouseList()).isEqualTo(List.of(juice));
    }
}