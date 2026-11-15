package fitnesstracker.observer;

import java.util.ArrayList;
import java.util.List;

public class LiveHeartRateTracker implements HeartRateSubject {
    private final List<HeartRateObserver> observers = new ArrayList<>();
    private String currentDevice;
    private int currentBpm;

    public void publishHeartRate(String deviceName, int bpm) {
        this.currentDevice = deviceName;
        this.currentBpm = bpm;
        notifyObservers();
    }

    @Override
    public void subscribe(HeartRateObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(HeartRateObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (HeartRateObserver observer : observers) {
            observer.update(currentDevice, currentBpm);
        }
    }
}