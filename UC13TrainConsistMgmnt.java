import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC13: Performance Comparison (Loops vs Streams)
 * Goal: Measure and compare execution time using System.nanoTime().
 */
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class UC13TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Performance Benchmarking (UC13) ===");

        // 1. Prepare a large dataset for meaningful measurement
        List<Bogie> bogieList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogieList.add(new Bogie("Sleeper", 72));
            bogieList.add(new Bogie("Chair", 50));
        }

        System.out.println("Dataset size: " + bogieList.size() + " bogies.");

        // 2. Loop-Based Filtering
        long startLoop = System.nanoTime();
        List<Bogie> filteredLoop = new ArrayList<>();
        for (Bogie b : bogieList) {
            if (b.capacity > 60) {
                filteredLoop.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        // 3. Stream-Based Filtering
        long startStream = System.nanoTime();
        List<Bogie> filteredStream = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // 4. Display Results
        System.out.println("\n--- Benchmarking Results ---");
        System.out.println("Loop Filtering Time   : " + loopDuration + " ns");
        System.out.println("Stream Filtering Time : " + streamDuration + " ns");
        
        // 5. Verification
        System.out.println("\n--- Integrity Check ---");
        System.out.println("Results Match? " + (filteredLoop.size() == filteredStream.size()));
        System.out.println("Filtered Count: " + filteredLoop.size());
        
        if (loopDuration < streamDuration) {
            System.out.println("\nConclusion: Traditional Loop was faster in this run.");
        } else {
            System.out.println("\nConclusion: Java Stream was faster (likely due to JVM optimization).");
        }
    }
}
