package leet;

import java.util.Arrays;

public class NextGreaterElement503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ans = (nextGreaterElements(new int[]{1,5,3,6,8})); //5,6,6,8,-1
		System.out.println(Arrays.toString(ans));
	}
	
	
	public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
       
        for(int i=0;i<nums.length;i++) {
        	boolean found = false;
	        for(int j=i+1;j<nums.length;j++) {
		       	if(nums[j] > nums[i]) {
		       		ans[i] = nums[j];
		       		found = true;
		       		break;
		       	}
	        }
	        if(!found) {
	        	for(int j=0;j<nums.length;j++) {
			       	if(nums[j] > nums[i]) {
			       		ans[i] = nums[j];
			       		found = true;
			       		break;
			       	}
		        }
	        }
	        if(!found)
	        	ans[i] = -1;
	    }
	        
        return ans;
    }
}
