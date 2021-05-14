package Lesson8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForecastWeather {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";

    //295212 Saint Petersburg
    //294021 Moscow
    private static final String apiKey="jwA0Z4rYtjfTu8Ql1EBG9z5vteCXWFO5";
    private String idCity;

    DatabaseRepositorySQLite databaseRepositorySQLite=new DatabaseRepositorySQLite();


    public ForecastWeather( String idCity, String nameCity)  throws IOException, SQLException

    {
        this.idCity=idCity;

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();



        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(idCity)
                .addQueryParameter("apikey", apiKey)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        Request request=new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .get()
                .build();

        Response response=client.newCall(request).execute();
        //System.out.println(response.code());
        String jsonAll=response.body().string();

        ObjectMapper objectMapper = new ObjectMapper();

        //System.out.println("!");
        JsonNode dailyForecasts = objectMapper
                .readTree(jsonAll)
                .at("/DailyForecasts");
        //System.out.println(dailyForecasts.toString());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<WeatherResponse> weatherList = objectMapper.readValue(dailyForecasts.toString(), new TypeReference<List<WeatherResponse>>() {});

        for (int i=0; i<weatherList.size(); i++)
            //System.out.println(weatherList.get(i).info());
            databaseRepositorySQLite.insertWeather(nameCity,weatherList.get(i).getDate(),weatherList.get(i).getWeather(),weatherList.get(i).getTemperature());


    }

}
