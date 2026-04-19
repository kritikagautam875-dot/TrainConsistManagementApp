import java.util.regex.Pattern;
import java.util.regex.Matcher;

// The class name MUST match the filename UC11TrainConsistMgmnt.java
public class UC11TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC11) ===");

        // Define Patterns
        String trainIdRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // Sample Inputs
        String[] testTrainIDs = {"TRN-1234", "TRAIN12", "TRN-123", "TRN-12345"};
        String[] testCargoCodes = {"PET-AB", "PET-ab", "PET123"};

        System.out.println("\n--- Validating Train IDs ---");
        for (String id : testTrainIDs) {
            validate(id, trainIdRegex, "Train ID");
        }

        System.out.println("\n--- Validating Cargo Codes ---");
        for (String code : testCargoCodes) {
            validate(code, cargoCodeRegex, "Cargo Code");
        }
    }

    public static void validate(String input, String regex, String label) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("✔ " + label + " [" + input + "] is valid.");
        } else {
            System.out.println("❌ " + label + " [" + input + "] is invalid.");
        }
    }
}
