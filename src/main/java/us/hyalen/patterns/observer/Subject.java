package us.hyalen.patterns.observer;

import java.util.List;

public interface Subject {
    public void register(Observer observer);
    public void remove(Observer observer);
    public void notifyObservers();
}
