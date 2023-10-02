package org.example.training.observerPattern;

public class ForecastDisplay implements Observer, DisplayElement{

    private WeatherData weatherData;
    private float currentPressure = 29.9f;
    private float lastPressure;

    public ForecastDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display(){
        System.out.println("Here is forecast " + lastPressure + " " + currentPressure);
    }

    @Override
    public void update(){
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    }
}
