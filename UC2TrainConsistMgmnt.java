import java.util.ArrayList;
import java.util.List;

/**
 * UC2: Add Passenger Bogies to Train (ArrayList Operations)
 * Goal: Manage the train's composition using CRUD operations.
 */
public class UC2TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // 1. Initialize an ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // 2. Add bogies: Sleeper, AC Chair, First Class
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display current state
        System.out.println("Current Consist: " + passengerBogies);

        // 3. Remove a bogie (AC Chair)
        System.out.println("\n[Action] Removing AC Chair...");
        passengerBogies.remove("AC Chair");

        // 4. Use contains() to check for Sleeper existence
        System.out.print("Is Sleeper attached? ");
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // 5. Print final list state and count
        System.out.println("\nFinal Bogies: " + passengerBogies);
        System.out.println("Total Bogie Count: " + passengerBogies.size());
        
        System.out.println("------------------------------------");
        System.out.println("Program continues.");
    }
}
