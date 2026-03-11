package acception;

public class Registration {
    
    // Method matching the style of your withDraw method
    public void registerUser(int age) {
        if (age < 18) {
            // Throwing the custom exception if the condition is met
            throw new invalidAgeException("Underage user", age);
        }
        
        // Code executed if no exception is thrown (similar to the balance deduction)
        System.out.println("User registered successfully with age: " + age);
    }
}
