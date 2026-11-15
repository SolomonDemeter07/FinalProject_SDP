package fitnesstracker.strategy;

public class HiitCalorieStrategy implements CalorieStrategy {
    private static final double HIIT_MET = 9.8;
    private static final double AFTERBURN_MULTIPLIER = 1.15;

    @Override
    public double calculateBurnedCalories(int durationMinutes, double weightKg, int avgBpm) {
        return Math.round((HIIT_MET * 3.5 * weightKg / 200.0) * durationMinutes * AFTERBURN_MULTIPLIER);
    }
}