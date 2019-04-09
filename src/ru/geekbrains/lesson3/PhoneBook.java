package ru.geekbrains.lesson3;

import java.util.*;

public class Phonebook {

    Map<Integer, String> phonebook = new HashMap<>();

    public void add(int number, String surname) {
        phonebook.put(number, surname);
    }

    public void get(String surname) {
        if (phonebook.containsValue(surname)) {
            Set<Map.Entry<Integer, String>> set = phonebook.entrySet();
            for (Map.Entry<Integer, String> temp : set) {
                if (temp.getValue().equals(surname)) {
                    System.out.println(temp.getValue() + " : " + temp.getKey());
                }
            }
        } else {
            System.out.printf("Фамилия %s в справочнике не найдена", surname);
        }
    }
}