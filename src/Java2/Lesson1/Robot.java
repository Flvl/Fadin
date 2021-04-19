package Java2.Lesson1;

public class Robot implements  Participant {

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