import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

public class Lesson1 {
    public static void main(String[] args) {
        System.out.println(FirstCalculate(1, 1, 1, 80));
        System.out.println("Сумма в пределе от 10 до 20 включительно: " + SecondCalculate(5, 5));
        ThirdCalculate(-2);
        NameCalculate("Александр");
        LeapYear(1900);
    }

    public static float FirstCalculate(int a, int b, int c, int d) {
        if (d == 0) {
            System.out.print("Деление на ");
            return 0;
        } else {
            return a * (b + ((float)c / d));
        }
    }

    public static boolean SecondCalculate(int a, int b) {
        if ((a + b <= 20) && (a + b >= 10))
            return true;
         else
             return false;

    }

    public static void ThirdCalculate(int a) {
        if (a < 0)
            System.out.println("Число отрицательное");
         else
            System.out.println("Число положительное");
    }

    public static void NameCalculate( String a) {
        String Hello="Привет," + a + "!";
        System.out.println(Hello);
    }

    public static void LeapYear( int a)
    {
        if ((a%4==0)&&(a%100!=0)||(a%400==0)) System.out.println("Год "+a+" високосный");
        else System.out.println("Год "+a+" не високосный");
    }


}
