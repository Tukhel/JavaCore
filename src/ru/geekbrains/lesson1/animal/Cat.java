
package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

public class Cat extends Animal implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Cat(String name, Color color, int age, int runDistance, int jumpHeight) {
        super(name, color, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public Cat(String name, Color color) {
        super(name, color, 0);
    }

    @Override
    public void voice() {
        System.out.println("Мяу");
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
            System.out.println(String.format("Кошка %s не смогла пробежать кросс длинной %d и выбывает из марафона", getName(), distance));
            return;
        }
        System.out.println(String.format("Кошка %s пробежала кросс длинной %d", getName(), distance));
    }

    @Override
    public void jump(int height) {
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            System.out.println(String.format("Кошка %s не смогла подпрыгнуть на высоту %d и выбывает из марафона", getName(), height));
            return;
        }
        System.out.println(String.format("Кошка %s пругнула на высоту %d", getName(), height));
    }

    @Override
    public void swim(int distance) {
        isOnDistance = false;
        System.out.println("Кошки не любят плавать");
        // throw new UnsupportedOperationException("Кошка не умеет плавать");
    }

    @Override
    public void getResult() {
        System.out.println(String.format("Кошка %s &sпрошла полосу препятствий", getName(), isOnDistance ? "": " не "));
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }
}