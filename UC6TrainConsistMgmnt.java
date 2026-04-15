import java.util.HashMap;
import java.util.Map;

/**
 * UC6: Map Bogie to Capacity (HashMap)
 * Goal: Associate bogies with their operational capacities using key-value pairs.
 */
public class UC6TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // 1. Initialize a HashMap to store Bogie Name (Key) and Capacity (Value)
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // 2. Map bogies to their respective seating/load capacities using put()
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 56);
        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("Cargo", 1000); // 1000 kg capacity

        System.out.println("Status: Bogie capacities registered successfully.");

        // 3. Iterate over the map using entrySet() to display details
        System.out.println("\n--- Bogie Capacity Summary ---");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }

        // 4. Demonstrate fast lookup
        String searchBogie = "Sleeper";
        if (bogieCapacityMap.containsKey(searchBogie)) {
            System.out.println("\n[Lookup] Capacity for " + searchBogie + " is: " + bogieCapacityMap.get(searchBogie));
        }

        System.out.println("------------------------------------");
        System.out.println("Operational mapping completed.");
    }
}

