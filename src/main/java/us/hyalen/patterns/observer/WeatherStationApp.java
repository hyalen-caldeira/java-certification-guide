package us.hyalen.patterns.observer;

public class WeatherStationApp {
    WeatherDataSubject subject;
    CurrentConditionsObserver currentConditionsObserver;
    StatisticObserver statisticObserver;
    ForecastObserver forecastObserver;

    public WeatherStationApp() {
        this.subject = new WeatherDataSubject();
        this.currentConditionsObserver = new CurrentConditionsObserver(subject);
        this.statisticObserver = new StatisticObserver(subject);
        this.forecastObserver = new ForecastObserver(subject);
    }

    public static void main(String[] args) {
        WeatherStationApp station = new WeatherStationApp();
        station.subject.setMeasurements(80, 65, 30.4f);
        // station.subject.setMeasurements(81, 64, 30.6f);
        // station.subject.setMeasurements(82, 63, 30.8f);
    }
}
