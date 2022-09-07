package ru.job4j.ood.dip;

public class Cooking {

    private Food food;

    private Hob hob;

    public Cooking(Food food, Hob hob) {
        this.food = food;
        this.hob = hob;
    }

    public void makeFood() {
        hob.cook(food);
    }
}
