package fitnesstracker.factory;

public class CardioActivity implements WorkoutActivity {
    @Override
    public String getActivityType() {
        return "CARDIO";
    }

    @Override
    public String performSession(int durationMinutes) {
        return "Executing endurance heart-rate zone session for " + durationMinutes + " minutes.";
    }
}
