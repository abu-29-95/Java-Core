package Lesson7.project;




import Lesson7.project.enums.Periods;
import Lesson7.weatherFor5Day.DailyForecast;
import Lesson7.weatherFor5Day.WeatherResponse;
import Lesson7.weatherNow.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";

    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            ObjectMapper objectMapper1 = new ObjectMapper();

            String jsonString = response.body().string();
            System.out.println(jsonString);

            Weather [] weather = objectMapper1.readValue(jsonString, Weather[].class);
            for(int i=0; i<weather.length;i++){
                System.out.println("Weather text " +weather[i].getWeatherText());
                System.out.println("Temperature " + weather[i].getTemperature().getMetric().getValue()
                +weather[i].getTemperature().getMetric().getUnit());
            }

        } else if(periods.equals(Periods.FIVE_DAYS)){
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(FORECAST_TYPE)
                    .addPathSegment(FORECAST_PERIOD)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            ObjectMapper objectMapper1 = new ObjectMapper();

            String jsonString = response.body().string();
            System.out.println(jsonString);

            WeatherResponse weather= objectMapper1.readValue(jsonString, WeatherResponse.class);
            DailyForecast [] dailyForecasts= weather.getDailyForecasts().toArray(new DailyForecast[0]);

            for (int i=0;i< dailyForecasts.length;i++){
                System.out.println("City "+ApplicationGlobalState.getInstance().getSelectedCity()+"/"+
                        "Date "+ dailyForecasts[i].getDate()+"/"+
                        "Daytime weather "+ dailyForecasts[i].getDay().getIconPhrase()+"/"+
                        "Nighttime weather "+ dailyForecasts[i].getNight().getIconPhrase()+"/"+
                        "Maximum's temperature "+dailyForecasts[i].getTemperature().getMaximum().getValue()+
                                dailyForecasts[i].getTemperature().getMaximum().getUnit()+"/"+
                        "Minimum's temperature "+dailyForecasts[i].getTemperature().getMinimum().getValue()+
                        dailyForecasts[i].getTemperature().getMinimum().getUnit());
                System.out.println("-----------------------------------------------------------------");
            }

        }
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
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

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }
}