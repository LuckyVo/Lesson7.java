package geekbrains.YandexWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parts {
    private Night night;
    private Day day;

    public Night getNight() { return night; }
    public void setNight(Night value) { this.night = value; }

    public Day getDay() { return day; }
    public void setDay(Day value) { this.day = value; }
}
