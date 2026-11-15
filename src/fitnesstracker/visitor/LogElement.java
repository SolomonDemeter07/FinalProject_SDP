package fitnesstracker.visitor;

public interface LogElement {
    void accept(LogVisitor visitor);
}
