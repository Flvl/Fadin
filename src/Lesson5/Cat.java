package Lesson5;

public class Cat extends Animal {

    public  Cat (String name, int distanceRun, int distanceSwim, int distanceJump) {
        super(name, distanceRun, distanceSwim, distanceJump);
    }

    @Override
    public void swim (double a)
    {
        System.out.println("Коты не умеют плавать");
    }
}
