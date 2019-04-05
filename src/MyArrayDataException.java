public class MyArrayDataException extends Exception {
    public int i;
    public int j;

    MyArrayDataException(int i, int j) {
        super(String.format("Не корректные данные в ячейке: [%s][%s]", i, j));
        this.i = i;
        this.j = j;

    }

}