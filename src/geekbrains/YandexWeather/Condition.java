package geekbrains.YandexWeather;

public class Condition {
    private String condition;

    public Condition(String condition){
        this.condition = condition;
    }

    public String getCondition() {
        switch (condition) {
            case "clear": return "ясно";
            case "cloudy": return "облачно с прояснениями";
            case "light-snow": return "небольшой снег";
            case "partly-cloudy": return "малооблачно";
            case "light-rain": return "небольшой дождь";
            case "rain": return "дождь";
            case "moderate-rain": return "умеренно сильный дождь";
            case "heavy-rain": return "сильный дождь";
            case "continuous-heavy-rain": return "длительный сильный дождь";
            case "showers": return "ливень";
            case "wet-snow": return "дождь со снегом";
            case "snow": return "снег";
            case "snow-showers": return "снегопад";
            case "hail": return "град";
            case "thunderstorm": return "гроза";
            case "thunderstorm-with-rain": return "дождь с грозой";
            case "thunderstorm-with-hail": return "гроза с градом";
            case "overcast": return "пасмурно";
            case "drizzle": return "морось";
        }
        return null;
    }

    public void setCondition(String inputCondition) {
        this.condition = inputCondition;
    }
}

//    private String condition;
//
//    Condition(){}
//
//    public String getCondition() {
//
//        switch (condition) {
//            case "clear": return "ясно";
//            case "cloudy": return "облачно с прояснениями";
//            case "light-snow": return "небольшой снег";
//            case "partly-cloudy": return "малооблачно";
//            case "light-rain": return "небольшой дождь";
//            case "rain": return "дождь";
//            case "moderate-rain": return "умеренно сильный дождь";
//            case "heavy-rain": return "сильный дождь";
//            case "continuous-heavy-rain": return "длительный сильный дождь";
//            case "showers": return "ливень";
//            case "wet-snow": return "дождь со снегом";
//            case "snow": return "снег";
//            case "snow-showers": return "снегопад";
//            case "hail": return "град";
//            case "thunderstorm": return "гроза";
//            case "thunderstorm-with-rain": return "дождь с грозой";
//            case "thunderstorm-with-hail": return "гроза с градом";
//            case "overcast": return "пасмурно";
//            case "drizzle": return "морось";
//        }
//        return null;
//    }
//
//    public void setCondition (String value){
//        this.condition = value;
//    }


//    CLEAR, CLOUDY, LIGHT_SNOW, OVERCAST, PARTLY_CLOUDY, DRIZZLE, LIGHT_RAIN, RAIN, MODERATE_RAIN, HEAVY_RAIN,
//    CONTINUOUS_HEAVY_RAIN, SHOWERS, WET_SNOW, SNOW, SNOW_SHOWERS, HAIL, THUNDERSTORM, THUNDERSTORM_WITH_RAIN,
//    THUNDERSTORM_WITH_HAIL;
//
//    public String getCondition() {
//        switch (this) {
//            case CLEAR: return "ясно";
//            case CLOUDY: return "облачно с прояснениями";
//            case LIGHT_SNOW: return "небольшой снег";
//            case PARTLY_CLOUDY: return "малооблачно";
//            case LIGHT_RAIN: return "небольшой дождь";
//            case RAIN: return "дождь";
//            case MODERATE_RAIN: return "умеренно сильный дождь";
//            case HEAVY_RAIN: return "сильный дождь";
//            case CONTINUOUS_HEAVY_RAIN: return "длительный сильный дождь";
//            case SHOWERS: return "ливень";
//            case WET_SNOW: return "дождь со снегом";
//            case SNOW: return "снег";
//            case SNOW_SHOWERS: return "снегопад";
//            case HAIL: return "град";
//            case THUNDERSTORM: return "гроза";
//            case THUNDERSTORM_WITH_RAIN: return "дождь с грозой";
//            case THUNDERSTORM_WITH_HAIL: return "гроза с градом";
//            case OVERCAST: return "пасмурно";
//            case DRIZZLE: return "морось";
//        }
//        return null;
//    }
//
//    public static Condition setCondition(String value) throws IOException {
//        if (value.equals("clear")) return CLEAR;
//        if (value.equals("cloudy")) return CLOUDY;
//        if (value.equals("light-snow")) return LIGHT_SNOW;
//        if (value.equals("overcast")) return OVERCAST;
//        if (value.equals("drizzle")) return DRIZZLE;
//        if (value.equals("light-rain")) return LIGHT_RAIN;
//        if (value.equals("rain")) return RAIN;
//        if (value.equals("moderate-rain")) return MODERATE_RAIN;
//        if (value.equals("heavy-rain")) return HEAVY_RAIN;
//        if (value.equals("continuous-heavy-rain")) return CONTINUOUS_HEAVY_RAIN;
//        if (value.equals("showers")) return SHOWERS;
//        if (value.equals("wet-snow")) return WET_SNOW;
//        if (value.equals("snow")) return SNOW;
//        if (value.equals("snow-showers")) return SNOW_SHOWERS;
//        if (value.equals("hail")) return HAIL;
//        if (value.equals("thunderstorm")) return THUNDERSTORM;
//        if (value.equals("partly-cloudy")) return PARTLY_CLOUDY;
//        if (value.equals("thunderstorm-with-rain")) return THUNDERSTORM_WITH_RAIN;
//        if (value.equals("thunderstorm-with-hail")) return THUNDERSTORM_WITH_HAIL;
//        throw new IOException("Cannot deserialize Condition");
//    }
//}


//    private String condition;
//    HashMap<String, String> variantCondition = new HashMap();
//
//    public Condition() {
//        variantCondition.put("clear", "ясно");
//        variantCondition.put("partly-cloudy", "малооблачно");
//        variantCondition.put("cloudy", "облачно с прояснениями");
//        variantCondition.put("overcast", "пасмурно");
//        variantCondition.put("drizzle", "морось");
//        variantCondition.put("light-rain", "небольшой дождь");
//        variantCondition.put("rain", "дождь");
//        variantCondition.put("moderate-rain", "умеренно сильный дождь");
//        variantCondition.put("heavy-rain", "сильный дождь");
//        variantCondition.put("continuous-heavy-rain", "длительный сильный дождь");
//        variantCondition.put("showers", "ливень");
//        variantCondition.put("wet-snow", "дождь со снегом");
//        variantCondition.put("light-snow", "небольшой снег");
//        variantCondition.put("snow", "снег");
//        variantCondition.put("snow-showers", "снегопад");
//        variantCondition.put("hail", "град");
//        variantCondition.put("thunderstorm", "гроза");
//        variantCondition.put("thunderstorm-with-rain", "дождь с грозой");
//        variantCondition.put("thunderstorm-with-hail", "гроза с градом");
//    }
//
//    public String getCondition() throws IOException {
//        String initializationCondition = variantCondition.get(condition);
//        return initializationCondition;
//    }
//
//    public void setCondition(String inputCondition){
//        this.condition = inputCondition;
//    }

//
//    public static Condition getInstance() {
//        if(INSTANCE == null) {
//            INSTANCE = new Condition();
//        }
//        return INSTANCE;
//    }