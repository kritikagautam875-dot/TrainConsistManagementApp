/**
 * UC15: Safe Cargo Assignment Using try-catch-finally
 * Custom Runtime Exception for operational safety violations.
 */
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String shape;
    private String cargo = "None";

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    /**
     * Assigns cargo with runtime safety validation
     */
    public void assignCargo(String cargoName) {
        System.out.println("[Action] Attempting to assign " + cargoName + " to " + shape + " bogie...");
        
        try {
            // Safety Rule: Petroleum must ONLY go in Cylindrical bogies
            if (cargoName.equalsIgnoreCase("Petroleum") && !shape.equalsIgnoreCase("Cylindrical")) {
                throw new CargoSafetyException("SAFETY ALERT: Petroleum cannot be stored in a " + shape + " bogie!");
            }
            
            this.cargo = cargoName;
            System.out.println("✔ Success: Cargo assigned.");

        } catch (CargoSafetyException e) {
            System.out.println("❌ ERROR: " + e.getMessage());
        } finally {
            // This always runs, ensuring logging or state-checks are performed
            System.out.println("--- Validation check for " + shape + " completed ---");
        }
    }

    @Override
    public String toString() {
        return "Bogie [Shape: " + shape + ", Cargo: " + cargo + "]";
    }
}

public class UC15TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC15) ===\n");

        // 1. Valid Assignment
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");
        
        System.out.println();

        // 2. Unsafe Assignment (Triggering Exception)
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println("\n--- Final Status ---");
        System.out.println(cylindrical);
        System.out.println(rectangular);
        System.out.println("\nProgram execution continued safely after the exception.");
    }
}
