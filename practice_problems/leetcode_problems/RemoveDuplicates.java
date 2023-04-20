package leet;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(arr));
	}
	public static int removeDuplicates(int[] nums) {
        int i=0,j=1,k=0;
        for(i = 0;i<nums.length-1;) {
        	if(nums[i] == nums[j]) {
        		i++;
        		j++;
        	}
        	else {
        		nums[k++] = nums[i];
        		i++;
        		j++;
        	}
        }
        nums[k++] = nums[i];
        return k;
    }
}
