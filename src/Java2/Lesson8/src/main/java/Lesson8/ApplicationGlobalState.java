package Lesson8;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationGlobalState {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String API_VERSION = "v1";
    private String apiKey="jwA0Z4rYtjfTu8Ql1EBG9z5vteCXWFO5";
    String idCity="294021";
    private String selectedCity;
    ObjectMapper objectMapper = new ObjectMapper();

    public ApplicationGlobalState (String selectedCity)
    {

        this.selectedCity=selectedCity;
    }

    public String[] detectCityKey() throws IOException {

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", apiKey)
                .addQueryParameter("q", selectedCity)
                .build();


        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);
        //System.out.println(jsonResponse);
        String cityName;
        if (objectMapper.readTree(jsonResponse).size() > 0) {
            cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);

        } else throw new IOException("Server returns 0 cities");

        //System.out.println(objectMapper.readTree(jsonResponse).get(0).at("/Key").asText());

        String [] returnArray=new String[2];
                returnArray [0]= new String(objectMapper.readTree(jsonResponse).get(0).at("/Key").asText());
                returnArray[1]=cityName;
        return returnArray;
    }


}
