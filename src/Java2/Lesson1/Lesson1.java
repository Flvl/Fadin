package Java2.Lesson1;

import com.sun.org.apache.xpath.internal.operations.Variable;

import java.util.Objects;

public class Lesson1 {
    public static void main(String args[]){


       RunTrack runTrack=new RunTrack(20000);
       Wall wall=new Wall(0.1f);
       runTrack.info();
       wall.info();
        Human human1=new Human("Максим",16000,1f);
        human1.info();
        Cat cat1=new Cat("Мурзик",25000,1.5f);
        cat1.info();
        Robot robot1=new Robot("R2D2",50000,10f);
        robot1.info();
        //human1.start(runTrack);
        //human1.start(wall);

        Participant [] participants = new Participant[]{human1,cat1,robot1,new Human("Евгений",11000,1.5f),new Human("Николай",44000,1.1f), new Robot("C3PO",50000,0.01f),new Cat("Мурсия",28000,3.1f)};
        Let [] let = new Let[]{runTrack, wall, new RunTrack(1000), new RunTrack(42000), new Wall(1f), new Wall(2f)};
        RunTrack rt=runTrack;
        Wall wl=wall;
        for (int i=0; i<participants.length; i++)
        {for (int j=0; j<let.length; j++) {

            if (let[j].getClass()==rt.getClass())
            {rt=(RunTrack)let[j];
            participants[i].start(rt);


           if (!participants[i].finish(rt)) break;
            }
            else
            {
                wl=(Wall) let[j];
                participants[i].start(wl);
                if (!participants[i].finish(wl)) break;
            }

            //System.out.println(let[j]);
        }
        }

        //participants[0].start(let[1]);
    }

}


interface Participant {
    void info();
    void start(RunTrack runTrack);
    void start(Wall wall);
    boolean finish(RunTrack runTrack);
    boolean finish(Wall wall);

}

interface Let {
    void info();
}

 class Human implements  Participant {

    private String name;
    private int maxDistance;
    private float maxHeight;

    public Human(String name, int maxDistance, float maxHeight) {
        this.name = name;
        this.maxDistance=maxDistance;
        this.maxHeight=maxHeight;

    }

     public void start(RunTrack runTrack){
         System.out.println("Участник с именем "+name+" бежит...");
         if (runTrack.overcome(maxDistance)) System.out.print( "пробежал ");
         else System.out.print( "и не пробежал ");
         System.out.println(runTrack.getLength()+" м");
     }
     public void start(Wall wall){
         System.out.println("Участник с именем "+name+" прыгает...");
         if (wall.overcome(maxHeight)) System.out.print( "перепрыгнул ");
         else System.out.print( "и не перепрыгнул");
         System.out.println(wall.getHeight()+" м");
     }

     public boolean finish (RunTrack runTrack){
         if (runTrack.overcome(maxDistance))  return true;
         else return false;
     }
     public boolean finish(Wall wall){
         if (wall.overcome(maxHeight))  return true;
         else  return false;
     }

    public void info() {
        System.out.println("Человек по имени " + name+" может пробежать "+maxDistance+" м и прыгнуть на высоту "+maxHeight+" м");
    }
}

class Cat implements  Participant {

    private String name;
    private int maxDistance;
    private float maxHeight;


    public Cat(String name, int maxDistance, float maxHeight) {
        this.name = name;
        this.maxDistance=maxDistance;
        this.maxHeight=maxHeight;
    }

    public void info() {
        System.out.println("Кот по кличке " + name+" может пробежать "+maxDistance+" м и прыгнуть на высоту "+maxHeight+" м");
    }

    public void start(RunTrack runTrack){
        System.out.println("Участник по кличке "+name+" бежит...");
        if (runTrack.overcome(maxDistance)) System.out.print( "пробежал ");
        else System.out.print( "и не пробежал ");
        System.out.println(runTrack.getLength()+" м");
    }


    public void start(Wall wall){
        System.out.println("Участник по кличке "+name+" прыгает...");
        if (wall.overcome(maxHeight)) System.out.print( "перепрыгнул ");
        else System.out.print( "и не перепрыгнул ");
        System.out.println(wall.getHeight()+" м");
    }

    public boolean finish (RunTrack runTrack){
        if (runTrack.overcome(maxDistance))  return true;
        else return false;
    }
    public boolean finish(Wall wall){
        if (wall.overcome(maxHeight))  return true;
        else  return false;
    }
}

class Robot implements  Participant {

    private String name;
    private int maxDistance;
    private float maxHeight;


    public Robot(String name, int maxDistance, float maxHeight) {
        this.name = name;
        this.maxDistance=maxDistance;
        this.maxHeight=maxHeight;
    }

    public void info() {
        System.out.println("Робот с номером " + name+" может пробежать "+maxDistance+" м и прыгнуть на высоту "+maxHeight+" м");
    }

    public void start(RunTrack runTrack){
        System.out.println("Участник под номером "+name+" бежит...");
        if (runTrack.overcome(maxDistance)) System.out.print( "пробежал ");
        else System.out.print( "и не пробежал ");
        System.out.println(runTrack.getLength()+" м");
    }



    public void start(Wall wall){
        System.out.println("Участник под номером "+name+" прыгает...");
        if (wall.overcome(maxHeight)) System.out.print( "перепрыгнул ");
        else System.out.print( "и не перепрыгнул ");
        System.out.println(wall.getHeight()+" м");
    }

    public boolean finish (RunTrack runTrack){
        if (runTrack.overcome(maxDistance))  return true;
        else return false;
    }
    public boolean finish(Wall wall){
        if (wall.overcome(maxHeight))  return true;
        else  return false;
    }
}

class RunTrack implements Let {

    private int length;

    public RunTrack(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void info() {
        System.out.println("Длина беговой дорожки: " + length+" м");
    }

    public boolean overcome(int distance)
    {
        if (distance<length) return false;
        else return true;
    }
}

class Wall implements Let{

    private float height;

    public Wall(float height) {
        this.height = height;
    }


    public float getHeight() {
        return height;
    }

    public void info() {
        System.out.println("Высота стены: " + height+" м");
    }

    public boolean overcome(float distance)
    {
        if (distance<height) return false;
        else return true;
    }
}




