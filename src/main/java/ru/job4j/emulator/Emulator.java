package ru.job4j.emulator;

import ru.job4j.cache.DirFileCache;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Emulator {

    private final static String ONE = "1. ";

    private final static String TWO = "2. ";

    private final static String THREE = "3. ";

    private final static String FOUR = "4. ";

    private final static String SPECIFY_THE_CACHED_DIRECTORY = "Указать кэшируемую дирректорию;";

    private final static String UPLOAD_FILE_CONTENTS_TO_CACHE = "Загрузить содержимое файла в кэш;";

    private final static String GET_FILE_CONTENTS_TO_CACHE = "Получить содержимое файла из кэша;";

    private final static String EXIT = "Выход.";

    private static Scanner scanner = new Scanner(System.in);

    private static DirFileCache dirFileCache;

    public static void main(String[] args) throws IOException {
        boolean cycle = true;
        while (cycle) {
            menu();
            int userChoice = Integer.parseInt(scanner.next());
            if (userChoice == 1) {
                System.out.printf(
                        "Укажите относительный путь в формате: %s%n",
                        "DIR/"
                );
                String path = scanner.next();
                dirFileCache = new DirFileCache(path);
            } else if (userChoice == 2) {
                System.out.printf(
                        "Укажите имя файла в формате: %s%n",
                        "FILE_NAME.EXTENSION"
                );
                String fileName = scanner.next();
                dirFileCache.put(fileName, dirFileCache.get(fileName));
            } else if (userChoice == 3) {
                System.out.printf(
                        "Укажите имя файла в формате: %s%n",
                        "FILE_NAME.EXTENSION"
                );
                String key = scanner.next();
                String value = dirFileCache.get(key);
                if (value != null) {
                    System.out.println(dirFileCache.get(key));
                } else {
                    dirFileCache.put(key, dirFileCache.get(key));
                    System.out.println("Файл отсутствует. Файл загружен в кэш.");
                }
            } else if (userChoice == 4) {
                cycle = false;
            }
        }
    }

    public static void menu() {
        List<String> menu = List.of(
                SPECIFY_THE_CACHED_DIRECTORY,
                UPLOAD_FILE_CONTENTS_TO_CACHE,
                GET_FILE_CONTENTS_TO_CACHE,
                EXIT
        );
        List<String> menuNumbers = List.of(
                ONE,
                TWO,
                THREE,
                FOUR
        );
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menuNumbers.get(i) + menu.get(i));
        }
    }
}
