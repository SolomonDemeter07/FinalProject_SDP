package fitnesstracker.bridge;

public class PlainTextFormatter implements ReportFormatter {
    @Override
    public String formatReport(String title, String content) {
        return "=== " + title + " ===\n" + content + "\n==============================";
    }
}
