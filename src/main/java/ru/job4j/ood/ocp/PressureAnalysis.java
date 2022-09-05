package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.List;

public class PressureAnalysis {

    public int analyse(List<Meteo> list) {
        return list.stream().mapToInt(x -> x.getPressure()).sum();
    }
}
