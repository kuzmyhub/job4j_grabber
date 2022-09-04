package ru.job4j.ood.srp;

public class CheckIn implements CheckInForTheFlight {
    @Override
    public boolean registration(String passport, String ticket) {
        boolean rsl = false;
        if (!passport.isEmpty() && !ticket.isEmpty()) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public String checkInLuggage(int luggageWeight) {
        String tag = null;
        if (luggageWeight < 30) {
            tag = "*baggage number*";
        }
        return tag;
    }
}
