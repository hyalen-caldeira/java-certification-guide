package us.hyalen.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSubject implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update(temperature, humidity, pressure);
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }
}
