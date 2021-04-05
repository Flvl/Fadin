package L6;

import java.io.*;
import java.util.Scanner;

public class Lesson6 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args)
    {

      writeToFile("src/L6/file/file1.txt", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec at.", false);
       writeToFile("src/L6/file/file2.txt", "Ut vulputate posuere eleifend. Mauris tempor purus luctus accumsan viverra. Nam diam dui, vulputate id purus eget", false);
        unionFiles("src/L6/file/file1.txt","src/L6/file/file2.txt","src/L6/file/file3.txt");
        readFromFile("src/L6/file/file3.txt");
        System.out.println("\nСлово присутствует в файле: "+searchInFile("src/L6/file/file1.txt", "amet"));
System.out.println(searchInPack("src/L6/file","amet"));

    }

    private static void unionFiles(String nameFile1, String nameFile2, String nameFile3)
    {
        try{
            writeToFileSymbol(nameFile3,0, false);
            FileInputStream fileInputStream1 = new FileInputStream(nameFile1);
            FileInputStream fileInputStream2 = new FileInputStream(nameFile2);
            int tmp;
            while ((tmp= fileInputStream1.read())!=-1)
            {
        writeToFileSymbol(nameFile3,tmp, true);
            }
            fileInputStream1.close();
            while ((tmp= fileInputStream2.read())!=-1)
            {
                writeToFileSymbol(nameFile3,tmp, true);
            }
            fileInputStream2.close();
        }catch (IOException ioException)
        {System.out.println("File not found"); }
    }

    private static void readFromFile(String nameFile)
    {
        try{
            FileInputStream fileInputStream = new FileInputStream(nameFile);
            int tmp;
            while ((tmp= fileInputStream.read())!=-1)
            System.out.print ((char)tmp);
            fileInputStream.close();
        }catch (IOException ioException)
        {System.out.println("File not found"); }

    }

    private static void writeToFileSymbol(String nameFile, int Symbol,Boolean addText){
        try{
            FileOutputStream file = new FileOutputStream(nameFile,addText);
            file.write(Symbol);
            file.close();
        } catch (IOException ioException)
        {System.out.println("File not found"); }

    }

    private static void writeToFile(String nameFile, String text,Boolean addText){
        try{
            FileOutputStream file = new FileOutputStream(nameFile,addText);
            PrintStream printStream= new PrintStream(file);
            printStream.print(text);
            printStream.flush();
            printStream.close();
            file.close();
        } catch (IOException ioException)
        {System.out.println("File not found"); }

    }

    private static boolean searchInFile(String nameFile, String word)
    {
        String tmpWord="";
        try{
            FileInputStream fileInputStream = new FileInputStream(nameFile);
            int tmp;

            while ((tmp= fileInputStream.read())!=-1)
            {
                tmpWord =tmpWord+ (char) tmp;
                if (tmpWord.length() == word.length())
                    if (tmpWord.equals(word)) return true;
                    else tmpWord=tmpWord.substring(1);
            }
            fileInputStream.close();
            return false;
        }catch (IOException ioException)
        {System.out.println("File not found");
        return false;}

    }
    private static boolean searchInPack(String namePath, String word) {

        File folder = new File(namePath);
        for (File fileInFolder : folder.listFiles())
        {
            if (searchInFile(fileInFolder.getName(), word)) return true;
        }
        return false;
    }



}
