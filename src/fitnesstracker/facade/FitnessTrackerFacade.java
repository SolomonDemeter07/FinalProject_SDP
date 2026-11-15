package fitnesstracker.facade;

import fitnesstracker.adapter.WearableSensor;
import fitnesstracker.bridge.BiometricHealthReport;
import fitnesstracker.bridge.DailyWorkoutReport;
import fitnesstracker.bridge.JsonReportFormatter;
import fitnesstracker.bridge.PlainTextFormatter;
import fitnesstracker.bridge.TrackerReport;
import fitnesstracker.builder.CardioRecoveryBuilder;
import fitnesstracker.builder.PowerliftingBuilder;
import fitnesstracker.builder.WorkoutBuilder;
import fitnesstracker.builder.WorkoutDirector;
import fitnesstracker.builder.WorkoutPlan;
import fitnesstracker.factory.ActivityCreator;
import fitnesstracker.factory.CardioActivityCreator;
import fitnesstracker.factory.StrengthActivityCreator;
import fitnesstracker.observer.CoachAlertObserver;
import fitnesstracker.observer.LiveHeartRateTracker;
import fitnesstracker.observer.MobileAppObserver;
import fitnesstracker.strategy.CalorieCalculator;
import fitnesstracker.strategy.HeavyLiftingCalorieStrategy;
import fitnesstracker.strategy.InclineWalkCalorieStrategy;
import fitnesstracker.visitor.LogElement;
import fitnesstracker.visitor.RecoveryAdvisorVisitor;
import fitnesstracker.visitor.TotalVolumeVisitor;
import java.util.List;

public class FitnessTrackerFacade {
    private final WorkoutDirector workoutDirector;
    private final LiveHeartRateTracker heartRateTracker;
    private final CalorieCalculator calorieCalculator;

    public FitnessTrackerFacade(String athleteName) {
        this.workoutDirector = new WorkoutDirector();
        this.heartRateTracker = new LiveHeartRateTracker();
        this.heartRateTracker.subscribe(new MobileAppObserver(athleteName));
        this.heartRateTracker.subscribe(new CoachAlertObserver());
        this.calorieCalculator = new CalorieCalculator(new HeavyLiftingCalorieStrategy());
    }

    public void executeStrengthTrainingWorkflow(WearableSensor sensor, int durationMinutes, double bodyWeightKg) {
        WorkoutBuilder builder = new PowerliftingBuilder();
        workoutDirector.constructHeavyStrengthPlan(builder);
        WorkoutPlan plan = builder.build();
        System.out.println("[Builder] Constructed: " + plan);

        ActivityCreator creator = new StrengthActivityCreator();
        creator.startSession(durationMinutes);

        int bpm = sensor.readHeartRateBpm();
        heartRateTracker.publishHeartRate(sensor.getDeviceName(), bpm);

        calorieCalculator.setStrategy(new HeavyLiftingCalorieStrategy());
        double calories = calorieCalculator.executeCalculation(durationMinutes, bodyWeightKg, bpm);

        TrackerReport report = new DailyWorkoutReport(new PlainTextFormatter(), plan.toString(), calories);
        System.out.println(report.export());

        report.setFormatter(new JsonReportFormatter());
        System.out.println("[Bridge - Runtime Format Switch] " + report.export());
    }

    public void executeRecoveryWorkflow(WearableSensor sensor, int durationMinutes, double bodyWeightKg) {
        WorkoutBuilder builder = new CardioRecoveryBuilder();
        workoutDirector.constructActiveRecoveryPlan(builder);
        WorkoutPlan plan = builder.build();
        System.out.println("[Builder] Constructed: " + plan);

        ActivityCreator creator = new CardioActivityCreator();
        creator.startSession(durationMinutes);

        int bpm = sensor.readHeartRateBpm();
        int steps = sensor.readDailySteps();
        heartRateTracker.publishHeartRate(sensor.getDeviceName(), bpm);

        calorieCalculator.setStrategy(new InclineWalkCalorieStrategy());
        double calories = calorieCalculator.executeCalculation(durationMinutes, bodyWeightKg, bpm);
        System.out.println("[Strategy] Active recovery calories burned: " + calories + " kcal");

        TrackerReport healthReport = new BiometricHealthReport(new PlainTextFormatter(), sensor.getDeviceName(), bpm, steps);
        System.out.println(healthReport.export());
    }

    public void runPostWorkoutAudit(List<LogElement> sessionLogs) {
        TotalVolumeVisitor volumeVisitor = new TotalVolumeVisitor();
        RecoveryAdvisorVisitor recoveryVisitor = new RecoveryAdvisorVisitor();

        for (LogElement element : sessionLogs) {
            element.accept(volumeVisitor);
            element.accept(recoveryVisitor);
        }

        System.out.println(volumeVisitor.getVolumeSummary());
        System.out.println(recoveryVisitor.getRecoveryAdvice());
    }
}