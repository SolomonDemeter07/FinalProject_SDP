package fitnesstracker.factory;

public class StrengthActivityCreator extends ActivityCreator {
    @Override
    protected WorkoutActivity createActivity() {
        return new StrengthActivity();
    }
}

