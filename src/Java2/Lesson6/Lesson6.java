package Lesson6;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Lesson6 {

    public static void main(String arg[]) throws IOException {

       OkHttpClient client = new OkHttpClient()
        .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();


        //295212 Saint Petersburg
        //294021 Moscow
        Request request=new Request.Builder().url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=jwA0Z4rYtjfTu8Ql1EBG9z5vteCXWFO5")
                .get()
                .build();

        Response response=client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
        /*String [] forecast=response.body().string().split(":|,|T");
        for (int i=0; i<forecast.length;i++)
        if (forecast[i].contains("\"Date"))
            System.out.println("Date: "+forecast[i+1]);
        else
            if (forecast[i].contains("Value"))
        System.out.println("Value: "+forecast[i+1]+" F");*/

    }
}
