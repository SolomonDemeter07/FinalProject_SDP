package fitnesstracker.factory;

public abstract class ActivityCreator {
    protected abstract WorkoutActivity createActivity();

    public WorkoutActivity startSession(int durationMinutes) {
        WorkoutActivity activity = createActivity();
        System.out.println("[FactoryMethod] " + activity.performSession(durationMinutes));
        return activity;
    }
}
