package L4.home;

public class Lesson4 {
    public static void main(String[] args) {
        Person person1 = new Person("Ivanon I.I.", "Director", "+7 (903) 123-45-67", 140009, 45);
        System.out.println("ФИО: "+ person1.getName()+ "Должность: "+person1.getWork());

        Person [] myCompany = new Person[5];
        myCompany[0]=person1;
        myCompany[1]= new Person("Ivanon A.I.", "Director", "+7 (903) 123-45-67", 80000, 23);
        myCompany[2]= new Person("Sidorov S.S.", "Engineer", "+7 (903) 123-45-67", 85000, 40);
        myCompany[3]= new Person("Pavlova P.P.", "Accountant", "+7 (903) 123-45-67", 110000, 34);
        myCompany[4]= new Person("Koval K.K.", "Secretary", "+7 (903) 123-45-67", 80000, 29);

        for (int i=0; i< myCompany.length; i++)
        {
            if (myCompany[i].getYear()>=40) System.out.println(myCompany[i].getId()+".ФИО: "+ myCompany[i].getName()+ "\nДолжность: "+myCompany[i].getWork()+"\nЗП "+myCompany[i].getZp()+"\nВозраст"+myCompany[i].getYear());
        }

        for (int i=0; i< myCompany.length; i++)
        {

            if (myCompany[i].getYear()>=35) {
                System.out.println(myCompany[i].getId()+".ФИО: " + myCompany[i].getName() + "\nСтарая ЗП " + myCompany[i].getZp());
                myCompany[i].setZP(myCompany[i].getZp()+10000);
                System.out.println("Новая ЗП " + myCompany[i].getZp());
                System.out.println("id=" + myCompany[i].getId());
            }
        }

        for (int i=0; i< myCompany.length; i++)
        {
                System.out.println("id=" + myCompany[i].getId());

        }

    }
}
