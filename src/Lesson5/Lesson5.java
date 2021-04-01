package Lesson5;

public class Lesson5 {

    public static void main(String[] args) {

        Cat cat = new Cat("myCat", 200, 0, 2);
        Dog dog = new Dog("myDog", 500, 10, 0.5);
        Horse horse = new Horse("myHorse", 1500, 100, 3);
        Bird bird = new Bird("myBird", 5, 0, 0.2);

        cat.run(5);
        horse.jump(5);
        bird.jump(0.3);
        bird.swim(300);
        dog.jump(0.6);
    }


}
