package leet;

public class Jump {

	static int arr[] = {2,3,0,1,4};
	static int len = arr.length;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxJump(arr));
	}
	public static boolean maxJump(int[] nums) {
	       int last = nums[nums.length-1];
	       for(int i=nums.length-1;i>=0;i--){
	           if(nums[i]+i >= last)
	                last = i;
	       }
	       if(last == 0)
	            return true;
	        else 
	            return false;
		}
}