package fitnesstracker.strategy;

public interface CalorieStrategy {
    double calculateBurnedCalories(int durationMinutes, double weightKg, int avgBpm);
}