package ru.job4j.ood.lsp;

class Hyundyi extends Conditioner {

    public Hyundyi(int temperature) {
        super(temperature);
    }

    @Override
    public void autoCooling(int temperature) {
        if (temperature < 20) {
            System.out.println("Cooling is not required");
        }
    }
}
