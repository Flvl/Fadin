package L3.home;

import java.util.Random;
import java.util.Scanner;

public class Lesson3_5na5 {

    public static char[][] map;
    public static int sizeMapX;
    public static int sizeMapY;

    public static char human='X';
    public static char ai='O';
    public static char empty='*';

    public static Scanner scanner = new Scanner(System.in);
    public static Random random=new Random ();

    public static void createMap (int sizeX, int sizeY)
    {
     sizeMapX=sizeX;
     sizeMapY=sizeY;
     map=new char[sizeMapX][sizeMapX];

     for (int y=0; y<sizeMapY; y++)
         for (int x=0; x<sizeMapX; x++)
             map[y][x]=empty;

    }

    public static void printMap ()
    {
        System.out.println("____________");
        for (int y=0; y<sizeMapY; y++)
        { System.out.println();
            for (int x=0; x<sizeMapX; x++)
                System.out.print(map[y][x]+"|");
        }
        System.out.println("\n____________");

    }
    public static void turnHuman ()
    {
        int x;
        int y;
        do {
            System.out.print("Введите координату Х: ");
            x = scanner.nextInt() - 1;
            System.out.print("Введите координату У: ");
            y = scanner.nextInt() - 1;
        }
        while
        (!validCell(y,x)||(!emptyCell(y,x)));
         map[y][x]=human;
    }

    public static void turnAi ()
    {
        int x;
        int y;
        do {
            x = random.nextInt(sizeMapX);
            y = random.nextInt(sizeMapY);
        }
        while
        (!emptyCell(y,x));
        map[y][x]=ai;

    }
public static boolean validCell (int y, int x)
{
    return x>=0 && x<sizeMapX && y>=0 && y<sizeMapY;
}


public static boolean checkWin (char player) {
    int check = 0;
    for (int i = 0; i < sizeMapX; i++) {
        if (map[i][i] == player)
        {
            check++;
            if (check == 4) return true;
        }
            else check = 0;

    }
    check = 0;
    for (int i = 0; i < sizeMapX; i++) {
        if (map[sizeMapX - i - 1][i] == player)
        {
            check++;
            if (check == 4) return true;
        }
            else check = 0;
    }
    check=0;
    for (int x=0; x<sizeMapX; x++)
    {
        check=0;
        for (int y=0; y<sizeMapY; y++)
        if (map[y][x] == player)
        {
            check++;
            if (check == 4) return true;
        }
        else check = 0;
    }

    check=0;
    for (int y=0; y<sizeMapY; y++)
    {
        check=0;
        for (int x=0; x<sizeMapX; x++)
            if (map[y][x] == player)
            {
                check++;
                if (check == 4) return true;
            }
            else check = 0;
    }

    return false;
}

    public static boolean isDraw() {
        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                if (map[y][x] == empty) {
                    return false;
                }
            }
        }
        return true;
    }


public static boolean emptyCell (int y, int x)
{
    return map[y][x]==empty;
}

    public static void main (String[] args){
    createMap(5, 5);
        while (true) {
            turnHuman();
            printMap();
            if (checkWin(human)) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

            //turnAi();
            printMap();
            if (checkWin(ai)) {
                System.out.println("AI win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }
        }


    }
}
