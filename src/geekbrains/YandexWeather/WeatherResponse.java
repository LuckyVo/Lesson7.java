package geekbrains.YandexWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherResponse {
    private Geo_Object geo_object;
    private Fact fact;
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









