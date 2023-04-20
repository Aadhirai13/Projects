package leet;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,2,3};
		int num = 3;
		System.out.println(removeElement(arr , num));
	}
	public static int removeElement(int[] nums, int val) {
		int k=0;
        for(int i=0;i<nums.length;i++) 
        	if(nums[i] != val) 
        		nums[k++] = nums[i];
        return k;
    }

}
