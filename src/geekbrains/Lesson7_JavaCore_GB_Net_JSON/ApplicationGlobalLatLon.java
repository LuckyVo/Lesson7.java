package geekbrains.Lesson7_JavaCore_GB_Net_JSON;

public class ApplicationGlobalLatLon {

    private static ApplicationGlobalLatLon INSTANCE;
    private String selectedLatCity = null;
    private String selectedLonCity = null;

    public static ApplicationGlobalLatLon getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalLatLon();
        }
        return INSTANCE;
    }

    public String getLatCity() {
        return selectedLatCity;
    }

    public String getLonCity() {
        return selectedLonCity;
    }

    public void setLatCity(String selectedLatCity) {
        this.selectedLatCity = selectedLatCity;
    }

    public void setLonCity(String selectedLonCity) {
        this.selectedLonCity = selectedLonCity;
    }

}
