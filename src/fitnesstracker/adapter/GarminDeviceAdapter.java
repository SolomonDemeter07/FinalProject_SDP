package fitnesstracker.adapter;

public class GarminDeviceAdapter implements WearableSensor {
    private final GarminLegacyDevice legacyDevice;

    public GarminDeviceAdapter(GarminLegacyDevice legacyDevice) {
        this.legacyDevice = legacyDevice;
    }

    @Override
    public String getDeviceName() {
        return "Garmin Fenix Pro (via Adapter)";
    }

    @Override
    public int readHeartRateBpm() {
        String[] parts = legacyDevice.exportRawTelemetryPayload().split(";");
        return Integer.parseInt(parts[0].split(":")[1]);
    }

    @Override
    public int readDailySteps() {
        String[] parts = legacyDevice.exportRawTelemetryPayload().split(";");
        return Integer.parseInt(parts[1].split(":")[1]);
    }
}
