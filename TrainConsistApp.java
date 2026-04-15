import java.util.ArrayList;
import java.util.List;

/**
 * UC1: Initialize Train and Display Consist Summary
 * Goal: Setup the entry point and initialize a dynamic bogie collection.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        // 1. Print Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // 2. Initialize the Train Consist (Collection of Bogies)
        // We use List (Interface) and ArrayList (Implementation) for dynamic sizing
        List<String> trainConsist = new ArrayList<>();

        // 3. Display Initial State
        // size() is used to show how many bogies are currently attached
        System.out.println("Status: Train consist initialized.");
        System.out.println("Initial Bogie Count: " + trainConsist.size());

        System.out.println("------------------------------------");
        System.out.println("System ready for bogie attachment.");
    }
}
