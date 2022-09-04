package ru.job4j.ood.ocp;

/*
Изначально есть только одно оружие - пистолет.
У него есть метод aim() (наведение). Появилось новое оружие - катюша,
которое тоже должно уметь прицеливаться. Для расширения класса Weapon
хотелось бы экстендиться от класса Pistol, но это делать нельзя,
так как состояния у объектов разные. Они оба являются оружием,
но совершенно разными как по смыслу, так и по виду. В данной ситуации
нужно было бы выделить отдельный интерфейс Target с методом aim()
и имплементиться от него обоими классами.
*/

public class Weapon {

    private static class Pistol {
        public boolean aim(String target) {
            boolean done = false;
            if (!target.isEmpty()) {
                done = true;
            }
            return done;
        }
    }

    private static class Katyusha extends Pistol {
        @Override
        public boolean aim(String target) {
            boolean done = false;
            if (!target.isEmpty()) {
                done = true;
            }
            return done;
        }
    }
}
