package Java2.Lesson5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Lesson5 {

    public static void main(String args[]){

        AppData appData= new AppData(new String[5],new int[5][10]);
        appData.full();
        appData.info();
        appData.save("test1.txt");
        AppData loadData= new AppData();
        loadData.load("test.txt");
        loadData.info();



    }
}
