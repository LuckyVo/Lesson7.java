package geekbrains.YandexWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Geo_Object {
    @JsonProperty("district")
    private Country district;
    @JsonProperty("locality")
    private Country locality;
    @JsonProperty("province")
    private Country province;
    @JsonProperty("country")
    private Country country;

    public Country getDistrict() { return district; }
    public void setDistrict(Country value) { this.district = value; }

    public Country getLocality() { return locality; }
    public void setLocality(Country value) { this.locality = value; }

    public Country getProvince() { return province; }
    public void setProvince(Country value) { this.province = value; }

    public Country getCountry() { return country; }
    public void setCountry(Country value) { this.country = value; }
}
