package Lesson2;

public class MyTest {
    public void test (String [][] arr) throws MyArraySizeException {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr.length != 4 || arr[0].length != 4) throw new MyArraySizeException("Array wrong size");
            }
        }
    }
public int test1 (String [][] dataInCell) throws MyArrayDataException, MyArraySizeException{
        test(dataInCell);
    Integer res = 0;
    int i =0;
    int j =0;
        try {
            for (; i < dataInCell.length; i++) {
                j=0;
                for (; j < dataInCell.length; j++) {
                    res = res + Integer.parseInt(dataInCell[i][j]);
                }
            }
        } catch (NumberFormatException ex) {
            throw new MyArrayDataException("Wrong data in cell " + i+","+j );
        }
        return res;
}
}
