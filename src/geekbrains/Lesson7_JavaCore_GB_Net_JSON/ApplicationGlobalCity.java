package geekbrains.Lesson7_JavaCore_GB_Net_JSON;

public class ApplicationGlobalCity {

    private static ApplicationGlobalCity INSTANCE;
    private String selectedGlobalCity = null;

    public static ApplicationGlobalCity getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalCity();
        }
        return INSTANCE;
    }

    public String getSelectedCity() {
        return selectedGlobalCity;
    }

    public void setSelectedCity(String selectedGlobalCity) {
        this.selectedGlobalCity = selectedGlobalCity;
    }

}
