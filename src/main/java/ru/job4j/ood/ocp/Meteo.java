package ru.job4j.ood.ocp;

public class Meteo {

    int pressure;

    double windSpeed;

    public Meteo(int pressure, double windSpeed) {
        this.pressure = pressure;
        this.windSpeed = windSpeed;
    }

    public Meteo(int pressure) {
        this.pressure = pressure;
    }

    public Meteo(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
