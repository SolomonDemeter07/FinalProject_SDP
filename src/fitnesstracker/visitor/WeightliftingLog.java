package fitnesstracker.visitor;

public class WeightliftingLog implements LogElement {
    private final String exerciseName;
    private final int sets;
    private final int reps;
    private final double weightKg;

    public WeightliftingLog(String exerciseName, int sets, int reps, double weightKg) {
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.weightKg = weightKg;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public double getWeightKg() {
        return weightKg;
    }

    @Override
    public void accept(LogVisitor visitor) {
        visitor.visitWeightlifting(this);
    }
}

