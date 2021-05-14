package Lesson8;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {


    public void runApplication() throws IOException, SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название города на английском языке или \"Read weather\" для чтения прогноза из БД");
            String city = scanner.nextLine();
            checkIsExit(city);
            checkIsReadWeather(city);
            ApplicationGlobalState applicationGlobalState= new ApplicationGlobalState(city);
            //System.out.println(applicationGlobalState.detectCityKey());
            String[] returnCityArray=applicationGlobalState.detectCityKey();
            ForecastWeather forecastWeather=new ForecastWeather( returnCityArray[0],returnCityArray[1]);

        }
    }

    private void checkIsExit(String result) {
        if (result.toLowerCase().equals("выход") || result.toLowerCase().equals("exit")) {
            System.out.println("Завершаю работу");
            System.exit(0);
        }
    }
        private void checkIsReadWeather(String result) throws SQLException{
            if (result.toLowerCase().equals("read weather")) {
                DatabaseRepositorySQLite databaseRepositorySQLite=new DatabaseRepositorySQLite();
                databaseRepositorySQLite.readWeather();
                System.exit(0);
            }
    }


}
