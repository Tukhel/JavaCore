package ru.geekbrains.lesson3;

import java.util.*;

public class Phonebook {

    private Map<String, Set<String>> phonebook = new HashMap<>();

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String surname, String number) {
        Set<String> phones = phonebook.get(surname);
        if (phones == null) {
            phones = new HashSet<>(0);
            phonebook.put(surname, phones);
        }
        phones.add(number);
    }

    public Set<String> get(String surname) {
        return phonebook.get(surname);
    }
}