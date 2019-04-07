public class Main {

    private final static int SIZE = 4;

    public static void main(String[] args) {

        String[][] testArr1 = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};
        String[][] testArr2 = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7",},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};
        String[][] testArr3 = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "seh"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};

        try {
            System.out.println("Сумма массива 1: " + calcArraySum(testArr1));
        } catch (MyArrayDataException | MyArraySizeException ex ) {
            System.out.println(ex);
        }

        try {
            System.out.println("Сумма массива 2: " + calcArraySum(testArr2));
        } catch (MyArrayDataException | MyArraySizeException ex ) {
            System.out.println(ex);
        }

        try {
            System.out.println("Сумма массива 3: " + calcArraySum(testArr3));
        } catch (MyArrayDataException | MyArraySizeException ex ) {
            System.out.println(ex);
        }

    }

    public static int calcArraySum (String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int res = 0;

        if (arr.length != SIZE) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != SIZE) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    res += Integer.valueOf(arr[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j, arr[i][j], ex);
                }

            }
        }
        return res;
    }

}