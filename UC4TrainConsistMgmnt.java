import java.util.LinkedList;

/**
 * UC4: Maintain Ordered Bogie IDs (LinkedList)
 * Goal: Model the physical sequence of a train using a Doubly Linked List.
 */
public class UC4TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // 1. Initialize a LinkedList to model the train chain
        LinkedList<String> trainConsist = new LinkedList<>();

        // 2. Add initial bogies to the consist
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Sequence: " + trainConsist);

        // 3. Insert a Pantry Car at index 2 (between Sleeper and AC)
        System.out.println("\n[Action] Inserting Pantry Car at position 2...");
        trainConsist.add(2, "Pantry Car");
        System.out.println("After Insertion: " + trainConsist);

        // 4. Remove the first and last bogie
        System.out.println("\n[Action] Detaching first and last bogies...");
        trainConsist.removeFirst(); // Removes Engine
        trainConsist.removeLast();  // Removes Guard

        // 5. Display the final ordered train consist
        System.out.println("Final Consist: " + trainConsist);
        System.out.println("Total Bogies: " + trainConsist.size());

        System.out.println("------------------------------------");
        System.out.println("Physical sequence maintained.");
    }
}
