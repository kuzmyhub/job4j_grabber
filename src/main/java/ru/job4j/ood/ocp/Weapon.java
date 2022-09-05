package ru.job4j.ood.ocp;

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
