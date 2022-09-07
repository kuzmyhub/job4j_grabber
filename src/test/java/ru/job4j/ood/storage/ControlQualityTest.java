package ru.job4j.ood.storage;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    public void whenFoodIsRottenThenTrash() {
        List<Store> stores = List.of(
                new Trash(),
                new Shop(),
                new Warehouse()
        );
        ControlQuality controlQuality = new ControlQuality(stores);
        Calendar expiryDateCheese = Calendar.getInstance();
        Calendar createDateCheese = Calendar.getInstance();
        expiryDateCheese.set(expiryDateCheese.get(Calendar.YEAR),
                expiryDateCheese.get(Calendar.MONTH),
                expiryDateCheese.get(Calendar.DAY_OF_MONTH) - 1,
                10, 0);
        createDateCheese.set(createDateCheese.get(Calendar.YEAR),
                createDateCheese.get(Calendar.MONTH),
                createDateCheese.get(Calendar.DAY_OF_MONTH) - 20,
                10, 0);
        Food cheese = new Food("Cheese", expiryDateCheese,
                createDateCheese, 450, 0);
        Calendar expiryDateChicken = Calendar.getInstance();
        Calendar createDateChicken = Calendar.getInstance();
        expiryDateChicken.set(expiryDateChicken.get(Calendar.YEAR),
                expiryDateChicken.get(Calendar.MONTH),
                expiryDateChicken.get(Calendar.DAY_OF_MONTH) + 10,
                10, 0);
        createDateChicken.set(createDateChicken.get(Calendar.YEAR),
                createDateChicken.get(Calendar.MONTH),
                createDateChicken.get(Calendar.DAY_OF_MONTH) - 10,
                10, 0);
        Food chicken = new Food("Chicken", expiryDateChicken,
                createDateChicken, 220, 0);
        Calendar expiryDateJuice = Calendar.getInstance();
        Calendar createDateJuice = Calendar.getInstance();
        expiryDateJuice.set(expiryDateJuice.get(Calendar.YEAR),
                expiryDateJuice.get(Calendar.MONTH),
                expiryDateJuice.get(Calendar.DAY_OF_MONTH) + 10,
                10, 0);
        createDateJuice.set(createDateJuice.get(Calendar.YEAR),
                createDateJuice.get(Calendar.MONTH),
                createDateJuice.get(Calendar.DAY_OF_MONTH) - 1,
                10, 0);
        Food juice = new Food("Juice", expiryDateJuice,
               createDateJuice, 150, 0);
        List<Food> food = List.of(cheese, chicken, juice);
        controlQuality.doDistribute(food);
        assertThat(controlQuality.getStores().get(0).getFoodList()).isEqualTo(List.of(cheese));
    }

    @Test
    public void whenFoodIsNotFreshAndNotRottenThenShop() {
        List<Store> stores = List.of(
                new Trash(),
                new Shop(),
                new Warehouse()
        );
        ControlQuality controlQuality = new ControlQuality(stores);
        Calendar expiryDateCheese = Calendar.getInstance();
        Calendar createDateCheese = Calendar.getInstance();
        expiryDateCheese.set(expiryDateCheese.get(Calendar.YEAR),
                expiryDateCheese.get(Calendar.MONTH),
                expiryDateCheese.get(Calendar.DAY_OF_MONTH) - 1,
                10, 0);
        createDateCheese.set(createDateCheese.get(Calendar.YEAR),
                createDateCheese.get(Calendar.MONTH),
                createDateCheese.get(Calendar.DAY_OF_MONTH) - 20,
                10, 0);
        Food cheese = new Food("Cheese", expiryDateCheese,
                createDateCheese, 450, 0);
        Calendar expiryDateChicken = Calendar.getInstance();
        Calendar createDateChicken = Calendar.getInstance();
        expiryDateChicken.set(expiryDateChicken.get(Calendar.YEAR),
                expiryDateChicken.get(Calendar.MONTH),
                expiryDateChicken.get(Calendar.DAY_OF_MONTH) + 10,
                10, 0);
        createDateChicken.set(createDateChicken.get(Calendar.YEAR),
                createDateChicken.get(Calendar.MONTH),
                createDateChicken.get(Calendar.DAY_OF_MONTH) - 10,
                10, 0);
        Food chicken = new Food("Chicken", expiryDateChicken,
                createDateChicken, 220, 0);
        Calendar expiryDateJuice = Calendar.getInstance();
        Calendar createDateJuice = Calendar.getInstance();
        expiryDateJuice.set(expiryDateJuice.get(Calendar.YEAR),
                expiryDateJuice.get(Calendar.MONTH),
                expiryDateJuice.get(Calendar.DAY_OF_MONTH) + 10,
                10, 0);
        createDateJuice.set(createDateJuice.get(Calendar.YEAR),
                createDateJuice.get(Calendar.MONTH),
                createDateJuice.get(Calendar.DAY_OF_MONTH) - 1,
                10, 0);
        Food juice = new Food("Juice", expiryDateJuice,
                createDateJuice, 150, 0);
        List<Food> food = List.of(cheese, chicken, juice);
        controlQuality.doDistribute(food);
        assertThat(controlQuality.getStores().get(1).getFoodList()).isEqualTo(List.of(chicken));
    }

    @Test
    public void whenFoodIsFreshThenWarehouse() {
        List<Store> stores = List.of(
                new Trash(),
                new Shop(),
                new Warehouse()
        );
        ControlQuality controlQuality = new ControlQuality(stores);
        Calendar expiryDateCheese = Calendar.getInstance();
        Calendar createDateCheese = Calendar.getInstance();
        expiryDateCheese.set(expiryDateCheese.get(Calendar.YEAR),
                expiryDateCheese.get(Calendar.MONTH),
                expiryDateCheese.get(Calendar.DAY_OF_MONTH) - 1,
                10, 0);
        createDateCheese.set(createDateCheese.get(Calendar.YEAR),
                createDateCheese.get(Calendar.MONTH),
                createDateCheese.get(Calendar.DAY_OF_MONTH) - 20,
                10, 0);
        Food cheese = new Food("Cheese", expiryDateCheese,
                createDateCheese, 450, 0);
        Calendar expiryDateChicken = Calendar.getInstance();
        Calendar createDateChicken = Calendar.getInstance();
        expiryDateChicken.set(expiryDateChicken.get(Calendar.YEAR),
                expiryDateChicken.get(Calendar.MONTH),
                expiryDateChicken.get(Calendar.DAY_OF_MONTH) + 10,
                10, 0);
        createDateChicken.set(createDateChicken.get(Calendar.YEAR),
                createDateChicken.get(Calendar.MONTH),
                createDateChicken.get(Calendar.DAY_OF_MONTH) - 10,
                10, 0);
        Food chicken = new Food("Chicken", expiryDateChicken,
                createDateChicken, 220, 0);
        Calendar expiryDateJuice = Calendar.getInstance();
        Calendar createDateJuice = Calendar.getInstance();
        expiryDateJuice.set(expiryDateJuice.get(Calendar.YEAR),
                expiryDateJuice.get(Calendar.MONTH),
                expiryDateJuice.get(Calendar.DAY_OF_MONTH) + 10,
                10, 0);
        createDateJuice.set(createDateJuice.get(Calendar.YEAR),
                createDateJuice.get(Calendar.MONTH),
                createDateJuice.get(Calendar.DAY_OF_MONTH) - 1,
                10, 0);
        Food juice = new Food("Juice", expiryDateJuice,
                createDateJuice, 150, 0);
        List<Food> food = List.of(cheese, chicken, juice);
        controlQuality.doDistribute(food);
        assertThat(controlQuality.getStores().get(2).getFoodList()).isEqualTo(List.of(juice));
    }

    @Test
    public void whenAllFoodIsSorted() {
        List<Store> stores = List.of(
                new Trash(),
                new Shop(),
                new Warehouse()
        );
        ControlQuality controlQuality = new ControlQuality(stores);
        Calendar expiryDateCheese = Calendar.getInstance();
        Calendar createDateCheese = Calendar.getInstance();
        expiryDateCheese.set(expiryDateCheese.get(Calendar.YEAR),
                expiryDateCheese.get(Calendar.MONTH),
                expiryDateCheese.get(Calendar.DAY_OF_MONTH) - 1,
                10, 0);
        createDateCheese.set(createDateCheese.get(Calendar.YEAR),
                createDateCheese.get(Calendar.MONTH),
                createDateCheese.get(Calendar.DAY_OF_MONTH) - 20,
                10, 0);
        Food cheese = new Food("Cheese", expiryDateCheese,
                createDateCheese, 450, 0);
        Calendar expiryDateChicken = Calendar.getInstance();
        Calendar createDateChicken = Calendar.getInstance();
        expiryDateChicken.set(expiryDateChicken.get(Calendar.YEAR),
                expiryDateChicken.get(Calendar.MONTH),
                expiryDateChicken.get(Calendar.DAY_OF_MONTH) + 10,
                10, 0);
        createDateChicken.set(createDateChicken.get(Calendar.YEAR),
                createDateChicken.get(Calendar.MONTH),
                createDateChicken.get(Calendar.DAY_OF_MONTH) - 10,
                10, 0);
        Food chicken = new Food("Chicken", expiryDateChicken,
                createDateChicken, 220, 0);
        Calendar expiryDateJuice = Calendar.getInstance();
        Calendar createDateJuice = Calendar.getInstance();
        expiryDateJuice.set(expiryDateJuice.get(Calendar.YEAR),
                expiryDateJuice.get(Calendar.MONTH),
                expiryDateJuice.get(Calendar.DAY_OF_MONTH) + 10,
                10, 0);
        createDateJuice.set(createDateJuice.get(Calendar.YEAR),
                createDateJuice.get(Calendar.MONTH),
                createDateJuice.get(Calendar.DAY_OF_MONTH) - 1,
                10, 0);
        Food juice = new Food("Juice", expiryDateJuice,
                createDateJuice, 150, 0);
        List<Food> food = List.of(cheese, chicken, juice);
        controlQuality.doDistribute(food);
        assertThat(controlQuality.getStores().get(0).getFoodList()).isEqualTo(List.of(cheese));
        assertThat(controlQuality.getStores().get(1).getFoodList()).isEqualTo(List.of(chicken));
        assertThat(controlQuality.getStores().get(2).getFoodList()).isEqualTo(List.of(juice));

    }

    @Test
    public void whenClearAndResort() {
        List<Store> stores = List.of(
                new Trash(),
                new Shop(),
                new Warehouse()
        );
        ControlQuality controlQuality = new ControlQuality(stores);
        Calendar expiryDateCheese = Calendar.getInstance();
        Calendar createDateCheese = Calendar.getInstance();
        expiryDateCheese.set(expiryDateCheese.get(Calendar.YEAR),
                expiryDateCheese.get(Calendar.MONTH),
                expiryDateCheese.get(Calendar.DAY_OF_MONTH) - 1,
                10, 0);
        createDateCheese.set(createDateCheese.get(Calendar.YEAR),
                createDateCheese.get(Calendar.MONTH),
                createDateCheese.get(Calendar.DAY_OF_MONTH) - 20,
                10, 0);
        Food cheese = new Food("Cheese", expiryDateCheese,
                createDateCheese, 450, 0);
        Calendar expiryDateChicken = Calendar.getInstance();
        Calendar createDateChicken = Calendar.getInstance();
        expiryDateChicken.set(expiryDateChicken.get(Calendar.YEAR),
                expiryDateChicken.get(Calendar.MONTH),
                expiryDateChicken.get(Calendar.DAY_OF_MONTH) + 10,
                10, 0);
        createDateChicken.set(createDateChicken.get(Calendar.YEAR),
                createDateChicken.get(Calendar.MONTH),
                createDateChicken.get(Calendar.DAY_OF_MONTH) - 10,
                10, 0);
        Food chicken = new Food("Chicken", expiryDateChicken,
                createDateChicken, 220, 0);
        Calendar expiryDateJuice = Calendar.getInstance();
        Calendar createDateJuice = Calendar.getInstance();
        expiryDateJuice.set(expiryDateJuice.get(Calendar.YEAR),
                expiryDateJuice.get(Calendar.MONTH),
                expiryDateJuice.get(Calendar.DAY_OF_MONTH) + 10,
                10, 0);
        createDateJuice.set(createDateJuice.get(Calendar.YEAR),
                createDateJuice.get(Calendar.MONTH),
                createDateJuice.get(Calendar.DAY_OF_MONTH) - 1,
                10, 0);
        Food juice = new Food("Juice", expiryDateJuice,
                createDateJuice, 150, 0);
        List<Food> food = List.of(cheese, chicken, juice);
        controlQuality.doDistribute(food);
        controlQuality.resort();
        assertThat(controlQuality.getStores().get(0).getFoodList()).isEqualTo(List.of(cheese));
        assertThat(controlQuality.getStores().get(1).getFoodList()).isEqualTo(List.of(chicken));
        assertThat(controlQuality.getStores().get(2).getFoodList()).isEqualTo(List.of(juice));
    }
}