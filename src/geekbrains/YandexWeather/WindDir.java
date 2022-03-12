package geekbrains.YandexWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WindDir {

    private  String windDir;

    public WindDir (String windDir){
        this.windDir = windDir;
    }

    public String getWindDir() {
        switch (windDir) {
            case "e": return "восток";
            case "ne": return "северо-восток";
            case "s": return "юг";
            case "se": return "юго-восток";
            case "sw": return "юго-запад";
            case "w": return "запад";
            case "n": return "север";
            case "nw": return "северо-запад";
        }
        return null;
    }

    public void setWindDir(String value) {
        this.windDir = value;
    }
}
