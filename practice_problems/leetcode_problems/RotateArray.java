package leet;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2};
		rotate(arr,3);

	}
	public static void rotate(int[] nums, int k) {
		while(nums.length <= k) {
			k = k - nums.length;
		}
        int arr[] = new int[nums.length-k];
        int i=0,j=nums.length-k;
        System.arraycopy(nums, 0, arr, 0, nums.length-k);
        while(j<nums.length) 
        	nums[i++] = nums[j++];
        System.arraycopy(arr, 0, nums, i, nums.length-k);
		for(int n:nums)
        	System.out.print(n);
	}
}
