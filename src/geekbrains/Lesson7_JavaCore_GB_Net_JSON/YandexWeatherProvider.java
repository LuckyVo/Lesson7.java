package geekbrains.Lesson7_JavaCore_GB_Net_JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import geekbrains.ENUM.Periods;
import geekbrains.YandexWeather.Forecast;
import geekbrains.YandexWeather.WeatherResponse;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class YandexWeatherProvider implements WeatherProvider {

    static Properties prop = new Properties();
    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();
    ReverseGeocode reverseGeocode = new ReverseGeocode();

    @Override
    public void getWeather(Periods periods) throws IOException {
        loadProperties();
        String[] valueLatLon = reverseGeocode.getCity();
        String latValue = valueLatLon[0];
        String lonValue = valueLatLon[1];

        String limit = WeatherLimit.getInstance().getWeatherLimit();

        if (periods.equals(Periods.CUSTOM)) {
            HttpUrl yandexWeatherForecast = new HttpUrl.Builder()
                .scheme("https")
                .host(prop.getProperty("BASE_HOST_YANDEX"))
                .addPathSegment(prop.getProperty("API_VERSION_YANDEX"))
                .addPathSegment(prop.getProperty("FORECAST_YANDEX"))
                .addQueryParameter("lat", latValue)
                .addQueryParameter("lon", lonValue)
                .addQueryParameter("lang", prop.getProperty("LANG_YANDEX"))
                .addQueryParameter("limit", limit)
                .addQueryParameter("hours", prop.getProperty("HOURS_YANDEX"))
                .addQueryParameter("extra", prop.getProperty("EXTRA_YANDEX"))
                .build();

            System.out.println(yandexWeatherForecast);

            Request requestToYandexAPI = new Request.Builder()
                .addHeader("accept", "application/json")
                .addHeader("X-Yandex-API-Key", prop.getProperty("YANDEX_API_KEY"))
                .url(yandexWeatherForecast)
                .get()
                .build();

            String jsonResponse = client.newCall(requestToYandexAPI).execute().body().string();
            System.out.println(jsonResponse);
            StringReader yandexWeatherJSON = new StringReader(jsonResponse);
            WeatherResponse weatherResponse = objectMapper.readValue(yandexWeatherJSON, WeatherResponse.class);

//            ЭТО ССЫЛКА НА ДОКУМЕНТАЦИЮ ЯНДЕКС
//            https://yandex.ru/dev/weather/doc/dg/concepts/forecast-test.html#req-example


            try {
                String loclity = weatherResponse.getGeoObject().getLocality().getName();
                System.out.println("В городе " + loclity + " ожидается: ");
            } catch (NullPointerException e){
                throw new IOException("Значение города нулевое! Стоит разобраться!");
            }

            for (Forecast forecast : weatherResponse.getForecasts()) {
                    System.out.println("На дату: " + forecast.getDate() +
                            "\nДнём погодные условия будут: " + forecast.getParts().getDay().getCondition().getCondition() +
                            ", температура: " + forecast.getParts().getDay().getTempAvg() + "С." +
                            "\nНочью погодные условия будут: " + forecast.getParts().getNight().getCondition().getCondition() +
                            ", температура: " + forecast.getParts().getNight().getTempAvg() + "С.");
                }

        }
    }

    private static void loadProperties() throws IOException {
        try(FileInputStream configFile = new FileInputStream("src/resources/config.properties")){
            prop.load(configFile);
        }
    }
}
