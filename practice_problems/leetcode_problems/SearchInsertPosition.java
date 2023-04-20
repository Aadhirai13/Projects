package leet;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,3,5,6};
		System.out.println(searchInsert(arr,2));
	}
	public static int searchInsert(int[] nums, int target) {
		 int i=0;
			for(;i<nums.length;i++){
	            if(nums[i] >= target)
	                break;
	        }
	        return i;
    }
	
	

}
