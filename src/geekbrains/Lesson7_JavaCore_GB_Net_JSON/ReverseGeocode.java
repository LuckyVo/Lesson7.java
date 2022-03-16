package geekbrains.Lesson7_JavaCore_GB_Net_JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ReverseGeocode {
    static Properties prop = new Properties();
    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();


    public String[] getCity()  throws IOException {
        loadProperties();
        String selectedCity = ApplicationGlobalCity.getInstance().getSelectedCity();

//      ССЫЛКА НА ДОКУМЕНТАЦИЮ
//      https://developer.mapquest.com/documentation/open/geocoding-api/address/get/

        HttpUrl mapQuestURL = new HttpUrl.Builder()
                .scheme("http")
                .host(prop.getProperty("BASE_HOST_MAP_QUEST"))
                .addPathSegment(prop.getProperty("GEOCODING_MAP_QUEST"))
                .addPathSegment(prop.getProperty("API_VERSION_MAP_QUEST"))
                .addPathSegment(prop.getProperty("ADDRESS"))
                .addQueryParameter("key", prop.getProperty("MAP_QUEST_DEVELOPER_API_KEY"))
                .addQueryParameter("location", selectedCity)
                .build();

        System.out.println(mapQuestURL);

        Request requestToMapQuestAPI = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(mapQuestURL)
                .get()
                .build();

        Response response = client.newCall(requestToMapQuestAPI).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }

        String jsonResponse = Objects.requireNonNull(response.body().string());
        System.out.println(jsonResponse);
        System.out.println("Произвожу поиск города: " + selectedCity + ".");

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            JsonNode lat = objectMapper.readTree(jsonResponse).at("/results/0/locations/0/latLng/lat");
            JsonNode lon = objectMapper.readTree(jsonResponse).at("/results/0/locations/0/latLng/lng");
            System.out.println("Город " + selectedCity + " найден на широте: " + lat.asText() +
                    ", и долготе: " + lon.asText() + ".");
            return new String[]{String.valueOf(lat),String.valueOf(lon)};
        } else throw new IOException("Server returns 0 cities");


//        if (objectMapper.readTree(jsonResponse).size() > 0) {
//            for (JsonNode res : objectMapper.readTree(jsonResponse).at("/results")) {
//                for (JsonNode locations : res.at("/locations")) {
//                    for (JsonNode latLng : locations.at("/latLng")) {
//                        lat = latLng.at("/lat").asText();
//                        lon = latLng.at("/lng").asText();
//                        System.out.println("Город " + selectedCity + " найден на широте " + lat + " и долготе " + lon);
//
//                    }
//                }
//            }
//        } else throw new IOException("Server returns 0 cities");
//        return new String[]{lat, lon};
    }

    private static void loadProperties() throws IOException {
        try(FileInputStream configFile = new FileInputStream("src/resources/config.properties")){
            prop.load(configFile);
        }
    }
}
