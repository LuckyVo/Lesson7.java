package geekbrains.YandexWeather;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Geo_Object {
    private Country district;
    private Country locality;
    private Country province;
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
