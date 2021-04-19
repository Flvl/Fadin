package Java2.Lesson2;

public class Lesson2 {

    public static void main(String args[]) {

        String[][] myArray = new String[4][6];
        int[][] myArray2 = new int[4][4];


        for (int i = 0; i < myArray.length; i++)
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = String.valueOf(i + j);
            }
        myArray[2][1] = "356";
        myArray[0][1] = "Hello";
        myArray[1][0] = "1Hello";
         myArray2=myMethod(myArray);

        int summ = 0;
        for (int i = 0; i < myArray2.length; i++)
            for (int j = 0; j < myArray2[i].length; j++) {
               // System.out.println(myArray2[i][j]);
                summ += myArray2[i][j];
            }
        System.out.print("Сумма=" + summ);
    }

    public static int[][] myMethod(String[][] stringArray)
    {
        int[][] intArray = new int[4][4];

        for (int i = 0; i < stringArray.length; i++)
            for (int j = 0; j < stringArray[i].length; j++) {
                try {

                    if ((i >= 4) || (j >= 4)) {

                        throw new MyArraySizeException(stringArray.length, stringArray[i].length);
                    }
                        else
                        if ((i+1== stringArray.length)&(i<3) || (j+1== stringArray[i].length)&(j<3))

                        {   if (isDigit(stringArray[i][j],i,j))
                            intArray[i][j] = Integer.parseInt(stringArray[i][j]);
                            throw new MyArraySizeException(stringArray.length, stringArray[i].length);
                        }


                    if (isDigit(stringArray[i][j],i,j))
                    intArray[i][j] = Integer.parseInt(stringArray[i][j]);
                } catch ( MyArraySizeException e) {
                }
            }
        return intArray;
    }

    public static boolean isDigit(String s, int i, int j) throws MyArrayDataException
    {
        String digits="[0-9]+";
         try {
             if(s.matches(digits))
                return true;
         else
            {
             throw new MyArrayDataException(s,i,j);
            }
         }
         catch (MyArrayDataException e){
             return false;
         }
         }
}
