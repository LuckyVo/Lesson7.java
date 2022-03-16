package geekbrains.YandexWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherResponse {
    @JsonProperty("geo_object")
    private Geo_Object geo_object;
    @JsonProperty("fact")
    private Fact fact;
    @JsonProperty("forecasts")
    private Forecast[] forecasts;

    public Geo_Object getGeoObject() { return geo_object; }
    public void setGeoObject(Geo_Object geo_object) {
        this.geo_object = geo_object;
    }

    public Fact getFact() {
        return fact;
    }
    public void setFact(Fact factObject) { this.fact = factObject; }

    public Forecast[] getForecasts() { return forecasts; }
    public void setForecasts(Forecast[] forecasts) { this.forecasts = forecasts; }
}









