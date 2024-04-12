package models.observers;

import Interfaces.IObserver;
import Interfaces.ISubstance;
import entitys.Substance;

import java.time.LocalDateTime;
import config.Config;
import java.util.HashMap;
import java.util.UUID;

public class TemperatureObserver implements IObserver<Double> {
    private final UUID id;
    private final HashMap<LocalDateTime, String> historyLog;
    private final Substance substance;
    private double temperature;

    public TemperatureObserver() {
        this.substance = new Substance();
        this.id = UUID.randomUUID();
        this.historyLog = new HashMap<>();
    }

    public UUID getId() {
        return this.id;
    }

    @Override
    public void update(Double temperature) {
        this.temperature = temperature;
        double wight = this.currentWeight();
        double color = this.currentColor();
        this.substance.setSubstance(new Double[]{temperature, wight, color});

        this.historyLog.put(LocalDateTime.now(), this.substance.getSubstance());
    }

    @Override
    public ISubstance currentSubstanceStatus() {
        return this.substance;
    }

    private double currentWeight() {
        if (this.temperature <= 0.0) {
            return Config.WEIGHT_ZERO_VALUE;
        }
        return this.temperature * Config.WEIGHT_CHANGE_STEP;
    }

    private double currentColor() {
        if (this.temperature <= 0.0) {
            return 1.0;
        }
        return 2.0;
    }


    @Override
    public HashMap<LocalDateTime, String> getHistoryLog() {
        return this.historyLog;
    }

}
