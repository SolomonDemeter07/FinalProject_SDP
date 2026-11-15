package fitnesstracker.visitor;

public interface LogVisitor {
    void visitWeightlifting(WeightliftingLog log);
    void visitTreadmill(TreadmillLog log);
}
