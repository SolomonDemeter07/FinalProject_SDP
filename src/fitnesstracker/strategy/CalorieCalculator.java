package fitnesstracker.strategy;

public class CalorieCalculator {
    private CalorieStrategy strategy;

    public CalorieCalculator(CalorieStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(CalorieStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeCalculation(int durationMinutes, double weightKg, int avgBpm) {
        if (strategy == null) {
            throw new IllegalStateException("Calorie calculation strategy is not set.");
        }
        return strategy.calculateBurnedCalories(durationMinutes, weightKg, avgBpm);
    }
}