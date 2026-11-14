public class WorkoutPlan {
    private String warmUp;
    private String mainExercises;
    private String accessories;
    private String cardio;

    protected WorkoutPlan() {
    }

    public void setWarmUp(String warmUp) {
        this.warmUp = warmUp;
    }

    public void setMainExercises(String mainExercises) {
        this.mainExercises = mainExercises;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public void setCardio(String cardio) {
        this.cardio = cardio;
    }

    public String getWarmUp() {
        return warmUp;
    }

    public String getMainExercises() {
        return mainExercises;
    }

    public String getAccessories() {
        return accessories;
    }

    public String getCardio() {
        return cardio;
    }

    @Override
    public String toString() {
        return "WorkoutPlan [WarmUp=" + (warmUp != null ? warmUp : "None")
                + " | Main=" + (mainExercises != null ? mainExercises : "None")
                + " | Accessories=" + (accessories != null ? accessories != "" ? accessories : "None" : "None")
                + " | Cardio=" + (cardio != null ? cardio : "None") + "]";
    }
}