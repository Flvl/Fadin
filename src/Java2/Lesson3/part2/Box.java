package Java2.Lesson3.part2;

import java.util.ArrayList;

public class Box <T extends Fruit> extends ArrayList<T>{

    private T obj;
    private Apple apple=new Apple();
    private Orange orange=new Orange();
    private Box box;
    private String name;


    public Box(String name) {
        super();
        this.name=name;
    }


    public double getWeight (){
        try {
             return super.size()*this.get(0).getWeight();
        } catch ( IndexOutOfBoundsException e)
        {
            return 0;
        }
    }

    public void putInBox (T obj, int count)
    {
        for (int i=0; i<count; i++)
        {
            super.add(obj);
        }
    }

    public void outputFromBox ()
    {
        int count=this.size();
        for (int i=0; i<count; i++)
        {
            super.remove(0);
        }
    }

    public void pourOver (Box<T> otherBox)
    {
        System.out.println("Перекладываем в "+this.nameBox()+" из "+otherBox.nameBox()+" ");
        try {
            this.putInBox(otherBox.get(0),otherBox.size());
            otherBox.outputFromBox();
        }
        catch (IndexOutOfBoundsException e) {}
        this.info();
        otherBox.info();

    }

    public boolean compare (Box<?> otherBox)
    {
        System.out.println("Сравниваем вес "+this.nameBox()+" и "+otherBox.nameBox()+" ");
        if (this.getWeight()==otherBox.getWeight()) return true;
        else return false;
    }

    public void info (){
        System.out.println(this.nameBox()+" весит "+this.getWeight());
    }

    public String nameBox (){

        return name;
    }


}
