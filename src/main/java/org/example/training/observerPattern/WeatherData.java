package org.example.training.observerPattern;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherData implements Subject {
private List<Observer> observers;
private float temperature;
private float humidity;
private float pressure;

    public WeatherData(){
        observers = new ArrayList<Observer>();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers){
            observer.update();
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        setTemperature(temperature);
        setHumidity(humidity);
        setPressure(pressure);
        measurementsChanged();
    }
}
