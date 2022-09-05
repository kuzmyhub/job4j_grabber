package ru.job4j.ood.lsp;

public class Conditioner {

    protected int temperature;

    public Conditioner(int temperature) {
        this.temperature = temperature;
    }

    public void autoCooling(int temperature) {
        if (temperature < 25) {
            System.out.println("Cooling is not required");
        } else {
            System.out.println("Cooling...");
        }
    }
}
