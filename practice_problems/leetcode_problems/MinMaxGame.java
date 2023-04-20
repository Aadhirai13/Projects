package leet;

public class MinMaxGame {

	public static void main(String[] args) {
		int[] arr = {1,3,5,2,4,8,2,2};
		System.out.println(minMaxGame(arr));
	}
	public static int minMaxGame(int[] nums) {
		if(nums.length == 1)
			return nums[0];
		int cnt = 0,j = 0;
		int[] a = new int[nums.length / 2];
		for(int i=0;i<nums.length;i=i+2) {
			a[j] = (cnt % 2 == 0) ? Math.min(nums[i], nums[i+1]): Math.max(nums[i], nums[i+1]);
			cnt++;
			j++;
		}
		if(a.length == 1)
			return a[0];
		else
			return minMaxGame(a);
    }

}
