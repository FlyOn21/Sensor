package models.sensors;

import Interfaces.IObserver;
import Interfaces.ITemperatureSensor;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements ITemperatureSensor {
    private double temperature;
    private double minTemperature;
    private double maxTemperature;
    private final List<IObserver<Double>> observers;

    public TemperatureSensor() {
        this.observers = new ArrayList<>();
    }

    @Override
    public boolean setTemperature(double temperature) {
        if (temperature < minTemperature || temperature > maxTemperature) {
            return false;
        }
        this.temperature = temperature;
        return true;
    }

    @Override
    public void setTemperatureRange(double minTemperature, double maxTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    @Override
    public void subscribe(IObserver<Double> observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(IObserver<Double> observer) {
        this.observers.remove(observer);
    }

    @Override
    public void broadcasting() {
        observers.forEach(observer -> observer.update(this.temperature));
    }
}
