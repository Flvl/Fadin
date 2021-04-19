package Java2.Lesson2;

public class MyArrayDataException extends  NumberFormatException{

   public MyArrayDataException () {
   }

   public MyArrayDataException (String s, int i, int j) {
      System.out.println("В ячейке "+i+" "+ j+" находится не число, а: "+ s);
   }



}
