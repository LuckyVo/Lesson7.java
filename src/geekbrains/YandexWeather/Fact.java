package geekbrains.YandexWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fact {
    private Condition condition;
    private WindDir windDir;

    public Condition getCondition() { return condition; }
    public void setCondition(Condition value) { this.condition = value; }

    public WindDir getWindDir() { return windDir; }
    public void setWindDir(WindDir value) { this.windDir = value; }
}
