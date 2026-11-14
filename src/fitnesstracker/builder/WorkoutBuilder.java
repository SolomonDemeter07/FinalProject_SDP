package fitnesstracker.builder;

public interface WorkoutBuilder {
    WorkoutBuilder buildWarmUp(String warmUp);
    WorkoutBuilder buildMainExercises(String mainExercises);
    WorkoutBuilder buildAccessories(String accessories);
    WorkoutBuilder buildCardio(String cardio);
    WorkoutPlan build();
}