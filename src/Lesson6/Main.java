package Lesson6;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.ByteString;

import java.io.*;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {
        loadProperties();
        OkHttpClient client=new OkHttpClient();
        HttpUrl url=new HttpUrl.Builder()
                .scheme("http")
                .host(prop.getProperty("BASE_HOST"))
                .addPathSegment(prop.getProperty("FORECAST"))
                .addPathSegment(prop.getProperty("API_VERSION"))
                .addPathSegment(prop.getProperty("FORECAST_TYPE"))
                .addPathSegment(prop.getProperty("FORECAST_PERIOD"))
                .addPathSegment(prop.getProperty("SAINT_PETERSBURG_KEY"))
                .addQueryParameter("apikey",prop.getProperty("API_KEY"))
                .addQueryParameter("language","ru-ru")
                .addQueryParameter("metric","true")
                .build();

        System.out.println(url);

        Request requestHttp =new Request.Builder()
                .addHeader("accept","application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requestHttp).execute().body().string();
        System.out.println(jsonResponse);
        ObjectMapper objectMapper = new ObjectMapper();



        StringReader stringReader=new StringReader(jsonResponse);
        WeatherResponse weatherResponse=objectMapper.readValue(stringReader, WeatherResponse.class);

        System.out.println("Minimum's temperature "+
                weatherResponse.getDailyForecasts().iterator().next().getTemperature().getMinimum().getValue());
        System.out.println("Maximum's temperature "+
                weatherResponse.getDailyForecasts().iterator().next().getTemperature().getMaximum().getValue());
        System.out.println("Daytime weather "+
                weatherResponse.getDailyForecasts().iterator().next().getDay().getIconPhrase());
        System.out.println("Nighttime weather "+
                weatherResponse.getDailyForecasts().iterator().next().getNight().getIconPhrase());


    }

    private static void loadProperties () throws IOException{
        try(FileInputStream fileInputStream = new FileInputStream("src/resources/lesson6.properties")){
            prop.load(fileInputStream);
        }
    }

}
