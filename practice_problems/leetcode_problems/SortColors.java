package leet;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,0,2,1,1,0};
		sortColors(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sortColors(int[] nums) {
		int len = nums.length;
		if(len == 1)
			return;
		
		int left[] = Arrays.copyOfRange(nums, 0, len / 2);
		sortColors(left);
		int right[] = Arrays.copyOfRange(nums, len / 2, len);
		sortColors(right);
		
		merge(left,right,nums);
    }
	
	public static void merge(int[] left , int[] right , int arr[]) {
		int l = 0, r = 0,i = 0;
		while(l<left.length && r<right.length) {
			if(left[l] < right[r])
				arr[i++] = left[l++];
			else
				arr[i++] = right[r++];
		}
		while(l<left.length)
			arr[i++] = left[l++];

		while(r<right.length)
			arr[i++] = right[r++];
	}

}
