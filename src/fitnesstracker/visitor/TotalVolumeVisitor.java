package fitnesstracker.visitor;

public class TotalVolumeVisitor implements LogVisitor {
    private double totalTonnageKg = 0;
    private double totalCardioDistanceKm = 0;

    @Override
    public void visitWeightlifting(WeightliftingLog log) {
        totalTonnageKg += log.getSets() * log.getReps() * log.getWeightKg();
    }

    @Override
    public void visitTreadmill(TreadmillLog log) {
        totalCardioDistanceKm += (log.getDurationMinutes() / 60.0) * log.getSpeedKmh();
    }

    public String getVolumeSummary() {
        return String.format("[Visitor - VolumeAudit] Total Iron Tonnage: %.1f kg | Cardio Distance: %.2f km",
                totalTonnageKg, totalCardioDistanceKm);
    }
}
