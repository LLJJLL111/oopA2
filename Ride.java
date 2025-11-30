import java.util.*;
import java.io.*;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private int maxRider;
    private int numOfCycles;
    private Employee operator;

    // Collections
    private Queue<Visitor> waitingLine;
    private LinkedList<Visitor> rideHistory;

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Standard";
        this.maxRider = 2;
        this.numOfCycles = 0;
        this.operator = null;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, int maxRider, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.operator = operator;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Getters and setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public Queue<Visitor> getWaitingLine() {
        return waitingLine;
    }

    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    // Interface method implementations

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.add(visitor);
            System.out.println("Success: Visitor " + visitor.getName() + " added to queue for " + rideName);
        } else {
            System.out.println("Error: Cannot add null visitor to queue");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removed = waitingLine.poll();
            System.out.println("Success: Visitor " + removed.getName() + " removed from queue");
        } else {
            System.out.println("Error: Queue is empty, cannot remove visitor");
        }
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Queue for " + rideName + " is empty");
            return;
        }

        System.out.println("Waiting queue for " + rideName + ":");
        int position = 1;
        for (Visitor visitor : waitingLine) {
            System.out.println(position + ". " + visitor.getName() + " (ID: " + visitor.getVisitorId() + ")");
            position++;
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Success: Visitor " + visitor.getName() + " added to ride history");
        } else {
            System.out.println("Error: Cannot add null visitor to history");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Cannot check null visitor");
            return false;
        }

        boolean found = rideHistory.contains(visitor);
        System.out.println("Visitor " + visitor.getName() + " in history: " + found);
        return found;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Number of visitors in history: " + count);
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history for " + rideName + " is empty");
            return;
        }

        System.out.println("Ride history for " + rideName + ":");
        Iterator<Visitor> iterator = rideHistory.iterator();
        int position = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(position + ". " + visitor);
            position++;
        }
    }

    @Override
    public void runOneCycle() {
        // Check if operator is assigned
        if (operator == null) {
            System.out.println("Error: Cannot run ride - no operator assigned");
            return;
        }

        // Check if queue is empty
        if (waitingLine.isEmpty()) {
            System.out.println("Error: Cannot run ride - no visitors in queue");
            return;
        }

        // Calculate how many visitors can ride this cycle
        int ridersThisCycle = Math.min(maxRider, waitingLine.size());
        System.out.println("Running " + rideName + " for one cycle with " + ridersThisCycle + " visitors");

        // Process visitors
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = waitingLine.poll();
            if (rider != null) {
                addVisitorToHistory(rider);
                System.out.println("Visitor " + rider.getName() + " has taken the ride");
            }
        }

        numOfCycles++;
        System.out.println("Ride cycle completed. Total cycles: " + numOfCycles);
    }

    // Sorting method using Comparator
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, comparator);
            System.out.println("Ride history sorted successfully");
        } else {
            System.out.println("Not enough visitors to sort");
        }
    }

    // File export method
    public void exportRideHistory(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                // Format: name,age,email,visitorId,ticketType,hasSeasonPass
                writer.println(visitor.getName() + "," +
                        visitor.getAge() + "," +
                        visitor.getEmail() + "," +
                        visitor.getVisitorId() + "," +
                        visitor.getTicketType() + "," +
                        visitor.isHasSeasonPass());
            }
            System.out.println("Success: Ride history exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error: Failed to export ride history - " + e.getMessage());
        }
    }

    // File import method
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int importedCount = 0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    try {
                        String name = parts[0];
                        int age = Integer.parseInt(parts[1]);
                        String email = parts[2];
                        String visitorId = parts[3];
                        String ticketType = parts[4];
                        boolean hasSeasonPass = Boolean.parseBoolean(parts[5]);

                        Visitor visitor = new Visitor(name, age, email, visitorId, ticketType, hasSeasonPass);
                        addVisitorToHistory(visitor);
                        importedCount++;
                    } catch (NumberFormatException e) {
                        System.out.println("Warning: Skipping invalid line - " + line);
                    }
                }
            }

            System.out.println("Success: Imported " + importedCount + " visitors from " + filename);
        } catch (IOException e) {
            System.out.println("Error: Failed to import ride history - " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", rideType='" + rideType + '\'' +
                ", maxRider=" + maxRider +
                ", numOfCycles=" + numOfCycles +
                ", operator=" + (operator != null ? operator.getName() : "None") +
                '}';
    }
}