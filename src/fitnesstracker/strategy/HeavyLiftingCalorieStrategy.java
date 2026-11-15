package fitnesstracker.strategy;

public class HeavyLiftingCalorieStrategy implements CalorieStrategy {
    private static final double STRENGTH_MET = 6.0;

    @Override
    public double calculateBurnedCalories(int durationMinutes, double weightKg, int avgBpm) {
        double intensityFactor = avgBpm / 140.0;
        return Math.round((STRENGTH_MET * 3.5 * weightKg / 200.0) * durationMinutes * intensityFactor);
    }
}