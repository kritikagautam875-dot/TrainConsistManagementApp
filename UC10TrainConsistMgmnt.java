import java.util.ArrayList;
import java.util.List;

/**
 * UC10: Count Total Seats in Train (reduce)
 * Goal: Use Stream reduction to aggregate individual bogie capacities into a total sum.
 */

// Bogie class reused from previous use cases
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class UC10TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // 1. Initialize the bogie list with various capacities
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        System.out.println("Train Consist: " + bogieList);

        // 2. Apply Stream Pipeline: map() -> reduce()
        // map: Extracts the integer capacity from each Bogie object
        // reduce: Sums them up starting from an identity value of 0
        System.out.println("\n[Action] Calculating total seating capacity...");
        int totalSeats = bogieList.stream()
                .map(b -> b.capacity)          // Extract capacities
                .reduce(0, Integer::sum);     // Aggregate using sum

        // 3. Display the result
        System.out.println("====================================");
        System.out.println("TOTAL SEATING CAPACITY: " + totalSeats + " seats");
        System.out.println("====================================");

        // 4. Verification of original list integrity
        System.out.println("Verification: Processed " + bogieList.size() + " bogies.");
        
        System.out.println("------------------------------------");
        System.out.println("Analytical aggregation complete.");
    }
}
