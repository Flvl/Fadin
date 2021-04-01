package Lesson5;

public class Bird extends Animal {


    public  Bird (String name, double distanceRun, double distanceSwim, double distanceJump) {
        super(name, distanceRun, distanceSwim, distanceJump);
    }

    @Override
    public void swim (double a)
    {
        System.out.println("Птицы не умеют плавать");
    }
}
