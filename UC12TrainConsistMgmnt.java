import java.util.ArrayList;
import java.util.List;

/**
 * UC12: Safety Compliance Check for Goods Bogies
 * Goal: Use Streams and allMatch() to enforce cargo safety rules.
 */

class GoodsBogie {
    String type;
    String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "[" + type + " | " + cargo + "]";
    }
}

public class UC12TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC12) ===");

        // 1. Initialize a list of Goods Bogies
        List<GoodsBogie> goodsList = new ArrayList<>();
        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsList.add(new GoodsBogie("Box", "Coal"));
        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsList.add(new GoodsBogie("Open", "Grain"));

        System.out.println("Current Goods Consist: " + goodsList);

        // 2. Apply Safety Rule using Stream allMatch()
        // Rule: IF type is "Cylindrical", cargo MUST be "Petroleum".
        // Logic: (Not Cylindrical) OR (Cargo is Petroleum)
        System.out.println("\n[Action] Performing Safety Compliance Check...");
        
        boolean isSafe = goodsList.stream().allMatch(bogie -> {
            if (bogie.type.equalsIgnoreCase("Cylindrical")) {
                return bogie.cargo.equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies are safe by default in this context
        });

        // 3. Display Result
        System.out.println("==========================================");
        if (isSafe) {
            System.out.println("STATUS: ✔ TRAIN IS SAFETY COMPLIANT");
            System.out.println("Result: All cylindrical bogies contain authorized cargo.");
        } else {
            System.out.println("STATUS: ❌ SAFETY VIOLATION DETECTED");
            System.out.println("Result: One or more Cylindrical bogies contain invalid cargo!");
        }
        System.out.println("==========================================");

        // 4. Verification with a known failure case
        verifyViolation();
    }

    private static void verifyViolation() {
        List<GoodsBogie> unsafeList = new ArrayList<>();
        unsafeList.add(new GoodsBogie("Cylindrical", "Coal")); // Violation

        System.out.println("\nTesting Violation Scenario: " + unsafeList);
        boolean check = unsafeList.stream().allMatch(b -> 
            !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum")
        );
        System.out.println("Violation Check Passed (Safe=False): " + !check);
    }
}
