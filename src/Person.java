package L4.home;

public class Person {
    private String name;
    private String work;
    private String phone;
    private int zp;
    private int year;
    private int id;
    private static int innerId=0;


    public Person (String name, String work, String phone, int zp, int year){

        this.name=name;
        this.work=work;
        this.phone=phone;
        this.zp=zp;
        this.year=year;
        innerId++;
        this.id=innerId;
    }

    public String getName (){return name;}
    public String getWork (){return work;}
    public String getPhone (){return phone;}
    public int getZp (){return zp;}
    public int getYear (){return year;}
    public int getId (){return id;}

//    public void setId ()
//    {id++;
//        this.id=id;}
    public void setZP (int zp) {this.zp=zp;}


}