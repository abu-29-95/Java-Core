package Lesson8.project;



import Lesson8.project.enums.Periods;
import Lesson8.WeatherData;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherProvider {

    WeatherData getWeather(Periods periods) throws IOException, SQLException;

    WeatherData getAllFromDb() throws IOException;

}
