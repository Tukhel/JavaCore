public class MyArraySizeException extends Exception {
    MyArraySizeException(int size) {
        super("Не верный размер массива! Массив равен: " + size);
    }
}
