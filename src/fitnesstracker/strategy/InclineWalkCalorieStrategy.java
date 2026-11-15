package fitnesstracker.strategy;

public class InclineWalkCalorieStrategy implements CalorieStrategy {
    private static final double INCLINE_WALK_MET = 7.5;

    @Override
    public double calculateBurnedCalories(int durationMinutes, double weightKg, int avgBpm) {
        return Math.round((INCLINE_WALK_MET * 3.5 * weightKg / 200.0) * durationMinutes);
    }
}