public class SumArray extends Exception {

    public static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int size = 4;
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException(size);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException(size);
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return sum;
    }
}