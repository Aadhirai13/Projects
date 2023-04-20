package leet;
import java.util.*;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,4,-1,1};
		System.out.println(firstMissingPositive(arr));

	}
	public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1;i < nums[nums.length-1] ; i++) {
            if(Arrays.binarySearch(nums,i) < 0)
                return i;
        }

        return nums[nums.length - 1] + 1;
    }

}
