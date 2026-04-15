import java.util.HashSet;
import java.util.Set;

/**
 * UC3: Track Unique Bogie IDs (Set – HashSet)
 * Goal: Enforce uniqueness to prevent duplicate bogie registration.
 */
public class UC3TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // 1. Initialize a HashSet for unique bogie IDs
        // Set automatically enforces uniqueness
        Set<String> bogieIds = new HashSet<>();

        // 2. Add bogie IDs (including duplicates)
        System.out.println("[Action] Registering bogie IDs: BG101, BG102, BG101, BG103");
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101"); // Intentional duplicate
        bogieIds.add("BG103");

        // 3. Display the unique IDs
        // Notice that "BG101" only appears once in the output
        System.out.println("\nUnique Bogie IDs in System: " + bogieIds);

        // 4. Verify count
        System.out.println("Total Unique Count: " + bogieIds.size());

        System.out.println("------------------------------------");
        System.out.println("Duplicate registration prevented.");
    }
}
