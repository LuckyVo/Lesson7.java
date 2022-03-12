package geekbrains.YandexWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private String date;
    private Parts parts;


    public String getDate() { return date; }
    public void setDate(String value) { this.date = value; }

    public Parts getParts() { return parts; }
    public void setParts(Parts value) { this.parts = value; }


}
