package Lesson7;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {
    public static final int GAME_MODE_HVH = 0;
    public static final int GAME_MODE_HVA = 1;

    GameMap() {

        setBackground(new Color(100, 100, 100));
    }

    void startGame(int modeGame, int mapSize, int winLength, int aiComplexity) {
        System.out.println("modeGame= " + modeGame + "\nmapSize= " + mapSize + "\nwinLength=" + winLength + "\nComplexity= " + aiComplexity);

    }


}
