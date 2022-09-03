package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return result(value, comparator, (x) -> x < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return result(value, comparator, (x) -> x > 0);
    }

    public <T> T result(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = null;
        for (T v : value) {
            if (rsl == null) {
                rsl = v;
            }
            int compare = comparator.compare(rsl, v);
            if (predicate.test(compare)) {
                rsl = v;
            }
        }
        return rsl;
    }
}