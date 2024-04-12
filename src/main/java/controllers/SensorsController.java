package controllers;


import config.Config;
import models.observers.TemperatureObserver;
import models.sensors.TemperatureSensor;
import views.ObserverView;
import views.SensorsViews;

import java.util.Scanner;

public class SensorsController {
    public void sensorControllerProcessing() {
        String welcome = "Welcome to the sensors controller!";

        String menu = """
                1. Set current temperature
                2. Get current substance status
                3. Get observer history
                4. Exit
                """;
        System.out.println(welcome);
        Scanner scanner = new Scanner(System.in);
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        temperatureSensor.setTemperatureRange(Config.MIN_TEMPERATURE_VALUE, Config.MAX_TEMPERATURE_VALUE);
        TemperatureObserver temperatureObserver = new TemperatureObserver();
        temperatureSensor.subscribe(temperatureObserver);
        ObserverView observerView = new ObserverView();
        SensorsViews sensorsViews = new SensorsViews();
        while (true) {
            System.out.println(menu);
            System.out.println("Enter the menu item:");
            String menuItem = scanner.nextLine();
            switch (menuItem) {
                case "1":
                    sensorsViews.sensorUI(scanner, temperatureSensor);
                    break;
                case "2":
                    observerView.showCurrentSubstanceStatus(temperatureObserver);
                    break;
                case "3":
                    observerView.showHistoryLog(temperatureObserver);
                    break;
                case "4":
                    temperatureSensor.unsubscribe(temperatureObserver);
                    System.out.println("Observer unsubscribed.");
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Incorrect menu item. Try again.");
                    break;
            }
        }
    }
}
