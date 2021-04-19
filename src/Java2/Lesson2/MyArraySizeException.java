package Java2.Lesson2;

public class MyArraySizeException extends IndexOutOfBoundsException{


    public MyArraySizeException(int i, int j) {
        System.out.println("Величина массива не 4х4, а "+i+" "+ j);

    }


}
