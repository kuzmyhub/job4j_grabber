package ru.job4j.design.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;

class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Employee worker = new Employee("Ivan",
                Calendar.getInstance(), Calendar.getInstance(),
                100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenProgrammersGenerated() {
        MemStore store = new MemStore();
        Employee worker = new Employee("Ivan",
                Calendar.getInstance(), Calendar.getInstance(),
                100);
        store.add(worker);
        Report programmers = new ProgrammersReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("Name = ").append(worker.getName())
                .append(System.lineSeparator())
                .append("Hired = ").append(DATE_FORMAT.format(worker.getHired().getTime()))
                .append(System.lineSeparator())
                .append("Fired = ").append(DATE_FORMAT.format(worker.getHired().getTime()))
                .append(System.lineSeparator())
                .append("Salary = ").append(worker.getSalary())
                .append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        assertThat(programmers.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenAccountantGenerated() {
        MemStore store = new MemStore();
        Employee worker = new Employee("Ivan",
                Calendar.getInstance(), Calendar.getInstance(),
                100);
        store.add(worker);
        Report accountant = new AccountantReport(store);
        int dollarRate = 60;
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary() * dollarRate).append(";")
                .append(System.lineSeparator());
        assertThat(accountant.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Employee worker1 = new Employee("Ivan",
                Calendar.getInstance(), Calendar.getInstance(),
                100);
        Employee worker2 = new Employee("Oleg",
                Calendar.getInstance(), Calendar.getInstance(),
                200);
        Employee worker3 = new Employee("Zhenya",
                Calendar.getInstance(), Calendar.getInstance(),
                300);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report hr = new HRReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator()).append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(hr.generate(em -> true)).isEqualTo(expect.toString());
    }
}