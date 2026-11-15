package fitnesstracker.adapter;

public class AppleWatchAdapter implements WearableSensor {
    private final AppleWatchSdk sdk;

    public AppleWatchAdapter(AppleWatchSdk sdk) {
        this.sdk = sdk;
    }

    @Override
    public String getDeviceName() {
        return "Apple Watch Ultra (via Adapter)";
    }

    @Override
    public int readHeartRateBpm() {
        return (int) Math.round(sdk.getHeartBeatsPerSecond() * 60);
    }

    @Override
    public int readDailySteps() {
        return sdk.fetchPedometerCount();
    }
}
