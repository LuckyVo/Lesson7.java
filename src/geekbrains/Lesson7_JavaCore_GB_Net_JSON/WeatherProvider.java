package geekbrains.Lesson7_JavaCore_GB_Net_JSON;

import geekbrains.ENUM.*;

import java.io.IOException;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException;

}
