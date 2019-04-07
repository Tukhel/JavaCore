package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.enums.Color;

public abstract class Animal {

    private String name;
    private Color color;
    private int age;

    public Animal(String name, Color color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    // Перегруженный (overload) конструктор
    public Animal(String name, int age) {
        this(name, null,age);
//        this.name = name;
//        this.color = color;
//        this.age = 0;
    }

    public abstract void voice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}