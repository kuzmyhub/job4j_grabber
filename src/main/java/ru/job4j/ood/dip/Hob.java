package ru.job4j.ood.dip;

public class Hob {

    public void cook(Food food) {
        System.out.println(
                "Приготовление" + food.getName() + "на варочной панели"
        );
    }
}
