import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * UC9: Group Bogies by Type (Collectors.groupingBy)
 * Goal: Categorize bogies into a structured Map for reporting and analysis.
 */

// Bogie class reused and enhanced for grouping
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Cap: " + capacity + ")";
    }
}

public class UC9TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // 1. Initialize a List with multiple bogies of the same type
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("Sleeper", 72)); // Second Sleeper
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("AC Chair", 56)); // Second AC Chair

        System.out.println("Original Flat List: " + bogieList);

        // 2. Apply Stream groupingBy() collector
        // This converts List<Bogie> -> Map<String, List<Bogie>>
        System.out.println("\n[Action] Grouping bogies by category...");
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // 3. Display the structured results
        System.out.println("--- Grouped Bogie Report ---");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: " + type + " | Count: " + list.size());
            System.out.println("  Details: " + list);
        });

        // 4. Verification
        System.out.println("\nVerification: Total unique categories found: " + groupedBogies.size());
        
        System.out.println("------------------------------------");
        System.out.println("Categorization complete.");
    }
}
