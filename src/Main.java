public class Main {

    public static void main(String[] args) {

        String[][] arr = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};
        try {
            int result = SumArray.sumArray(arr);
            System.out.println(result);
        }
        catch (MyArraySizeException ex) {
            System.err.println("Ошибка: " + ex);
        }
        catch (MyArrayDataException ex) {
            System.err.println("Ошибка: " + ex);

        }

    }

}