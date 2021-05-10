package Lesson7;


import com.fasterxml.jackson.annotation.JsonCreator;

import com.fasterxml.jackson.annotation.JsonProperty;


public class WeatherResponse {

    private String date;
    private Day day;
    private Temperature temperature;


    @JsonCreator
    public WeatherResponse(@JsonProperty("Date") String date, @JsonProperty("Day") Day day, @JsonProperty("Temperature") Temperature temperature ){

        this.date=date;
        this.day=day;
        this.temperature=temperature;
    }
    public WeatherResponse(){

    }

    public String getDate (){
        return date;
    }

    public String info (){

        return  "Дата "+date+" "+ day.getIconPhrase()+" "+temperature.getTemperature();
    }
}
