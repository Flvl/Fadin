public class Lesson2 {
    public static void main(String[] args)
    {
        //Задание 1
        int[] firstArray= {1,1,0,0,1,0,1,1,0,0};
        readArray(firstArray);
        firstWork(firstArray);
        readArray(firstArray);

        //Задание 2
        int [] secondArray = new int[8];
        for (int i=0, j=1; i<secondArray.length; i++, j=j+3) {
            secondArray[i]=j;
        }
        readArray(secondArray);

        //Задание 3
        int[] thirdArray= {1,5,3,2,11,4,5,2,4,8,9,1};
        thirdWork(thirdArray);
        readArray(thirdArray);

        //Задание 4
        System.out.println("Минимальное значение в третьем массиве: "+ minInArray(thirdArray));
        System.out.println("Максимальное значение в третьем массиве: "+ maxInArray(thirdArray));

        //Задание 5
        int[][] fifthArray=new int[10][10];
        fifthWork(fifthArray);
        readArray2(fifthArray);

        //Задание 6
        int[] sixthArray= {1,2,3,4,5,6};
        readArray(sixthWork(sixthArray, 16));

        //Задание 7
        int[] seventhArray= {1,2,3,4,5,6,7};
        readArray(seventhWork(seventhArray, 2));
    }

    public static void readArray (int[] inputArray)
    {
        for (int i= 0; i<inputArray.length; i++)
            System.out.print(inputArray[i]+"\t");
        System.out.println();

    }
    public static void readArray2 (int[][] inputArray)
    {
        for (int i= 0; i<inputArray.length; i++)
        {
            {for (int j= 0; j<inputArray[i].length; j++)
            System.out.print(inputArray[i][j]+"\t");
        }
        System.out.println();
        }

    }

    public static int[] firstWork (int[] firstArray)
    {
        for (int i= 0; i<firstArray.length; i++) {
            firstArray[i] = (firstArray[i]==0) ? 1 : 0;
        }
        return firstArray;
    }
    public static int[] thirdWork (int[] inputArray)
    {
        for (int i=0; i<inputArray.length; i++)
        {
            if (inputArray[i]<6)
                inputArray[i]=inputArray[i]*2;
        }
        return inputArray;
    }
    public static int maxInArray (int[] inputArray)
    {
        int max=inputArray[0];
        for (int i=1; i<inputArray.length; i++)
        {
            if (max<inputArray[i]) max=inputArray[i];
        }
        return max;
    }
    public static int minInArray (int[] inputArray)
    {
        int min=inputArray[0];
        for (int i=1; i<inputArray.length; i++)
        {
            if (min>inputArray[i]) min=inputArray[i];
        }
        return min;
    }
    public static int[][] fifthWork (int [][] inputArray)
    {
        for (int i=0; i<inputArray.length; i++)
        {
            for (int j=0; j<inputArray[i].length;j++)
            {
                if ((i==j)||(inputArray.length-1==i+j)) inputArray[i][j]=inputArray.length;
            }
        }
        return inputArray;
    }

    public static int [] sixthWork (int [] inputArray, int a)
    {
        if (a<0) a=a-(a/inputArray.length-1)*inputArray.length;
                else
        if (a>inputArray.length) a=a-(a/inputArray.length)*inputArray.length;// на случай если задать сдвиг больше, чем длина массива

       int [] helpArray=new int[inputArray.length];
        for (int i= 0; i<inputArray.length; i++)
        {
            if (i+a<inputArray.length)
                helpArray[i+a]=inputArray[i];
            else helpArray[i+a-inputArray.length]=inputArray[i];
        }
        return helpArray;
    }

    public static int [] seventhWork (int [] inputArray, int a)
    {
        int b;
        if (a<0) a=a-(a/inputArray.length-1)*inputArray.length;
        else
        if (a>inputArray.length) a=a-(a/inputArray.length)*inputArray.length;// на случай если задать сдвиг больше, чем длина массива
for (int j=0; j<a; j++) {
    for (int i = 0; i < inputArray.length - 1; i++) {
        b = inputArray[0];
        inputArray[0] = inputArray[i + 1];
        inputArray[i + 1] = b;
    }
}
        return inputArray;
    }
}
