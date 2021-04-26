package Java2.Lesson4;

import java.util.*;

public class Lesson4 {

    public static void main(String args[])
    {
        ArrayList<String> arrayListTown=new ArrayList<>(Arrays.asList("Москва","Лондон", "Париж","Оттава","Сидней","Москва","Москва","Вашингтон","Берлин","Токио","Бразилиа","Мехико","Стокгольм","Рим","Берлин","Пекин","Улан-Батор","Рим"));

        System.out.println(arrayListTown.size());
        uniqTown(arrayListTown);
        countTown(arrayListTown);
    }

    public static void uniqTown (ArrayList<String> arrayList){

        System.out.println("Города, которые встречаются один раз: ");
        for (String s: arrayList)
            if (Collections.frequency(arrayList,s)==1) System.out.print(s+" ");
    }

    public static void countTown (ArrayList<String> arrayList){

        System.out.println("\nСчетчик: ");
        HashMap<String,Integer> arrayTown1=new HashMap<>();
        for (String s: arrayList)
            if (!arrayTown1.containsKey(s))
            arrayTown1.put(s,1);
            else arrayTown1.put(s, arrayTown1.get(s)+1);

        //for (String s: arrayTown1.keySet()) System.out.print(s+" "+arrayTown1);
        System.out.println(arrayTown1);

    }
}
