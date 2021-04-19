package Java2.Lesson1;

interface Participant {
    void info();
    void start(RunTrack runTrack);
    void start(Wall wall);
    boolean finish(RunTrack runTrack);
    boolean finish(Wall wall);

}
