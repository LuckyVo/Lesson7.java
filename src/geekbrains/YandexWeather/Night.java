package geekbrains.YandexWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Night {
    private Integer tempAvg;
    private WindDir windDir;
    private Condition condition;

    public Integer getTempAvg() { return tempAvg; }
    public void setTempAvg(Integer value) { this.tempAvg = value; }

    public WindDir getWindDir() { return windDir; }
    public void setWindDir(WindDir value) { this.windDir = value; }

    public Condition getCondition() { return condition; }
    public void setCondition(Condition value) { this.condition = value; }
}
