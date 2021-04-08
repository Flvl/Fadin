package Lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private final int WIN_WIDTH=300;
    private final int WIN_HEIGHT=400;
    private JRadioButton playWithHuman;
    private JRadioButton playWithAi;
    private JSlider sliderMapSizeSetup;
    private JSlider sliderWinLengthSetup;
    private JSlider sliderAiComplexity;

    private JButton confirmUserSettings;

    private final int MIN_MAP_SIZE=3;
    private final int MAX_MAP_SIZE=10;
    private final int MIN_WIN_LENGTH=3;

private MainWindow mainWindow;
    Settings(MainWindow mainWindow)
    {
        this.mainWindow=mainWindow;
        setupWindow(mainWindow);
modeGameController();
mapSetupController();
confirmUserSettings();
    }

    private void modeGameController(){
        String complex="light";
        add(new JLabel("Choose mode game:"));
        playWithAi=new JRadioButton("Human vs Ai",true);
        playWithHuman=new JRadioButton("Human vs Human");
        ButtonGroup gameModeButtonGroup= new ButtonGroup();
        gameModeButtonGroup.add(playWithAi);
        gameModeButtonGroup.add(playWithHuman);


        JLabel labelAIComplexity=new JLabel("Ai complexity is "+ complex);
        sliderAiComplexity=new JSlider(0,2,0);


        playWithAi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sliderAiComplexity.setVisible(true);
                labelAIComplexity.setVisible(true);
            }
        });

        playWithHuman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sliderAiComplexity.setVisible(false);
                labelAIComplexity.setVisible(false);
            }
        });


        //Отклик слайдера со сложностью Ai
        sliderAiComplexity.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String complex="light";
                switch (sliderAiComplexity.getValue()) {
                    case 0:
                        complex = "light";
                        break;
                    case 2:
                        complex = "hard";
                        break;
                    default:
                        complex = "normal";
                        break;
                }
                labelAIComplexity.setText("Ai complexity is "+complex);
            }
        });
        add(playWithHuman);
        add(playWithAi);
        add(labelAIComplexity);
        add(sliderAiComplexity);

    }
    private void mapSetupController(){
        JLabel labelMapSize=new JLabel("Map size is "+ MIN_MAP_SIZE);
        JLabel labelWinLength=new JLabel("Win length is "+ MIN_WIN_LENGTH);


        sliderMapSizeSetup=new JSlider(MIN_MAP_SIZE,MAX_MAP_SIZE,MIN_MAP_SIZE);
        sliderWinLengthSetup=new JSlider(MIN_WIN_LENGTH,MIN_MAP_SIZE,MIN_MAP_SIZE);


//Отклик слайдера с размером карты
        sliderMapSizeSetup.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentMapSize=sliderMapSizeSetup.getValue();
                labelMapSize.setText("Map size is "+ currentMapSize);
                sliderWinLengthSetup.setMaximum(currentMapSize);
            }
        });
//Отклик слайдера с победной серией
        sliderWinLengthSetup.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            labelWinLength.setText("Win length is "+ sliderWinLengthSetup.getValue());
            }
        });



        add (new JLabel("Choose map size"));
        add(labelMapSize);
        add(sliderMapSizeSetup);
        add(labelWinLength);
        add(sliderWinLengthSetup);

    }
    private void confirmUserSettings(){
        confirmUserSettings=new JButton("start Game with settings");
        confirmUserSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectUserSettings();
            }
        });
        add(confirmUserSettings);

    }
    private void collectUserSettings(){
        int gameMode;
        int mapSize=sliderMapSizeSetup.getValue();
        int winLen=sliderWinLengthSetup.getValue();
        int aiComplexity=sliderAiComplexity.getValue();
        if (playWithHuman.isSelected()){
            gameMode=GameMap.GAME_MODE_HVH;
        }
            else if (playWithAi.isSelected()){gameMode=GameMap.GAME_MODE_HVA;}
                else{
                    throw new RuntimeException("Incorrect game mode");
        }
                mainWindow.startGameWithUserSetting(gameMode,mapSize, winLen, aiComplexity);
                setVisible(false);
        }

    private void setupWindow(MainWindow mainWindow){
        Rectangle mainWindowParams=mainWindow.getBounds();
        int posWindowX= (int)mainWindowParams.getCenterX()-WIN_WIDTH/2;
        int posWindowY= (int)mainWindowParams.getCenterY()-WIN_HEIGHT/2;
        setSize(WIN_WIDTH,WIN_HEIGHT);
        setLocation(posWindowX,posWindowY);
        setTitle("Settings");
        setResizable(false);
        setLayout(new GridLayout(14,1));


    }
}
