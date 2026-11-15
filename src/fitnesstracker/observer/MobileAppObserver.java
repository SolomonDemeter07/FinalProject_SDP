package fitnesstracker.observer;

public class MobileAppObserver implements HeartRateObserver {
    private final String athleteName;

    public MobileAppObserver(String athleteName) {
        this.athleteName = athleteName;
    }

    @Override
    public void update(String deviceName, int bpm) {
        System.out.println("[Observer - MobileApp] Athlete " + athleteName + " live pulse from " + deviceName + ": " + bpm + " BPM");
    }
}