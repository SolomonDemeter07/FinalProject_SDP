package fitnesstracker.bridge;

public class BiometricHealthReport extends TrackerReport {
    private final String deviceName;
    private final int peakBpm;
    private final int steps;

    public BiometricHealthReport(ReportFormatter formatter, String deviceName, int peakBpm, int steps) {
        super(formatter);
        this.deviceName = deviceName;
        this.peakBpm = peakBpm;
        this.steps = steps;
    }

    @Override
    public String export() {
        String body = "Source: " + deviceName + "\nPeak Heart Rate: " + peakBpm + " BPM\nDaily Steps: " + steps;
        return formatter.formatReport("Biometric Health Report", body);
    }
}

