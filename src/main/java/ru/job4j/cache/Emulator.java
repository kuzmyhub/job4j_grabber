package ru.job4j.cache;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Emulator {

    private static List<String> menu = List.of(
            "Указать кэшируемую дирректорию;",
            "Загрузить содержимое файла в кэш;",
            "Получить содержимое файла из кэша;",
            "Выход."
            );

    private static Scanner scanner = new Scanner(System.in);

    private static DirFileCache dirFileCache;

    public static void main(String[] args) throws IOException {
        boolean cycle = true;
        while (cycle) {
            menu();
            int userChoice = Integer.parseInt(scanner.next());
            if (userChoice == 0) {
                System.out.printf(
                        "Укажите относительный путь в формате: %s%n",
                        "DIR/"
                );
                String path = scanner.next();
                dirFileCache = new DirFileCache(path);
            } else if (userChoice == 1) {
                System.out.printf(
                        "Укажите имя файла в формате: %s%n",
                        "FILE_NAME.EXTENSION"
                );
                String fileName = scanner.next();
                dirFileCache.put(fileName, dirFileCache.load(fileName));
            } else if (userChoice == 2) {
                System.out.printf(
                        "Укажите имя файла в формате: %s%n",
                        "FILE_NAME.EXTENSION"
                );
                String key = scanner.next();
                String value = dirFileCache.get(key);
                if (value != null) {
                    System.out.println(dirFileCache.get(key));
                } else {
                    dirFileCache.put(key, dirFileCache.load(key));
                    System.out.println("Файл отсутствует. Файл загружен в кэш.");
                }
            } else if (userChoice == 3) {
                cycle = false;
            }
        }
    }

    public static void menu() {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + ". " + menu.get(i));
        }
    }
}
