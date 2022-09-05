package ru.job4j.ood.lsp;

public class Feeding {

    private Owner owner;

    public Feeding() {
        this.owner = new Owner();
    }

    public void feedAnimal(PetAnimal petAnimal) {
        if (petAnimal.getClass() == Cow.class) {
            owner.feedCow("hay");
        } else if (petAnimal.getClass() == Goat.class) {
            owner.feedGoat("grass");
        } else if (petAnimal.getClass() == Chicken.class) {
            owner.feedChicken("grass");
        }
    }
}
