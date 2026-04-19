/**
 * Custom Exception for Bogie validation rules.
 */
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

/**
 * PassengerBogie class with built-in validation in the constructor.
 */
class PassengerBogie {
    private String name;
    private int capacity;

    public PassengerBogie(String name, int capacity) throws InvalidCapacityException {
        // Business Rule: Capacity must be greater than zero
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero. Provided: " + capacity);
        }
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class UC14TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC14) ===");

        // Scenario 1: Valid Capacity
        try {
            System.out.println("\n[Action] Creating valid bogies...");
            PassengerBogie s1 = new PassengerBogie("Sleeper", 72);
            System.out.println("✔ Created: " + s1);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Failed: " + e.getMessage());
        }

        // Scenario 2: Zero Capacity (Invalid)
        try {
            System.out.println("\n[Action] Creating bogie with zero capacity...");
            PassengerBogie s2 = new PassengerBogie("AC Chair", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Caught expected error: " + e.getMessage());
        }

        // Scenario 3: Negative Capacity (Invalid)
        try {
            System.out.println("\n[Action] Creating bogie with negative capacity...");
            PassengerBogie s3 = new PassengerBogie("First Class", -10);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Caught expected error: " + e.getMessage());
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("Data integrity check complete.");
    }
}
