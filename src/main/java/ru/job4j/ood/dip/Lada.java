package ru.job4j.ood.dip;

import java.util.Objects;

public class Lada {

    private String mark;

    private int damage;

    public Lada(String mark, int damage) {
        this.mark = mark;
        this.damage = damage;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lada lada = (Lada) o;
        return damage == lada.damage && Objects.equals(mark, lada.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, damage);
    }
}
