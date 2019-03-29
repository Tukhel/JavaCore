package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;

public class Human extends Animal implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;
    private int swimDistance;

    public Human(String name, int age, int runDistance, int jumpHeight, int swimDistance) {
        super(name, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.swimDistance = swimDistance;
    }



    @Override
    public void voice() {
        System.out.println("Привет");
    }

    @Override
    public boolean isOnDistance() {
        return isOnDistance;
    }

    @Override
    public void run(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > runDistance) {
            isOnDistance = false;
            System.out.println(String.format("Человек %s не справился с кроссом длинной %d и выбывает из марафона", getName(), distance));
            return;
        }
        System.out.println(String.format("Человек %s пробежал кросс длинной %d", getName(), distance));
    }

    @Override
    public void jump(int height) {
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            System.out.println(String.format("Человек %s не справился с высотой %d и выбывает из марафона", getName(), height));
            return;
        }
        System.out.println(String.format("Человек %s пругнул на высоту %d", getName(), height));
    }

    @Override
    public void swim(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > swimDistance) {
            isOnDistance = false;
            System.out.println(String.format("Человек %s не смог проплыть %d и выбывает из марафона", getName(), distance));
            return;
        }
        System.out.println(String.format("Человек %s проплыл %d", getName(), distance));
    }
}