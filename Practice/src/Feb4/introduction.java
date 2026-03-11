/**
 * 
 */
package Feb4;

import java.util.Map;
import java.util.Scanner;

/**
 * 
 */
public class introduction {

	public int subarraysumequalsK(int[] nums, int k) {
	    int i = 0, j = 0;
	    int sum = 0;
	    int maxLen = 0;
	    
	    while (j < nums.length) {
	        sum += nums[j];
	        
	        while (sum > k && i <= j) {
	            sum -= nums[i];
	            i++;
	        }
	        
	        if (sum == k) {
	            maxLen = Math.max(maxLen, j - i + 1);
	        }
	        
	        j++;
	    }
	    return maxLen;
	}
	
	public boolean anagram(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		int[] ch1 = new int[26];
		
		
		for(int i = 0; i < s1.length(); i++) {
		
			ch1[s1.charAt(i) - 'a']++;
			ch1[s2.charAt(i) - 'a']--;
		
		}
		for(int i = 0; i < 26; i++) {
			if(ch1[i] != 0) return false;
		}
		return true;
	}
	
	public static boolean isPrime(int n) {
		if(n%2 == 0  || n%3 == 0) return false;
		
		for(int i = 5; i*i <= n; i+=6) {
			if(n%i == 0) return false;
		}
		return true;
	} //checking for sq root of n is useful because 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		introduction obj = new introduction();
		/*System.out.println("Enter length of array");
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println("Enter target sum");
		int k = sc.nextInt();
		System.out.println(obj.subarraysumequalsK(nums,k));*/
		//String s1 = sc.nextLine();
		//String s2 = sc.nextLine();
		
		//System.out.println(obj.anagram(s1,s2));
		System.out.println("enter a number");
		int n = sc.nextInt();
		System.out.println(introduction.isPrime(n));
		
		sc.close();
	}

}
