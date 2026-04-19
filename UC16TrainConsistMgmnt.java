import java.util.Arrays;

/**
 * UC16: Sort Passenger Bogies by Capacity (Bubble Sort)
 * Goal: Manually implement sorting logic to understand algorithm fundamentals.
 */
public class UC16TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC16) ===");

        // 1. Initial capacities of passenger bogies
        int[] capacities = {72, 56, 24, 70, 60};
        
        System.out.println("Original Capacities: " + Arrays.toString(capacities));

        // 2. Perform Bubble Sort
        bubbleSort(capacities);

        // 3. Display Sorted Result
        System.out.println("Sorted Capacities (Ascending): " + Arrays.toString(capacities));
        
        // 4. Verification with edge cases
        runEdgeCaseTests();
    }

    /**
     * Manual implementation of Bubble Sort algorithm
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop for multiple passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop to compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap Logic: Use a temporary variable
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void runEdgeCaseTests() {
        System.out.println("\n--- Running Edge Case Validations ---");

        int[] duplicates = {72, 56, 56, 24};
        bubbleSort(duplicates);
        System.out.println("Duplicate Test: " + Arrays.toString(duplicates));

        int[] singleElement = {50};
        bubbleSort(singleElement);
        System.out.println("Single Element Test: " + Arrays.toString(singleElement));
        
        System.out.println("\nAlgorithmic sorting complete.");
    }
}
