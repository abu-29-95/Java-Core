package Lesson8;


import Lesson6.DailyForecast;
import Lesson6.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
        import okhttp3.HttpUrl;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
        import java.util.Properties;

public class ExampleMain {

    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException, SQLException {
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
        DailyForecast [] dailyForecasts = weatherResponse.getDailyForecasts().toArray(new DailyForecast[0]);

        DatabaseRepositorySQLiteImpl database =new DatabaseRepositorySQLiteImpl();

        ArrayList<WeatherData> weatherDataArrayList=new ArrayList<>();
         for (DailyForecast i: dailyForecasts){
             weatherDataArrayList.add(new WeatherData("City", i.getDate(),i.getDay().getIconPhrase(),
                     i.getTemperature().getMaximum().getValue().doubleValue()));
         }

         database.filename="lesson8db.db";

        for (WeatherData w: weatherDataArrayList){
            database.saveWeatherData(w);
        }

        database.getAllSavedData();

    }

    private static void loadProperties () throws IOException{
        try(FileInputStream fileInputStream = new FileInputStream("src/resources/lesson6.properties")){
            prop.load(fileInputStream);
        }
    }

}
