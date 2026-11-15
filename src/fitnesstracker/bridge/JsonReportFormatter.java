package fitnesstracker.bridge;

public class JsonReportFormatter implements ReportFormatter {
    @Override
    public String formatReport(String title, String content) {
        return "{ \"reportTitle\": \"" + title + "\", \"payload\": \"" + content.replace("\n", " | ") + "\" }";
    }
}
