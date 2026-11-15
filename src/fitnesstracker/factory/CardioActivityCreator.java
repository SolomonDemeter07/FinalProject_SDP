package fitnesstracker.factory;

public class CardioActivityCreator extends ActivityCreator {
    @Override
    protected WorkoutActivity createActivity() {
        return new CardioActivity();
    }
}
