package views;

import models.observers.TemperatureObserver;

import java.util.UUID;

public class ObserverView {
    public void showHistoryLog(TemperatureObserver temperatureObserver) {
        System.out.println("Observer history:");
        UUID observerId = temperatureObserver.getId();
        System.out.println(STR."Observer ID: \{observerId}");
        temperatureObserver.getHistoryLog().forEach(
                (key, value) -> System.out.println(STR."\{key} - \{value}")
        );
    }

    public void showCurrentSubstanceStatus(TemperatureObserver temperatureObserver) {
        System.out.println("Current substance status:");
        System.out.println(temperatureObserver.currentSubstanceStatus().getSubstance());
    }
}
