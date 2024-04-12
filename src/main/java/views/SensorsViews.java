package views;

import config.Config;
import models.sensors.TemperatureSensor;

import java.util.Scanner;

public class SensorsViews {

    public void sensorUI(Scanner scanner, TemperatureSensor temperatureSensor) {
        System.out.println("Enter the temperature:");
        try {
            String temperatureString = scanner.nextLine();
            double temperature = Double.parseDouble(temperatureString);
            boolean isAdded = temperatureSensor.setTemperature(temperature);
            if (!isAdded) {
                System.out.println(STR."Temperature out of range: \{Config.MIN_TEMPERATURE_VALUE} ... \{Config.MAX_TEMPERATURE_VALUE}. Try again.");
                return;
            }
            temperatureSensor.broadcasting();
            System.out.println(STR."Temperature \{temperature} \{Config.TEMPERATURE_UNIT} add success!!!");
        } catch ( NumberFormatException e) {
            System.out.println("Incorrect temperature value. Try again.");
        }
    }
}
