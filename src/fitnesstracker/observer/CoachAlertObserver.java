package fitnesstracker.observer;

public class CoachAlertObserver implements HeartRateObserver {
    private static final int RED_ZONE_THRESHOLD_BPM = 165;

    @Override
    public void update(String deviceName, int bpm) {
        if (bpm >= RED_ZONE_THRESHOLD_BPM) {
            System.out.println("[Observer - CoachAlert] WARNING! High heart rate detected (" + bpm + " BPM). Recommend extending rest interval.");
        } else {
            System.out.println("[Observer - CoachAlert] Heart rate (" + bpm + " BPM) is within optimal training zone.");
        }
    }
}