/**
 * UC18: Linear Search for Bogie ID
 * Goal: Search for a specific bogie ID in an unsorted array using sequential traversal.
 */
public class UC18TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC18) ===");

        // 1. Array of Bogie IDs (Unsorted)
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // 2. Define Search Keys
        String searchKey1 = "BG309"; // Existing ID
        String searchKey2 = "BG999"; // Non-existent ID

        System.out.println("\n[Action] Searching for Bogie IDs...");

        // 3. Perform Searches
        performSearch(bogieIds, searchKey1);
        performSearch(bogieIds, searchKey2);

        // 4. Run Edge Case Tests
        runEdgeCaseTests(bogieIds);
    }

    /**
     * Sequential/Linear Search Logic
     */
    public static boolean linearSearch(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            // Use .equals() for String comparison
            if (arr[i].equals(target)) {
                return true; // Match found - Early Termination
            }
        }
        return false; // Traversed entire list without a match
    }

    private static void performSearch(String[] arr, String target) {
        boolean found = linearSearch(arr, target);
        if (found) {
            System.out.println("✔ Bogie ID [" + target + "] found in the consist.");
        } else {
            System.out.println("❌ Bogie ID [" + target + "] NOT found.");
        }
    }

    private static void runEdgeCaseTests(String[] bogieIds) {
        System.out.println("\n--- Edge Case Validations ---");
        
        System.out.print("Testing First Element (BG101): ");
        System.out.println(linearSearch(bogieIds, "BG101"));

        System.out.print("Testing Last Element (BG550): ");
        System.out.println(linearSearch(bogieIds, "BG550"));

        System.out.print("Testing Single Element Array: ");
        String[] single = {"BG101"};
        System.out.println(linearSearch(single, "BG101"));
    }
}
