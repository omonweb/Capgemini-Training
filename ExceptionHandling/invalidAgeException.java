package acception;

public class invalidAgeException extends RuntimeException{
		// TODO Auto-generated method stub
		int age;
	    // Constructor matching the style of your screenshot
	    public invalidAgeException(String message, int age) {
	        super(message);
	        this.age = age;
	        // Mimicking the print statement from your original exception class
	        System.out.println("Age " + age + " is too low."); 
	    }
	}

