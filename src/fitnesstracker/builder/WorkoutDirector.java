package fitnesstracker.builder;

public class WorkoutDirector {
    public void constructHeavyStrengthPlan(WorkoutBuilder builder) {
        builder.buildWarmUp("Rotator cuff warm-up and dynamic mobility")
                .buildMainExercises("Squat 5x5, Bench Press 5x5, Deadlift 3x3")
                .buildAccessories("Weighted dips 3x10, Barbell rows 4x8")
                .buildCardio("None");
    }

    public void constructActiveRecoveryPlan(WorkoutBuilder builder) {
        builder.buildWarmUp("Full body foam rolling 10 min")
                .buildMainExercises("Light core stability drills")
                .buildAccessories("Stretching")
                .buildCardio("Incline treadmill walk: 50 min, 12% incline, 4 km/h");
    }
}