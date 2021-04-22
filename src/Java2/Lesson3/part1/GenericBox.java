package Java2.Lesson3.part1;

public class GenericBox<T> {

    private T[] obj;

    public GenericBox(T... оbj) {
        this.obj = оbj;
    }

    public void show(){
        for (int i = 0; i < obj.length; i++) {
            System.out.print(obj[i]);
        }
    }
    public void swap(int i, int j)
    {

        try {
            if((i>= obj.length)||(j>= obj.length))
                throw new ArrayIndexOutOfBoundsException();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println((i+1)+" или "+(j+1)+" превышают длину массива "+ obj.length);
            return;
        }
        T str;
        str=obj[i];
        obj[i]=obj[j];
        obj[j]=str;

    }


}
