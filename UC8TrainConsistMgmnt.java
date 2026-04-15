import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC8: Filter Passenger Bogies Using Streams
 * Goal: Use declarative Stream pipelines to filter bogies based on capacity conditions.
 */

// Bogie class reused from UC7
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class UC8TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // 1. Initialize a List of Bogie objects
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        System.out.println("Original Bogie List: " + bogieList);

        // 2. Define capacity threshold
        int threshold = 60;
        System.out.println("\n[Action] Filtering bogies with capacity > " + threshold + "...");

        // 3. Apply Stream Pipeline: stream() -> filter() -> collect()
        List<Bogie> highCapacityBogies = bogieList.stream()
                .filter(b -> b.capacity > threshold) // Lambda expression for condition
                .collect(Collectors.toList());      // Collect results into a new list

        // 4. Display Filtered Results
        System.out.println("Filtered High-Capacity Bogies:");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies matched the criteria.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }

        // 5. Verify Original List Integrity
        System.out.println("\nVerification: Original list size remains " + bogieList.size());
        
        System.out.println("------------------------------------");
        System.out.println("Filtering complete using Stream API.");
    }
}
