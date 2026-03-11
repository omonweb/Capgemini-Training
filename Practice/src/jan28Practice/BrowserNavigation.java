package jan28Practice;
import java.util.*;

public class BrowserNavigation {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        Deque<String> forward = new ArrayDeque<>();
	        Deque<String> back = new ArrayDeque<>();

	        forward.addLast("Open Gmail");
	        forward.addLast("Open Inbox");

	        String current = "Open Google";

	        while (true) {
	            System.out.println("Current Step: " + current);
	            System.out.print("Enter command (continue/back/close): ");
	            String command = sc.nextLine();

	            if (command.equalsIgnoreCase("continue")) {
	                if (!forward.isEmpty()) {
	                    back.addLast(current);
	                    current = forward.removeFirst();
	                } else {
	                    System.out.println("No next step.");
	                }
	            } 
	            else if (command.equalsIgnoreCase("back")) {
	                if (!back.isEmpty()) {
	                    forward.addFirst(current);
	                    current = back.removeLast();
	                } else {
	                    System.out.println("No previous step.");
	                }
	            } 
	            else if (command.equalsIgnoreCase("close")) {
	                break;
	            } 
	            else {
	                System.out.println("Invalid command.");
	            }
	        }

	        sc.close();
	    }

}
