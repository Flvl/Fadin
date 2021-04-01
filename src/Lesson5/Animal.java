package Lesson5;

import java.util.Random;

public abstract class Animal {

    protected String name;
    protected double limitDistanceRun;
    protected double limitDistanceSwim;
    protected double limitDistanceJump;

 //   protected int distanceRun;
  //  protected int distanceSwim;
   // protected int distanceJump;




    public Animal(String name, double limitDistanceRun, double limitDistanceSwim, double limitDistanceJump) {
        this.name=name;
        this.limitDistanceRun=limitDistanceRun+Math.random()*limitDistanceRun;
        this.limitDistanceSwim=limitDistanceSwim+Math.random()*limitDistanceSwim;
        this.limitDistanceJump=limitDistanceJump+Math.random()*limitDistanceJump;
    }


    public void run (double distanceRun) {
        if (distanceRun<=limitDistanceRun)
        System.out.println(name + " пробежал!");
        else
            System.out.println("Увы! "+ name + " не пробежал!");
    };
    public void swim (double distanceSwim) {
        if (distanceSwim<=limitDistanceSwim)
            System.out.println(name + " проплыл!");
        else
            System.out.println("Увы! "+ name + " не проплыл!");
    };
    public void jump (double distanceJump) {
        if (distanceJump<=limitDistanceJump)
            System.out.println(name + " перепрыгнул!");
        else
            System.out.println("Увы! "+ name + " не перепрыгнул!");
    };
}