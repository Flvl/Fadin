package Java2.Lesson5;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AppData {
    private String[] header;
    private int[][] data;
    private String delimiter=";";

    public AppData (String[] header , int[][] data)
    {
        this.header=header;
        this.data=data;
    }
    public AppData ()
    {
        this.header=new String[5];
        this.data=new int[5][5];
    }

    public void full ()
    {
        for (int i=0; i< header.length; i++)
            header[i]="Values "+(i+1);

        for (int i=0; i< data.length; i++)
            for (int j=0; j< data[i].length;j++)
                data[i][j]=j+i;
    }

    public void full (String[] loadHeader, ArrayList <String> strValues)
    {
        header= new String[loadHeader.length];
        for (int i=0; i< header.length; i++)
            header[i]=loadHeader[i];

        int iMax=strValues.size();
        int jMax= strValues.get(0).split(delimiter).length;
        data=new int[iMax][jMax];
        //System.out.println(iMax+" "+jMax);
        String [] str;
        for (int i=0; i< data.length; i++)
        {str =strValues.get(i).split(delimiter);
            for (int j=0; j< data[i].length;j++)
                data[i][j]=Integer.parseInt(str[j]);
        }
    }

    public void save (String fileWriter){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileWriter)))
        {
            for (int i=0; i< header.length; i++)
                writer.write(header[i]+";");

            for (int i=0; i< data.length; i++)
            {
                writer.write("\n");
                for (int j=0; j< data[i].length;j++)
            writer.write(data[i][j]+";");
            }
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
    public void info (){

        System.out.println("Вывод из памяти: ");
            for (int i=0; i< header.length; i++)
                System.out.print(header[i]+";");

            for (int i=0; i< data.length; i++)
            {
                System.out.println("");
                for (int j=0; j< data[i].length;j++)
                    System.out.print(data[i][j]+";");
            }
        }


    public void load(String loadFile)
    {
        System.out.println("Загружаю файл "+loadFile);
        String[] loadHeaders;
        int i=0;
        ArrayList<String> strValues= new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(loadFile))) {
            String str;
            str = reader.readLine();
            loadHeaders=str.split(delimiter);
            while ((str = reader.readLine()) != null) {
                    strValues.add(str);
                    System.out.println(str);
            }
            this.full(loadHeaders, strValues);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
