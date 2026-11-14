package fitnesstracker.builder;

public class PowerliftingBuilder implements WorkoutBuilder {
    private final WorkoutPlan plan;

    public PowerliftingBuilder() {
        this.plan = new WorkoutPlan();
    }

    @Override
    public WorkoutBuilder buildWarmUp(String warmUp) {
        plan.setWarmUp(warmUp);
        return this;
    }

    @Override
    public WorkoutBuilder buildMainExercises(String mainExercises) {
        plan.setMainExercises(mainExercises);
        return this;
    }

    @Override
    public WorkoutBuilder buildAccessories(String accessories) {
        plan.setAccessories(accessories);
        return this;
    }

    @Override
    public WorkoutBuilder buildCardio(String cardio) {
        plan.setCardio(cardio);
        return this;
    }

    @Override
    public WorkoutPlan build() {
        if (plan.getMainExercises() == null || plan.getMainExercises().isEmpty()) {
            throw new IllegalStateException("Powerlifting plan requires main compound exercises.");
        }
        return plan;
    }
}