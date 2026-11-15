package fitnesstracker.adapter;

public interface WearableSensor {
    String getDeviceName();
    int readHeartRateBpm();
    int readDailySteps();
}
