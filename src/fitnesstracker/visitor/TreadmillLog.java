package fitnesstracker.visitor;

public class TreadmillLog implements LogElement {
    private final int durationMinutes;
    private final double inclinePercent;
    private final double speedKmh;

    public TreadmillLog(int durationMinutes, double inclinePercent, double speedKmh) {
        this.durationMinutes = durationMinutes;
        this.inclinePercent = inclinePercent;
        this.speedKmh = speedKmh;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public double getInclinePercent() {
        return inclinePercent;
    }

    public double getSpeedKmh() {
        return speedKmh;
    }

    @Override
    public void accept(LogVisitor visitor) {
        visitor.visitTreadmill(this);
    }
}
