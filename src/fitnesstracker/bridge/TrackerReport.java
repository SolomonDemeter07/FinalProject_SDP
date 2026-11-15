package fitnesstracker.bridge;

public abstract class TrackerReport {
    protected ReportFormatter formatter;

    protected TrackerReport(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public void setFormatter(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public abstract String export();
}
