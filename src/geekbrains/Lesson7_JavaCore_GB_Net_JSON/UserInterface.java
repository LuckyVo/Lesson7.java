package geekbrains.Lesson7_JavaCore_GB_Net_JSON;

import java.io.*;
import java.util.*;

public class UserInterface {

    private static UserInterface INSTANCE;
    private Controller controller = new Controller();
    private ApplicationGlobalLatLon applicationGlobalLatLon = new ApplicationGlobalLatLon();

    public void runApplication(){

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Введите широту (пример: 59.950186):");
            String lat = scanner.nextLine();
            setLatCity(lat);

            System.out.println("Введите долготу (пример: 30.314271):");
            String lon = scanner.nextLine();
            setLonCity(lon);

            System.out.println("Введите введите на сколько дней вывести прогноз погоды(максимальная длина 7 дней). " +
                    "\nДля завершения работы введите - выход/exit:");
            String limit = scanner.nextLine();
            setLimit(limit);
            checkIsExit(limit);

            try {
                validateUserInput(limit);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                notifyController(limit);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    private void checkIsExit(String result) {
        if (result.toLowerCase().equals("выход") || result.toLowerCase().equals("exit")) {
            System.out.println("Завершаю работу");
            System.exit(0);
        }
    }

    private void setLatCity(String lat) {
        applicationGlobalLatLon.getInstance().setLatCity(lat);
    }

    private void setLonCity(String lon) {
        applicationGlobalLatLon.getInstance().setLonCity(lon);
    }

    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Попробуйте ввести данные ещё раз:" + userInput);
        }
        int answer = 0;

        try {
            answer = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Стоит ввести число!");
        }
    }

    private void notifyController(String limit) throws IOException {
        controller.onUserInput(limit);
    }

    public void setLimit(String limit) { WeatherLimit.getInstance().setWeatherLimit(limit); }



}
