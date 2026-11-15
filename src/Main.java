
import fitnesstracker.adapter.AppleWatchAdapter;
import fitnesstracker.adapter.AppleWatchSdk;
import fitnesstracker.adapter.GarminDeviceAdapter;
import fitnesstracker.adapter.GarminLegacyDevice;
import fitnesstracker.adapter.WearableSensor;
import fitnesstracker.facade.FitnessTrackerFacade;
import fitnesstracker.visitor.LogElement;
import fitnesstracker.visitor.TreadmillLog;
import fitnesstracker.visitor.WeightliftingLog;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FitnessTrackerFacade trackerFacade = new FitnessTrackerFacade("Dias");

        System.out.println("=== SCENARIO 1: HEAVY POWERLIFTING SESSION WITH APPLE WATCH ===");
        WearableSensor appleWatch = new AppleWatchAdapter(new AppleWatchSdk());
        trackerFacade.executeStrengthTrainingWorkflow(appleWatch, 100, 85.0);

        System.out.println("\n=== SCENARIO 2: ACTIVE RECOVERY SESSION WITH GARMIN LEGACY DEVICE ===");
        WearableSensor garminWatch = new GarminDeviceAdapter(new GarminLegacyDevice());
        trackerFacade.executeRecoveryWorkflow(garminWatch, 75, 85.0);

        System.out.println("\n=== SCENARIO 3: POST-WORKOUT LOG ANALYTICS VIA VISITOR ===");
        List<LogElement> weeklyLogs = Arrays.asList(
                new WeightliftingLog("Barbell Squat", 5, 5, 140.0),
                new WeightliftingLog("Bench Press", 5, 5, 110.0),
                new TreadmillLog(50, 12.0, 4.0)
        );
        trackerFacade.runPostWorkoutAudit(weeklyLogs);
    }
}