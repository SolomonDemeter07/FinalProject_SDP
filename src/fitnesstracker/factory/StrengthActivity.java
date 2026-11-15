package fitnesstracker.factory;

public class StrengthActivity implements WorkoutActivity {
    @Override
    public String getActivityType() {
        return "STRENGTH";
    }

    @Override
    public String performSession(int durationMinutes) {
        return "Executing heavy barbell compound session for " + durationMinutes + " minutes.";
    }
}
