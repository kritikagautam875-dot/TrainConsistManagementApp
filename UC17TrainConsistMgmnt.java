import java.util.Arrays;

/**
 * UC17: Sort Bogie Names Using Arrays.sort()
 * Goal: Use Java's optimized built-in utility for alphabetical sorting.
 */
public class UC17TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC17) ===");

        // 1. Array of unsorted bogie type names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("\n[Before Sorting]: " + Arrays.toString(bogieNames));

        // 2. Perform Natural Ordering (Alphabetical) Sorting using built-in method
        // This is significantly faster than Bubble Sort for large datasets (O(n log n))
        Arrays.sort(bogieNames);

        // 3. Display Sorted Result
        System.out.println("[After Sorting]:  " + Arrays.toString(bogieNames));

        // 4. Verification with edge cases
        runTestCases();
    }

    private static void runTestCases() {
        System.out.println("\n--- Running Validation Tests ---");

        // Test Case: Duplicate Names
        String[] duplicates = {"Sleeper", "AC Chair", "Sleeper", "General"};
        Arrays.sort(duplicates);
        System.out.println("Duplicate Test: " + Arrays.toString(duplicates));

        // Test Case: Unsorted Input
        String[] unsorted = {"Luxury", "General", "Sleeper", "AC Chair"};
        Arrays.sort(unsorted);
        System.out.println("Unsorted Test:  " + Arrays.toString(unsorted));

        // Test Case: Single Element
        String[] single = {"Sleeper"};
        Arrays.sort(single);
        System.out.println("Single Element: " + Arrays.toString(single));
    }
}
