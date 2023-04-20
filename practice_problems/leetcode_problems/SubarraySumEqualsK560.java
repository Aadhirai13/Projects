package leet;

import java.util.Arrays;

public class SubarraySumEqualsK560 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subarraySum(new int[]{1,-1,0},0));
	}
	
	 public static int subarraySum(int[] nums, int k) {
	     int count = 0;
	     for(int i=0;i<nums.length;i++) {
	    	 int sum = 0;
	    	 for(int j=i;j < nums.length;j++) {
	    		 sum += nums[j];
		    		if(sum == k){
		    			count++;
	                }
	    	 }
	     }
	     return count;
	 }

	private static int sum(int i, int j, int[] nums) {
		int sum = 0;
		for(int c = i;c <= j;c++) {
			sum += nums[c];
		}
		return sum;
	}
}
