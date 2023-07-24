package src.Seminar03;

import java.util.Random;

public class Main {

    /**
     * 1.Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).
     * 2.Доп Задача.Добавляем метод сортировки для связного списка.
     * */
    public static final int SIZE = 10;

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new List<>();
        for (int i = 0; i < SIZE; i++) {
            list.addFirst(random.nextInt(11));
        }
        System.out.println("Созданный односвязный список");
        System.out.println(list.printList());
        System.out.println("===");
        System.out.println("Task_1. Разворот списка");
        list.revert();
        System.out.println(list.printList());
        System.out.println("Task_2. Сортировка списка");
        list.bubbleSort();
        System.out.println(list.printList());

    }
}
