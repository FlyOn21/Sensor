package Interfaces;

public interface ITemperatureSensor extends ISensor<Double> {
    boolean setTemperature(double temperature);
    void setTemperatureRange(double minTemperature, double maxTemperature);

}
