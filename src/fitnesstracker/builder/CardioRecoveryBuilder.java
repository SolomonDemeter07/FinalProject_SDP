package fitnesstracker.builder;

public class CardioRecoveryBuilder implements WorkoutBuilder {
    private final WorkoutPlan plan;

    public CardioRecoveryBuilder() {
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
        if (plan.getCardio() == null || plan.getCardio().isEmpty()) {
            throw new IllegalStateException("Recovery plan requires a cardio session.");
        }
        return plan;
    }
}