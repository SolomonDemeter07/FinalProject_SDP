package fitnesstracker.observer;

public interface HeartRateSubject {
    void subscribe(HeartRateObserver observer);
    void unsubscribe(HeartRateObserver observer);
    void notifyObservers();
}