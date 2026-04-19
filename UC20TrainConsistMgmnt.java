import java.util.Arrays;

/**
 * UC20: Exception Handling During Search Operations
 * Goal: Implement state validation to prevent searching on an empty collection.
 */
public class UC20TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC20) ===");

        // Scenario 1: Searching an empty array (Should Fail)
        String[] emptyConsist = {};
        try {
            System.out.println("\n[Test 1] Searching empty consist...");
            performSafeSearch(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("❌ Caught Expected Exception: " + e.getMessage());
        }

        // Scenario 2: Searching a populated array (Should Pass)
        String[] activeConsist = {"BG101", "BG205", "BG309"};
        try {
            System.out.println("\n[Test 2] Searching active consist for BG205...");
            boolean found = performSafeSearch(activeConsist, "BG205");
            System.out.println("Result: " + (found ? "Found ✔" : "Not Found ❌"));
        } catch (IllegalStateException e) {
            System.out.println("❌ Unexpected Error: " + e.getMessage());
        }
    }

    /**
     * Performs state validation before executing search logic.
     * @throws IllegalStateException if the array is empty.
     */
    public static boolean performSafeSearch(String[] bogieIds, String target) {
        // 1. State Validation (Defensive Check)
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Search failed: No bogies available in the train consist.");
        }

        // 2. Proceed with Search logic (using Linear Search for simplicity)
        for (String id : bogieIds) {
            if (id.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
