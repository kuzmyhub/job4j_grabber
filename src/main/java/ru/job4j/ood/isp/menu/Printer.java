package ru.job4j.ood.isp.menu;

public class Printer implements MenuPrinter {

    private static final String INDENT = "---";

    private StringBuilder sb = new StringBuilder();

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo info : menu) {
            String outputStr = info.getName() + " " + info.getNumber();
            int sequenceNumberLength = info.getNumber().split("\\.").length;
            if (sequenceNumberLength == 1) {
                sb.append(outputStr).append(System.lineSeparator());
            } else {
                sb.append(INDENT.repeat(sequenceNumberLength - 1))
                        .append(outputStr)
                        .append(System.lineSeparator());
            }
        }
        System.out.println(getString());
    }

    @Override
    public String getString() {
        return sb.toString();
    }
}
