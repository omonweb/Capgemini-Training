package feb2;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayComparison {

	public boolean compareArrays(int[] nums1, int[] nums2) {
		
		int n1 = nums1.length;
		int n2 = nums2.length;
	
		if(n1 != n2) return false;
		
		for(int i = 0; i < n1; i++) {
			if(nums1[i] != nums2[i]) return false;
		}
		
		return true;
	}
	
	public void reverse(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		
		while(i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
	
	public int addToN(int[] nums,int target) {
		int counter = 0;
		int[] flags = new int[nums.length];
		
		Arrays.fill(flags, 0);
		
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = i+1; j < nums.length; j++) {
				if((nums[i] + nums[j] == target) && (flags[i] != 1 && flags[j] != 1)) {
					counter++;
					flags[i] = 1;
					flags[j] = 1;
					break;
				}
			}
		}
		return counter;
		
	}
	
	public int addToM(int[] nums,int target) {
		int counter = 0;
		int maxi = Integer.MIN_VALUE;
		
		for(int num : nums) {
			maxi = Math.max(maxi, num);
		}
		
		boolean[] flags = new boolean[maxi + 1];
		Arrays.fill(flags, false);
		
		for(int i = 0; i < nums.length ; i++) {
			if(flags[nums[i]]) continue;
			
			int complement = target - nums[i];
			
			if(!flags[complement]) {
				counter++;
				flags[complement] = true;
				flags[nums[i]] = true;
			}
		}
		return counter;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ArrayComparison obj = new ArrayComparison();
		
		System.out.println("enter length of first array");
		int n1 = sc.nextInt();
		int[] nums1 = new int[n1];
		
		for(int i = 0; i < n1; i++) {
			System.out.println("enter " + i + " element of first array");
			nums1[i] = sc.nextInt();
		}
		sc.nextLine();
		
		/* System.out.println("enter length of second array");
		int n2 = sc.nextInt();
		int[] nums2 = new int[n2];
		
		for(int i = 0; i < n2; i++) {
			System.out.println("enter " + i + " element of second array");
			nums2[i] = sc.nextInt();
		} */
		
		//System.out.println(obj.compareArrays(nums1,nums2));
		//obj.reverse(nums1);
		System.out.println("Enter the target sum");
		int target = sc.nextInt();
		System.out.println(obj.addToM(nums1, target));
		/*for(int num : nums1) {
			System.out.print(num + "  ");
		}*/
		sc.close();
	
	}

}
