package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Cat;
import ru.geekbrains.lesson1.animal.Dog;
import ru.geekbrains.lesson1.animal.Human;
import ru.geekbrains.lesson1.animal.Robot;
import ru.geekbrains.lesson1.course.Course;
import ru.geekbrains.lesson1.course.Cross;
import ru.geekbrains.lesson1.course.Wall;
import ru.geekbrains.lesson1.course.Water;
import ru.geekbrains.lesson1.enums.Color;

/**
 * Класс для запуска приложения - симулятор кросса
 */
public class Application {

    public static void main(String[] args) {
        Team team = new Team(
                new Cat("Барсик", Color.BLACK, 1, 100, 10),
                new Cat("Барон", Color.WHITE, 10, 20, 3),
                new Dog("Шарик", Color.BLACK, 2, 200, 10, 10),
                new Dog("Дружок", Color.RED, 5, 100, 5, 5),
                new Human("Андрей", 29,2000, 2, 800),
                new Robot("Железяка", 10000)
        );

        Course course = new Course(
                new Cross(50),
                new Wall(3),
                new Water(5)
        );

        course.doIt(team);

        //team.showResults();
    }
}