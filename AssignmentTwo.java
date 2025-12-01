import java.util.*;

public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();

        // Run all parts
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree() {
        System.out.println("\n=== Part 3: Queue Operations ===");

        // Create a ride with an operator
        Employee operator = new Employee("John Operator", 30, "john@themepark.com", "E001", "Ride Operations", 50000);
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill Ride", 2, operator);

        // Create visitors
        Visitor[] visitors = {
                new Visitor("Alice", 25, "alice@email.com", "V001", "Standard", false),
                new Visitor("Bob", 30, "bob@email.com", "V002", "Premium", true),
                new Visitor("Charlie", 22, "charlie@email.com", "V003", "Standard", false),
                new Visitor("Diana", 28, "diana@email.com", "V004", "VIP", true),
                new Visitor("Eve", 35, "eve@email.com", "V005", "Standard", false)
        };

        // Add visitors to queue
        for (Visitor visitor : visitors) {
            rollerCoaster.addVisitorToQueue(visitor);
        }

        // Print queue
        rollerCoaster.printQueue();

        // Remove one visitor
        rollerCoaster.removeVisitorFromQueue();

        // Print queue again
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        System.out.println("\n=== Part 4A: Ride History Operations ===");

        Ride waterRide = new Ride("Water Splash", "Water Ride", 4, null);

        // Create visitors
        Visitor[] visitors = {
                new Visitor("Frank", 20, "frank@email.com", "V006", "Standard", false),
                new Visitor("Grace", 26, "grace@email.com", "V007", "Premium", true),
                new Visitor("Henry", 32, "henry@email.com", "V008", "Standard", false),
                new Visitor("Ivy", 29, "ivy@email.com", "V009", "VIP", true),
                new Visitor("Jack", 40, "jack@email.com", "V010", "Standard", false)
        };

        // Add visitors to history
        for (Visitor visitor : visitors) {
            waterRide.addVisitorToHistory(visitor);
        }

        // Check if a visitor is in history
        waterRide.checkVisitorFromHistory(visitors[2]);

        // Print number of visitors
        waterRide.numberOfVisitors();

        // Print ride history
        waterRide.printRideHistory();
    }

    public void partFourB() {
        System.out.println("\n=== Part 4B: Sorting Ride History ===");

        Ride ferrisWheel = new Ride("Ferris Wheel", "Family Ride", 6, null);

        // Create visitors in unsorted order
        Visitor[] visitors = {
                new Visitor("Zack", 35, "zack@email.com", "V011", "Standard", false),
                new Visitor("Alice", 25, "alice2@email.com", "V012", "Premium", true),
                new Visitor("Mike", 30, "mike@email.com", "V013", "Standard", false),
                new Visitor("Bob", 22, "bob2@email.com", "V014", "VIP", true),
                new Visitor("Cathy", 28, "cathy@email.com", "V015", "Standard", false)
        };

        // Add visitors to history
        for (Visitor visitor : visitors) {
            ferrisWheel.addVisitorToHistory(visitor);
        }

        System.out.println("Before sorting:");
        ferrisWheel.printRideHistory();

        // Sort using comparator
        ferrisWheel.sortRideHistory(new VisitorComparator());

        System.out.println("After sorting:");
        ferrisWheel.printRideHistory();
    }

    public void partFive() {
        System.out.println("\n=== Part 5: Run One Cycle ===");

        Employee operator = new Employee("Sarah Operator", 28, "sarah@themepark.com", "E002", "Ride Operations", 52000);
        Ride thunderCoaster = new Ride("Thunder Coaster", "Thrill Ride", 3, operator);

        // Create 10 visitors
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor(
                    "Visitor" + i,
                    20 + i,
                    "visitor" + i + "@email.com",
                    "V10" + i,
                    i % 2 == 0 ? "Premium" : "Standard",
                    i % 3 == 0
            );
            thunderCoaster.addVisitorToQueue(visitor);
        }

        System.out.println("Before running cycle:");
        thunderCoaster.printQueue();

        // Run one cycle
        thunderCoaster.runOneCycle();

        System.out.println("After running cycle:");
        thunderCoaster.printQueue();

        System.out.println("Ride history after cycle:");
        thunderCoaster.printRideHistory();
    }

    public void partSix() {
        System.out.println("\n=== Part 6: Writing to File ===");

        Ride dragonRide = new Ride("Dragon Adventure", "Family Ride", 4, null);

        // Create and add visitors
        Visitor[] visitors = {
                new Visitor("Oliver", 15, "oliver@email.com", "V016", "Child", false),
                new Visitor("Sophia", 12, "sophia@email.com", "V017", "Child", true),
                new Visitor("Liam", 16, "liam@email.com", "V018", "Teen", false),
                new Visitor("Emma", 14, "emma@email.com", "V019", "Teen", true),
                new Visitor("Noah", 17, "noah@email.com", "V020", "Teen", false)
        };

        for (Visitor visitor : visitors) {
            dragonRide.addVisitorToHistory(visitor);
        }

        // Export to file
        dragonRide.exportRideHistory("ride_history_export.csv");
    }

    public void partSeven() {
        System.out.println("\n=== Part 7: Reading from File ===");

        Ride importedRide = new Ride("Imported Ride", "Test Ride", 4, null);

        // Import from file
        importedRide.importRideHistory("ride_history_export.csv");

        // Verify import
        importedRide.numberOfVisitors();
        importedRide.printRideHistory();
    }
}