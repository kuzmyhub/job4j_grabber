package ru.job4j.design.srp;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.text.SimpleDateFormat;
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
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary() * AccountantReport.DOLLAR_RATE).append(";")
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

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Employee worker = new Employee("Ivan",
                Calendar.getInstance(), Calendar.getInstance(),
                100);
        store.add(worker);
        Report json = new ReportJSON(store);
        String expected = "[{\"name\":\"Ivan\",\"hired\":{"
                + "\"year\":"
                + worker.getHired().get(Calendar.YEAR)
                + ",\"month\":"
                + worker.getHired().get(Calendar.MONTH)
                + ",\"dayOfMonth\":"
                + worker.getHired().get(Calendar.DAY_OF_MONTH)
                + ",\"hourOfDay\":"
                + worker.getHired().get(Calendar.HOUR_OF_DAY)
                + ",\"minute\":"
                + worker.getHired().get(Calendar.MINUTE)
                + ",\"second\":"
                + worker.getHired().get(Calendar.SECOND)
                + "},\"fired\":{\"year\":"
                + worker.getFired().get(Calendar.YEAR)
                + ",\"month\":"
                + worker.getHired().get(Calendar.MONTH)
                + ",\"dayOfMonth\":"
                + worker.getHired().get(Calendar.DAY_OF_MONTH)
                + ",\"hourOfDay\":"
                + worker.getHired().get(Calendar.HOUR_OF_DAY)
                + ",\"minute\":"
                + worker.getHired().get(Calendar.MINUTE)
                + ",\"second\":"
                + worker.getHired().get(Calendar.SECOND)
                + "},\"salary\":100.0}]";
        assertThat(json.generate(em -> true)).isEqualTo(expected);
    }

    @Test
    public void whenXMLGenerated() throws JAXBException {
        MemStore store = new MemStore();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
        );
        Employee worker = new Employee("Ivan",
                Calendar.getInstance(), Calendar.getInstance(),
                100);
        store.add(worker);
        Report xml = new ReportXML(store);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employees>\n"
                + "    <employee>\n"
                + "        <fired>"
                + dateFormat.format(worker.getFired().getTime())
                + "</fired>\n"
                + "        <hired>"
                + dateFormat.format(worker.getFired().getTime())
                + "</hired>\n"
                + "        <name>Ivan</name>\n"
                + "        <salary>100.0</salary>\n"
                + "    </employee>\n"
                + "</employees>\n";
        assertThat(xml.generate(em -> true)).isEqualTo(expected);
    }
}