package ru.geekbrains.lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] animal = {"Собака", "Кошка", "Воробей",
                "Дельфин", "Воробей", "Пантера",
                "Кошка", "Лось", "Тигр", "Сова" ,
                "Дельфин", "Воробей" , "Енот"};

        System.out.println("Массив: " + Arrays.toString(animal));

        LinkedHashSet<String> uniqueAnimal = new LinkedHashSet<>();
        for (int i = 0; i < animal.length; i++){
            uniqueAnimal.add(animal[i]);
        }

        System.out.println("Уникальные слова из массива: " + uniqueAnimal);

        Map<String, Integer> numberOfRepeat = new HashMap<>();
        for (int i = 0; i < animal.length; i++) {
            int count = 0;
            for (int j = 0; j < animal.length; j++) {
                if (animal[i] == animal[j]) {
                    count++;
                    numberOfRepeat.put(animal[i], count);
                }
            }
        }
        System.out.println("Колличество повторений слов в массиве: " + numberOfRepeat);

        Phonebook phonebook = new Phonebook();

        phonebook.add(2302500, "Иванов");
        phonebook.add(2501501, "Иванов");
        phonebook.add(2747474, "Петров");
        phonebook.add(2123456, "Петров");
        phonebook.add(2987654, "Сидоров");
        phonebook.add(2222222, "Гольдман");

        phonebook.get("Иванов");
        phonebook.get("Петров");
        phonebook.get("Сидоров");
        phonebook.get("Энштейн");
    }
}
