package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;

public class ReportJSON implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private Store store;

    private Gson gson;

    public ReportJSON(Store store) {
        this.store = store;
        this.gson = new GsonBuilder().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        return gson.toJson(employees);
    }
}
