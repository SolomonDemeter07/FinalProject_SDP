package fitnesstracker.visitor;

public class RecoveryAdvisorVisitor implements LogVisitor {
    private int recommendedRestHours = 0;

    @Override
    public void visitWeightlifting(WeightliftingLog log) {
        if (log.getWeightKg() >= 100.0) {
            recommendedRestHours += 24;
        } else {
            recommendedRestHours += 12;
        }
    }

    @Override
    public void visitTreadmill(TreadmillLog log) {
        if (log.getInclinePercent() >= 10.0) {
            recommendedRestHours += 8;
        } else {
            recommendedRestHours += 4;
        }
    }

    public String getRecoveryAdvice() {
        return "[Visitor - RecoveryAdvisor] Recommended nervous system recovery time: " + recommendedRestHours + " hours";
    }
}
