package Java2.Lesson1;

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
