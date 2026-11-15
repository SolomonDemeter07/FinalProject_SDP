package fitnesstracker.observer;
public interface HeartRateObserver {
    void update(String deviceName, int bpm);
}
