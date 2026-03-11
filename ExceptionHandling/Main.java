package acception;

public class Main {
    public static void main(String[] args) {
        // Instantiate the class that contains our business logic
        Registration registration = new Registration();

        System.out.println("--- Test Case 1: Valid Age (22) ---");
        try {
            // This should execute successfully
            registration.registerUser(22); 
        } catch (invalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("\n--- Test Case 2: Invalid Age (15) ---");
        try {
            // This will trigger our custom exception
            registration.registerUser(15); 
        } catch (invalidAgeException e) {
            // Because it extends RuntimeException, catching it prevents the program from crashing
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
