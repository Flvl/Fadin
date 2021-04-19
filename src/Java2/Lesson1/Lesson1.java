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



















