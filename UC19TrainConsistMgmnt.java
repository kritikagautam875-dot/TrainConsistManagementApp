import java.util.Arrays;

/**
 * UC19: Binary Search for Bogie ID (Optimized Searching)
 * Goal: Use Divide-and-Conquer strategy to find IDs in O(log n) time.
 */
public class UC19TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC19) ===");

        // 1. Unsorted input (as per requirements, we must handle unsorted data)
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // 2. Precondition: Binary Search REQUIRES sorted data
        System.out.println("[Action] Sorting data for Binary Search...");
        Arrays.sort(bogieIds);
        System.out.println("Sorted IDs: " + Arrays.toString(bogieIds));

        // 3. Define Search Keys
        String searchKey = "BG309";

        // 4. Perform Binary Search
        boolean found = binarySearch(bogieIds, searchKey);
        
        System.out.println("\nSearch Result for [" + searchKey + "]: " + (found ? "FOUND ✔" : "NOT FOUND ❌"));

        // 5. Run Test Cases
        runTestCases();
    }

    /**
     * Manual Binary Search Implementation using low, high, and mid indexes
     */
    public static boolean binarySearch(String[] arr, String target) {
        if (arr == null || arr.length == 0) return false;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate middle index
            int comparison = target.compareTo(arr[mid]);

            if (comparison == 0) {
                return true; // Match found
            } else if (comparison > 0) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return false; // Target not found
    }

    private static void runTestCases() {
        System.out.println("\n--- Testing Search Scenarios ---");
        String[] sortedIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        System.out.println("First Element (BG101): " + binarySearch(sortedIds, "BG101"));
        System.out.println("Last Element (BG550):  " + binarySearch(sortedIds, "BG550"));
        System.out.println("Non-existent (BG999): " + binarySearch(sortedIds, "BG999"));
        System.out.println("Empty Array Test:      " + binarySearch(new String[]{}, "BG101"));
    }
}
