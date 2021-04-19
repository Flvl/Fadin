package Java2.Lesson1;

public class RunTrack implements Let {

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
