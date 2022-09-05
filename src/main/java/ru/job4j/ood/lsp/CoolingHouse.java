package ru.job4j.ood.lsp;

public class CoolingHouse {
    public static void main(String[] args) {
        Conditioner hyundyi = new Hyundyi(
                new Thermometer().determineTemperature()
        );
    }
}
