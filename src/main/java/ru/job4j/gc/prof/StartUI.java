package ru.job4j.gc.prof;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StartUI {

    public static void menu() {
        System.out.println(
                "1. Создание массива;"
                + System.lineSeparator()
                + "2. Сортировка пузырьком;"
                + System.lineSeparator()
                + "3. Сортировка вставками;"
                + System.lineSeparator()
                + "4. Сортировка слиянием;"
                + System.lineSeparator()
                + "5. Выход."
                + System.lineSeparator()
        );
    }

    public static Data makeArray() {
        Data data = new RandomArray(new Random());
        data.insert(250000);
        return data;
    }

    public static int makeChoice() {
        System.out.print("Выберете действие:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Data data = null;
        BubbleSort bubble = new BubbleSort();
        InsertSort insert = new InsertSort();
        MergeSort merge = new MergeSort();
        boolean trigger = true;
        while (trigger) {
            menu();
            int number = makeChoice();
            if (number == 1) {
                long time = System.currentTimeMillis();
                data = makeArray();
                System.out.println(time - System.currentTimeMillis());
            } else if (number == 2) {
                long time = System.currentTimeMillis();
                bubble.sort(data);
                System.out.println(time - System.currentTimeMillis());
            } else if (number == 3) {
                long time = System.currentTimeMillis();
                insert.sort(data);
                System.out.println(time - System.currentTimeMillis());
            } else if (number == 4) {
                long time = System.currentTimeMillis();
                merge.sort(data);
                System.out.println(time - System.currentTimeMillis());
            } else if (number == 5) {
                trigger = false;
            }
        }
    }

}
