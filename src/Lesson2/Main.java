package Lesson2;



public class Main {
    public static void main(String[] args) {

        String [][] wrongDataInCell = {{"1", "2", "3", "4"}, {"5", "6", "b", "8"}, {"9", "8", "7", "6"}, {"5", "4", "2", "1"}};

        String [][] arrayWrongSize = {{"1", "2", "3", "4"}, {"5", "6", "1", "8"}, {"9", "6", "7", "8"}};

        String [][] arrayNoError  = {{"1", "2", "4", "4"}, {"5", "6", "1", "8"}, {"9", "4", "7", "8"}, {"7", "6", "7", "8"}};

       try {
           System.out.println("Arrays sum "+ new MyTest().test1(wrongDataInCell));
       } catch (MyArrayDataException | MyArraySizeException  ex) {
           System.out.println(ex.getMessage());
       }

        try {
            System.out.println("Arrays sum "+ new MyTest().test1(arrayWrongSize));
        } catch (MyArrayDataException | MyArraySizeException  ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Arrays sum "+ new MyTest().test1(arrayNoError));
        } catch (MyArrayDataException | MyArraySizeException  ex) {
            System.out.println(ex.getMessage());
        }

    }
}




