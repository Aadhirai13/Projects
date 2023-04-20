package leet;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,1};
		System.out.println(rob(arr));
	}
	public static int rob(int[] nums) {
        for(int i=nums.length-3;i>=0;i--)
        	nums[i] = nums[i] + nums[i+2];
        return Math.max(nums[0],nums[1]);
    }

}
