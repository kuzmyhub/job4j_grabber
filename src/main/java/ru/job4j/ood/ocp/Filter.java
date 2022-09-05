package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public List<String> filterEMailDomain(List<String> list, String domain) {
        List<String> filtered = new ArrayList<>();
        for (String s : list) {
            if (s.contains(domain)) {
                filtered.add(s);
            }
        }
        return filtered;
    }

    public List<String> filterEMailLogin(List<String> list, String login) {
        List<String> filtered = new ArrayList<>();
        for (String s : list) {
            if (s.contains(login)) {
                filtered.add(s);
            }
        }
        return filtered;
    }

    public List<String> filterEMail(List<String> list, Predicate<String> pred) {
        List<String> filtered = new ArrayList<>();
        for (String s : list) {
            if (pred.test(s)) {
                filtered.add(s);
            }
        }
        return filtered;
    }
}
