package fitnesstracker.bridge;

public class DailyWorkoutReport extends TrackerReport {
    private final String workoutSummary;
    private final double caloriesBurned;

    public DailyWorkoutReport(ReportFormatter formatter, String workoutSummary, double caloriesBurned) {
        super(formatter);
        this.workoutSummary = workoutSummary;
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String export() {
        String body = "Plan: " + workoutSummary + "\nTotal Burn: " + caloriesBurned + " kcal";
        return formatter.formatReport("Daily Workout Summary", body);
    }
}

