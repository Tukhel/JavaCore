package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;

/**
 * Робот не является животным, но может учавствовать в соревнованиях
 * так как реализует интерфейс {@link Participant}
 */
public class Robot implements Participant {

    private String name;

    public Robot(String name) {
        this.name = name;
    }

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Robot(String name, int runDistance) {
        this.name = name;
        this.isOnDistance = true;
        this.runDistance = runDistance;
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
            System.out.println(String.format("Робот %s не смог пробежать кросс длинной %d и выбывает из марафона", getName(), distance));
            return;
        }
        System.out.println(String.format("Робот %s пробежал кросс длинной %d", getName(), distance));
    }

    @Override
    public void jump(int height) {
        isOnDistance = false;
        System.out.println("Роботы не умеют прыгать");
    }

    @Override
    public void swim(int distance) {
        isOnDistance = false;
        System.out.println("Роботы не умеют плавать");
    }

    public String getName() {
        return name;
    }
}