import java.util.Scanner;
public class Loops {

	public int sumOfDigits(int n) {
		int n1 = n;
		int sum = 0;
		
		while(n1 > 0) {
			int rem = n1%10;
			sum += rem;
			n1 /= 10;
		}
		return sum;
	}
	
	public boolean checkPallindrome(int n) {
		int n1 = n;
		int sum = 0;
		
		while(n1 > 0) {
		int rem = n1%10;
		sum = sum * 10 + rem;
		n1 = n1/10;
		
		}
		
		if(sum == n) return true;
		
		return false;
	}
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a number");
	int n = sc.nextInt();
	Loops obj = new Loops();
	System.out.println(obj.checkPallindrome(n));
	sc.close();
	
	}

}
