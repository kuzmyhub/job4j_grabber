package ru.job4j.design.srp;

import ru.job4j.design.srp.Employee;
import ru.job4j.design.srp.Report;
import ru.job4j.design.srp.Store;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;

public class ProgrammersReport implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private Store store;

    public ProgrammersReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("Name = ").append(employee.getName())
                    .append(System.lineSeparator())
                    .append("Hired = ").append(DATE_FORMAT.format(employee.getHired().getTime()))
                    .append(System.lineSeparator())
                    .append("Fired = ").append(DATE_FORMAT.format(employee.getHired().getTime()))
                    .append(System.lineSeparator())
                    .append("Salary = ").append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        text.append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        return text.toString();
    }
}
