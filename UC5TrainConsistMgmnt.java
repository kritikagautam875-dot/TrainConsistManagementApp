import java.util.LinkedHashSet;
import java.util.Set;

/**
 * UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
 * Goal: Maintain the physical attachment sequence while preventing duplicate bogies.
 */
public class UC5TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // 1. Initialize LinkedHashSet
        // It maintains insertion order AND prevents duplicates
        Set<String> trainFormation = new LinkedHashSet<>();

        // 2. Attach bogies to the formation
        System.out.println("[Action] Attaching: Engine, Sleeper, Cargo, Guard");
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // 3. Intentional Duplicate Attachment
        // Real-world check: Prevent the same bogie from being attached twice
        System.out.println("[Action] Attempting to attach duplicate: Sleeper");
        boolean isAdded = trainFormation.add("Sleeper"); 
        
        if (!isAdded) {
            System.out.println("Status: Duplicate bogie 'Sleeper' ignored by system.");
        }

        // 4. Display the formation
        // Notice: The order is preserved (unlike HashSet) and unique (unlike List)
        System.out.println("\nFinal Train Formation (Physical Order):");
        System.out.println(trainFormation);

        // 5. Summary
        System.out.println("Total Bogies Attached: " + trainFormation.size());

        System.out.println("------------------------------------");
        System.out.println("Formation order preserved with uniqueness.");
    }
}
