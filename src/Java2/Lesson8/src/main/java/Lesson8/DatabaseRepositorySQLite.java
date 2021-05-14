package Lesson8;

import java.sql.*;

public class DatabaseRepositorySQLite {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    DatabaseRepositorySQLite() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lesson8db.db");
            statement = connection.createStatement();
            performCreateDB();
            // insertWeather();
            // readWeather();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeBD();
        }
    }

    private static void performCreateDB() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "city TEXT NOT NULL," +
                "date_time TEXT NOT NULL," +
                "weather_text TEXT NOT NULL," +
                "temperature REAL NOT NULL);");

    }

    public void insertWeather(String city, String date, String weather, double temperature) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lesson8db.db");
            statement = connection.createStatement();

        statement.executeUpdate(
                "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES " +
                        "(\'"+city+"\', \'"+date+"\', \'"+weather+"\',\'"+temperature+"\');"
        );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeBD();
        }

    }

    public void readWeather() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lesson8db.db");
            statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM weather");

        while (resultSet.next())
            System.out.println("#"+
                    resultSet.getInt(1) +" "+
                            resultSet.getString(2) +" "+
                            resultSet.getString(3) +" "+
                            resultSet.getString(4) +" "+
                            resultSet.getDouble(5) +"С"
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeBD();
        }
    }

    private static void closeBD() {

        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
