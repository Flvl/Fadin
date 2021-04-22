package Java2.Lesson3.part1;

public class Lesson3 {
    public static void main(String args[]) {

        GenericBox<String> arrayStr = new GenericBox<String>("Hello","World"," ","!","\n");

        arrayStr.show();
        arrayStr.swap(2,1);
        arrayStr.show();
    }
}

