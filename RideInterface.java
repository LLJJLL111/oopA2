import java.util.LinkedList;
import java.util.Queue;

public interface RideInterface {
    // Queue operations
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();

    // Ride history operations
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();

    // Ride operation
    void runOneCycle();
}