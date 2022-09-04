package ru.job4j.ood.srp;

public interface CheckInForTheFlight {
    boolean registration(String passport, String ticket);

    String checkInLuggage(int luggageWeight);
}
