package ru.geekbrains.lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] animal = {"Собака", "Кошка", "Воробей",
                "Дельфин", "Воробей", "Пантера",
                "Кошка", "Лось", "Тигр", "Сова" ,
                "Дельфин", "Воробей" , "Енот"};

        System.out.println("Массив: " + Arrays.toString(animal));

        Set uniqueAnimal = new LinkedHashSet<>();
        for (String str : animal){
            uniqueAnimal.add(str);
        }
        System.out.println("Уникальные слова из массива: " + uniqueAnimal);

        Map<String, Integer> numberOfRepeat = new HashMap<>();
        for (String str : animal) {
            numberOfRepeat.putIfAbsent(str, 0);
            int count = numberOfRepeat.get(str);
            numberOfRepeat.put(str, count + 1);
        }
        System.out.println("Колличество повторений слов в массиве: " + numberOfRepeat);

        Phonebook phonebook = new Phonebook();

        phonebook.add("Иванов", "2302500");
        phonebook.add("Иванов", "2501501");
        phonebook.add("Петров", "2747474");
        phonebook.add("Петров", "2123456");
        phonebook.add("Сидоров", "2987654");
        phonebook.add("Гольдман", "2222222");

        System.out.println("Номера по фамилии Иванов: " + phonebook.get("Иванов"));
        System.out.println("Номера по фамилии Петров: " + phonebook.get("Петров"));
        System.out.println("Номера по фамилии Сидоров: " + phonebook.get("Сидоров"));
    }
}
