import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * UC7: Sort Bogies by Capacity (Comparator)
 * Goal: Rank and sort bogie objects based on seating capacity for better planning.
 */

// 1. Bogie class to hold name and capacity
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

public class UC7TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // 2. Initialize a List to store Bogie objects
        List<Bogie> bogieList = new ArrayList<>();

        // 3. Add passenger bogies with their respective capacities
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        System.out.println("Initial List: " + bogieList);

        // 4. Use Comparator to sort bogies by capacity (Descending Order)
        // We use comparingInt and reversed() to see high-capacity bogies first
        System.out.println("\n[Action] Sorting bogies by capacity (High to Low)...");
        bogieList.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());

        // 5. Display the sorted result
        System.out.println("Sorted Bogie List:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        System.out.println("------------------------------------");
        System.out.println("Train planning summary generated.");
    }
}
