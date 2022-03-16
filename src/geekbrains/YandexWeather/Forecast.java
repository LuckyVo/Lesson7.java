package geekbrains.YandexWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Forecast {
    @JsonProperty("date")
    private String date;
    @JsonProperty("parts")
    private Parts parts;

    public String getDate() { return date; }
    public void setDate(String value) { this.date = value; }

    public Parts getParts() { return parts; }
    public void setParts(Parts value) { this.parts = value; }


}
