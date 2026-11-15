package fitnesstracker.factory;

public interface WorkoutActivity {
    String getActivityType();
    String performSession(int durationMinutes);
}
