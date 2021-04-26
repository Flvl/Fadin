package Java2.Lesson4;

import java.util.HashMap;

public class Lesson4_part2 {

    public static void main(String args[]){

        Phonebook<String,String> myPhonebook=new Phonebook<>();
        //myPhonebook.put("+7903567891","Ivanov");
        myPhonebook.add("+7903567891","Ivanov");
        myPhonebook.add("+7536457676","Belov");
        myPhonebook.add("+7769894368","Petrov");
        myPhonebook.add("+7547568678","Sidorov");
        myPhonebook.add("+7456858456","Sidorova");
        myPhonebook.add("+7325645758","Nikolaev");
        myPhonebook.add("+7926867967","Ivanov");


        //System.out.println(myPhonebook);
        myPhonebook.myGet("Ivanov");
        myPhonebook.myGet("Sidorova");
        myPhonebook.myGet("Kurnikova");
    }
}
