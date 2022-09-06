package ru.job4j.ood.isp.menu;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class TODOApp {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static final int ADD_ROOT = 0;

    public static final int ADD_CHILD = 1;

    public static final int VIEW = 2;

    public static final int EXIT = 3;

    public static void menu() {
        List<String> list = List.of(
                "Добавить запись в корень",
                "Добавить запись под корень",
                "Показать записи",
                "Выход"
        );
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
        }

    }

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        boolean selector = true;
        while (selector) {
            menu();
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == ADD_ROOT) {
                System.out.println("Введите корень:");
                String userRecord = scanner.nextLine();
                boolean isAdd = menu.add(Menu.ROOT, userRecord, STUB_ACTION);
                System.out.println(isAdd ? "Добавлено" : "Не добавлено");
            } else if (choice == ADD_CHILD) {
                System.out.println("Введите корень:");
                String root = scanner.nextLine();
                System.out.println("Что добавить:");
                String userRecord = scanner.nextLine();
                boolean isAdd = menu.add(root, userRecord, STUB_ACTION);
                System.out.println(isAdd ? "Добавлено" : "Не добавлено");
            } else if (choice == VIEW) {
                printer.print(menu);
            } else if (choice == EXIT) {
                selector = false;
            }
        }
    }
}
