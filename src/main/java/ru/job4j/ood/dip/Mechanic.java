package ru.job4j.ood.dip;

public class Mechanic {
    public void repair(Lada lada) {
        if (lada.getDamage() <= 15) {
            System.out.println("Машина в порядке с вас пять тыщ");
        } else if (lada.getDamage() > 15) {
            System.out.println("Машина отремонтирована с вас сто тыщ");
        }
    }
}
