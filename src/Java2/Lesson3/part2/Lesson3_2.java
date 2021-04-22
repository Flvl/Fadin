package Java2.Lesson3.part2;

import java.util.ArrayList;

public class Lesson3_2 {
    public static void main (String args[]){

        Apple apple=new Apple();
        Orange orange =new Orange();

        Box<Apple> box1=new Box("Коробка1");
        Box<Apple> box2=new Box("Коробка2");
        Box<Apple> box3=new Box("Коробка3");
        Box<Orange> box4=new Box("Коробка4");
        Box<Orange> box5=new Box("Коробка5");

        box1.putInBox(apple,1);
        box2.putInBox(apple,2);
        box3.putInBox(apple,3);
        box4.putInBox(orange,4);
        box5.putInBox(orange,5);

        box1.info();
        box2.info();
        box3.info();
        box4.info();
        box5.info();

        System.out.println(box1.compare(box5));
        System.out.println( box1.compare(box3));
        box1.pourOver(box2);
        System.out.println(box1.compare(box3));
        box1.info();
        box2.info();
        box3.info();
        box4.info();
        box5.info();
        box2.pourOver(box3);
        box2.pourOver(box3);

    }
}
