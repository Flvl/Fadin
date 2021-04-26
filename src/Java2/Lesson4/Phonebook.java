package Java2.Lesson4;

import java.util.HashMap;

public class Phonebook<K,V> extends HashMap<K,V> {

    private K phone;
    private V name;


    public Phonebook (){
        super();
    }

    public void add(K phone, V name){

        super.put(phone, name);
    }

    public void myGet( V name){
        for (K s: this.keySet())
            if (super.get(s)==name)
        System.out.println(name+": "+s);
    }


}
