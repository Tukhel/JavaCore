package ru.geekbrains.lesson2;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(int i, int j, String value, Throwable caused) {
        super(String.format("Некорректное значение '%s' в ячейке [%d][%d]", value, i, j), caused);

    }

}
