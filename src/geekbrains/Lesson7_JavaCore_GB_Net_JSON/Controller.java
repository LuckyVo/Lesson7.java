package geekbrains.Lesson7_JavaCore_GB_Net_JSON;

import geekbrains.ENUM.Functionality;
import geekbrains.ENUM.Periods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    WeatherProvider weatherProvider = new YandexWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_2_DAYS);
        variantResult.put(3, Functionality.GET_WEATHER_IN_NEXT_3_DAYS);
        variantResult.put(4, Functionality.GET_WEATHER_IN_NEXT_4_DAYS);
        variantResult.put(5, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(6, Functionality.GET_WEATHER_IN_NEXT_6_DAYS);
        variantResult.put(7, Functionality.GET_WEATHER_IN_NEXT_7_DAYS);
    }

    public void onUserInput(String limit) throws IOException {
        int command = Integer.parseInt(limit);
        if (!variantResult.containsKey(command)) {
            throw new IOException("На прогноз больше 7 дней, стоит обратиться к бабке гадалке.");
        }

        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
            case GET_WEATHER_IN_NEXT_2_DAYS:
            case GET_WEATHER_IN_NEXT_3_DAYS:
            case GET_WEATHER_IN_NEXT_4_DAYS:
            case GET_WEATHER_IN_NEXT_5_DAYS:
            case GET_WEATHER_IN_NEXT_6_DAYS:
            case GET_WEATHER_IN_NEXT_7_DAYS:
                getCustomWeather();
                break;
        }
    }

    public void getCustomWeather() throws IOException {
        weatherProvider.getWeather(Periods.CUSTOM);
    }



}
