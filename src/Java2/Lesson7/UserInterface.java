package Lesson7;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {


    public void runApplication() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название города на английском языке");
            String city = scanner.nextLine();
            checkIsExit(city);
            ApplicationGlobalState applicationGlobalState= new ApplicationGlobalState(city);
            //System.out.println(applicationGlobalState.detectCityKey());
            ForecastWeather forecastWeather=new ForecastWeather( applicationGlobalState.detectCityKey());



        }
    }

    private void checkIsExit(String result) {
        if (result.toLowerCase().equals("выход") || result.toLowerCase().equals("exit")) {
            System.out.println("Завершаю работу");
            System.exit(0);
        }
    }





}
