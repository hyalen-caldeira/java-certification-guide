package us.hyalen.patterns.observer;

public class ForecastObserver implements Observer, Display {
    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherDataSubject subject;

    public ForecastObserver(WeatherDataSubject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(
                "Forecast: " +
                        temperature + "F Degrees, " +
                        humidity + "% Humidity: " +
                        pressure + " Pressure"
        );
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        display();
    }
}
